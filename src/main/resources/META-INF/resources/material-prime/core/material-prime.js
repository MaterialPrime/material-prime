(function(window) {
    
    if(window.MaterialPrime) {
        PrimeFaces.debug("MaterialPrime already loaded, ignoring duplicate execution.");
        return;
    }
    
    var toast = function(message,duration,rounded){
    	window.Materialize.toast(message,duration || 1000, rounded ? 'rounded' : '');
    }
    
    var MaterialPrime = {
		 widget:{},
    	 widgets:{},
    	 toast:toast,
		 cw : function(widgetConstructor, widgetVar, cfg, resource) {
			 MaterialPrime.createWidget(widgetConstructor, widgetVar, cfg, resource);
	     },
	     createWidget : function(widgetConstructor, widgetVar, cfg, resource) { 
	         if(MaterialPrime.widget[widgetConstructor]) {
	             if(PrimeFaces.widgets[widgetVar]) {
	            	 PrimeFaces.widgets[widgetVar].refresh(cfg);//ajax update
	             }
	             else {
	            	 PrimeFaces.widgets[widgetVar] = new MaterialPrime.widget[widgetConstructor](cfg);  //page init
	                 if(PrimeFaces.settings.legacyWidgetNamespace) {
	                     window[widgetVar] = PrimeFaces.widgets[widgetVar]; 
	                 }
	             }
	         }
	         // widget script not loaded -> lazy load script + stylesheet
	         else {
	             var scriptURI = PrimeFaces.getFacesResource(resource + '/' + resource + '.js', 'primefaces');
	             var cssURI = PrimeFaces.getFacesResource(resource + '/' + resource + '.css', 'primefaces');
	
	             //load css
	             var cssResource = '<link type="text/css" rel="stylesheet" href="' + cssURI + '" />';      
	             $('head').append(cssResource);
	
	             //load script and initialize widget
	             PrimeFaces.getScript(scriptURI, function() {
	                 setTimeout(function() {
	                	 PrimeFaces.widgets[widgetVar] = new MaterialPrime.widget[widgetConstructor](cfg);
	                 }, 100);
	             });
	         }
	     }
    };   
   
    window.MaterialPrime = MaterialPrime;

})(window);