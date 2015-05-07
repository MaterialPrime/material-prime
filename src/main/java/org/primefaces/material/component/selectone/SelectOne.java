package org.primefaces.material.component.selectone;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "selectone/selectOne.js")
})
public class SelectOne extends SelectOneMenu{
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.SelectOne";
	
	protected enum PropertyKeys {
		nativeMode
	}
	
	public SelectOne() {
		setRendererType(SelectOneRenderer.RENDERER_TYPE);
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public boolean isNativeMode(){
		return (Boolean) getStateHelper().eval(PropertyKeys.nativeMode,false);
	}
	
	public void setNativeMode(boolean nativeMode){
		getStateHelper().put(PropertyKeys.nativeMode, nativeMode);
	}

}
