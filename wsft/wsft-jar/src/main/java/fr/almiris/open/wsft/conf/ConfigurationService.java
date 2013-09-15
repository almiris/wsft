package fr.almiris.open.wsft.conf;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ConfigurationService {

	public ConfigurationService() {
	}

	public Configuration loadConfiguration(InputStream is) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Configuration.class);
		Unmarshaller u = jc.createUnmarshaller();
		return (Configuration)u.unmarshal(is);
	}
	
	public String toString(Configuration c) throws JAXBException {
		StringWriter sw = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(Configuration.class);
		Marshaller m = jc.createMarshaller();
		m.marshal(c, sw);	
		return sw.toString();
	}
}
