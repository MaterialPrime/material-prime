package org.primefaces.material.component.fixedactionbutton;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.commandbutton.CommandButtonRenderer;
import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.util.WidgetBuilder;

public class FixedActionButtonRenderer extends CommandButtonRenderer{
	
	public static final String RENDERER_TYPE = "org.primefaces.material.component.FixedActionButtonRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		FixedActionButton button = (FixedActionButton) component;
		
		encodeMarkup(context, button);
		encodeScript(context, button);
	}
	
	protected void encodeScript(FacesContext context, FixedActionButton button) throws IOException {
		String clientId = button.getClientId();
		String widgetVar = button.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("FixedActionButton", widgetVar, clientId);
		 
		wb.finish();
	}
	
	protected void encodeMarkup(FacesContext context, FixedActionButton fab) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement("div", fab);
		writer.writeAttribute("class", "fixed-action-btn", null);
			writer.startElement("a", null);
			writer.writeAttribute("class", "btn-floating btn-large red", null);
				writer.startElement("i", null);
					writer.writeAttribute("class", "large " + fab.getIcon(), null);
				writer.endElement("i");
			writer.endElement("a");
			writer.startElement("ul", null);
			for (UIComponent child : fab.getChildren()) {
				renderFabItem(context,writer,(FixedActionButtonItem) child);
			}
			writer.endElement("ul");
		writer.endElement("div");
		
	}
	
	private void renderFabItem(FacesContext context, ResponseWriter writer, FixedActionButtonItem child) throws IOException {
	     writer.startElement("li", child);
	     	writer.startElement("a", null);
			writer.writeAttribute("class", "btn-floating blue", null);
		     	writer.startElement("i", null);
		     		writer.writeAttribute("class",  child.getIcon(), null);
				writer.endElement("i");
			writer.endElement("a");
	     writer.endElement("li");
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        //Rendering happens on encodeEnd
	}
	
	@Override
	public boolean getRendersChildren() {
	    return true;
}
	
}
