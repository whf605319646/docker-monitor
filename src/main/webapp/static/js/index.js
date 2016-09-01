$(function(){
	/*$().click(function(){
		let aurl =;
		$.ajax({
			   type: "GET",
			   url: aurl,
			   success: function(response){
			     $("#show").text(JSON.parse(response));
			   }
			});
	})*/
	/*$(".btn").click(function(){
		$(this).click(function(){
			$("#show").text("");
			$.ajax({
				   type: "GET",
				   url: url,
				   success: function(response){
				     $("#show").text(JSON.parse(response));
				   }
				});
		})
	})*/
	click("#hosts", "wemonitor/hosts");
	click("#containers2", "wemonitor/containers");
	click("#subcontainer", "wemonitor/container");
	
	click("#subcontainers","dockermonitor/subcontainers");
	click("#containers","dockermonitor/containers");
	click("#machine","dockermonitor/machine");
	click("#docker","dockermonitor/docker");
	function click(id,url) {
		$(id).click(function(){
			$("#show").text("");
			$.ajax({
				   type: "GET",
				   url: url,
				   success: function(response){
					   var data = JSON.parse(response);
					   console.log(data)
					   var html = loopForValue(data);
					   /*for(var o in data){
						  if( Array.isArray(data[o])){
							  for (var i = 0;i<data[o].length;i++) {
								  console.log(o+ '> ')
								  for(var obj in data[o][i]){
									  console.log("   "+obj+ ' : '+data[o][i][obj])
								  }
								  data[o].forEach(function(item,index,array){
									  console.log("   "+index+ ' : '+item)
								  })
							  }
						  }else if(typeof data[o] =='object') {
							  console.log(o+ '>>')
							  for(var ob in data[o]){
								  console.log(ob + ' : '+data[o][ob])
							  }
						  }
						   console.log(o + ' : '+data[o])
					   } */
					   $("#show").html(html);
				   },
				   error:function(){
					   $("#show").html("<div class='alert alert-warning' role='alert'>Oh snap!</div>");
				   }
				});
		})
	}
	
	function loopForValue(obj) {
		var html = '';
		if(typeof obj =='object') {
			for(var o in obj){
				if(typeof obj[o] =='object'){
					html +=(o+">>");
					console.log(o+">>")
					loopForValue(obj[o])
				} else if (Array.isArray(obj[o])) {
					html +=(o+">>");
					console.log(o+">>")
					obj[o].forEach(function(item,index,array){
						if(typeof item == 'object'){
							loopForValue(item);
						} 
					})
				}else{
					html +=(o +" : "+obj[o]);
					console.log(o +" :: "+obj[o]);
				}
			}
		}else if(Array.isArray(obj[o])) {
			html +=(o+">>");
			console.log(o+">>")
			obj[o].forEach(function(item,index,array){
				if(typeof item == 'object'){
					loopForValue(item);
				} 
			})
		}else{
			html +=(o +" : "+obj[o]);
			console.log(o +" ::: "+obj[o])
		}
		return html;
	}
})