var myApp = angular.module('todoapp', ['ui.router'])
.config(function ($stateProvider, $urlRouterProvider) {
  
  $stateProvider
 
  .state('Login',{
    url:"/Login",
    templateUrl:"html/Login.html",
    controller:"LoginController"
  })
  
  .state('signUp',{
    url:"/signUp",
    templateUrl:"html/Signup.html",
    controller:"SignUpController"
  })
  
    .state('Home',{
	    url:"/Home",
	    templateUrl:"html/Home.html",
	    controller:"HomeController"
	  })
  
  $urlRouterProvider.otherwise('/Login');

});
