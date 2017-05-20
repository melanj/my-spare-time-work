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

package org.example.mediator.task;

import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import org.apache.synapse.MessageContext; 
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.task.TaskDescription;
import org.apache.synapse.task.TaskDescriptionSerializer;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axiom.soap.SOAPBody;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.task.stub.TaskAdminStub;

public class TaskCreateMediator extends AbstractMediator { 
	
	private static final Log log = LogFactory.getLog(TaskCreateMediator.class);
	
	/* non-configurable constants - do not edit  */
	private static final String VALUE_SEQUENCE = "sequence"; //$NON-NLS-1$
	private static final String PROP_MESSAGE = "message"; //$NON-NLS-1$
	private static final String PROP_SEQUENCE_NAME = "sequenceName"; //$NON-NLS-1$
	private static final String PROP_INJECT_TO = "injectTo"; //$NON-NLS-1$
	private static final String QUARTZ_FQN = "synapse.simple.quartz"; //$NON-NLS-1$
	private final static String TASK = "task"; //$NON-NLS-1$
	private static final String MESSAGE_INJECTOR_FQN = "org.apache.synapse.startup.tasks.MessageInjector"; //$NON-NLS-1$
	private static final String TASK_NS = "http://www.wso2.org/products/wso2commons/tasks"; //$NON-NLS-1$

	/* configurable constants - please edit as needed */
	private static final String VALUE_SEQUENCE_NAME = "TwitterCallSequence"; //$NON-NLS-1$
    private static final String SERVICE_URL = "https://localhost:9443/services/TaskAdmin"; //$NON-NLS-1$
    private static final String AUTH_USER = "admin"; //$NON-NLS-1$
    private static final String AUTH_PASSWORD = "admin"; //$NON-NLS-1$
    private static final String PROP_USER_EMAIL = "userEmail"; //$NON-NLS-1$
    private static final String PROP_INTERVAL = "frequency"; //$NON-NLS-1$
    private static final String PROP_COUNT = "occurrence"; //$NON-NLS-1$
    private static final String PROP_PAYLOAD = "payload"; //$NON-NLS-1$
    private static final String RESPONSE_NS = "http://response.service.example.org"; //$NON-NLS-1$
    /* end configurable constants */
    
    private TaskAdminStub taskAdminStub;


	public boolean mediate(MessageContext context) {

		try {
			taskAdminStub = new TaskAdminStub(SERVICE_URL);
			OMFactory omFactory = OMAbstractFactory.getOMFactory();

			Options options = taskAdminStub._getServiceClient().getOptions();
			HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
			auth.setPreemptiveAuthentication(true);
			auth.setPassword(AUTH_USER);
			auth.setUsername(AUTH_PASSWORD);
			options.setProperty(HTTPConstants.AUTHENTICATE, auth);
			TaskDescription task = new TaskDescription();

			// FIXME: handle possible NullPointer/NumberFormat exceptions

			String taskName = generateUniqueName(context.getProperty(PROP_USER_EMAIL).toString());
			int count = Integer.parseInt(context.getProperty(PROP_COUNT).toString());
			long intervalInMin = Long.parseLong(context.getProperty(PROP_INTERVAL).toString());
			OMElement payload = AXIOMUtil.stringToOM(context.getProperty(PROP_PAYLOAD).toString());

			task.setName(taskName);
			task.setGroup(QUARTZ_FQN);
			task.setTaskClass(MESSAGE_INJECTOR_FQN);
			task.setCount(count);
			task.setInterval(intervalInMin * 60 * 1000); // in ms

			OMNamespace taskNS = omFactory.createOMNamespace(TASK_NS, TASK);

			task.addProperty(createProperty(PROP_INJECT_TO, VALUE_SEQUENCE));
			task.addProperty(createProperty(PROP_SEQUENCE_NAME, VALUE_SEQUENCE_NAME));
			task.addProperty(createProperty(PROP_MESSAGE, payload));

			OMElement taskElement = TaskDescriptionSerializer.serializeTaskDescription(taskNS, task);

			taskAdminStub.addTaskDescription(taskElement);

			setPayloadXML(context, generateResponse(true));

		} catch (Throwable e) {
			/*
			 * FIXME: Handle errors by catching specific exceptions rather than
			 * catching root level exception
			 */
			log.error(e);
			return false;
		}

		return true;
	}


	private <T> OMElement createProperty(String name, T value) throws XMLStreamException {
		OMElement ele = AXIOMUtil.stringToOM("<property xmlns:task=\"" + TASK_NS + "\"/>");
		ele.addAttribute("name", name, null);
		if (value instanceof OMElement) {
			ele.addChild((OMElement) value);
		} else {
			ele.addAttribute("value", value.toString(), null);
		}
		return ele;
	}
	
	private String generateUniqueName(String key){
		key = key.replaceAll("@","_").replaceAll("\\.", "_"); // replace all . and @ with _
		UUID uuid = UUID.randomUUID();
		return String.format("twitter_task_%s_%s",key, uuid.toString());
	}
	
	private void setPayloadXML(MessageContext context, OMElement payload) {
        SOAPBody body = context.getEnvelope().getBody();
        OMElement firstChild = body.getFirstElement();
        if (firstChild == null) {
            body.addChild(payload);
        } else {
            firstChild.insertSiblingAfter(payload);
            firstChild.detach();
        }
    }
	
	private OMElement generateResponse(boolean value) throws XMLStreamException{
		String xml = String.format("<p:insertInfluenceResponse xmlns:p=\"%s\">"
				+ "<return>%s</return>"
				+ "</p:insertInfluenceResponse>", RESPONSE_NS,String.valueOf(value));
		return AXIOMUtil.stringToOM(xml);
	}
}
