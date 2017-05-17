myApp.controller("HomeController",function ($scope,  $state, homeService,dataService ) {
	
	$scope.task=[];
	console.log("Inside controller");
	  var httpObje=homeService.listOfNote();
	  httpObje.then(function (data)
	  {  console.log("inside method");
		  $scope.task=data.data.listofnotes;
		  console.log(data);
	  })
	
	
	
	  $scope.addNote = function () {
	var toDoData = {};
	toDoData.title=$scope.title;
	toDoData.description=$scope.description;
	// $scope.task.push("toDoData");
	var httpObje=dataService.addNote(toDoData);
	httpObje.then(function (data) {
		console.log(data)
		console.log(data.status);
		if( data.status=="200"){	
			var httpObje=homeService.listOfNote();
			httpObje.then(function (data)
					  {  console.log("inside method");
						  $scope.task=data.data.listofnotes;
						  console.log(data);
					
					  })
		    if(true)
		    	{
		    	console.log("inside n")
		    	$state.go("home");
		    	}
		  console.log("salman"); 
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
		console.log("inside  method");
		return $http
		({
			url:"http://localhost:8012/todoapp/listOfNotes",
			method:"get",
			
		});
	}
});


myApp.service("dataService",function ($http) {
	console.log("inside dataservice")
	this.addNote = function(toDoData)
	{ 
		console.log("inside add method");
		return $http
		({
			url:"http://localhost:8012/todoapp/addNote",
			method:"post",
			data:toDoData
		});
	}
});