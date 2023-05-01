<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view</title>
</head>
<body>
<p>${image.fileName} || ${image.label} || ${image.caption}</p>
<img src="${path}${image.fileName}">
</body>
</html>