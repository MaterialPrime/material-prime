package org.primefaces.material.component.toggle;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIInput;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

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
	@ResourceDependency(library = "material-prime", name = "toggle/toggle.js")
})
public class Toggle extends SelectBooleanCheckbox {
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Toggle";
	public static final String COMPONENT_FAMILY = "org.primefaces.material.component";
	
	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
}
