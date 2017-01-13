package org.primefaces.material.component.input;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "core.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "input/input.js")
})
public class Input extends InputText {
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Input";
	
	protected enum PropertyKeys {
		
		icon,
		multiLine,
		showCounter;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public boolean isShowCounter(){
		return (Boolean) this.getStateHelper().eval(PropertyKeys.showCounter,false);
	}
	
	public void setShowCounter(boolean showCounter){
		this.getStateHelper().put(PropertyKeys.showCounter, showCounter);
	}

	public boolean isMultiLine(){
		return (Boolean) this.getStateHelper().eval(PropertyKeys.multiLine,false);
	}
	
	public void setMultiLine(boolean multiLine){
		this.getStateHelper().put(PropertyKeys.multiLine, multiLine);
	}
	
	public String getIcon() {
		return (String) getStateHelper().eval(PropertyKeys.icon, null);
	}
	
	public void setIcon(String _icon) {
		getStateHelper().put(PropertyKeys.icon, _icon);
	}
	
}
