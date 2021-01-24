<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.html" %>


<div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3">
<h1>ENTER YOUR UID TO CONFIRM</h1>
<form:form action="../register" method="post">
	<div class="form-group">
		<label for="">UID number</label>
		<form:input path="donorId" cssClass="form-control" />
	</div>
	<div class="form-group" hidden="true">
		<form:input path="campId" cssClass="form-control"  value="${campId}"/>
	</div>

	<div class="form-group">
		<input type="submit" value="register" class="form-control btn btn-primary">
	</div>
</form:form>
</div>
</div>
</div>
</body>
</html>