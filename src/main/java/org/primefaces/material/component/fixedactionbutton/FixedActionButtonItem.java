package org.primefaces.material.component.fixedactionbutton;

import javax.faces.component.UICommand;

import org.primefaces.material.MaterialPrime;
import org.primefaces.material.util.Strings;

public class FixedActionButtonItem extends UICommand {
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.FixedActionButtonItem";
	
	protected enum PropertyKeys {
		icon;
	}
	
	public FixedActionButtonItem() {
		setRendererType(null);
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
}
