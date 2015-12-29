package org.primefaces.material.component.fixedactionbutton;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import org.primefaces.material.MaterialColors;
import org.primefaces.material.MaterialWidgetBuilder;
import org.primefaces.material.util.Strings;
import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.WidgetBuilder;

public class FixedActionButtonRenderer extends CoreRenderer{
	
	private static final String DEFAULT_FIXED_ACTION_COLOR = "red";
	private static final String FIXED_ACTION_BTN_CLASS = "fixed-action-btn";
	public static final String RENDERER_TYPE = "org.primefaces.material.component.FixedActionButtonRenderer";
	
	@Override
	public void decode(FacesContext context, UIComponent fab) {
		
		for (UIComponent component : fab.getChildren()) {
			String param = component.getClientId(context);
			if(context.getExternalContext().getRequestParameterMap().containsKey(param)) {
				component.queueEvent(new ActionEvent(component));
			}
		}
		
        decodeBehaviors(context, fab);
	}
	
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
		
		writer.startElement("div", fab);
		writer.writeAttribute("id", fab.getClientId(), null);
		writer.writeAttribute("style", fab.getStyle(), null);
		writer.writeAttribute("class", getButtonClass(context,fab), null);
			writer.startElement("a", null);
			writer.writeAttribute("class", "btn-floating btn-large " + getButtonColor(context,fab), null);
				writer.startElement("i", null);
					writer.writeAttribute("class", "large " + fab.getIcon(), null);
				writer.endElement("i");
			writer.endElement("a");
			writer.startElement("ul", null);
			for (UIComponent child : fab.getChildren()) {
				renderFabItem(context,writer,(FixedActionButtonItem) child);
			}
			writer.endElement("ul");
		writer.endElement("div");
		
	}

	private String getButtonClass(FacesContext context, FixedActionButton fab) {
		String toReturn = FIXED_ACTION_BTN_CLASS;
		
		if(Strings.isNotEmpty(fab.getStyleClass())){
			toReturn += " " + fab.getStyleClass(); 
		}
		
		if(fab.isHorizontal()){
			toReturn += " horizontal";
		}
		
		if(fab.isClickToToggle()){
			toReturn += " click-to-toggle";
		}
		
		return toReturn;
	}
	
	private void renderFabItem(FacesContext context, ResponseWriter writer, FixedActionButtonItem child) throws IOException {
		
		String request = buildAjaxRequest(context, child, null);        
        String onclick = buildDomEvent(context, child, "onclick", "click", "action", request);		
		
	     writer.startElement("li", child);
	     	writer.startElement("a", null);
	     	writer.writeAttribute("id", child.getClientId(), null);
	     	writer.writeAttribute("onclick", onclick, "onclick");
			writer.writeAttribute("class", "btn-floating " + getItemColor(child), null);
		     	writer.startElement("i", null);
		     		writer.writeAttribute("class",  child.getIcon(), null);
				writer.endElement("i");
			writer.endElement("a");
	     writer.endElement("li");
	}
	
	private String getButtonColor(FacesContext context, FixedActionButton fab) {
		if(fab.getColor() != null){
			if(fab.getColor() instanceof MaterialColors){
				return ((MaterialColors) fab.getColor()).getColorName();
			}else{
				return fab.getColor().toString();
			}
		}else{
			return DEFAULT_FIXED_ACTION_COLOR;
		}
	}
	
	private String getItemColor(FixedActionButtonItem item){
		if(item.getColor() != null){
			if(item.getColor() instanceof MaterialColors){
				return ((MaterialColors) item.getColor()).getColorName();
			}else{
				return item.getColor().toString();
			}
		}else{
			return MaterialColors.random().getColorName();
		}
	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        //Rendering happens on encodeEnd
	}
	
	@Override
	public boolean getRendersChildren() {
	    return true;
}
	
}
