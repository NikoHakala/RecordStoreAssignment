<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ param.name != null }">
		KYL <c:out value="${ param.name.toUpperCase() }" />
	</c:if>
	<c:if test="${ param.name == null }">
		EI <c:out value="${ param.name.toUpperCase() }" />
	</c:if>
</body>
</html>