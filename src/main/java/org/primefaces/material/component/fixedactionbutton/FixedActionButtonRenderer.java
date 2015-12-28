package org.primefaces.material.component.fixedactionbutton;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.commandbutton.CommandButtonRenderer;
import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.material.util.Strings;
import org.primefaces.util.HTML;
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
		/*
		 * <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
    <a class="btn-floating btn-large red">
      <i class="large material-icons">mode_edit</i>
    </a>
    <ul>
      <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
      <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
      <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
      <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
    </ul>
  </div>
		 */
		
		writer.startElement("div", fab);
			writer.startElement("a", fab);
			writer.writeAttribute("class", "btn-floating btn-large red", null);
				writer.startElement("i", fab);
					writer.writeAttribute("class", "large " + fab.getIcon(), null);
				writer.endElement("i");
			writer.endElement("a");
		writer.endElement("div");
	}
	
}
