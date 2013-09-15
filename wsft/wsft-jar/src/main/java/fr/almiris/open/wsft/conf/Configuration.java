package fr.almiris.open.wsft.conf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")  
@XmlAccessorType(XmlAccessType.NONE)
public class Configuration {
	
	private List<Rule> rules = new ArrayList<Rule>();
	
	private List<Processor> processors = new ArrayList<Processor>();
	
	@XmlElement(name="default")
	private String defaultResult;
	
	public Configuration() {
	}

	public List<Rule> getRules() {
		return rules;
	}

	@XmlElementWrapper(name="rules")
	@XmlElement(name="rule")
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Processor> getProcessors() {
		return processors;
	}

	@XmlElementWrapper(name="processors")
	@XmlElement(name="processor")
	public void setProcessors(List<Processor> processors) {
		this.processors = processors;
	}

	public String getDefaultResult() {
		return defaultResult;
	}

	public void setDefaultResult(String defaultResult) {
		this.defaultResult = defaultResult;
	}

}
