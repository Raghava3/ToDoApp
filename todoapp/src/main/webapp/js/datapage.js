myApp
$(document).ready(
			function() {
				$("body").click(
						function(event) {
							
							if (event.target.id == "gridicon") {
								
								$("#listicon").show();
								$("#gridicon").hide();
								
							}
							else if(event.target.id=="listicon")
								{
								$("#listicon").hide();
								$("#gridicon").show();
								}
						

							if (event.target.id == "form"
									|| event.target.id == "newNote"
									|| event.target.className == "ff"
									|| event.target.id == "title"
									|| event.target.id == "des" 
									|| event.target.id == "input"
									|| event.target.id == "") {
								return;
							}
							$("#newNote").css("display", "none");
							

						});

				
				$("b").on('click',function(e) {
							if($(this).hasClass('grid'))
								{
								$('#container div').removeClass('list').addClass('grid');
								}
							else if($(this).hasClass('list'))
								{
								$('#container div').removeClass('grid').addClass('list');
								}
				 });
				
			});

	
	
	function searchDiv()
	{
		  document.getElementById("search").style.backgroundColor="white";
	}

	function serchDivOriginal()
	{
		  document.getElementById("search").style.backgroundColor="#CD8300";
	}
	
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
		document.getElementById("main").style.marginLeft = "250px";
	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
		document.getElementById("main").style.marginLeft = "0";
	}
	function openEntry() {
		document.getElementById("newNote").style.display = "block";
	}

	

	function myFunction() {
		var popup = document.getElementById("myPopup");
		popup.classList.toggle("show");
	}
	
	function popUp(title,description)
	{
		document.getElementById("pop").innerHTML=("<b>"+title+"</b></br></br>"+description);
        document.getElementById("pop").style.visibility="visible";
		document.getElementById("ff1").style.opacity=0.3;
		setTimeout(function() {
			 document.getElementById("pop").style.visibility="hidden";
				document.getElementById("ff1").style.opacity=1;},1100);
	
		}
			
	