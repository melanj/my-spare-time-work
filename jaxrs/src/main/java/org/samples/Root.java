package org.samples;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.samples.ExportFile.MyDataList;

@XmlRootElement
public class Root {
	
	private MyDataList customers;

	public MyDataList getCustomers() {
		return customers;
	}

	@XmlElement
	public void setCustomers(MyDataList customers) {
		this.customers = customers;
	}


}
