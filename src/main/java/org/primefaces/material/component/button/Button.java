package org.primefaces.material.component.button;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/bootstrap.js"),
	@ResourceDependency(library = "material-prime", name = "libs/bootstrap.css"),
	@ResourceDependency(library = "material-prime", name = "libs/material.css"),
	@ResourceDependency(library = "material-prime", name = "libs/material.js"),
	@ResourceDependency(library = "material-prime", name = "libs/ripples.css"),
	@ResourceDependency(library = "material-prime", name = "libs/ripples.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "button/button.js")
})
public class Button extends CommandButton{
	
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Button";
	
	protected enum PropertyKeys {
		look
	}
	
	public Button() {
		setRendererType(ButtonRenderer.RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public String getLook() {
		return (String) getStateHelper().eval(PropertyKeys.look, null);
	}

	public void setLook(String look) {
		getStateHelper().put(PropertyKeys.look, look);
	}
}
