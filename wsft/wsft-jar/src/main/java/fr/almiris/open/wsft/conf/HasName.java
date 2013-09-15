package fr.almiris.open.wsft.conf;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class HasName {

	private String name;

	public String getName() {
		return name;
	}
	
	@XmlAttribute(name="name", required=true)
	public void setName(String name) {
		this.name = name;
	}

}
