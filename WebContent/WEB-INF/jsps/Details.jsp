<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function sendRequest(cname)
{
	var req;
	var url="/ATA/Admin/source/"+cname;
	if(cname.trim()=="") {
		document.getElementById("mydiv").innerHTML="";
		return;
		}
	if(window.XMLHttpRequest)
	{
		req=new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		req=new ActiveXObject("Microsoft.XMLHTTP")	
	}
	req.onreadystatechange=function(){
		if(req.readyState==4 && req.status==200)
		{
			document.getElementById("mydiv").innerHTML=req.responseText;	
		}
	}
	req.open("GET",url,true);
	req.send(null);
}


</script>
<meta charset="ISO-8859-1">
<title>View Booking Details</title>
</head>
<body>
Enter Source<input type="text" name="t1" onkeyup="sendRequest(this.value)">
		<div id="mydiv" style="border: solid; border-color: blue; width: 40px">
		</div>
		
</body>
</html>