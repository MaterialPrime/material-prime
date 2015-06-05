package org.primefaces.material.component.toast;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class ToastRenderer extends CoreRenderer{

	public static final String RENDERER_TYPE = "org.primefaces.material.component.ToastRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Toast toast = (Toast) component;
		
		encodeMarkup(context, toast);
		encodeScript(context, toast);
	}

	private void encodeScript(FacesContext context, Toast toast) throws IOException {
		String clientId = toast.getClientId();
		String widgetVar = toast.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("Toast", widgetVar, clientId);
		 
		wb.finish();
		 
	}
	
	private void encodeMarkup(FacesContext context, Toast toast) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		UIComponent content = toast.getFacet("content");
		
		writer.startElement("div", toast);
			writer.writeAttribute("id", toast.getClientId(), null);
			writer.writeAttribute("style", "display:none", null);
			if(content != null){
				content.encodeAll(context);
			}else{
				writer.write(toast.getMessage());
			}		
		writer.endElement("div");
	}

}
