package org.primefaces.material.component.fileinput;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class FileInputRenderer extends CoreRenderer{

	public static final String RENDERER_TYPE = "org.primefaces.material.component.FileInputRenderer";

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		FileInput fileInput = (FileInput) component;

		encodeMarkup(context, fileInput);
		encodeScript(context, fileInput);
	}

	private void encodeMarkup(FacesContext context, FileInput fileInput) throws IOException {
		
		ResponseWriter writer = context.getResponseWriter();

		String inputId = fileInput.getClientId() + "_input";

		writer.startElement("div", fileInput);
			writer.writeAttribute("id", fileInput.getClientId(), null);
			writer.writeAttribute("class", "file-field input-field", null);
			
			

//			writer.startElement("div", null);
//				writer.writeAttribute("class", "btn", null);
//				
//				writer.startElement("span", null);
//					writer.write("File");					
//				writer.endElement("span");
//				writer.startElement("input", null);
//					writer.writeAttribute("type", "file", null);	
//					writer.writeAttribute("id", inputId, null);
//					writer.writeAttribute("name", inputId, null);
//					writer.writeAttribute("value", fileInput.getValue(), null);
//				writer.endElement("input");	
//				writer.startElement("div", null);
//					writer.writeAttribute("class", "file-path-wrapper", null);
//					
//					writer.startElement("input", null);
//						writer.writeAttribute("type", "text", null);	
//						writer.writeAttribute("class", "file-path validate valid", null);
//					writer.endElement("input");	
//				writer.endElement("div");	
//			
//			writer.endElement("div");
			
			
			
			
			writer.startElement("input", null);				
				writer.writeAttribute("class", "file-path validate", null);
				writer.writeAttribute("type", "text", null);	
				writer.writeAttribute("id", inputId, null);
				writer.writeAttribute("name", inputId, null);
				writer.writeAttribute("value", fileInput.getValue(), null);
			writer.endElement("input");	
			writer.startElement("div", null);
				writer.writeAttribute("class", "btn", null);
				writer.startElement("span", null);
					writer.write("File");					
				writer.endElement("span");
				writer.startElement("input", null);
					writer.writeAttribute("type", "file", null);						
				writer.endElement("input");	
			writer.endElement("div");

		writer.endElement("div");
	}

	private void encodeScript(FacesContext context, FileInput fileInput) throws IOException {
		String clientId = fileInput.getClientId();
		String widgetVar = fileInput.resolveWidgetVar();

		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);

		wb.initWithDomReady("FileInput", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);

		encodeClientBehaviors(context, fileInput);

		wb.finish();
	}

	@Override
	public void decode(FacesContext context, UIComponent component) {
		FileInput fileInput = (FileInput) component;

		if(fileInput.isDisabled()) {
			return;
		}

		String clientId = fileInput.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue != null) {
			fileInput.setSubmittedValue(submittedValue);
		}	

		decodeBehaviors(context, fileInput);
	}

}
