package org.primefaces.material.application;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.primefaces.material.MaterialPrime;

public class PostConstructApplicationEventListener implements SystemEventListener {

	private static final Logger LOGGER = Logger.getLogger(PostConstructApplicationEventListener.class.getName());

	public boolean isListenerForSource(final Object source) {
		return true;
	}

	public void processEvent(final SystemEvent event) {
		LOGGER.log(Level.INFO, "Running on MaterialPrime {0}",MaterialPrime.VERSION);
	}
}