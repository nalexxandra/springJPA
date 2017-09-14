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
	<jsp:include page="header.jsp" />
	<br> Hello ${sessionScope.username}!

	<!--  -->

	<!--  -->
	<br>
	<br> Search
	<br>
	<br>

	<input type="text" id="search" />
	<input type="submit" value="search" id="submit" />
	<div id="userSearch"></div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$('#submit').click( function() {
			   var content = document.getElementById("search").value;
			   $.ajax({
			    url : 'http://localhost:8080/sdata/search',
			    type: 'post',
			    dataType: 'json',
			    async : true,
			          data: JSON.stringify(content),
			          contentType: 'application/json; charset=utf-8',
			      success: function(data) {
			    	  $('#userSearch').text(data.message);
			    	},failure: function(data) {
			    		$('#userSearch').text(data.message); 
			    	}
			    });
		});
		</script>

	<P>The time on the server is ${serverTime}.</P>
</html>
