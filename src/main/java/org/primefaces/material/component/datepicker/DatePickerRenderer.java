package org.primefaces.material.component.datepicker;

import java.io.IOException;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class DatePickerRenderer extends CoreRenderer{

	public static final String RENDERER_TYPE = "org.primefaces.material.component.DatePickerRenderer";

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		DatePicker datePicker = (DatePicker) component;

		encodeMarkup(context, datePicker);
		encodeScript(context, datePicker);
	}

	private void encodeMarkup(FacesContext context, DatePicker datePicker) throws IOException {
		DateTimeConverter converter=new DateTimeConverter();
		converter.setPattern(datePicker.getPattern());
		String value = converter.getAsString(context, datePicker, datePicker.getValue());
		
		ResponseWriter writer = context.getResponseWriter();

		String inputId = datePicker.getClientId() + "_input";

		writer.startElement("div", datePicker);
		writer.writeAttribute("id", datePicker.getClientId(), null);

		writer.startElement("input", null);
			writer.writeAttribute("id", inputId, null);
			writer.writeAttribute("name", inputId, null);
			writer.writeAttribute("value", value, null);
			writer.writeAttribute("class", "datepicker picker__input", null);
			writer.writeAttribute("type", "text", null);					
			writer.writeAttribute("readonly", "", null);
			writer.writeAttribute("tabindex", "-1", null);
			writer.writeAttribute("aria-haspopup", "true", null);
			writer.writeAttribute("aria-expanded", "false", null);
			writer.writeAttribute("aria-readonly", "false", null);
			writer.writeAttribute("aria-owns", inputId+"_root", null);
		writer.endElement("input");	

		writer.endElement("div");
	}

	private void encodeScript(FacesContext context, DatePicker datePicker) throws IOException {
		String clientId = datePicker.getClientId();
		String widgetVar = datePicker.resolveWidgetVar();

		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);

		wb.initWithDomReady("DatePicker", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		wb.attr("pattern", datePicker.getPattern());
		wb.attr("selectYears", datePicker.getSelectYears());
		wb.attr("today", datePicker.getToday());
		wb.attr("clear", datePicker.getClear());
		wb.attr("close", datePicker.getClose());
		wb.attr("labelMonthNext", datePicker.getLabelMonthNext());
		wb.attr("labelMonthPrev", datePicker.getLabelMonthPrev());
		wb.attr("labelYearSelect", datePicker.getLabelYearSelect());
		wb.attr("labelMonthSelect", datePicker.getLabelMonthSelect());
		wb.attr("min", datePicker.getMin());
		wb.attr("max", datePicker.getMax());
		encodeClientBehaviors(context, datePicker);

		wb.finish();
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		DatePicker datePicker = (DatePicker) component;

		if(datePicker.isDisabled()) {
			return;
		}

		String clientId = datePicker.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue != null) {
			datePicker.setSubmittedValue(submittedValue);
		}	

		decodeBehaviors(context, datePicker);
	}

	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {	
		DateTimeConverter converter=new DateTimeConverter();
		converter.setPattern(((DatePicker) component).getPattern());
		return ((submittedValue instanceof Date) ? submittedValue : converter.getAsObject(context, component, submittedValue.toString()));
	}
}
