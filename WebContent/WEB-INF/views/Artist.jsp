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

<form action="/RecordStoreAssignment/artist" method="get">
	Hae Artisti Idllä<br>
	<input type="text" name="id" >
	<input type="submit" value="Submit" >
</form>

<form action="/RecordStoreAssignment/artists" method="get">
	<input type="submit" value="back">
</form>
<br>
Artist:
<br>
<c:out value="${ artists.getName() }" />
<br>
<br>
Albums:
<br>
<ul>
<c:forEach items="${ albums }" var="albums">
		<li>
			<c:out value="${ albums.getTitle() }" />
		</li>
</c:forEach>
</ul>

</body>
</html>