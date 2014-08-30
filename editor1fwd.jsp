<%-- 
    Document   : editor1fwd
    Created on : Aug 4, 2014, 6:39:24 PM
    Author     : diptimaya
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="Beans.Editor1Bean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Editor 1</title>


<script language="javascript" type="text/javascript" src="editarea/edit_area/edit_area_full.js"></script>
<script language="javascript" type="text/javascript">
editAreaLoader.init({
	id : "editor1disp"		// textarea id
	,syntax: "html"			// syntax to be uses for highgliting
	,start_highlight: true	
        ,is_editable:false 
        ,allow_toggle:false 
        // to display with highlight mode on start-up
});
 
 function displaycode()
            {
                <% Editor1Bean eb11=(Editor1Bean)request.getSession().getAttribute("e1b");
                   String str=eb11.getCode1();
                   Gson gson=new Gson();
                   String v=gson.toJson(str);
                 %>
                var v='<%=v%>';
                for(var i=0;i<v.length;i++)
                {
                    if(v[i]==';')
                    {
                        document.getElementById("editor1disp").value+=v[i];
                        document.getElementById("editor1disp").value+="\n";
                    }    
                    else if(v[i]=='{' || v[i]=='}')
                    {
                        document.getElementById("editor1disp").value+="\n";
                        document.getElementById("editor1disp").value+=v[i];
                        document.getElementById("editor1disp").value+="\n";
                    } 
                    else if(v[i]=='>')
                    {
                        document.getElementById("editor1disp").value+=v[i];
                        document.getElementById("editor1disp").value+="\n";
                    } 
                    else if(v[i]=='/' && v[i-1]=='*')
                    {
                        document.getElementById("editor1disp").value+=v[i];
                        document.getElementById("editor1disp").value+="\n";
 
                    }   
                    else
                    {
                        document.getElementById("editor1disp").value+=v[i];
                    }    
                }    
            } 
</script>
</head>
<body onload="displaycode()">
        <form action="fetch1back.do" method="POST" enctype="multipart/form-data">
            <input type="submit" value="View another module" />
        </form>    
            <textarea id="editor1disp" rows="30" cols="70" readonly="readonly">
            </textarea>
           
</body>
</html>
