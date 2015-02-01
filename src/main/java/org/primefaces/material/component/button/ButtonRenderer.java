package org.primefaces.material.component.button;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.commandbutton.CommandButtonRenderer;
import org.primefaces.material.MaterialLooks;
import org.primefaces.material.MaterialWidgetBuilder;
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
		String buttonClass = "btn " + getLookClass(button);
		
		writer.startElement("button", button);		
			writer.writeAttribute("id", button.getClientId(), null);
			writer.writeAttribute("class", buttonClass , null);	
			writer.writeAttribute("onclick", onclick, "onclick");
			renderPassThruAttributes(context, button, HTML.BUTTON_ATTRS, HTML.CLICK_EVENT);

	        if(button.isDisabled()) writer.writeAttribute("disabled", "disabled", "disabled");
	        if(button.isReadonly()) writer.writeAttribute("readonly", "readonly", "readonly");
	        if(button.getValue() != null){
	        	writer.write(button.getValue().toString());
	        }
	   writer.endElement("button");
			
	}
	
	private String getLookClass(Button button){
		String look = "default";
		
		if(button.getLook() != null && button.getLook().length() > 0){
			for(MaterialLooks mLook : MaterialLooks.values()){
				if(mLook.name().equalsIgnoreCase(button.getLook())){
					look = button.getLook();
					break;
				}
			}
		}
		
		return "btn-" + look;
	}
}
