package org.primefaces.material.component.chips;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.material.util.Strings;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class ChipsRenderer extends CoreRenderer{

	public static final String RENDERER_TYPE = "org.primefaces.material.component.ChipsRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Chips chips = (Chips) component;
		
		encodeMarkup(context, chips);
		encodeScript(context, chips);
	}

	private void encodeScript(FacesContext context, Chips chips) throws IOException {
		String clientId = chips.getClientId();
		String widgetVar = chips.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("Chips", widgetVar, clientId);
		 
		wb.finish();
		 
	}
	
	private void encodeMarkup(FacesContext context, Chips chips) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
				
		writer.startElement("div", chips);
			writer.writeAttribute("id", chips.getClientId(), null);
			writer.writeAttribute("class", "chip", null);
			
			if(Strings.isNotEmpty(chips.getUrl())){
				writer.startElement("img", null);
					writer.writeAttribute("src", chips.getUrl(), null);								
				writer.endElement("img");
			}
			
			writer.write(chips.getLabel());
			
			if(chips.isClosable()){
				writer.startElement("i", null);
					writer.writeAttribute("class", "material-icons", null);		
					writer.write("close");
				writer.endElement("i");
			}
		writer.endElement("div");
	}

}
