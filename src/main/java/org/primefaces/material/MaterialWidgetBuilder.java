package org.primefaces.material;

import java.io.IOException;

import javax.faces.context.FacesContext;

import org.primefaces.util.WidgetBuilder;

public class MaterialWidgetBuilder extends WidgetBuilder {

	private static final String KEY = MaterialWidgetBuilder.class.getName();

	public static MaterialWidgetBuilder getInstance(final FacesContext context) {

		MaterialWidgetBuilder wb = (MaterialWidgetBuilder) context.getExternalContext().getRequestMap().get(KEY);

		if (wb == null) {
			wb = new MaterialWidgetBuilder(context);

			context.getExternalContext().getRequestMap().put(KEY, wb);
		}

		return wb;
	}
    
    public MaterialWidgetBuilder(FacesContext context) {
        super(context);
    }

    protected WidgetBuilder init(String widgetClass, String widgetVar, String id, String resourcePath, boolean endFunction) throws IOException {
    	this.resourcePath = resourcePath;
    	this.endFunction = endFunction;
    	
        context.getResponseWriter().write("MaterialPrime.cw(\"");
        context.getResponseWriter().write(widgetClass);
        context.getResponseWriter().write("\",\"");
        context.getResponseWriter().write(widgetVar);
        context.getResponseWriter().write("\",{");
        context.getResponseWriter().write("id:\"");
        context.getResponseWriter().write(id);
        if (widgetVar == null) {
        	context.getResponseWriter().write("\"");
        } else {
	        context.getResponseWriter().write("\",widgetVar:\"");
	        context.getResponseWriter().write(widgetVar);
	        context.getResponseWriter().write("\"");
        }

        return this;
    }
}
