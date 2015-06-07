package org.primefaces.material.component.input;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.HTML;
import org.primefaces.util.WidgetBuilder;

public class InputRenderer extends CoreRenderer{
	
	public static final String RENDERER_TYPE = "org.primefaces.material.component.InputRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Input input = (Input) component;

		encodeMarkup(context, input);
		encodeScript(context, input);
	}

	//TODO: manage add-ons
	private boolean hasAddons(Input input){
		return input.getFacet(Input.PRE_ADDON_FACET_NAME) != null || input.getFacet(Input.POST_ADDON_FACET_NAME) != null;
	}
	
	private void encodeMarkup(FacesContext context, Input input) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();
		
		String inputId = input.getClientId() + "_input";
		
		writer.startElement("div", input);
			writer.writeAttribute("id", input.getClientId(), null);
			writer.writeAttribute("class", "input-field", null);
				
				writer.startElement("input", null);
					writer.writeAttribute("id", inputId, null);
					writer.writeAttribute("class", "validate", null);
					writer.writeAttribute("type", input.getType(), null);
					if(input.isDisabled()){
						writer.writeAttribute("disabled", "true", null);
					}
					
					if(input.isShowCounter() && input.getMaxlength() > 0){
						writer.writeAttribute("length", input.getMaxlength(), null);
					}
					
					writer.writeAttribute("placeholder", input.getPlaceholder(), null);
					renderPassThruAttributes(context, input, HTML.INPUT_TEXT_ATTRS_WITHOUT_EVENTS);
					renderDomEvents(context, input, HTML.INPUT_TEXT_EVENTS);
				writer.endElement("input");
				
				if(input.getLabel() != null){
					writer.startElement("label", null);
						writer.writeAttribute("for", inputId, null);
						writer.writeAttribute("class", "active", null);
						writer.write(input.getLabel());
					writer.endElement("label");
				}
				
		writer.endElement("div");
	}
	
	private void encodeScript(FacesContext context, Input input) throws IOException {
		String clientId = input.getClientId();
		String widgetVar = input.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("Input", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		encodeClientBehaviors(context, input);
		 
		wb.finish();
		 
	}


}
