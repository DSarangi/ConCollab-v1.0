<%-- 
    Document   : myprosnapshot
    Created on : Aug 8, 2014, 5:44:27 PM
    Author     : diptimaya
--%>

<%@page import="Beans.ProjectSnapBean"%>
<%@page import="Beans.DummyBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           
      <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
      <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js" type="text/javascript"></script>
      <link href="fancytree/fancytree-2.2.0/dist/skin-lion/ui.fancytree.css" rel="stylesheet" type="text/css">
      <script src="fancytree/fancytree-2.2.0/dist/jquery.fancytree-all.js" type="text/javascript"></script>
        
      <% ProjectSnapBean psb11=(ProjectSnapBean)request.getSession().getAttribute("psb");
           int[] arr1=psb11.getList();
           int nmod=psb11.getNomodules();
           String projectname=psb11.getProjectname();
      %>
        <script>
        var listJson;
        <% Gson gson=new Gson();
           String listJson=gson.toJson(arr1);
        %>    
            
        listJson=<%=listJson %>;   
        var listData=[];
        for(elem in listJson)
        {
            listData.push(listJson[elem]);
        }
        var nmod=<%=nmod%>;
       
        function myfunc(divname)
        {
            
           <%-- document.getElementById('display').innerHTML=listData;
            document.getElementById('display1').innerHTML=nmod;
           --%> 
            var listElement=document.createElement("ul");
            
            document.getElementById('tree').appendChild(listElement);
            
            for(var i=0;i<nmod;i++)
            {
              var listItem=document.createElement("li");
              listItem.innerHTML="Module >> "+(i+1);
              listItem.className='folder';
             
              listElement.appendChild(listItem);
              
              for(var j=0;j<listData[i];j++)
              {
                  var listItem2=document.createElement("li");
                  listItem2.innerHTML="Code > "+(j+1);
                  listItem2.className='Node';

                  listItem.appendChild(listItem2);
              }

            }
            
             $(function(){
                // Create the tree inside the <div id="tree"> element.
             $("#tree").fancytree()
             }); 
             
        setTimeout(function()
        {document.getElementById('projsnapform').submit()},30000);

        }
        </script>    
    </head>
    
    <body onload="myfunc('tree')">
        <h3 id="pname"><%=projectname %></h3>
   
        <div id="tree"></div>
        <form id="projsnapform" action="projsnap.do">
            <textarea id="projnamefield" name="projname1" rows="4" cols="20" readonly="readonly" hidden="hidden">
            </textarea><br>
            <input type="submit" value="submit" hidden="hidden" />
        </form>
        
        <script>
            document.getElementById("projnamefield").value=document.getElementById('pname').innerHTML;
        </script>   
        
   </body>
</html>
