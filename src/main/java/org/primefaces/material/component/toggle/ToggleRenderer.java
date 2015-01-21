package org.primefaces.material.component.toggle;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.renderkit.CoreRenderer;

public class ToggleRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ToggleRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Toggle analogClock = (Toggle) component;

		encodeMarkup(context, analogClock);
	}

	protected void encodeMarkup(FacesContext context, Toggle clock) throws IOException {
		ResponseWriter writer = context.getResponseWriter();

		writer.startElement("div", clock);
			writer.writeAttribute("id", clock.getClientId(), null);
			writer.writeAttribute("class", "togglebutton", null);
			writer.startElement("label", null);
				writer.startElement("input", null);
				writer.writeAttribute("type", "checkbox", null);
				writer.endElement("input");
			writer.endElement("label");	
		writer.endElement("div");
	}
}
