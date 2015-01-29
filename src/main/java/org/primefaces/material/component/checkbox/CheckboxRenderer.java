package org.primefaces.material.component.checkbox;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;

import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.WidgetBuilder;

public class CheckboxRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.CheckboxRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		Checkbox checkbox = (Checkbox) component;

		if(checkbox.isDisabled()) {
			return;
		}

		decodeBehaviors(context, checkbox);

		String clientId = checkbox.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue != null && isChecked(submittedValue)) {
			checkbox.setSubmittedValue(true);
		}
		else {
			checkbox.setSubmittedValue(false);
		}
	}

	protected boolean isChecked(String value) {
		return value.equalsIgnoreCase("on")||value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("true");
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Checkbox checkbox = (Checkbox) component;

		encodeMarkup(context, checkbox);
		encodeScript(context, checkbox);
	}

	private void encodeMarkup(FacesContext context, Checkbox checkbox) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		boolean checked = Boolean.valueOf(ComponentUtils.getValueToRender(context, checkbox));
		
		String inputId = checkbox.getClientId() + "_input";
		
		writer.startElement("div", checkbox);		
			writer.writeAttribute("id", checkbox.getClientId(), null);
			writer.writeAttribute("class", "checkbox", null);			
			
			writer.startElement("label", null);
				
				writer.startElement("input", null);
					writer.writeAttribute("id", inputId, null);
					writer.writeAttribute("name", inputId, null);
					if(checkbox.getTabindex() != null){
			        	writer.writeAttribute("tabindex", checkbox.getTabindex(), null);
			        }
					if(checkbox.isDisabled()){
						writer.writeAttribute("disabled", checkbox.isDisabled(), null);
					}
					writer.writeAttribute("type", "checkbox", null);
					writer.writeAttribute("checked",  checked, null);
				writer.endElement("input");				
				writer.write(checkbox.getItemLabel());		
				
			writer.endElement("label");		
			
		writer.endElement("div");
	}
	
	private void encodeScript(FacesContext context, Checkbox checkbox) throws IOException {
		String clientId = checkbox.getClientId();
		String widgetVar = checkbox.resolveWidgetVar();
		 
		WidgetBuilder wb = getWidgetBuilder(context);
		 
		wb.initWithDomReady("Checkbox", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		encodeClientBehaviors(context, checkbox);
		 
		wb.finish();
		 
	}
	
	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		return ((submittedValue instanceof Boolean) ? submittedValue : Boolean.valueOf(submittedValue.toString()));
	}
}
