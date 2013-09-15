package fr.almiris.open.wsft.processors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import fr.almiris.open.wsft.conf.Rule;

public abstract class ProcessorChain {

	private ProcessorChain next;

	public ProcessorChain() {
	}

	public ProcessorChain getNext() {
		return next;
	}

	public ProcessorChain setNext(ProcessorChain next) {
		this.next = next;
		return this;
	}

	public abstract void doChain(Rule rule, ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;

}
