(function(window) {
    
    if(window.MaterialPrime) {
        PrimeFaces.debug("MaterialPrime already loaded, ignoring duplicate execution.");
        return;
    }
    
    var MaterialPrime = {
    	widgets:{},
    	 cw : function(widgetConstructor, widgetVar, cfg, resource) {
    		 MaterialPrime.createWidget(widgetConstructor, widgetVar, cfg, resource);
         },
         createWidget : function(widgetConstructor, widgetVar, cfg, resource) { 
             if(MaterialPrime.widget[widgetConstructor]) {
                 if(MaterialPrime.widgets[widgetVar]) {
                	 MaterialPrime.widgets[widgetVar].refresh(cfg);                                     //ajax update
                 }
                 else {
                	 MaterialPrime.widgets[widgetVar] = new MaterialPrime.widget[widgetConstructor](cfg);  //page init
                     if(PrimeFaces.settings.legacyWidgetNamespace) {
                         window[widgetVar] = MaterialPrime.widgets[widgetVar]; 
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
                    	 MaterialPrime.widgets[widgetVar] = new MaterialPrime.widget[widgetConstructor](cfg);
                     }, 100);
                 });
             }
         }
    };   
   
    window.MaterialPrime = MaterialPrime;

})(window);

$(function() {
    $.material.init();
});