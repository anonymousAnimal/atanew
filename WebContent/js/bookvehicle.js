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
	
	function getDestination(text, id){
		console.log("get destination called");
		var url="getdestination/?source="+text;
		req.onreadystatechange = function(){
			if(req.readyState == 4 && req.status == 200)
			document.getElementById(id).innerHTML= req.responseText;
		
		}
		
		req.open("GET", url, true);
		req.send();
	}
	
	
	

	function getVehicles(sidtype, sidseat, did){

	var seltype = document.getElementById(sidtype).value;	
	var selseat = document.getElementById(sidseat).value;		
	
	
	
	if(seltype=="NONE" && selseat =="NONE")
		return;
		
	
		var url="getvehicles/?type="+seltype+"&seat="+selseat;
		req.onreadystatechange = function()
		{
			if(req.readyState == 4 && req.status == 200)
			document.getElementById(did).innerHTML= req.responseText;
		
		}
		
		req.open("GET", url, true);
		req.send();
	}
	
	
	function checkCard(txtCardId, txtValidFromId, txtValidToId, divId)
	{
		console.log("checkcard() called");
		var url="checkCard/?card="+txtCardId+"&validfrom="+txtValidFromId+"&validTo="+txtValidToId;
		
		req.onreadystatechange = function(){
			if(req.readyState == 4 && req.status == 200)
			document.getElementById(divId).innerHTML= req.responseText;
		
		}
		
		req.open("GET", url, true);
		req.send();
	}
	
	
	function cancelBooking(rowId, divId){
		
		var res = confirm("Do you want to Delete this booking? ");
		if(!res){
			console.log("res is false");
			return;
		}
		
		console.log("cancelBooking() called");
		var url="doCancelBooking/?reservationID="+rowId;
		
		req.onreadystatechange = function(){
			if(req.readyState == 4 && req.status == 200)
			var result = req.responseText;
			if(result=="true")
				{
				var row = document.getElementById(rowId);
			    row.parentNode.removeChild(row);
			    document.getElementById("msg").value="booking successfully cancelled !!!";
			    return;
				}
			else
				{
				document.getElementById("msg").value="some error has occured at backend !! try again";
					return;
				}
		
		}
		
		req.open("GET", url, true);
		req.send();
		
	}
