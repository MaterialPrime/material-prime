package org.primefaces.material.component.icon;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;

import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "core.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js")
})
public class Icon extends UIComponentBase{

	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Icon";
	static String[] VALID_SIZE_VALUES = {"tiny","small","medium","large"};
	
	protected enum PropertyKeys {
		name,
		size
	}
	
	public Icon() {
		setRendererType(IconRenderer.RENDERER_TYPE);
	}
	
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public String getName() {
		return (String) getStateHelper().eval(PropertyKeys.name, null);
	}
	
	public void setName(String name) {
		getStateHelper().put(PropertyKeys.name, name);
	}
	
	public String getSize() {
		return (String) getStateHelper().eval(PropertyKeys.size, VALID_SIZE_VALUES[0]);
	}
	
	public void setSize(String size) {
		getStateHelper().put(PropertyKeys.size, size);
	}

}
