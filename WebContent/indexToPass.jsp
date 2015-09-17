<html>
<head>
<style>
#MinButton {
    left: 85%;
    position: relative;
    text-align: center;
    top: 8%;
}
#AddButton {
    left: 13%;
    position: relative;
    text-align: center;
    top: 8%;
}


</style>

<script type="text/javascript">
function loadXMLDoc()
{
var xmlhttp;
var k=document.getElementById("TextBox").value;
var urls="pass.jsp?ver="+k;
 
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        //document.getElementById("err").style.color="red";
        document.getElementById("err").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}
</script>

</head>
<body bgcolor="#94D4E9">
  <script src="http://code.jquery.com/jquery-1.4.3.min.js"></script>
        <script>
        var counter =1;
            $(document).ready(function(){
                $('#AddButton').click( function() {
					 counter = $('#TextBox').val();
 						counter++ ;
 						 if(counter>1){
 							 document.getElementById("MinButton").disabled=false;
 						 }
                    $('#TextBox').val(counter);
                });
            });
            $(document).ready(function(){
                $('#MinButton').click( function() {
              counter = $('#TextBox').val();
 						counter-- ;
 						 if(counter<1){
 							 document.getElementById("MinButton").disabled=true;
 						 }
                    $('#TextBox').val(counter);
                });
            });
        </script>
<!-- <input type="text" name="TextBox" id="TextBox" value="2" /> -->
<span  id="TextBox" ></span> 
<input type = "Button" id='AddButton' value="Next"onclick="loadXMLDoc()"/>
<input type="Button" id='MinButton' value="Previous" onclick="loadXMLDoc()" />
<span id="err"> </span>
 
</body>
</html>