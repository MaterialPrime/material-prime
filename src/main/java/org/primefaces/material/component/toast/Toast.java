package org.primefaces.material.component.toast;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;
import org.primefaces.context.RequestContext;
import org.primefaces.material.MaterialPrime;
import org.primefaces.material.application.ToastService;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "core.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "toast/toast.js")
})
public class Toast extends UIComponentBase implements Widget{

	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Toast";

	public Toast() {
		setRendererType(ToastRenderer.RENDERER_TYPE);
	}
	
	protected enum PropertyKeys {
		
		message,
		widgetVar;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}
	
	public String getMessage() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.message, null);
	}
	
	public void setMessage(String message) {
		getStateHelper().put(PropertyKeys.message, message);
	}
	
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
	
	/**
	 * Show this toast at the end of the current ajax request
	 * @param duration
	 */
	public void show(int duration){
		RequestContext.getCurrentInstance().execute(String.format("PF('%s').show(%d);", resolveWidgetVar(),duration));
	}
	
	/**
	 * Show this toast at the end of the current ajax request - it disappear after 1 second
	 */
	public void show(){
		RequestContext.getCurrentInstance().execute(String.format("PF('%s').show(%d);", resolveWidgetVar(),ToastService.DEFAULT_TOAST_DURATION));
	}

}
