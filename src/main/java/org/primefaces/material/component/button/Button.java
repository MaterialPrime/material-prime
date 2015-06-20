package org.primefaces.material.component.button;

import java.util.Arrays;
import java.util.Collection;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "button/button.js")
})
public class Button extends CommandButton{
	
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Button";
	static final Collection<String> BUTTON_SIZES = Arrays.asList(new String[]{"large","small"});
	
	protected enum PropertyKeys {
		size,
		flat,
		tooltip,
		tooltipPos;
	}
	
	public Button() {
		setRendererType(ButtonRenderer.RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public boolean isFlat() {
		return (Boolean) getStateHelper().eval(PropertyKeys.flat, false);
	}

	public void setFlat(boolean property) {
		getStateHelper().put(PropertyKeys.flat, property);
	}
	
	public String getSize() {
		return (String) getStateHelper().eval(PropertyKeys.size, "default");
	}

	public void setSize(String size) {
		getStateHelper().put(PropertyKeys.size, size);
	}
	
	public String getTooltip() {
		return (String) getStateHelper().eval(PropertyKeys.tooltip,null);
	}

	public void setTooltip(String tooltip) {
		getStateHelper().put(PropertyKeys.tooltip, tooltip);
	}
	
	public String getTooltipPos() {
		return (String) getStateHelper().eval(PropertyKeys.tooltipPos,"top");
	}

	public void setTooltipPos(String tooltipPos) {
		getStateHelper().put(PropertyKeys.tooltipPos, tooltipPos);
	}
}
