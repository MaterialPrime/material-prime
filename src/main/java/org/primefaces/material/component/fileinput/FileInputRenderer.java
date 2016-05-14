package org.primefaces.material.component.fileinput;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.model.NativeUploadedFile;
import org.primefaces.model.UploadedFileWrapper;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;
import org.primefaces.webapp.MultipartRequest;

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
		
		writer.startElement("form", null);
			writer.writeAttribute("action", "#", null);
			
			writer.startElement("div", fileInput);
				writer.writeAttribute("id", fileInput.getClientId(), null);
				writer.writeAttribute("class", "file-field input-field", null);
				
				writer.startElement("div", null);
					writer.writeAttribute("class", "btn", null);
					
					writer.startElement("span", null);
						writer.write("File");					
					writer.endElement("span");
					
					writer.startElement("input", null);						
						writer.writeAttribute("type", "file", null);	
						writer.writeAttribute("id", inputId, null);
						writer.writeAttribute("value", fileInput.getValue(), null);
						writer.writeAttribute("name", inputId, null);
					writer.endElement("input");	
				writer.endElement("div");
				
				writer.startElement("div", null);
					writer.writeAttribute("class", "file-path-wrapper", null);
					
					writer.startElement("input", null);
						writer.writeAttribute("type", "text", null);	
						writer.writeAttribute("class", "file-path validate", null);
					writer.endElement("input");	
					
				writer.endElement("div");
			writer.endElement("div");
		writer.endElement("form");
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
		try{
			FileInput fileInput = (FileInput) component;

			if(fileInput.isDisabled()) {
				return;
			}
			String clientId = fileInput.getClientId(context);
			
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	        Part part = request.getPart(clientId + "_input");
		   	        
	        if(part != null) {
	        	fileInput.setSubmittedValue(new UploadedFileWrapper(new NativeUploadedFile(part)));
	        }
	        else {
	        	fileInput.setSubmittedValue("");
	        }

			
//			String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");
//
//			if(submittedValue != null) {
//				fileInput.setSubmittedValue(submittedValue);
//			}	

			decodeBehaviors(context, fileInput);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
}
