package fr.almiris.open.wsft.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="processor")  
@XmlAccessorType(XmlAccessType.NONE)
public class Processor extends HasNameAndParams {
		
	private String clazz;
			
	public Processor() {
	}
		
	public String getClazz() {
		return clazz;
	}
	
	@XmlAttribute(name="class", required=true)
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
}
