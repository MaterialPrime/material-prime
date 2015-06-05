MaterialPrime.widget.Toast = PrimeFaces.widget.BaseWidget.extend({
	init:function(cfg) {
		this._super(cfg);
	},
	
	show:function(duration){
		MaterialPrime.toast(this.jq.html(),duration || 1000);
	}
});