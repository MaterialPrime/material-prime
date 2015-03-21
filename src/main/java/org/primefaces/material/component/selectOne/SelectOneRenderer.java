package org.primefaces.material.component.selectOne;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;

import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.renderkit.InputRenderer;
import org.primefaces.util.WidgetBuilder;

public class SelectOneRenderer extends InputRenderer {
	public static final String RENDERER_TYPE = "org.primefaces.material.component.SelectOneRenderer";

	@Override
	public void decode(FacesContext context, UIComponent component) {
		SelectOne selectOne = (SelectOne) component;

		if(selectOne.isDisabled()) {
			return;
		}

		decodeBehaviors(context, selectOne);

		String clientId = selectOne.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId + "_input");

		if(submittedValue!=null){
			selectOne.setSubmittedValue(submittedValue);	
		}		
	}
	 
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		SelectOne selectOne = (SelectOne) component;

		encodeMarkup(context, selectOne);
		encodeScript(context, selectOne);
	}

	private void encodeMarkup(FacesContext context, SelectOne selectOne) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
						
		String inputId = selectOne.getClientId() + "_input";
			
		List<SelectItem> selectItems = getSelectItems(context, selectOne);
		
		writer.startElement("div", selectOne);
			writer.writeAttribute("class", "col-lg-10", null);				
			
			writer.startElement("select", selectOne);
				writer.writeAttribute("class", "form-control", null);	
				writer.writeAttribute("id", inputId, null);	
				writer.writeAttribute("name", inputId, null);	
				
				for (SelectItem selectItem : selectItems) {
					writer.startElement("option", null);
						if(selectItem.getValue().equals(selectOne.getValue())){
							writer.writeAttribute("selected", "selected", null);
						}
						writer.writeAttribute("value", selectItem.getValue(),null);
						writer.write(selectItem.getLabel());
					writer.endElement("option");	
				}
			writer.endElement("select");				
			
		writer.endElement("div");				
		
	}
	
	private void encodeScript(FacesContext context, SelectOne selectOne) throws IOException {
		String clientId = selectOne.getClientId();
		String widgetVar = selectOne.resolveWidgetVar();
		 
		WidgetBuilder wb = MaterialWidgetBuilder.getInstance(context);
		 
		wb.initWithDomReady("SelectOne", widgetVar, clientId);
		wb.attr("widgetName", widgetVar);
		encodeClientBehaviors(context, selectOne);
		 
		wb.finish();
		 
	}
	
}
