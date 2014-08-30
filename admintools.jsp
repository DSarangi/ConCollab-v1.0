<%-- 
    Document   : addmintools
    Created on : Aug 6, 2014, 5:45:41 PM
    Author     : diptimaya
--%>

<%@page import="Beans.AdminToolsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #adlist{
                padding-left: 85%;
                display: inline-block;
                float:right; 
                margin-top: 0px;
                    
            }
            h2{
                display: inline;
                
            }
        </style>
        <% AdminToolsBean atb11=(AdminToolsBean)request.getSession().getAttribute("atb");
           String name=atb11.getUsername();
        %>
        <script>
            function fun()
            {
              var x=document.getElementById("admintoolslist").selectedIndex;
              if(x==0)
              {
                 window.open("addmodules.jsp");
              }
              if(x==1)
              {
                  window.open("http://www.w3schools.com");
              }
              if(X==2)
              {
                  window.open("http://www.w3schools.com");
              }
            }
            
        </script>    
        <title>Admin. Tools</title>
    </head>
    <body>
       <h2><%=name%>'s Workdesk</h2>
    
        <div id="adlist">
                <select id="admintoolslist"  name="admintoolslist">
                    <option>Add a module</option>
                    <option>Add a member</option>
                    <option>Block Access</option>
                    
                </select>
            <input type="button" value="Next" onclick="fun()" />
        </div>    
    </body>
</html>
