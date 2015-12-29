package org.primefaces.material.component.fixedactionbutton;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.Widget;
import org.primefaces.material.MaterialPrime;
import org.primefaces.material.component.fixedactionbutton.FixedActionButtonItem.PropertyKeys;
import org.primefaces.material.util.Strings;

@ResourceDependencies({ @ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
		@ResourceDependency(library = "primefaces", name = "primefaces.js"),
		@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
		@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
		@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
		@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
		@ResourceDependency(library = "material-prime", name = "fixedactionbutton/fixedactionbutton.js") })
public class FixedActionButton extends UIPanel implements Widget {

	public static final String COMPONENT_TYPE = "org.primefaces.material.component.FixedActionButton";

	public FixedActionButton() {
		setRendererType(FixedActionButtonRenderer.RENDERER_TYPE);
	}

	protected enum PropertyKeys {
		horizontal, icon, widgetVar, color, clickToToggle, style, styleClass;
	}

	public java.lang.String getStyle() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.style);
	}

	public void setStyle(java.lang.String style) {
		getStateHelper().put(PropertyKeys.style, style);
	}

	public java.lang.String getStyleClass() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.styleClass);
	}

	public void setStyleClass(java.lang.String styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, styleClass);
	}

	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}

	public String getIcon() {
		return (String) getStateHelper().eval(PropertyKeys.icon, Strings.EMPTY);
	}

	public void setIcon(String icon) {
		getStateHelper().put(PropertyKeys.icon, icon);
	}

	public boolean isHorizontal() {
		return (Boolean) getStateHelper().eval(PropertyKeys.horizontal, false);
	}

	public void setHorizontal(boolean horizontal) {
		getStateHelper().put(PropertyKeys.horizontal, horizontal);
	}

	public boolean isClickToToggle() {
		return (Boolean) getStateHelper().eval(PropertyKeys.clickToToggle, false);
	}

	public void setClickToToggle(boolean clickToToggle) {
		getStateHelper().put(PropertyKeys.clickToToggle, clickToToggle);
	}

	public Object getColor() {
		return getStateHelper().eval(PropertyKeys.color, null);
	}

	public void setColor(Object color) {
		getStateHelper().put(PropertyKeys.color, color);
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

		if (userWidgetVar != null)
			return userWidgetVar;
		else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}

}
