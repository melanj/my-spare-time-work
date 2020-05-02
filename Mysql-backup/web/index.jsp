<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mysql server backup</title>
    </head>
    <body>
        <h1>Mysql backup</h1>
         <s:url id="sqlBackup" namespace="/" action="backup" ></s:url>
         <s:url id="image" namespace="/" action="image" ></s:url>
<h4>to backup <s:a href="%{sqlBackup}">click here</s:a><br>
    view image <s:a href="%{image}">click here</s:a>
</h4>
    </body>
</html>
