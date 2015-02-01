MaterialPrime.widget.RadioButton = PrimeFaces.widget.BaseWidget.extend({
	init : function(cfg) {
		this._super(cfg);
		this.inputs=jQuery(this.jqId+"_input");
		this.inputs2=$( "input[name='"+this.jqId+"_input"+"']" );
		
		this.in1=jQuery(this.jqId+"_input1");
		this.in2=jQuery(this.jqId+"_input2");
		this.ins=[this.in1,this.in2];
			
		var that = this;
		
		$.each(this.ins, function(index, value) {
			value.on("select",function(){
				if(that.cfg.behaviors && that.cfg.behaviors.valueChange) {
					that.cfg.behaviors.valueChange.call(that.inputs);
				}
			});
		});
		
		this.ins.on("select",function(){
			if(that.cfg.behaviors && that.cfg.behaviors.valueChange) {
				that.cfg.behaviors.valueChange.call(that.inputs);
			}
		});
		$.material.init();
	}
});