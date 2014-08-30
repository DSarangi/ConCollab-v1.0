<%-- 
    Document   : editor1
    Created on : Aug 4, 2014, 2:36:36 PM
    Author     : diptimaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Editor 1</title>
<script language="javascript" type="text/javascript" src="editarea/edit_area/edit_area_full.js"></script>
<script language="javascript" type="text/javascript">
editAreaLoader.init({
	id : "editor1"		// textarea id
	,syntax: "html"			// syntax to be uses for highgliting
	,start_highlight: true
        ,is_editable:false
        ,allow_toggle:false 
        // to display with highlight mode on start-up
});
 
</script>
</head>
<body>
    <form id="editor1form" action="fetch1.do" method="POST">
      Enter Module no to display<input type="text" name="modnoview" value="" size="3" />
      Code no<input type="text" name="codenoview" value="" size="3" />
      <input type="submit" value="View" />
    </form>   
    <textarea id="editor1" cols="70" rows="30" readonly="readonly">
    No module selected.
    The PROJECT SNAPSHOT displays a list of the modules of your project.
    Refer it. 
    </textarea>


</body>
</html>
