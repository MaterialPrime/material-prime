package org.primefaces.material.component.button;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.commandbutton.CommandButtonRenderer;
import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.material.util.Strings;
import org.primefaces.util.HTML;
import org.primefaces.util.WidgetBuilder;

public class ButtonRenderer extends CommandButtonRenderer{
	
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ButtonRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Button button = (Button) component;
		
		encodeMarkup(context, button);
		encodeScript(context, button);
	}
	
	protected void encodeScript(FacesContext context, Button button) throws IOException {
		String clientId = button.getClientId();
		String widgetVar = button.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("Button", widgetVar, clientId);
		 
		wb.finish();
	}
	
	protected void encodeMarkup(FacesContext context, Button button) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();
		
		boolean pushButton = (button.getType().equals("reset")||button.getType().equals("button"));
        String request = pushButton ? null: buildRequest(context, button, button.getClientId());        
        String onclick = buildDomEvent(context, button, "onclick", "click", "action", request);		
		String buttonClass = getButtonClass(button);
		boolean hasIcon = button.getIcon() != null;
		
		writer.startElement("button", button);		
			writer.writeAttribute("id", button.getClientId(), null);
			writer.writeAttribute("class", buttonClass , null);	
			writer.writeAttribute("onclick", onclick, "onclick");
			writer.writeAttribute("data-tooltip", button.getTooltip(), "tooltip");
			writer.writeAttribute("data-delay", 50, null);
			writer.writeAttribute("data-position", button.getTooltipPos(), "tooltipPos");
			renderPassThruAttributes(context, button, HTML.BUTTON_ATTRS, HTML.CLICK_EVENT);

	        if(button.isDisabled()) writer.writeAttribute("disabled", "disabled", "disabled");
	        if(button.isReadonly()) writer.writeAttribute("readonly", "readonly", "readonly");
	        
	        if(hasIcon){
	        	writer.startElement("i", null);
					writer.writeAttribute("id", button.getClientId()+"_icon", null);
					writer.writeAttribute("class", getIconCass(button), null);
				writer.endElement("i");
	        }
	        
	        if(button.getValue() != null){
	        	writer.write(button.getValue().toString());
	        }
	   writer.endElement("button");
			
	}

	private String getIconCass(Button button) {
		String cssClass = button.getIcon();
		if(button.getValue() != null){
			cssClass += " " + button.getIconPos();
		}
		return cssClass;
	}

	private String getButtonClass(Button button) {
		
		String btnClass = "waves-effect waves-light ";
		btnClass += button.isFlat() ? "btn-flat" : "btn";
		
		String buttonSize = button.getSize() != null ? button.getSize().toLowerCase() : "small";
		if(Button.BUTTON_SIZES.contains(buttonSize)){
			btnClass += " btn-" + buttonSize;
		}
		
		if(Strings.isNotEmpty(button.getTooltip())){
			btnClass += " tooltipped";
		}
		
		if(button.isDisabled()){
			btnClass += " disabled";
		}
		
		return btnClass;
	}
	
}
