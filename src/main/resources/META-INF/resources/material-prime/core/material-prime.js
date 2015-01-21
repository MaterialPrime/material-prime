(function(window) {
    
    if(window.MaterialPrime) {
        PrimeFaces.debug("MaterialPrime already loaded, ignoring duplicate execution.");
        return;
    }
    
    var MaterialPrime = {

    };   
   
    window.MaterialPrime = MaterialPrime;

})(window);

$(function() {
    $.material.init();
});