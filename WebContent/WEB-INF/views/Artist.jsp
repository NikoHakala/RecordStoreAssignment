<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/RecordStore/artist" method="get">
	Hae Artisti Idllä<br>
	<input type="text" name="id" >
	<input type="submit" value="Submit" >
</form>

<form action="/RecordStore/artists" method="get">
	<input type="submit" value="back">
</form>
Artist:<br>
<c:out value="${ artists.getName() }" />
<br>
Albums:<br>
<c:out value="${ albums.getTitle() }" />


</body>
</html>