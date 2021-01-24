 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	form{
		border: 1px solid;
  	    padding: 10px;
    	border-radius: 10px;
    	background-color: floralwhite;
		
	}

</style>

<script type="text/javascript">

$(function(){
	$("#getDonor").on("click",function(){
		console.log($("#donorId").val())

		var config = {
				url:'http://localhost:5000/api/v1/donors/'+$("#donorId").val(),
				method:'GET',
				success : function(response){
					$("#main-form").html("");
					
							
					
				},
				failure : function(response){
					console.log(response)
				}
		
		}
	
		$.ajax(config);
		
		})

});


</script>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>
<section>
<div class="container">
<div class="row">
<div class="col-md-8 col-md-offset-2">
<h1>update your details</h1>


	


<form:form action="update" method="post" id="main-form">
<div class="form-group">
		<label for="">UID number</label>
		<form:input path="donorId" class="form-control" id="donorId"/>
		
	</div>
	<div class="form-group">
		<label for="">Name</label>
		<form:input  path="donorName" cssClass="form-control"/>
	</div>
	<div class="form-group">
		<label for="">Age</label>
		<form:input path="donorAge" cssClass="form-control"/>
	</div>
	<div class="form-check">
		<form:radiobutton path = "donorGender"  value = "male" label = "Male" cssClass="form-check-input" />
	</div>
	
	<div class="form-check">
        <form:radiobutton path = "donorGender" value = "female" label = "Female" cssClass="form-check-input" />
	</div>
	
	<div class="form-check">
        <form:radiobutton path = "donorGender" value = "other" label = "other" cssClass="form-check-input" />
	</div>
	
	<div class="form-group">
		<label for="">Blood Group</label>	
 			<form:select path="donorGroup" cssClass="form-control">
 			<form:option value="" disabled="true" selected="true" hidden="true">Choose here</form:option>
 			<form:option value="A+ve">A+ve</form:option>
 			<form:option value="O+ve">O+ve</form:option>
 			<form:option value="B+ve">B+ve</form:option>
 			<form:option value="AB+ve">AB+ve</form:option>
 			<form:option value="A-ve">A-ve</form:option>
 			<form:option value="O-ve">O-ve</form:option>
 			<form:option value="B-ve">B-ve</form:option>
 			<form:option value="AB-ve">AB-ve</form:option>
 			</form:select>
	</div>
	
	
	<div class="form-group">
		<label for="">Location</label>
		<form:input path="location" cssClass="form-control"/>
	</div>
	<div class="form-group">
		<label for="">Mobile Number</label>
		<form:input path="mobileNumber" cssClass="form-control"/>
	</div>
	<div class="form-group">
		<label for="">Last Donated Date</label>
		
		<form:input type="date" pattern="yyyy-MM-dd" path="lastDonatedDate" id="date" cssClass="form-control" />
	</div>
	<div class="form-group">
		<input type="submit" value="update" class="form-control btn btn-primary">
	</div>
</form:form>

</div>
</div>


</div>
</section>
</body>
</html>