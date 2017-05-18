myApp.controller("HomeController",function ($scope,  $state,toDoDataService ) {
	
	/*homepageService.homepage();
 */
	$scope.task=[];
	console.log("Inside controller");
	  var httpObje=toDoDataService.listOfNote();
	  httpObje.then(function (data)
	  {  console.log("inside method");
		  $scope.task=data.data.listofnotes;
		  console.log(data);
	  })
	
		
	  console.log(event);
	
	$scope.addNote = function () {
	var toDoData = {};
	toDoData.title=$scope.title;
	toDoData.description=$scope.description;
	 
	
	var httpObje=toDoDataService.addNote(toDoData);
	httpObje.then(function (data) {
		console.log(data)
		console.log(data.status);
		if( data.status==200){	
			{
				console.log(data.data.todo);
				$scope.task.push(data.data.todo);
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



	
$scope.deleteNotes=function(id,index)
{
	console.log("inside delete")
	var del = toDoDataService.deleteNote(id);
	del.then(function(data) {
	
		if( data.status == 200 ) {
			
			if(index>-1)
				{
				$scope.task.splice(index,1);
				}
			
			
			
		}
		
	}).catch( function(error) {
		
		$state.go('Login');
	});
}


});








myApp.service("toDoDataService",function ($http) {
	console.log("inside home service");
	this.listOfNote = function()
	{ 
		console.log("inside  list of note method");
		return $http
		({
			url:"http://localhost:8030/todoapp/listOfNotes",
			method:"get",
			
		});
	}
	
	this.addNote = function(toDoData)
	{ 
		console.log("inside add note method");
		return $http
		({
			url:"http://localhost:8030/todoapp/addNote",
			method:"post",
			data:toDoData
		});
	}
	
	this.deleteNote = function(id)
	{ 
		console.log(id);
		console.log("inside delete note method");
		return $http
		({
			
			url:"http://localhost:8030/todoapp/noteToDelete"+"/"+id,
			method:"get",
		});
	}
	
});


