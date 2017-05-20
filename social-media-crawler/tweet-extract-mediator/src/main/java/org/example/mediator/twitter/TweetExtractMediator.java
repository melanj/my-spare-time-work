/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.example.mediator.twitter;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.soap.SOAPBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

/**
 * 
 *
 */
public final class TweetExtractMediator extends AbstractMediator {

	private static final Log log = LogFactory.getLog(TweetExtractMediator.class);

	private OMFactory factory = OMAbstractFactory.getOMFactory();

	public boolean mediate(MessageContext mc) {
		SOAPBody body = mc.getEnvelope().getBody();
		OMElement firstChild = body.getFirstElement();
		if (firstChild != null) {
			if ("jsonObject".equals(firstChild.getLocalName())) {
				Iterator<?> statuses = firstChild.getChildrenWithLocalName("statuses");
				if (statuses.hasNext()) {
					processStatuses(mc, statuses);
				} else {
					log.warn("skipping... no 'statuses' found!");
					return false;
				}
			} else {
				log.warn("skipping... no JSON payload found!");
				return false;
			}
		} else {
			log.warn("skipping... no content in body!");
			return false;
		}

		return true;
	}

	private void processStatuses(MessageContext mc, Iterator<?> statuses) {
		OMElement results = factory.createOMElement(new QName("results"));
		while (statuses.hasNext()) {
			OMElement next = (OMElement) statuses.next();
			OMElement result = factory.createOMElement(new QName("result"));

			createChild(result, "keyword_id", mc.getProperty("id").toString());
			createChild(result, "result_type", getTextInPath(next, "metadata/result_type"));
			createChild(result, "created_at", getTextInPath(next, "created_at"));
			createChild(result, "id_str", getTextInPath(next, "id_str"));
			createChild(result, "text", getTextInPath(next, "text"));
			createChild(result, "source", getTextInPath(next, "source"));

			createChild(result, "coordinates", getTextInPath(next, "coordinates"));
			createChild(result, "source", getTextInPath(next, "source"));

			OMElement user = createChild(result, "user", null);
			createChild(user, "id_str", getTextInPath(next, "user/id_str"));
			createChild(user, "name", getTextInPath(next, "user/name"));
			createChild(user, "screen_name", getTextInPath(next, "user/screen_name"));
			createChild(user, "location", getTextInPath(next, "user/location"));
			createChild(user, "followers_count", getTextInPath(next, "user/followers_count"));
			createChild(user, "friends_count", getTextInPath(next, "user/friends_count"));
			createChild(user, "time_zone", getTextInPath(next, "user/time_zone"));

			createChild(result, "retweet_count", getTextInPath(next, "retweet_count"));
			createChild(result, "favorite_count", getTextInPath(next, "favorite_count"));

			OMElement entities = createChild(result, "entities", null);
			createChild(entities, "hashtags", getTextInPathAsCSV(next, "entities/hashtags", "text"));
			createChild(entities, "user_mentions", getTextInPathAsCSV(next, "entities/user_mentions", "screen_name"));

			createChild(result, "lang", getTextInPath(next, "lang"));

			results.addChild(result);
		}
		setPayloadXML(mc, results);
	}

	private OMElement createChild(final OMElement root, String name, String text) {
		OMElement child = factory.createOMElement(new QName(name));
		if (text != null) {
			child.setText(text);
		}
		root.addChild(child);
		return child;
	}

	private String getTextInPath(final OMElement root, String path) {
		String text = new String();
		try {
			String[] nodes = path.split("/");
			OMElement element = root;
			for (int i = 0; i < nodes.length; i++) {
				element = element.getFirstChildWithName(new QName(nodes[i]));
			}
			text = element.getText();
		} catch (Throwable e) {
			// For the moment, we ignore this
		}
		return text;
	}

	private String getTextInPathAsCSV(final OMElement root, String path, String subPath) {

		String text = new String();
		OMElement element = root;

		try {
			String[] nodes = path.split("/");
			int index = nodes.length - 1;
			for (int i = 0; i < index; i++) {
				element = element.getFirstChildWithName(new QName(nodes[i]));
			}

			Iterator<?> items = element.getChildrenWithLocalName(nodes[index]);
			while (items.hasNext()) {
				String itemText = getTextInPath((OMElement) items.next(), subPath);
				text = text + itemText + ",";
			}
			text = text.replaceAll(",$", "");
		} catch (Throwable e) {
			// For the moment, we ignore this
		}

		return text;
	}

	private void setPayloadXML(MessageContext mc, OMElement payload) {
		SOAPBody body = mc.getEnvelope().getBody();
		OMElement firstChild = body.getFirstElement();
		if (firstChild == null) {
			body.addChild(payload);
		} else {
			firstChild.insertSiblingAfter(payload);
			firstChild.detach();
		}
	}

	public boolean isContentAware() {
		return true;
	}
}
