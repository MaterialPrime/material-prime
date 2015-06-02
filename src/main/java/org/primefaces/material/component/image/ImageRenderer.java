package org.primefaces.material.component.image;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.graphicimage.GraphicImageRenderer;
import org.primefaces.material.util.Strings;
import org.primefaces.util.HTML;

public class ImageRenderer extends GraphicImageRenderer{
	
	public static final String RENDERER_TYPE = "org.primefaces.material.component.ImageRenderer";

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		Image image = (Image) component;
		String clientId = image.getClientId(context);
		String imageSrc;
        try {
            imageSrc = getImageSrc(context, image);
        } catch (Exception ex) {
            throw new IOException(ex);
        }
        
		writer.startElement("img", image);
		writer.writeAttribute("id", clientId, "id");
		writer.writeAttribute("src", imageSrc, null);
		
		if(image.getAlt() == null) writer.writeAttribute("alt", "", null);
		if(getImageClass(image) != null) writer.writeAttribute("class", getImageClass(image), "styleClass");
		
		renderPassThruAttributes(context, image, HTML.IMG_ATTRS);

		writer.endElement("img");
	}

	private String getImageClass(Image image) {
		String toReturn = Strings.EMPTY;
		
		if(image.isResponsive()){
			toReturn += " responsive-img";
		}
		
		if(image.isCircle()){
			toReturn += " circle";
		}
		
		if(Strings.isNotEmpty(image.getStyleClass())){
			toReturn += " " + image.getStyleClass();
		}
		
		return toReturn;
	}

}
