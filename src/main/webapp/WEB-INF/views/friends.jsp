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
	<br>
	<% if (session.getAttribute("username") != null) { %>
<!--  -->
		${sessionScope.username} Friends:<br>
<!--  -->
	
		<div id="friends"></div>
<!--  --	
		<div id="users"></div>
<!--  -->

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			$.ajax({
				type : 'GET',
				url : 'http://localhost:8080/sdata/friends/getFriends',
				dataType : 'json'
			}).then(
				function(data) {
					for(var user in data){
						for(var i=0;i<data[user].length;i++){
							$('#friends').append(' - ' + data[user][i].username + '<br>');
						}
					}
				});
		});
		</script>
		
		<h3>All users:</h3>
		
		<div id="users"></div>
		<script>
		$(document).ready(function(){
			$.ajax({
				type: 'GET',
				url: 'http://localhost:8080/sdata/friends/getUsers',
				dataType:'json'
			}).then(function(data) {
			       for(var user in data){
			           $('#users').append('Username: ' + data[user].username + '<br/>');
			           $('#users').append('Messages: <br/>');
			           data[user].messages.forEach( messages => {
			            $('#users').append('  - ' + messages.content + '<br/>');
			           });
			           $('#users').append('<br/>');
			       }
			});
		});
		</script>
		<br><br>
	
		
	<% } else {%>
	Please login!
	<% } %>
	
</body>
</html>
