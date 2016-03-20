MaterialPrime.widget.ScrollFire = PrimeFaces.widget.BaseWidget.extend({
	init : function(cfg) {
		this._super(cfg);
		
		var options = [{
			selector:PrimeFaces.escapeClientId(cfg.selector),
			offset:cfg.offset,
			callback:cfg.onScroll
		}];
		
		Materialize.scrollFire(options);
	}
});