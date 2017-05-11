/*$(function() {
		
        $("#email_error_message").hide();
        $("#password_error_message").hide();
        
        var error_email=false;
        var error_password=false;
     
      $("#form_email").focusout(function(){
      		check_email();
      		
      });
      
      $("#form_password").focusout(function(){
      		check_password();
      		
      });
       
       function check_email()
       {
    	   var email_pattern=new RegExp(/^[+a-zA-Z0-9._-]+@[+a-zA-Z0-9._-]+\.[a-zA-Z]{2,4}$/i);
    	   if(email_pattern.test($("#form_email").val()))
    		   {
    		   $("#email_error_message").hide();
    		   }
    	   else
    		   {
    		   $("#email_error_message").html("invalid.");
    		   $("#email_error_message").show();
    		   error_name=true;
    		  }
       } 
       function check_password()
       {
    	   var password_pattern=new RegExp(/^[a-zA-Z0-9]{7}/);
    	   if(password_pattern.test($("#form_password").val()))
    		   {
    		   $("#password_error_message").hide();
    		   }
    	   else
    		   {
    		   $("#password_error_message").html("forget u r password?");
    		   $("#password_error_message").show();
    		   error_name=true;
    		  }
       } 
});*/