<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Execute and Wait Examples</title></head>
<body>
    <h1>The process is complete</h1>
    <b>We have processed your request.</b>
    <p/>
    <s:url id="fileDownload" namespace="/" action="download/gz"></s:url>
    <s:url id="fileDownloadzip" namespace="/" action="download/zip"></s:url>
    <s:url id="fileDownloadsql" namespace="/" action="download/sql"></s:url>
<h4>Download file - <s:a href="%{fileDownload}">GZip format</s:a><br>
Download file - <s:a href="%{fileDownloadzip}">Zip format</s:a><br>
Download file - <s:a href="%{fileDownloadsql}">SQL format</s:a><br>
</h4>
</body>
</html>
