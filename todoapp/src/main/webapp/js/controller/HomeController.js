myApp.controller("HomeController",function ($scope,  $state, homeService,dataService ) {
	
	$scope.task=[];
	console.log("Inside controller");
	  var httpObje=homeService.listOfNote();
	  httpObje.then(function (data)
	  {  console.log("inside http...");
		  $scope.task=data.data.listofnotes;
		  console.log(data);
	  })
	
	
	
	  $scope.addNote = function () {
	var toDoData = {};
	toDoData.title=$scope.title;
	toDoData.description=$scope.description;
	var httpObje=toDoData.addNote(toDoData);
	httpObje.then(function (data) {
		console.log(data)
		console.log(data.status);
		if( data.status=="200"){
				$state.go("home");
				console.log("sdfasdf"); 
		}
		else
		{
			$scope.emailError = data.data.emailError;
			var message = data.data.message;
			$scope.errorMessage = message;
		}	})
	.catch( function(error){
		console.log(error);
	  });
	  }
});









myApp.service("homeService",function ($http) {
	console.log("inside home service");
	this.listOfNote = function()
	{ 
		console.log("inside  method")
		return $http
		({
			url:"http://localhost:8012/todoapp/listOfNotes",
			method:"get",
			
		});
	}
});


myApp.service("dataService",function ($http) {
	this.addNote = function()
	{ 
		return $http
		({
			url:"http://localhost:8012/todoapp/addNote",
			method:"post",
			
		});
	}
});