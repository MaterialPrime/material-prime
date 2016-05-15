package org.primefaces.material.component.progressbar;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class ProgressBarRenderer extends CoreRenderer{
	
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ProgressBarRenderer";
	
	private static final String PROGRESS_BAR_CLASS = "progress";
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ProgressBar progressBar = (ProgressBar) component;

		encodeMarkup(context, progressBar);
		encodeScript(context, progressBar);
	}

	private void encodeMarkup(FacesContext context, ProgressBar progressBar) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		boolean determinate = progressBar.getValue() != null && progressBar.getValue() > 0;
		
		writer.startElement("div", progressBar);		
			writer.writeAttribute("id", progressBar.getClientId(), null);
			writer.writeAttribute("class", PROGRESS_BAR_CLASS, null);
			writer.startElement("div", null);
				writer.writeAttribute("class", getProgressBarClass(determinate), null);
				if(determinate){
					writer.writeAttribute("style", getProgressBarWidth(progressBar), null);
				}
			writer.endElement("div");
		writer.endElement("div");
	}

	private String getProgressBarWidth(ProgressBar progressBar) {
		return "width: " + progressBar.getValue() + "%;";
	}

	private String getProgressBarClass(boolean determinate) {
		return determinate ? "determinate" : "indeterminate";
	}
	
	private void encodeScript(FacesContext context, ProgressBar progressBar) throws IOException {
		String clientId = progressBar.getClientId();
		String widgetVar = progressBar.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("ProgressBar", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		 
		wb.finish();
		 
	}
}
