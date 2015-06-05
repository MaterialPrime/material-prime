package org.primefaces.material.application;

import org.primefaces.context.RequestContext;
import org.primefaces.material.util.Strings;

public class ToastService {
	private static final int DURATION = 1000;
	private static final String TOAST_SCRIPT = "MaterialPrime.toast('%s', %d, %s)";
	private static ToastService instance;

	private ToastService() {
	}

	public static ToastService getInstance() {
		if (null == instance) {
			instance = new ToastService();
		}
		return instance;
	}
	
	/**
	 * Show a new toast after current ajax request is completed
	 * @param message - could not be null
	 * @param duration
	 * @param rounded - to show a rounded toast
	 */
	public void newToast(String message,int duration, boolean rounded){
		RequestContext.getCurrentInstance().execute(String.format(TOAST_SCRIPT, message,duration, rounded));
	}
	
	/**
	 * Show a new squared toast after current ajax request is completed
	 * @param message - could not be null
	 * @param duration
	 */
	public void newToast(String message,int duration){
		this.newToast(message, duration,false);
	}
	
	/**
	 * Show a new squared toast after current ajax request is completed, it disappears after a second
	 * @param message - could not be null
	 */
	public void newToast(String message){
		this.newToast(message, DURATION);
	}
}
