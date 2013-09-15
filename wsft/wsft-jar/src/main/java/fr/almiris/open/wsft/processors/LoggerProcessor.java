package fr.almiris.open.wsft.processors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import fr.almiris.open.wsft.conf.Rule;
import fr.almiris.open.wsft.util.Debug;

public class LoggerProcessor extends DefaultProcessorChain {

	public final static String TAG = LoggerProcessor.class.getName();

	public LoggerProcessor() {
	}

	@Override
	public void doChain(Rule rule, ServletRequest request,
			ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		if (Debug.isDebug()) {
			System.out.println(TAG + ": matches rule:" + rule.getName());						
		}
		super.doChain(rule, request, response, chain);
	}

}
