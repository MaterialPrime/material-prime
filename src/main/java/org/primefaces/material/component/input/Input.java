package org.primefaces.material.component.input;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "input/input.js")
})
public class Input extends InputText {
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Input";
	static final String PRE_ADDON_FACET_NAME = "preAddon";
	static final String POST_ADDON_FACET_NAME = "postAddon";
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
}
