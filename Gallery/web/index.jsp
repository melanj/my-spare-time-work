<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gallery</title>
    </head>
    <body>
        <h1>Gallery</h1>
<s:if test="fileList.size() > 0">
<table border="1px" cellpadding="8px">
	<tr>
		<th>FileName</th>
		<th>thumbnail</th>
	</tr>
        <s:iterator value="fileList" var="filename" status="userStatus">
		<tr>
                    <td><s:property value="filename"/></td>
                    <td><a href="image/<s:property value="filename"/>"><img src="thumbnail/<s:property value="filename"/>"></a></td>
		</tr>
	</s:iterator>
</table>
</s:if>
    </body>
</html>