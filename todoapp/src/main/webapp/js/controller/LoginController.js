myApp.controller("LoginController",function ($scope,  $state, loginService ) {	
	
	
     	$scope.login = function () {
		var user = {};
		user.email=$scope.email;
		user.password=$scope.password;
		var httpObje=loginService.login(user);
		httpObje.then(function (data) {
			console.log(data)
			console.log(data.status);
			if( data.status=="200"){
					$state.go("Home");
			}
			else
			{
				$scope.emailError = data.data.emailError;
				var message = data.data.message;
				$scope.errorMessage = message;
			}
		})
		.catch( function(error){
			console.log(error);
		});
	}	
});


myApp.service("loginService",function ($http) {
	this.login = function(user){ 
		return $http({
			url:"http://localhost:8012/todoapp/login",
			method:"post",
			data:user
		});
	}
});