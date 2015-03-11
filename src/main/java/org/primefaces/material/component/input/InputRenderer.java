package org.primefaces.material.component.input;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.material.util.Strings;
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

	private String getInputCssClass(Input input){
		String inputClass = "form-control";
		
		if(input.isFloatingPlaceholder() && input.getPlaceholder() != null){
			inputClass += " floating-label";
		}
		
		if(Strings.isNotEmpty(input.getHeight()) && Input.INPUT_VALID_HEIGHT.containsKey(input.getHeight()) && Strings.isNotEmpty(Input.INPUT_VALID_HEIGHT.get(input.getHeight()))){
			inputClass += " input-";
			inputClass += Input.INPUT_VALID_HEIGHT.get(input.getHeight());
		}
		
		return inputClass;
	}
	
	private boolean hasAddons(Input input){
		return input.getFacet(Input.PRE_ADDON_FACET_NAME) != null || input.getFacet(Input.POST_ADDON_FACET_NAME) != null;
	}
	
	private void encodeMarkup(FacesContext context, Input input) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		String inputId = input.getClientId() + "_input";
		
		writer.startElement("div", input);
			writer.writeAttribute("id", input.getClientId(), null);
			writer.writeAttribute("class", "form-group", null);
				if(input.getLabel() != null){
					writer.startElement("label", null);
						writer.writeAttribute("class", "control-label", null);
						writer.writeAttribute("for", inputId, null);
						writer.write(input.getLabel());
					writer.endElement("label");
				}
				
				if(hasAddons(input)){
					writer.startElement("div", null);
					writer.writeAttribute("class", "input-group", null);
					
					if(input.getFacet(Input.PRE_ADDON_FACET_NAME) != null){
						writer.startElement("span", null);
						writer.writeAttribute("class", "input-group-addon", null);
						this.renderChild(context, input.getFacet(Input.PRE_ADDON_FACET_NAME));
						writer.endElement("span");
					}
				}
				
				writer.startElement("input", null);
					writer.writeAttribute("id", inputId, null);
					writer.writeAttribute("class", getInputCssClass(input), null);
					writer.writeAttribute("type", input.getType(), null);
					writer.writeAttribute("placeholder", input.getPlaceholder(), null);
					writer.writeAttribute("data-hint", input.getHint(), null);
					renderPassThruAttributes(context, input, HTML.INPUT_TEXT_ATTRS_WITHOUT_EVENTS);
					renderDomEvents(context, input, HTML.INPUT_TEXT_EVENTS);
				writer.endElement("input");
				
				if(hasAddons(input)){
					
					if(input.getFacet(Input.POST_ADDON_FACET_NAME) != null){
						writer.startElement("span", null);
						writer.writeAttribute("class", "input-group-addon", null);
						this.renderChild(context, input.getFacet(Input.POST_ADDON_FACET_NAME));
						writer.endElement("span");
					}
					
					writer.endElement("div");
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
