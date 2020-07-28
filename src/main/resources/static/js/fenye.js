		(function($) {
			var count=11;//count=${page.rowcount}
			var start=1;//start=${page.pageon}
			var url=$("#page").attr('url');
			var displaycnt=10;
			fenye(count,start,url,displaycnt);
		})(jQuery);
		function fenye(count,start,url,displaycnt){
			if(count<displaycnt) 
			return;
			$("#page").paginate({
				count 		: count,
				start 		: start,
				display     : displaycnt,
				border					: true,
				border_color			: '#fff',
				text_color  			: '#fff',
				background_color    	: 'black',	
				border_hover_color		: '#ccc',
				text_hover_color  		: '#000',
				background_hover_color	: '#fff', 
				images					: false,
				mouse					: 'press',
				onChange: function(page_index) {  
					var tourl;
					if(url.indexOf('?')>0)
						tourl=url+'&pageon='+page_index;
					else
						tourl=url+'?pageon='+page_index;
                	alert(tourl) ;
                	//window.href=tourl;
				}
			});
		};