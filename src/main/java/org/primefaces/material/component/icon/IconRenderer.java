package org.primefaces.material.component.icon;

import java.io.IOException;
import java.util.Arrays;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.util.Strings;
import org.primefaces.renderkit.CoreRenderer;

public class IconRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.IconRenderer";
	
	public static void renderIcon(FacesContext context, String iconName) throws IOException{
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement("i", null);
			writer.writeAttribute("class", iconName, null);
		writer.endElement("i");
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Icon icon = (Icon) component;

		encodeMarkup(context, icon);
	}

	private void encodeMarkup(FacesContext context, Icon icon) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement("i", icon);
			writer.writeAttribute("id", icon.getClientId(), null);
			writer.writeAttribute("class", getIconClass(icon), null);
		writer.endElement("i");
	}

	private String getIconClass(Icon icon) {
		String toReturn = icon.getName();
		
		String size = Strings.isNotEmpty(icon.getSize()) && Arrays.asList(Icon.VALID_SIZE_VALUES).contains(icon.getSize()) ? icon.getSize() : Icon.VALID_SIZE_VALUES[0];
		
		toReturn += " " + size;
		
		return toReturn;
	}
}
