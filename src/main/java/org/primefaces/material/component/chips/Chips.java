package org.primefaces.material.component.chips;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "core.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "chips/chips.js")
})
public class Chips extends UIComponentBase implements Widget{

	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Chips";

	public Chips() {
		setRendererType(ChipsRenderer.RENDERER_TYPE);
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	protected enum PropertyKeys {	
		closable,
		url,
		label,
		alt,
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
	
	public java.lang.String getAlt() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.alt, null);
	}
	
	public void setLabel(java.lang.String label) {
		getStateHelper().put(PropertyKeys.label, label);
	}
	
	public java.lang.String getLabel() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.label, null);
	}
	
	public void setUrl(java.lang.String url) {
		getStateHelper().put(PropertyKeys.url, url);
	}
	
	public java.lang.String getUrl() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.url, null);
	}
	
	public void setClosable(boolean closable) {
		getStateHelper().put(PropertyKeys.closable, closable);
	}
	
	public boolean isClosable() {
		return (Boolean) getStateHelper().eval(PropertyKeys.closable, false);
	}
	
	public void setAlt(java.lang.String alt) {
		getStateHelper().put(PropertyKeys.alt, alt);
	}
	
	public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
	
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}
	
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}


}
