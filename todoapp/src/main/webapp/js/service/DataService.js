myApp.service("dataService",function ($http) {
	console.log("inside addnote service");
	this.addNote = function()
	{ 
		return $http
		({
			url:"http://localhost:8012/todoapp/addNote()",
			method:"get",
			
		});
	}
});