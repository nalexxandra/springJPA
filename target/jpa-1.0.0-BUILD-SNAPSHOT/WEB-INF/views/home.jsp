<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<br>

	Hello ${sessionScope.username}!
	<br><br>
<!--  -->	
	<div>${about}</div>
<!--  -->
		<br><br>
		Search
		<br><br>
	
		<input type="text" id="search" />
		<input type="submit" value="Search" id="submitSearch" />
		<div id="userSearch"></div>
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
		$('#submitSearch').click( function() { 
			var searchUser = document.getElementById("search").value;
			$.ajax({
				url: 'http://localhost:8080/sdata/search',
				type:'GET',
				dataType : 'json'
			}).then(
					function(data) {	
						var input;
						$('#userSearch').append(data.username + 'found');
					})
		});
		</script>
		
		
		
	
<P>  The time on the server is ${serverTime}. </P>

</html>
