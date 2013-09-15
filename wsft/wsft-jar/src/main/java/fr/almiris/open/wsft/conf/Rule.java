package fr.almiris.open.wsft.conf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rule")  
@XmlAccessorType(XmlAccessType.NONE)
public class Rule extends HasNameAndParams {
	
	private List<Regexp> regexps = new ArrayList<Regexp>();

	public Rule() {
	}
		
	public List<Regexp> getRegexps() {
		return regexps;
	}

	@XmlElement(name="regexp")
	public void setRegexps(List<Regexp> regexps) {
		this.regexps = regexps;
	}
	
	public boolean matches(String path) {
		if (regexps != null && regexps.size() > 0) {
			for (Regexp regexp : regexps) {
				if (regexp.matches(path)) {
					return true;
				}
			}
		}
		return false;
	}

}
