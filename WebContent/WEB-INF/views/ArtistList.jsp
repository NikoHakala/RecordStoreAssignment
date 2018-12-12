<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artist List</title>
</head>

<body>
Kaikki artistit:
<form action="/RecordStoreAssignment/artist" method="get">
	Hae Artisti Idllä<br>
	<input type="text" name="id">
	<input type="submit" value="Submit">
</form>

	<ul>
	<c:forEach items="${ artists }" var="artists">
		<li>
			<a href="/RecordStoreAssignment/artist?id=${ artists.getId() }"><c:out value="${ artists.getName() }" /></a>
		</li>
	</c:forEach>
	</ul>
</body>

</html>