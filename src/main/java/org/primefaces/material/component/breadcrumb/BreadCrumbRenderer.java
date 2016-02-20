package org.primefaces.material.component.breadcrumb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.api.AjaxSource;
import org.primefaces.component.api.UIOutcomeTarget;
import org.primefaces.component.menu.AbstractMenu;
import org.primefaces.component.menu.BaseMenuRenderer;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.util.ComponentTraversalUtils;

public class BreadCrumbRenderer extends BaseMenuRenderer{
	public static final String RENDERER_TYPE = "org.primefaces.material.component.BreadCrumbRenderer";
	
	@Override
	protected void encodeMarkup(FacesContext context, AbstractMenu menu) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		
		BreadCrumb breadCrumb = (BreadCrumb) menu;
		String clientId = breadCrumb.getClientId(context);
		int elementCount = menu.getElementsCount();
        List<MenuElement> menuElements = (List<MenuElement>) menu.getElements();
        boolean isIconHome = breadCrumb.getHomeDisplay().equals("icon");
        
        writer.startElement("nav", null);
        	writer.writeAttribute("id", clientId, null);
        	writer.writeAttribute("role", "menu", null);
        	writer.startElement("div", null);
        		writer.writeAttribute("class", "nav-wrapper", null);
        		writer.startElement("div", null);
	        		writer.writeAttribute("class", "col s12", null);
	        		for (int i = 0; i < elementCount; i++) {
	        			MenuItem item = (MenuItem) menuElements.get(i);
	        			if(item.isRendered()){
							encodeBreadCrumbItem(context, breadCrumb, item, i == 0 && isIconHome);
						}
					}
	        	writer.endElement("div");
        	writer.endElement("div");
        writer.endElement("nav");
        
	}
	
	private void encodeBreadCrumbItem(FacesContext context, BreadCrumb menu, MenuItem menuitem, boolean iconHome) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        
        String title = menuitem.getTitle();
        boolean disabled = menuitem.isDisabled();

        writer.startElement("a", null);
        writer.writeAttribute("tabindex", "-1", null);
       
        if(shouldRenderId(menuitem)) {
            writer.writeAttribute("id", menuitem.getClientId(), null);
        }
        
        if(title != null) {
            writer.writeAttribute("title", title, null);
        }
        
        writer.writeAttribute("class", "breadcrumb", null);

        if(disabled) {
            writer.writeAttribute("href", "#", null);
            writer.writeAttribute("onclick", "return false;", null);
        }
        else {
            setConfirmationScript(context, menuitem);
            String onclick = menuitem.getOnclick();

            //GET
            if(menuitem.getUrl() != null || menuitem.getOutcome() != null) {                
                String targetURL = getTargetURL(context, (UIOutcomeTarget) menuitem);
                writer.writeAttribute("href", targetURL, null);

                if(menuitem.getTarget() != null) {
                    writer.writeAttribute("target", menuitem.getTarget(), null);
                }
            }
            //POST
            else {
                writer.writeAttribute("href", "#", null);

                UIComponent form = ComponentTraversalUtils.closestForm(context, menu);
                if(form == null) {
                    throw new FacesException("MenuItem must be inside a form element");
                }

                String command;
                if(menuitem.isDynamic()) {
                    String menuClientId = menu.getClientId(context);
                    Map<String,List<String>> params = menuitem.getParams();
                    if(params == null) {
                        params = new LinkedHashMap<String, List<String>>();
                    }
                    List<String> idParams = new ArrayList<String>();
                    idParams.add(menuitem.getId());
                    params.put(menuClientId + "_menuid", idParams);

                    command = menuitem.isAjax() ? buildAjaxRequest(context, menu, (AjaxSource) menuitem, form, params) : buildNonAjaxRequest(context, menu, form, menuClientId, params, true);
                } 
                else {
                    command = menuitem.isAjax() ? buildAjaxRequest(context, (AjaxSource) menuitem, form) : buildNonAjaxRequest(context, ((UIComponent) menuitem), form, ((UIComponent) menuitem).getClientId(context), true);
                }

                onclick = (onclick == null) ? command : onclick + ";" + command;
            }

            if(onclick != null) {
                if(menuitem.requiresConfirmation()) {
                    writer.writeAttribute("data-pfconfirmcommand", onclick, null);
                    writer.writeAttribute("onclick", menuitem.getConfirmationScript(), "onclick");
                }
                else {
                    writer.writeAttribute("onclick", onclick, null);
                }
            }
        }
        
        if(iconHome){
        	writer.startElement("span", null);
        	writer.writeAttribute("class", "mdi-action-home", null);
        	writer.endElement("span");
        }else{
        	writer.writeText(menuitem.getValue(), "value");
        }
        

        writer.endElement("a");
	}

	protected void encodeScript(FacesContext context, AbstractMenu abstractMenu) throws IOException {
		//No Script for now
	}
}
