<%-- 
    Document   : editor2fwd
    Created on : Aug 4, 2014, 9:35:53 PM
    Author     : diptimaya
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="Beans.Editor2Bean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
     <script language="javascript" type="text/javascript" src="editarea/edit_area/edit_area_full.js"></script>
     <script language="javascript" type="text/javascript">    
       editAreaLoader.init({
	id : "editor2disp"		// textarea id
	,syntax: "html"			// syntax to be uses for highgliting
	,start_highlight: true	
        ,is_editable:false
        ,allow_toggle:false // to display with highlight mode on start-up
        });
        
            function displaycode()
            {
            <% Editor2Bean eb22=(Editor2Bean)request.getSession().getAttribute("e2b");
               String strcode=eb22.getCode2();
               Gson gson=new Gson();
               String v=gson.toJson(strcode);
               
            %>
            
            var v='<%= v %>';
            

            for(var i=0;i<v.length;i++)
                {
                    if(v[i]==';')
                    {
                        document.getElementById("editor2disp").value+=v[i];
                        document.getElementById("editor2disp").value+="\n";
                    }    
                    else if(v[i]=='{' || v[i]=='}')
                    {
                        document.getElementById("editor2disp").value+="\n";
                        document.getElementById("editor2disp").value+=v[i];
                        document.getElementById("editor2disp").value+="\n";
                    }  
                    else if(v[i]=='>')
                    {
                        document.getElementById("editor2disp").value+=v[i];
                        document.getElementById("editor2disp").value+="\n";
                    }  
                    else
                    {
                        document.getElementById("editor2disp").value+=v[i];
                    }    
                }    
            } 
        </script>    
    </head>
    <body onload="displaycode()">
        <form action="fetch2back.do" method="POST" enctype="multipart/form-data">
            <input type="submit" value="View another module" />
        </form>    
 
        <textarea id="editor2disp" rows="30" cols="70" readonly="readonly">
        </textarea>
           
    </body>
</html>
