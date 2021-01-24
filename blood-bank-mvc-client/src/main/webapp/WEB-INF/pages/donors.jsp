<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	thead{
	background-color: red;
    color: aliceblue;
	}
	#eligibleDiv{
	background-color: lavender;
    width: 195px;
    height: 36px;
    border: 1px solid;
    text-align: center;
    border-radius: 4px;
	}
	
	b{
	top: 4px;
    position: relative;
	}
	
	#thumbnail1{
	border: 1px solid;
    border-radius: 8px;
    padding: 10px;
    margin: 2px;
    background-color: lightgrey;
    box-shadow: 2px 3px grey;
	}
	
	#thumbnail2{
	background-color: lightgrey;
    border: 1px solid;
    height: 120px;
    margin: 2px;
    padding: 12px;
    border-radius: 8px;
    box-shadow: 2px 3px grey;
	}
	
	
	#thumbnail3{
	border: 1px solid;
    height: 120px;
    margin: 2px;
    padding: 10px;
    background-color: lightgray;
    box-shadow: 2px 3px grey;
    border-radius: 8px;
	}
	
	#searchByLocation{
		width:200px;
	}
	
	#eligibleButton{
	margin: 17px;
    width: 164px;
    background-color: lightgray;
    height: 62px;
    border: none;
	}
	
	body{
	background-color: seashell;
	}

</style>

<script type="text/javascript">
$(function(){
	$("#searchByLocation").on("click",function(){
		console.log($("#location").val())

		var config = {
				url:'http://localhost:3838/api/v1/donors/location/'+$("#location").val(),
				method:'GET',
				success : function(response){
					if(response.length>0){
						$("#table-body").html("");
					 $.each(response,function(index,result){
						console.log(result);
						$("#table-body").append('<tr><td>'+result.donorId+'</td> <td>'+result.donorName+'</td> <td>'+result.donorAge+'</td> <td>'+result.donorGender+'</td> <td>'+result.donorGroup+'</td> <td>'+result.location+'</td> <td>'+result.mobileNumber+'</td> <td>'+result.lastDonatedDate+'</td> </tr>')
					}) 
						}
					else{
							alert("no data found")
						}
					
				},
				failure : function(response){
					console.log(response)
				}
		
		}
	
		$.ajax(config);
		
		})


		$("#searchByGroup").on("click",function(){

			console.log($("#select").val());

			var config = {
					url:'http://localhost:3838/api/v1/donors/group/'+$("#select").val(),
					method:'GET',
					success : function(response){
						if(response.length>0){
							$("#table-body").html("");
						 $.each(response,function(index,result){
							console.log(result);
							$("#table-body").append('<tr><td>'+result.donorId+'</td> <td>'+result.donorName+'</td> <td>'+result.donorAge+'</td> <td>'+result.donorGender+'</td> <td>'+result.donorGroup+'</td> <td>'+result.location+'</td> <td>'+result.mobileNumber+'</td> <td>'+result.lastDonatedDate+'</td> </tr>')
						}) 
							}
						else{
							alert("no data found")
						}
					},
					failure : function(response){
						console.log(response)
					}
			
			}
		
			$.ajax(config);
			

			})

			$("#searchEligible").on("click",function(){

				var config = {
						url:'http://localhost:3838/api/v1/donors/eligible/'+$("#select").val(),
						method:'GET',
						success : function(response){
							if(response.length>0){
								$("#table-body").html("");
							 $.each(response,function(index,result){
								console.log(result);
								$("#table-body").append('<tr><td>'+result.donorId+'</td> <td>'+result.donorName+'</td> <td>'+result.donorAge+'</td> <td>'+result.donorGender+'</td> <td>'+result.donorGroup+'</td> <td>'+result.location+'</td> <td>'+result.mobileNumber+'</td> <td>'+result.lastDonatedDate+'</td> </tr>')
							}) 
								}
							else{
								alert("no data found")
							}
						},
						failure : function(response){
							console.log(response)
						}
				
				}
			
				$.ajax(config);
				
			
				})


				$("#eligibleButton").on("click",function(){

					var config = {
							url:'http://localhost:3838/api/v1/donors',
							method:'GET',
							success : function(response){
								if(response.length>0){
									$("#table-body").html("");
								 $.each(response,function(index,result){
									console.log(result);
									$("#table-body").append('<tr><td>'+result.donorId+'</td> <td>'+result.donorName+'</td> <td>'+result.donorAge+'</td> <td>'+result.donorGender+'</td> <td>'+result.donorGroup+'</td> <td>'+result.location+'</td> <td>'+result.mobileNumber+'</td> <td>'+result.lastDonatedDate+'</td> </tr>')
								}) 
									}
								else{
									alert("no data found")
								}
							},
							failure : function(response){
								console.log(response)
							}
					
					}
				
					$.ajax(config);
					
					
					})
					
})
</script>
</head>
<body>
<header>
<%@include file="menu.html" %>
</header>
<section>

<%-- <div class="contrainer">
  <div style="height:50px; border: 1px solid">
  	<form class="form-inline" id="locationForm">
  	<div class="form-group">
  	<input type="text" class="form-control" id="location" value="" placeholder="search By location" />
  	</div>
  	<button type="button" class="btn btn-primary" id="searchByLocation">Search</button>
  	</form>
  	
    </div>
 </div> --%>
 
 <div class="container-fluid">
  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-4" id="thumbnail1">
    	<form class="form" id="locationForm">
  			<div class="form-group">
  				<input type="text" class="form-control" id="location" value="" placeholder="search By location" />
  			</div>
  			<div class="form-group" style="text-align:center">
  			<button type="button" class="btn btn-primary" id="searchByLocation">Search</button>
  			</div>
  		</form>
    </div>
    <div class="col-md-2" id="thumbnail2">
    	<div style="text-align:center">
    		<button id="eligibleButton">All Donors</button>
   		</div>
    </div>
    <div class="col-md-4" id="thumbnail3">
    	<form class="form" id="locationForm">
  			<div class="form-group">
  				<select class="form-control" id="select">
  					<option value="" selected disabled hidden>Choose here</option>
    				<option value="A+ve">A+ve</option>
    				<option value="O+ve">O+ve</option>
    				<option value="B+ve">B+ve</option>
    				<option value="AB+ve">AB+ve</option>
    				<option value="A-ve">A-ve</option>
    				<option value="O-ve">O-ve</option>
    				<option value="B-ve">B-ve</option>
    				<option value="AB-ve">AB-ve</option>
  				</select>
			</div>
			<div style="text-align:center">
  			<button type="button" class="btn btn-primary" id="searchByGroup">show All</button>
  			<button type="button" class="btn btn-primary" id="searchEligible">show Eligible</button>
  			</div>
  		</form>
    </div>
    <div class="col-md-1"></div>
  </div>
</div>

<div class="container">
  <h2>DONORS</h2>        
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
		<c:forEach items="${donors}" var="eachDonor">
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