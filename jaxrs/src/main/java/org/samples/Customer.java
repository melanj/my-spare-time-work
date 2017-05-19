package org.samples;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	
	
	private int id;
	private int age;
	private String name;
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	/*public void setId(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setAge(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}*/

}
