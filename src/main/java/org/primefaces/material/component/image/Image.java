package org.primefaces.material.component.image;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.primefaces.component.graphicimage.GraphicImage;
import org.primefaces.material.MaterialPrime;

@ResourceDependencies({
	@ResourceDependency(library = "material-prime", name = "libs/materialize.css"),
	@ResourceDependency(library = "material-prime", name = "core/material-prime.css")
})
public class Image extends GraphicImage{

	public static final String COMPONENT_TYPE = "org.primefaces.material.component.Image";
	
	protected enum PropertyKeys {

		responsive,
		circle;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}
	
	public Image() {
		setRendererType(ImageRenderer.RENDERER_TYPE);
	}
	
	public String getFamily() {
		return MaterialPrime.COMPONENT_FAMILY;
	}
	
	public boolean isResponsive(){
		return (Boolean) this.getStateHelper().eval(PropertyKeys.responsive, true);
	}
	
	public void setResponsive(boolean responsive){
		this.getStateHelper().put(PropertyKeys.responsive, responsive);
	}

	public boolean isCircle(){
		return (Boolean) this.getStateHelper().eval(PropertyKeys.circle,false);
	}
	
	public void setCircle(boolean circle){
		this.getStateHelper().put(PropertyKeys.circle, circle);
	}
}
