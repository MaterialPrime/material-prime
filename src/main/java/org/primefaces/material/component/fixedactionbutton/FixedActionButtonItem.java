package org.primefaces.material.component.fixedactionbutton;

import javax.faces.component.UICommand;

import org.primefaces.component.api.AjaxSource;
import org.primefaces.material.MaterialPrime;
import org.primefaces.material.util.Strings;

public class FixedActionButtonItem extends UICommand implements AjaxSource{
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.FixedActionButtonItem";
	
	protected enum PropertyKeys {
		color,
		icon, 
		oncomplete, 
		onerror, 
		onsuccess, 
		onstart, 
		global, 
		process, 
		update, 
		resetValues, 
		ignoreAutoUpdate,
		partialSubmit,
		delay, 
		timeout,
		partialSubmitFilter, async;
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
	
	public Object getColor() {
		return getStateHelper().eval(PropertyKeys.color, null);
	}

	public void setColor(Object color) {
		getStateHelper().put(PropertyKeys.color, color);
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
	
	public java.lang.String getProcess() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.process, null);
	}
	
	public void setProcess(java.lang.String _process) {
		getStateHelper().put(PropertyKeys.process, _process);
	}

	public java.lang.String getUpdate() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.update, null);
	}
	
	public void setUpdate(java.lang.String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
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
	
	public boolean isPartialSubmitSet() {
        return (getStateHelper().get(PropertyKeys.partialSubmit) != null) || (this.getValueExpression("partialSubmit") != null);
    }
    
    public boolean isResetValuesSet() {
        return (getStateHelper().get(PropertyKeys.resetValues) != null) || (this.getValueExpression("resetValues") != null);
    }
    
    public boolean isPartialSubmit() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.partialSubmit, false);
	}
    
	public void setPartialSubmit(boolean _partialSubmit) {
		getStateHelper().put(PropertyKeys.partialSubmit, _partialSubmit);
	}
    
    public boolean isAjaxified() {
        return true;
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
	
	public java.lang.String getPartialSubmitFilter() {
		return (java.lang.String) getStateHelper().eval(PropertyKeys.partialSubmitFilter, null);
	}
	
	public void setPartialSubmitFilter(java.lang.String _partialSubmitFilter) {
		getStateHelper().put(PropertyKeys.partialSubmitFilter, _partialSubmitFilter);
	}

	public boolean isAsync() {
		return (java.lang.Boolean) getStateHelper().eval(PropertyKeys.async, false);
	}
	
	public void setAsync(boolean _async) {
		getStateHelper().put(PropertyKeys.async, _async);
	}
}
