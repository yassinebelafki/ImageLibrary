<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListingImages</title>
</head>
<body>
<h1>listing images </h1>
<table border="1">
<thead>
<th>image</th>
<th>informations</th>
<th>update info</th>
<th>Actions</th>
</thead>
<c:forEach items="${fileslist}" var="image">
<tr>
<td style="width:80px; height:80px;text-align:center; vertical-align:middle">
<img src="${path}${image.fileName}" style="max-height:100%; max-width:100%"></td>
<td>
<ul>
<li>Name : ${image.fileName}</li>
<li>Label : ${image.label}</li>
<li>Caption : ${image.caption}</li>
</ul>
</td>
<td>
<form action="<%=request.getContextPath()%>/filehandler?action=update&id=${image.id}" method="post"> 
Update Caption : <input type="text" name="caption"><br>
Update Label : <input type="text" name="label"><br>
<input type="submit">
</form>
</td>
<td>
<ul>
<li><a href="<%=request.getContextPath()%>/filehandler?action=view&id=${image.id}">view</a></li>
<li><a href="<%=request.getContextPath()%>/filehandler?action=delete&id=${image.id}">delete</a></li>
</ul>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>