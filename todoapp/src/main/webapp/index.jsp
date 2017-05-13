
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bower_components/angular/angular.min.js" type="text/javascript" ></script>
<script src="bower_components/angular-ui-router/release/angular-ui-router.min.js" type="text/javascript"></script>
<script src="bower_components/jquery/dist/jquery.min.js" type="text/javascript"></script>

<script src="js/app.js" type="text/javascript"></script>




<!-- this is for css -->
<link rel="stylesheet" href="css/Login.css">
<link rel="stylesheet" href="css/Signup.css">
<link rel="stylesheet" href="css/HomePage.css">

<title>ToDoApp</title>
</head>

<body>
     <div data-ng-app="todoapp">
	<ui-view></ui-view>
	</div>
</body>


<!-- this is for script -->
<script src="js/controller/LoginController.js" type="text/javascript"></script>
<script src="js/controller/SignUpController.js" type="text/javascript"></script>
<script src="js/Signup.js" type="text/javascript"></script> 


</html>