package fr.almiris.open.wsft.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="param")  
@XmlAccessorType(XmlAccessType.NONE)
public class Param extends HasName {
	
	private String value;
	
	public Param() {
	}
			
	public String getValue() {
		return value;
	}
	
	@XmlAttribute(name="value", required=true)
	public void setValue(String value) {
		this.value = value;
	}

}
