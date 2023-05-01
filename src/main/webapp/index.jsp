<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>imageUpload</title>
</head>
<body>
<form action="imageupload?action=fileupload" method="post" enctype="multipart/form-data">
<label>Upload Image</label> 
<input type="file" name="files" multiple>
<input type="submit" value="upload">
</form>
<a href="<%=request.getContextPath()%>/imageupload?action=listingimages">Listing images >>></a>
</body>
</html>