<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	thead{
	background-color: red;
    color: aliceblue;
	}

</style>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>
<section>
<div class="container">
  <h2>${campName}</h2>        
  <table class="table table-hover">
    <thead>
      <tr>
        <th>UID NUMBER</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>GENDER</th>
        <th>BLOOD GROUP</th>
        <th>LOCALITY</th>
        <th>MOBILE NUMBER</th>
        <th>LAST DONATED ON</th>
      </tr>
    </thead>
    <tbody id="table-body">
		<c:forEach items="${donorObj}" var="eachDonor">
		<tr>
       		<td><c:out value="${eachDonor.donorId}"/></td>
       		<td><c:out value="${eachDonor.donorName}"/></td>
       		<td><c:out value="${eachDonor.donorAge}"/></td>
       		<td><c:out value="${eachDonor.donorGender}"/></td>
       		<td><c:out value="${eachDonor.donorGroup}"/></td>
       		<td><c:out value="${eachDonor.location}"/></td>
       		<td><c:out value="${eachDonor.mobileNumber}"/></td>
       		<td><c:out value="${eachDonor.lastDonatedDate}"/></td>
      	</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
</section>
</body>
</html>