package org.primefaces.material.component.input;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.material.MaterialPrime;
import org.primefaces.material.util.Strings;

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
	@ResourceDependency(library = "material-prime", name = "input/input.js")
})
public class Input extends InputText {
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Input";
	static final String PRE_ADDON_FACET_NAME = "preAddon";
	static final String POST_ADDON_FACET_NAME = "postAddon";
	static Map<String, String> INPUT_VALID_HEIGHT;
	
	static{
		Map<String,String> sizes = new HashMap<String, String>();
		
		sizes.put("large", "lg");
		sizes.put("default", "");
		sizes.put("small", "sm");
		
		INPUT_VALID_HEIGHT = Collections.unmodifiableMap(sizes);
	}
	
	
	protected enum PropertyKeys {
		floatingPlaceholder,
		height,
		hint
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public boolean isFloatingPlaceholder() {
		return (Boolean) getStateHelper().eval(PropertyKeys.floatingPlaceholder, true);
	}

	public void setFloatingPlaceholder(boolean floatingLabel) {
		getStateHelper().put(PropertyKeys.floatingPlaceholder, floatingLabel);
	}
	
	public String getHeight() {
		return (String) getStateHelper().eval(PropertyKeys.height, "default");
	}

	public void setHeight(String height) {
		getStateHelper().put(PropertyKeys.height, height);
	}
	
	public String getHint() {
		return (String) getStateHelper().eval(PropertyKeys.hint, Strings.EMPTY);
	}

	public void setHint(String hint) {
		getStateHelper().put(PropertyKeys.hint, hint);
	}
}
