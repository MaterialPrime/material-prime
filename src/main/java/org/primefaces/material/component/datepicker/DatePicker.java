package org.primefaces.material.component.datepicker;

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
	@ResourceDependency(library = "material-prime", name = "datepicker/datePicker.js")
})
public class DatePicker extends InputText {
	public static final String COMPONENT_TYPE = "org.primefaces.material.component.DatePicker";
	static final String PRE_ADDON_FACET_NAME = "preAddon";
	static final String POST_ADDON_FACET_NAME = "postAddon";
	
	protected enum PropertyKeys {
		pattern,
		selectYears,
		close,
		clear,
		today,
		labelYearSelect,
		labelMonthSelect,
		labelMonthPrev,
		labelMonthNext,
		min,
		max;
	}
	
	@Override
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public String getPattern() {
		return (String) getStateHelper().eval(PropertyKeys.pattern, "yyyy/mm/dd");
	}

	public void setPattern(String property) {
		getStateHelper().put(PropertyKeys.pattern, property);
	}	
	
	public int getSelectYears() {
		return (Integer) getStateHelper().eval(PropertyKeys.selectYears, 15);
	}

	public void setSelectYears(int property) {
		getStateHelper().put(PropertyKeys.selectYears, property);
	}	
	
	public String getToday() {
		return (String) getStateHelper().eval(PropertyKeys.today, "Today");
	}

	public void setToday(String property) {
		getStateHelper().put(PropertyKeys.today, property);
	}	
	
	public String getClear() {
		return (String) getStateHelper().eval(PropertyKeys.clear, "Clear");
	}

	public void setClear(String property) {
		getStateHelper().put(PropertyKeys.clear, property);
	}	
	
	public String getClose() {
		return (String) getStateHelper().eval(PropertyKeys.close, "Close");
	}

	public void setClose(String property) {
		getStateHelper().put(PropertyKeys.close, property);
	}
	
	public String getLabelYearSelect() {
		return (String) getStateHelper().eval(PropertyKeys.labelYearSelect, "Select a year");
	}

	public void setLabelYearSelect(String property) {
		getStateHelper().put(PropertyKeys.labelYearSelect, property);
	}
	
	public String getLabelMonthSelect() {
		return (String) getStateHelper().eval(PropertyKeys.labelMonthSelect, "Select a month");
	}

	public void setLabelMonthSelect(String property) {
		getStateHelper().put(PropertyKeys.labelMonthSelect, property);
	}
	
	public String getLabelMonthPrev() {
		return (String) getStateHelper().eval(PropertyKeys.labelMonthPrev, "Previous month");
	}

	public void setLabelMonthPrev(String property) {
		getStateHelper().put(PropertyKeys.labelMonthPrev, property);
	}
	
	public String getLabelMonthNext() {
		return (String) getStateHelper().eval(PropertyKeys.labelMonthNext, "Next month");
	}

	public void setLabelMonthNext(String property) {
		getStateHelper().put(PropertyKeys.labelMonthNext, property);
	}
	
	public Integer getMin() {
		return (Integer) getStateHelper().eval(PropertyKeys.min, null);
	}

	public void setMin(Integer property) {
		getStateHelper().put(PropertyKeys.min, property);
	}
	
	public Integer getMax() {
		return (Integer) getStateHelper().eval(PropertyKeys.max, null);
	}

	public void setMax(Integer property) {
		getStateHelper().put(PropertyKeys.max, property);
	}

}
