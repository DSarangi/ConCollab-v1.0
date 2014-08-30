<%-- 
    Document   : editor
    Created on : Aug 2, 2014, 10:28:42 PM
    Author     : diptimaya
--%>

<html>
<head>
<title>Live Editor</title>
<style>
    #editor{
        background-color: #5F9EA0;
        font-family: monospace;
        font-style: oblique;
        color: #FA8072;
           
    }
    
</style>
  
<script language="javascript" type="text/javascript" src="editarea/edit_area/edit_area_full.js"></script>
<script language="javascript" type="text/javascript">
editAreaLoader.init({
	id : "editor"		// textarea id
	,syntax: "html"			// syntax to be uses for highgliting
	,start_highlight: true
        ,allow_toggle:false
        ,fullscreen:false
         // to display with highlight mode on start-up
});
 
 function myfun()
 {
     var modnosave=prompt("Enter module no where you want to add this code","");
  <%--var codenosave=prompt("Enter code no(submodule)where you want to add this code","");--%>
     document.getElementById('modnosave').value=modnosave;
   <%--document.getElementById('codenosave').value=codenosave; --%>
     
 }
 function myfun1()
 {
     var modnosave1=prompt("Enter module no where you want to overwrite an existing code","");
     document.getElementById('modnosave1').value=modnosave1;
     var codenosave1=prompt("Enter the code no which you want to overwrite","")
     document.getElementById('codenosave1').value=codenosave1;
     
 }
 
</script>
</head>
<body>
<centre>
    <form action="upload.do" method="POST">
     <textarea id="editor" name="editorcontent" cols="70" rows="30">
     <html>
        <head>
           <title>Hello World!</title>  
        </head>
        <body>
            <p>Welcome to ConCollab.</p>
        </body>
     </html>  
     </textarea>
        <input type="text" id="modnosave" name="modnosave" value="" readonly="readonly" hidden="hidden"/>
        <input type="text" id="codenosave" name="codenosave" value="" readonly="readonly" hidden="hidden"/>
        <input type="text" id="modnosave1" name="modnosave1" value="" readonly="readonly" hidden="hidden"/>
        <input type="text" id="codenosave1" name="codenosave1" value="" readonly="readonly" hidden="hidden"/>
        <input type="submit" value="Upload current edit" onclick="myfun()"/>
        <input type="submit" value="Upload & Overwrite" onclick="myfun1()"/>
     
    </form>
</centre>   

</body>
</html>