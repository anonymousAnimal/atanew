var req;
function checkAjax(){
	
	console.log("///////////////////ajax////");
	try{
		req = new XMLHttpRequest();
	
		return;
		}
		catch(e){}
	
}



function unallotedDrivers(reservationid,driverid)
{
	var did=document.getElementById(driverid).value;
	var url="allotDriver/?resid="+reservationid+"&did="+did;
	console.log("------inside unalloteddrivers------");
	req.onreadystatechange = function()
	{
		if(req.readyState == 4 && req.status == 200){
			console.log("------------");
			document.getElementById(reservationid).innerHTML= req.responseText;
			
		}
	}
	
	req.open("GET", url, true);
	req.send();
	document.getElementById("msg").innerHTML = "please wait ......."
	
}

function getDestination(text){
	console.log("get destination for Admin called");
	var url="getAdmindestination/?source="+text;
	req.onreadystatechange = function(){
		if(req.readyState == 4 && req.status == 200)
		document.getElementById("destdiv").innerHTML= req.responseText;
	
	}
	
	req.open("GET", url, true);
	req.send();
}

function viewBooking(journeydate,source,destination)
{
	var src=document.getElementById(source).value;
	var dest=document.getElementById(destination).value;
	var journeyd=document.getElementById(journeydate).value;
	console.log(journeyd);
	var url="viewBookingDetails/?journeydate="+journeyd+"&source="+src+"&destination="+dest;
	console.log("------------inside viewBooking-----");
	req.onreadystatechange=function()
	{
		if(req.readyState==4 && req.status==200)
		{
			document.getElementById("result").innerHTML=req.responseText;
		}
	}
	req.open("GET", url, true);
	req.send();
	
}














