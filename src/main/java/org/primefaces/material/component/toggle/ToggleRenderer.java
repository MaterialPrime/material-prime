package org.primefaces.material.component.toggle;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;

import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.ComponentUtils;

public class ToggleRenderer extends CoreRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ToggleRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent component) {
		Toggle toggle = (Toggle) component;

		if(toggle.isDisabled()) {
			return;
		}

		decodeBehaviors(context, toggle);

		String clientId = toggle.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue != null && isChecked(submittedValue)) {
			toggle.setSubmittedValue(true);
		}
		else {
			toggle.setSubmittedValue(false);
		}
	}

	protected boolean isChecked(String value) {
		return value.equalsIgnoreCase("on")||value.equalsIgnoreCase("yes")||value.equalsIgnoreCase("true");
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		Toggle toggle = (Toggle) component;

		encodeMarkup(context, toggle);
	}

	protected void encodeMarkup(FacesContext context, Toggle toggle) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		boolean checked = Boolean.valueOf(ComponentUtils.getValueToRender(context, toggle));
		
		String inputId = toggle.getClientId() + "_input";
		
		writer.startElement("div", toggle);
			writer.writeAttribute("id", toggle.getClientId(), null);
			writer.writeAttribute("class", "togglebutton", null);
			writer.startElement("label", null);
				writer.startElement("input", null);
					writer.writeAttribute("id", inputId, null);
					writer.writeAttribute("name", inputId, null);
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
