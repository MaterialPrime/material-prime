package org.primefaces.material.component.toggle;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckboxRenderer;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.ComponentUtils;

public class ToggleRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ToggleRenderer";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Toggle analogClock = (Toggle) component;

		encodeMarkup(context, analogClock);
	}

	protected void encodeMarkup(FacesContext context, Toggle clock) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		boolean checked = Boolean.valueOf(ComponentUtils.getValueToRender(context, clock));

		writer.startElement("div", clock);
			writer.writeAttribute("id", clock.getClientId(), null);
			writer.writeAttribute("class", "togglebutton", null);
			writer.startElement("label", null);
				writer.startElement("input", null);
				writer.writeAttribute("type", "checkbox", null);
				writer.writeAttribute("checked",  checked, null);
				writer.endElement("input");
			writer.endElement("label");	
		writer.endElement("div");
	}

	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		return ((submittedValue instanceof Boolean) ? submittedValue : Boolean.valueOf(submittedValue.toString()));
	}
}
