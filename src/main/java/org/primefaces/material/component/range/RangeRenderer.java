package org.primefaces.material.component.range;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class RangeRenderer extends CoreRenderer {

public static final String RENDERER_TYPE = "org.primefaces.material.component.CheckboxRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		Range range = (Range) component;

		if(range.isDisabled()) {
			return;
		}

		decodeBehaviors(context, range);

		String clientId = range.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");
		range.setSubmittedValue(submittedValue);
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Range checkbox = (Range) component;

		encodeMarkup(context, checkbox);
		encodeScript(context, checkbox);
	}

	private void encodeMarkup(FacesContext context, Range range) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		String inputId = range.getClientId() + "_input";
		
		writer.startElement("p", range);		
			writer.writeAttribute("id", range.getClientId(), null);
			writer.writeAttribute("class", "range-field", null);
			
			writer.startElement("input", null);
				writer.writeAttribute("id", inputId, null);
				writer.writeAttribute("name", inputId, null);
				writer.writeAttribute("value", range.getValue(), null);
				writer.writeAttribute("min", range.getMin(), "min");
				writer.writeAttribute("max", range.getMax(), "max");
				if(range.isDisabled()){
					writer.writeAttribute("disabled", range.isDisabled(), null);
				}
				writer.writeAttribute("type", "range", null);
				
			writer.endElement("input");				
		writer.endElement("p");
	}
	
	private void encodeScript(FacesContext context, Range checkbox) throws IOException {
		String clientId = checkbox.getClientId();
		String widgetVar = checkbox.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("Range", widgetVar, clientId);
		encodeClientBehaviors(context, checkbox);
		 
		wb.finish();
		 
	}

}
