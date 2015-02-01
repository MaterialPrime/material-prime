package org.primefaces.material.component.radioButton;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.model.SelectItem;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.InputRenderer;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.WidgetBuilder;

public class RadioButtonRenderer extends InputRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.RadioButtonRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		RadioButton radioButton = (RadioButton) component;

		if(radioButton.isDisabled()) {
			return;
		}

		decodeBehaviors(context, radioButton);

		String clientId = radioButton.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue != null && isChecked(submittedValue)) {
			radioButton.setSubmittedValue(true);
		}
		else {
			radioButton.setSubmittedValue(false);
		}
	}

	protected boolean isChecked(String value) {
		return value.equalsIgnoreCase("on")||value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("true");
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		RadioButton radioButton = (RadioButton) component;

		encodeMarkup(context, radioButton);
		encodeScript(context, radioButton);
	}

	private void encodeMarkup(FacesContext context, RadioButton radioButton) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
						
		String inputId = radioButton.getClientId() + "_input";
		
		boolean checked = Boolean.valueOf(ComponentUtils.getValueToRender(context, radioButton));
		
		List<SelectItem> selectItems = getSelectItems(context, radioButton);
		
		writer.startElement("div", radioButton);
			writer.writeAttribute("class", "col-lg-10", null);				
			
			int i=0;
			for (SelectItem selectItem : selectItems) {
				i++;
				writer.startElement("div", radioButton);
					writer.writeAttribute("class", "radio radio-primary", null);	
					
					writer.startElement("label", null);
						
						writer.startElement("input", null);
							writer.writeAttribute("id", inputId+i, null);
							writer.writeAttribute("type", "radio", null);
							writer.writeAttribute("name", inputId, null);
							writer.writeAttribute("value", selectItem.getValue(), null);
						//	if(i==1){
								writer.writeAttribute("checked", checked, null);	
						//	}														
							writer.write(selectItem.getLabel());		
						writer.endElement("input");	
						
					writer.endElement("label");	
					
				writer.endElement("div");
			}						
			
		writer.endElement("div");				
		
	}
	
	private void encodeScript(FacesContext context, RadioButton radioButton) throws IOException {
		String clientId = radioButton.getClientId();
		String widgetVar = radioButton.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("RadioButton", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		encodeClientBehaviors(context, radioButton);
		 
		wb.finish();
		 
	}
	
	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		return ((submittedValue instanceof Boolean) ? submittedValue : Boolean.valueOf(submittedValue.toString()));
	}
}
