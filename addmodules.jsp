<%-- 
    Document   : addmodules
    Created on : Aug 6, 2014, 6:55:23 PM
    Author     : diptimaya
--%>

<%@page import="Beans.AddingModuleBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% AddingModuleBean amb11=(AddingModuleBean)request.getSession().getAttribute("amb");
           String projname=amb11.getProjectname();
        %>
        <script>
            var nomod;
            var counter = 1;
            function addInput(divName)
            {
              var limit=document.getElementById("nomodules").value;    
            if (counter == limit)  
            {
             alert("You have added " + counter + " modules");
            }
          else 
          {
             var newdiv = document.createElement('div');
             newdiv.innerHTML = "Module" + (counter + 1)+"*" + "<input type='text' size='30' id='"+"moddesc"+(counter+1)+"'>";
             document.getElementById(divName).appendChild(newdiv);
             counter++;
           }
           
           
          }
          function checkval()
          {
               nomod=document.getElementById("nomodules").value;
              if(nomod>20)
              {
                  document.getElementById("nomodules").value="";
                  alert("Sorry! You cannot have more than 20 modules at the moment.:( ");
                  
              }
              
              
          }
          function finalcheck()
          { 

              var blankcount=0;
              for(var i=0;i<nomod;i++)
              {
                  var c=document.getElementById("moddesc"+(i+1));
                  if(c.value=="")
                  {  
                      blankcount=blankcount+1;
                  }
              }
              if(blankcount>0)
              {
                  alert("You cannot leave any field blank!");
              }
              
              else if(blankcount==0)
              {  
                filltextarea();
              }
        
          }
          function filltextarea()
          {
              for(var i=0;i<nomod;i++)
              {
                  var d=document.getElementById("moddesc"+(i+1));
                  var e=document.getElementById('moddescription');
                  e.value=e.value+","+d.value;
              }
          }
          
            
        </script>    
    </head>
    <body>
        <h1>Add modules to project <%=projname%></h1>
        You can add multiple modules to your project here.
       <form action="addmod.do">

        Enter the number of modules <input type="text" id="nomodules" name="nomodules" value="" onchange="checkval()" size="5" />
        <div id="newmodule">
            Module 1 * <input type="text" id="moddesc1" value="" size="30"/>           
        </div>
        <input type="button" value="Add another module" onclick="addInput('newmodule')" />
        
        <textarea id="moddescription" name="moddescription" rows="4" cols="20">
        </textarea>
        
        <input type="submit" value="Submit" onclick="finalcheck()" />
        </form>
           
        
        
    </body>
</html>
