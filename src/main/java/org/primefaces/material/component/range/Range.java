package org.primefaces.material.component.range;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.IntegerConverter;

import org.primefaces.component.api.Widget;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "core.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "range/range.js")
})
public class Range extends UIInput implements ClientBehaviorHolder,Widget{
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Range";
	
	protected enum PropertyKeys {
		min,
		max,
		disabled, widgetVar;
	}
	
	public Range() {
		setRendererType(RangeRenderer.RENDERER_TYPE);
	}
	
	public int getMin(){
		return (Integer) this.getStateHelper().eval(PropertyKeys.min, 0);
	}
	
	public void setMin(int min){
		this.getStateHelper().put(PropertyKeys.min, min);
	}
	
	public int getMax(){
		return (Integer) this.getStateHelper().eval(PropertyKeys.max, 100);
	}
	
	public void setMax(int max){
		this.getStateHelper().put(PropertyKeys.max, max);
	}
	
	public boolean isDisabled() {
        return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.disabled, false);

    }

    public void setDisabled(boolean disabled) {
        getStateHelper().put(PropertyKeys.disabled, disabled);
    }
    
    public java.lang.String getWidgetVar() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}
    
	public void setWidgetVar(java.lang.String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}
	
	public String resolveWidgetVar() {
		FacesContext context = getFacesContext();
		String userWidgetVar = (String) getAttributes().get("widgetVar");

		if(userWidgetVar != null)
			return userWidgetVar;
		 else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}
	
	@Override
	public Converter getConverter() {
		return super.getConverter() != null ? super.getConverter() : new IntegerConverter(); 
		
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
}
