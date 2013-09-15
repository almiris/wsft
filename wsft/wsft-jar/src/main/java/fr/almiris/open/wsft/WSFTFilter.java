package fr.almiris.open.wsft;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import fr.almiris.open.wsft.conf.Configuration;
import fr.almiris.open.wsft.conf.ConfigurationService;
import fr.almiris.open.wsft.conf.Processor;
import fr.almiris.open.wsft.conf.Rule;
import fr.almiris.open.wsft.processors.DefaultProcessorChain;
import fr.almiris.open.wsft.processors.ProcessorChain;
import fr.almiris.open.wsft.util.Debug;

public class WSFTFilter implements Filter {
	
	public final static String TAG = WSFTFilter.class.getName();

	public final static String DEFAULT_CONF = "/WEB-INF/wsft-conf.xml";

	public final static String DEBUG_PARAM = "debug";
	
	public final static String CONF_PARAM = "conf";
	
	private ServletContext context;
		
	private Configuration conf;
	
	private ProcessorChain processorChain;
	
	public WSFTFilter() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {	
		context = filterConfig.getServletContext();
		
		String debugParam = filterConfig.getInitParameter(DEBUG_PARAM);		
		Debug.setDebug(Boolean.valueOf(debugParam));

		String confParam = filterConfig.getInitParameter(CONF_PARAM);
		InputStream is = null;
		try {
			is = context.getResourceAsStream(confParam == null || confParam.length() == 0 ? DEFAULT_CONF : confParam);
			ConfigurationService cs = new ConfigurationService();
			conf = cs.loadConfiguration(is);
			List<Processor> processors = conf.getProcessors();
			processorChain = new DefaultProcessorChain();
			for (Processor processor : processors) {
				String clazz = processor.getClazz();
				Object obj = Class.forName(clazz).newInstance();
				if (obj instanceof ProcessorChain) {
					processorChain = ((ProcessorChain)obj).setNext(processorChain);
				}
			}
			if (Debug.isDebug()) {
				System.out.println(TAG + ": " + cs.toString(conf));
			}
		}
		catch (Exception e) {
			System.out.println(TAG + ": Exception: " + e.toString());
		}
		finally {
			try { 
				if (is != null) {
					is.close();
				}
			}
			catch (IOException e) {
				System.out.println(TAG + ": Exception: " + e.toString());
			}
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		List<Rule> rules = conf.getRules();
		for (Rule rule : rules) {
			if (rule.matches(path)) {
				processorChain.doChain(rule, request, response, chain);
				return;
			}
		}
	}

	public void destroy() {
	}

}
