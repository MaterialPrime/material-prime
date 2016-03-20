package org.primefaces.material.component.scrollfire;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UICommand;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.AjaxSource;
import org.primefaces.component.api.Widget;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
	@ResourceDependency(library = "primefaces", name = "primefaces.js"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "libs/materialize.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.js"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css"),
	@ResourceDependency(library = "material-prime", name = "scrollfire/scrollfire.js")
})
public class ScrollFire extends UICommand implements AjaxSource, Widget {
	
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.ScrollFire";
	
	protected enum PropertyKeys {
		selector,
		widgetVar, 
		timeout, 
		delay, 
		onstart, 
		oncomplete, 
		onerror, 
		onsuccess, 
		global, 
		ignoreAutoUpdate, 
		partialSubmit, 
		resetValues, 
		update, 
		async, 
		process, 
		partialSubmitFilter, 
		form, 
		offset;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}
	
	public ScrollFire() {
		this.setRendererType(ScrollFireRenderer.RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
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

		if (userWidgetVar != null)
			return userWidgetVar;
		else
			return "widget_" + getClientId(context).replaceAll("-|" + UINamingContainer.getSeparatorChar(context), "_");
	}

	public java.lang.String getOnstart() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onstart, null);
	}
	public void setOnstart(java.lang.String _onstart) {
		getStateHelper().put(PropertyKeys.onstart, _onstart);
	}

	public java.lang.String getOncomplete() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.oncomplete, null);
	}
	public void setOncomplete(java.lang.String _oncomplete) {
		getStateHelper().put(PropertyKeys.oncomplete, _oncomplete);
	}

	public java.lang.String getOnerror() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onerror, null);
	}
	public void setOnerror(java.lang.String _onerror) {
		getStateHelper().put(PropertyKeys.onerror, _onerror);
	}

	public java.lang.String getOnsuccess() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.onsuccess, null);
	}
	public void setOnsuccess(java.lang.String _onsuccess) {
		getStateHelper().put(PropertyKeys.onsuccess, _onsuccess);
	}

	public boolean isGlobal() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.global, true);
	}
	public void setGlobal(boolean _global) {
		getStateHelper().put(PropertyKeys.global, _global);
	}

	public boolean isPartialSubmit() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.partialSubmit, false);
	}
	public void setPartialSubmit(boolean _partialSubmit) {
		getStateHelper().put(PropertyKeys.partialSubmit, _partialSubmit);
	}

	public boolean isResetValues() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.resetValues, false);
	}
	public void setResetValues(boolean _resetValues) {
		getStateHelper().put(PropertyKeys.resetValues, _resetValues);
	}

	public boolean isIgnoreAutoUpdate() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.ignoreAutoUpdate, false);
	}
	public void setIgnoreAutoUpdate(boolean _ignoreAutoUpdate) {
		getStateHelper().put(PropertyKeys.ignoreAutoUpdate, _ignoreAutoUpdate);
	}

	public java.lang.String getDelay() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.delay, null);
	}

	public void setDelay(java.lang.String _delay) {
		getStateHelper().put(PropertyKeys.delay, _delay);
	}

	public int getTimeout() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.timeout, 0);
	}

	public void setTimeout(int _timeout) {
		getStateHelper().put(PropertyKeys.timeout, _timeout);
	}

	public java.lang.String getUpdate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.update, null);
	}
	public void setUpdate(java.lang.String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
	}
	
	public java.lang.String getProcess() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.process, null);
	}
	public void setProcess(java.lang.String _process) {
		getStateHelper().put(PropertyKeys.process, _process);
	}
	
	public boolean isAsync() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.async, false);
	}
	public void setAsync(boolean _async) {
		getStateHelper().put(PropertyKeys.async, _async);
	}

	public boolean isPartialSubmitSet() {
        return (getStateHelper().get(PropertyKeys.partialSubmit) != null) || (this.getValueExpression("partialSubmit") != null);
    }
    
    public boolean isResetValuesSet() {
        return (getStateHelper().get(PropertyKeys.resetValues) != null) || (this.getValueExpression("resetValues") != null);
    }
    
    public boolean isAjaxified() {
        return true;
    }

    public java.lang.String getPartialSubmitFilter() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.partialSubmitFilter, null);
	}
	public void setPartialSubmitFilter(java.lang.String _partialSubmitFilter) {
		getStateHelper().put(PropertyKeys.partialSubmitFilter, _partialSubmitFilter);
	}

	public java.lang.String getForm() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.form, null);
	}
	public void setForm(java.lang.String _form) {
		getStateHelper().put(PropertyKeys.form, _form);
	}
	
	public java.lang.String getSelector() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.selector, this.getClientId());
	}
	public void setSelector(java.lang.String selector) {
		getStateHelper().put(PropertyKeys.selector, selector);
	}
	
	public int getOffset() {
		return (java.lang.Integer) getStateHelper().eval(PropertyKeys.offset, 0);
	}

	public void setOffset(int offset) {
		getStateHelper().put(PropertyKeys.offset, offset);
	}
	
}
