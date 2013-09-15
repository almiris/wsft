package fr.almiris.open.wsft.processors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import fr.almiris.open.wsft.conf.Rule;

public class DefaultProcessorChain extends ProcessorChain {

	public DefaultProcessorChain() {
	}

	public void doChain(Rule rule, ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ProcessorChain next = getNext();
		if (next != null) {
			next.doChain(rule, request, response, chain);
		}
		else {
			chain.doFilter(request, response);
		}
	}

}
