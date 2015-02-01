package org.primefaces.material.component.button;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
	static final Collection<String> BUTTON_LEVELS = Collections.unmodifiableList(Arrays.asList(new String[]{"default","flat","raised"}));
	static final Map<String,String> BUTTON_SIZES;
	
	protected enum PropertyKeys {
		size,
		level,
		look
	}
	
	static{
		Map<String,String> sizes = new HashMap<String, String>();
		
		sizes.put("large", "lg");
		sizes.put("small", "sm");
		sizes.put("mini", "xs");
		
		BUTTON_SIZES = Collections.unmodifiableMap(sizes);
	}
	
	public Button() {
		setRendererType(ButtonRenderer.RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public String getLook() {
		return (String) getStateHelper().eval(PropertyKeys.look, "default");
	}

	public void setLook(String look) {
		getStateHelper().put(PropertyKeys.look, look);
	}
	
	public String getLevel() {
		return (String) getStateHelper().eval(PropertyKeys.level, "default");
	}

	public void setLevel(String level) {
		getStateHelper().put(PropertyKeys.level, level);
	}
	
	public String getSize() {
		return (String) getStateHelper().eval(PropertyKeys.size, "default");
	}

	public void setSize(String size) {
		getStateHelper().put(PropertyKeys.size, size);
	}
}
