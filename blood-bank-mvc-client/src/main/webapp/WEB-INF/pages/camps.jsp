<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<style type="text/css">

	.card{
	border:1px solid;
	padding:10px;
	border-radius:4px;
	box-shadow:2px 2px gray;
	}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.html" %>
<%-- <c:forEach var="eachCamp" items="${camps}">

	<c:out value="${eachCamp}" />

</c:forEach> --%>

<div class="row">
  <div class="col-sm-4 col-md-offset-1">
    <div class="card">
      <div class="card-body">
        <h2 class="card-title"><c:out value="${camps[1].name}" /></h2>
        <p class="card-text">With supporting local BPL citizens initiated by RGV GROUPS.</p>
        <a href="camps/register/1" class="btn btn-primary">REGISTER</a>
         <a href="camps/1" class="btn btn-primary">VIEW DONORS</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 col-md-offset-1">
    <div class="card">
      <div class="card-body">
       <h2 class="card-title"><c:out value="${camps[2].name}" /></h2>
        <p class="card-text">With supporting local BPL citizens initiated by MRNV GROUPS.</p>
        <a href="camps/register/2" class="btn btn-primary">REGISTER</a>
        <a href="camps/2" class="btn btn-primary">VIEW DONORS</a>
      </div>
    </div>
  </div>
</div>


<div class="row" style="margin-top:50px">
  <div class="col-sm-4 col-md-offset-1">
    <div class="card">
      <div class="card-body">
        <h2 class="card-title"><c:out value="${camps[3].name}" /></h2>
        <p class="card-text">With supporting local BPL citizens initiated by PM Support GROUPS.</p>
        <a href="camps/register/3" class="btn btn-primary">REGISTER</a>
         <a href="camps/3" class="btn btn-primary">VIEW DONORS</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 col-md-offset-1">
    <div class="card">
      <div class="card-body">
       <h2 class="card-title"><c:out value="${camps[4].name}" /></h2>
        <p class="card-text">With supporting local BPL citizens initiated by CM Support GROUPS.</p>
        <a href="camps/register/4" class="btn btn-primary">REGISTER</a>
         <a href="camps/4" class="btn btn-primary">VIEW DONORS</a>
      </div>
    </div>
  </div>
</div>



</body>
</html>