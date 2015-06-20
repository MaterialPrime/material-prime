MaterialPrime.widget.DatePicker = PrimeFaces.widget.BaseWidget.extend({
	init : function(cfg) {
		this._super(cfg);		

		$(this.jqId+"_input").pickadate({
			selectMonths: true,
			selectYears: cfg.selectYears, 
			format: cfg.pattern,
			today: cfg.today,
			clear: cfg.clear,
			close: cfg.close,
			labelMonthNext: cfg.labelMonthNext,
			labelMonthPrev: cfg.labelMonthPrev,
			labelMonthSelect: cfg.labelMonthSelect,
			labelYearSelect: cfg.labelYearSelect,
			min: cfg.min !=null ? cfg.min : undefined,
			max: cfg.max !=null ? cfg.max : undefined,
//			weekdaysShort: ['q', 'f', 'f', 's', 'a', 's', 'f'],
//			monthsShort: ['Jd', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
//			weekdaysFull: ['dddd', 'Mondassy', 'Tuesssday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
//			monthsFull: ['Janssuary', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
		});
	}
});