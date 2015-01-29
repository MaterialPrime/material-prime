package org.primefaces.material.component.toggle;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;

import org.primefaces.material.MaterialPrime;
import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.WidgetBuilder;

public class ToggleRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ToggleRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		Toggle toggle = (Toggle) component;

		if(toggle.isDisabled()) {
			return;
		}

		decodeBehaviors(context, toggle);

		String clientId = toggle.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue != null && isChecked(submittedValue)) {
			toggle.setSubmittedValue(true);
		}
		else {
			toggle.setSubmittedValue(false);
		}
	}

	protected boolean isChecked(String value) {
		return value.equalsIgnoreCase("on")||value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("true");
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Toggle toggle = (Toggle) component;

		encodeMarkup(context, toggle);
		encodeScript(context, toggle);
	}

	private void encodeMarkup(FacesContext context, Toggle toggle) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		boolean checked = Boolean.valueOf(ComponentUtils.getValueToRender(context, toggle));
		
		String inputId = toggle.getClientId() + "_input";
		
		writer.startElement("div", toggle);
			writer.writeAttribute("id", toggle.getClientId(), null);
			writer.writeAttribute("class", "togglebutton", null);
			writer.startElement("label", null);
				writer.startElement("input", null);
					writer.writeAttribute("id", inputId, null);
					writer.writeAttribute("name", inputId, null);
					if(toggle.getTabindex() != null){
			        	writer.writeAttribute("tabindex", toggle.getTabindex(), null);
			        }
					if(toggle.isDisabled()){
						writer.writeAttribute("disabled", toggle.isDisabled(), null);
					}
					writer.writeAttribute("type", "checkbox", null);
					writer.writeAttribute("checked",  checked, null);
				writer.endElement("input");
				if(toggle.getItemLabel() != null){
					writer.write(toggle.getItemLabel());
				}
			writer.endElement("label");	
		writer.endElement("div");
	}
	
	private void encodeScript(FacesContext context, Toggle toggle) throws IOException {
		String clientId = toggle.getClientId();
		String widgetVar = toggle.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("Toggle", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		encodeClientBehaviors(context, toggle);
		 
		wb.finish();
		 
	}
	
	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		return ((submittedValue instanceof Boolean) ? submittedValue : Boolean.valueOf(submittedValue.toString()));
	}
}
