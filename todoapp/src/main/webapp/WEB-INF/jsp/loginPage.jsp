<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css" />
<script type="text/javascript" language="javascript" src="jsp/script.js"></script>
<script type="text/javascript" language="javascript"
	src="javascripts/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="images/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>

<script type="text/javascript">



 /*  $.ajax({
	type : "POST",
	dataType: "json",
	url : "$http://localhost:8080/login",
	success : function(data) {
		if(data.status=="true")
			{
			return new Model
			}
		else
			{
			return new 
			}
	},
	error:function()
	{
		console.log
	}

});   */




</script>
</head>
<style type="text/css">
body {
	background-color: #41474B; /* color=image:url("images/simple.png");  */
	background-repeat: no-repeat;
	background-size: cover;
}

.aa {
	width: 350px;
	height: 150px;
	background-color: rgba(0, 0, 0, 0.2);
	margin: 0 auto;
	margin-top: 160px;
	padding-top: 10px;
	padding-left: 50px;
	border-radius: 5px;
}

.bb {
	width: fit;
	height: 65px;
	background-color: rgba(0, 0, 0, 0.9);
	margin: 0 auto;
	margin-top: 0px;
	padding-top: 10px;
	padding-left: 10px;
}

.cc {
	width: fit;
	height: 40px;
	background-color: rgba(0, 0, 0, 0.9);
	margin: 0 auto;
	margin-top: 100px;
	padding-top: 10px;
	padding-left: 10px;
	border-radius: 0px;
}
</style>

<body style="overflow:hidden;">

<div style="margin-left:-10px;margin-top:-6px;margin-right:-10px" s>	<div class="bb">
		<font color="white"><center>
				<b>
					<h4>ToDo</h4>
				</b>
			</center></font>
	</div>
	</div>
	<pre>
<div class="aa">
<form action="login" method="post">
 <font color="white"><b>email:   </b></font><input type="text"id="form_email" name="email" placeholder="email">
 <font color="red">  <i><span class="error_form"id="email_error_message"></span></i></font>
 <font color="white"><b>password:</b></font><input type="password" id="form_password" name="password" placeholder="password">
 <font color="red">  <i><span class="error_form" id="password_error_message"></span></i></font>
                 <input type="submit" value="login"> 
</form>
         <pre>                 
                 <a href="signup"><font color="white">signup</font></a>
		</pre>
</div>
<center>
<pre>




<div class="cc"><center><a href="http://bridgelabz.com/"><font color="white">About us</font></center></a></div>
</pre>
</center>
</pre>
</body>
</html>






