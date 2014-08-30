<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="register_form" id="register_form" action="register.do" method="POST">
            Project Name<input type="text" name="projectname" value="" /><br>
            Project Time<input type="text" name="projecttime" value="Enter no. of days" /><br>
            Requirement and Analysis Phase<input type="text" name="s1" value="Enter no. of days" /><br>
            Design Phase<input type="text" name="s2" value="Enter no. of days" /><br>
            Implementation Phase<input type="text" name="s3" value="Enter no. of days" /><br>
            Testing Phase<input type="text" name="s4" value="Enter no. of days" /><br>
            Deployment Phase<input type="text" name="s5" value="Enter no. of days" /><br>
            
            # Project Modules<input type="text" name="nomodules" value="" /><br>
            
            admin's name<input type="text" name="adminname" value="" /><br>
            admin's password<input type="text" name="adminpass" value="" /><br>
            
            <div id="members">
                Member 1<br><input type="text" name="member1">
            </div>
            <input type="button" value="Add another member" onClick="addInput('members');">
            <input type="submit" value="submit" name="submit" />        
        </form>    
        
        <script>
            var counter = 1;
            var limit =10 ;
            function addInput(divName){
            if (counter == limit)  
            {
            alert("You have reached the limit of adding " + counter + " members");
            }
          else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Member " + (counter + 1) + " <br><input type='text' name='"+"member"+(counter+1)+"'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
           }
          }
            
        </script>    
    </body>
</html>
