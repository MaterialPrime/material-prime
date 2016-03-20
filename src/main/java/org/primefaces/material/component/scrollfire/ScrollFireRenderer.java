package org.primefaces.material.component.scrollfire;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class ScrollFireRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ScrollFireRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent scrollFire) {
		
		String param = scrollFire.getClientId(context);
		if(context.getExternalContext().getRequestParameterMap().containsKey(param)) {
			scrollFire.queueEvent(new ActionEvent(scrollFire));
		}
		
        decodeBehaviors(context, scrollFire);
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ScrollFire scrollFire = (ScrollFire) component;
		
		encodeMarkup(context, scrollFire);
		encodeScript(context, scrollFire);
	}

	private void encodeScript(FacesContext context, ScrollFire scrollFire) throws IOException {
		String clientId = scrollFire.getClientId();
		String widgetVar = scrollFire.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("ScrollFire", widgetVar, clientId);
		wb.attr("selector", scrollFire.getSelector());
		wb.attr("offset", scrollFire.getOffset());
		wb.callback("onScroll", generateCallback(context,scrollFire));
		wb.finish();
		 
	}
	
	private String generateCallback(FacesContext context, ScrollFire scrollFire){
		return "function(){" + buildAjaxRequest(context, scrollFire,null) + "}";		
	}
	
	private void encodeMarkup(FacesContext context, ScrollFire scrollFire) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement("div", scrollFire);
			writer.writeAttribute("id", scrollFire.getClientId(), null);
			writer.writeAttribute("style", "display:none", null);
		writer.endElement("div");
	}
}
