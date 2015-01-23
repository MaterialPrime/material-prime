package org.primefaces.material.component.icon;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.renderkit.CoreRenderer;

public class IconRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.IconRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Icon icon = (Icon) component;

		encodeMarkup(context, icon);
	}

	private void encodeMarkup(FacesContext context, Icon icon) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement("i", icon);
			writer.writeAttribute("id", icon.getClientId(), null);
			writer.writeAttribute("class", icon.getName(), null);
		writer.endElement("i");
	}
}
