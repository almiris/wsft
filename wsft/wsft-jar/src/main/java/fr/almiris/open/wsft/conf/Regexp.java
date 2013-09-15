package fr.almiris.open.wsft.conf;

import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="regexp")  
@XmlAccessorType(XmlAccessType.NONE)
public class Regexp {

	private String regexp;

	private Pattern pattern;

	public Regexp() {
	}

	public String getRegexp() {
		return regexp;
	}
	
	@XmlValue
	public void setRegexp(String regexp) {
		this.regexp = regexp;
		pattern = Pattern.compile(regexp);
	}
	
	public boolean matches(String path) {
		return pattern.matcher(path).matches();
	}
}
