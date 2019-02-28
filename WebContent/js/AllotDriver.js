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
	console.log("------inside ajax------");
	req.onreadystatechange = function()
	{
		if(req.readyState == 4 && req.status == 200){
			console.log("------------");
			document.getElementById(reservationid).innerHTML= req.responseText;
		
		}
	}
	
	req.open("GET", url, true);
	req.send();
	
}
function viewBooking(journeydate,source,destination)
{
	
}