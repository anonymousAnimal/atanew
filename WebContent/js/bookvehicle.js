/**
 * 
 */

var req;
	
	function checkajax(){
		try{
		req = new XMLHttpRequest();
		/* alert("xmlhttprequest done") */
		return;
		}
		catch(e){}
		
		try{
			req = new ActiveXObject("Msxm2.XMLHTTP");
			/* alert("activex msxm2 done"); */
			return;
		}
		catch(e){}
		
		try{
			req = new ActiveXObject("Microsoft.XMLHTTP");
			/* alert("activex microsoft xmlhttp done"); */
			return;
		}catch(e){}
		
		alert("your browser doesnot support ajax");
	}
	
	function getData(text, id){
		console.log("get vehicles called");
		var url="getdestination/?source="+text;
		req.onreadystatechange = function(){
			if(req.readyState == 4 && req.status == 200)
			document.getElementById(id).innerHTML= req.responseText;
		
		}
		
		req.open("GET", url, true);
		req.send();
	}

function getvehicles(id){

	var res = document.getElementById(id).checked;
	console.log("get vehicles called");
	if(res)
		text = 'type';
	else
		text = 'seat';
		
		var url="getvehicles/?criteria="+text;
		req.onreadystatechange = function(){
			if(req.readyState == 4 && req.status == 200)
			document.getElementById(id).innerHTML= req.responseText;
		
		}
		
		req.open("GET", url, true);
		req.send();
	}
