
(function ($) {
    $.fn.openWidow = function (options) {
        var divId = "dialog" + Math.round(Math.random() * 100);
        var settings = {
            id: divId,
            width: 300,
            height: 200,
            modal: true,
            buttons: {
       },
       show: "fold",
       hide: "fold",
       title: "提示",
       url: "",
       close: function () {
           $("#" + this.id).remove();
           //debugger
           if (document.getElementById(this.id))
           document.body.removeChild(document.getElementById(this.id));
       }
   };
   if (options) {
       $.extend(settings, options);
  }
   $("body").append('<div id="' + settings.id + '" title="Dialog Title"><p class="loading"></p></div>');
   // Dialog            
   $('#' + settings.id).dialog({
       autoOpen: false,
       title: settings.title,
       width: settings.width,
       height: settings.height,
       modal: true,
       bgiframe: true,
       show: settings.show,
       hide: settings.hide,
       buttons: settings.buttons,
       close: settings.close,
       open: function () {
           $("#" + settings.id).html('<iframe src="' + settings.url + '" frameborder="0" height="100%" width="100%" id="dialogFrame" scrolling="auto"></iframe>');
       },
       resizeStop: function () {
           $("#dialogFrame").css("width", parseInt($(this).css("width")) - 5);
           $("#dialogFrame").css("height", parseInt($(this).css("height")) - 5);
       }
   });

   $('#' + settings.id).dialog("open");
   return this;
};
})(jQuery);

$.open = function(config) {
	var defaultConfig = {
		title: '',
		modal: true,
		width: 600
	};
	//config.url = contextPath + config.url;
	config = $.extend({}, defaultConfig, config);
	config.id = config.id || ('_dialog' + new Date().getTime());
	var box = $('<div />').hide().appendTo($('body'));
	box.data('config', config);
	var ids = $('body').data('ids') || [];
	ids[ids.length] = config.id;
	$('body').data('ids', ids);
	var window = $('body').data('window') || {};
	window[config.id] = box;
	$('body').data('window', window);
	box.load(config.url, function() {
		if(config.prepare)
			config.prepare(box);
		box.dialog({
			title: config.title,
			modal: config.modal,
			width: config.width,
			height: config.height,
			close: function() {
				var ids = $('body').data('ids');
				ids.pop();
				$('body').data('ids', ids);
				box.remove();
			}
		});
	});
};

$.close = function(data, id) {
	data = data || {};
	var ids = $('body').data('ids');
	id = id || ids[ids.length - 1];
	ids.pop();
	$('body').data('ids', ids);
	var window = $('body').data('window');
	var box = window[id];
	var config = box.data('config');
	box.dialog('option', {
		close: function() {
			if(config.success) {
				config.success(data);
			}
			box.remove();
		}
	});
	box.dialog('close');
};