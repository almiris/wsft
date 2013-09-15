package fr.almiris.open.wsft.processors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import fr.almiris.open.wsft.conf.Rule;
import fr.almiris.open.wsft.util.Debug;

public class TimerProcessor extends DefaultProcessorChain {

	public final static String TAG = TimerProcessor.class.getName();

	public TimerProcessor() {
	}

	@Override
	public void doChain(Rule rule, ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long duration = System.currentTimeMillis();
		super.doChain(rule, request, response, chain);
		duration = System.currentTimeMillis() - duration;
		if (Debug.isDebug()) {
			System.out.println(TAG + ": rule " + rule.getName() + " executed in " + duration + " ms");						
		}
	}

}
