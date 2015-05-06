MaterialPrime.widget.RadioButton = PrimeFaces.widget.BaseWidget.extend({
	init : function(cfg) {
		this._super(cfg);
		
		this.inputs = document.getElementsByName(this.jqId+"_input");

		var that = this;
		
		$(this.jqId+" :input").on("click",function(){
			if(that.cfg.behaviors && that.cfg.behaviors.valueChange) {
				that.cfg.behaviors.valueChange.call(this.jqId);
			}
		});
	}
});