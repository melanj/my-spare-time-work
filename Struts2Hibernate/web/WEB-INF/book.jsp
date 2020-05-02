<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
<body>
<h2>All e-books</h2>
<s:if test="bookList.size() > 0">
<table border="1px" cellpadding="8px">
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Year</th>
	</tr>
	<s:iterator value="bookList" status="userStatus">
		<tr>
			<td><s:property value="Id" /></td>
			<td><s:property value="Title" /></td>
			<td><s:property value="Year" /></td>
		</tr>
	</s:iterator>
</table>
</s:if>
<br/>
<br/>

</body>
</html>