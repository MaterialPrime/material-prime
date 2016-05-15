package org.primefaces.material.component.progressbar;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "libs/material-icons.css"),
	@ResourceDependency(library = "material-prime", name = "progressbar/progressBar.js")
})
public class ProgressBar extends UIComponentBase implements Widget{
	
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.ProgressBar";
	
	protected enum PropertyKeys {

		widgetVar,
		value;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}

	public ProgressBar() {
		this.setRendererType(ProgressBarRenderer.RENDERER_TYPE);
	}
	
	@Override
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}

	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public String getWidgetVar() {
		return (String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	
	public void setWidgetVar(String widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, widgetVar);
	}
	
	public Integer getValue() {
		return (Integer) getStateHelper().eval(PropertyKeys.value, null);
	}
	
	public void setValue(Integer value) {
		getStateHelper().put(PropertyKeys.value, value);
	}
}
