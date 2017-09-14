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
		<input type="text" id="content" />
		<input type="submit" value="post" id="submit" />
	<br><br>
		<div id="messages"></div>

	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
	 $('#submit').click( function() { 
	var content = document.getElementById('content').value;
	var data = {'content' :  content};
	$.ajax({
		url: 'http://localhost:8080/sdata/messages/addMessage',
		type:'post',
	        dataType : 'json',
	        async : true,
	        data: JSON.stringify(data),
	        contentType: 'application/json; charset=utf-8',
		success: function(data) 
			{
			location.reload();

			},
			failure: function(data){
			}
		}); 
	});
	</script>
	
	
	
	<script>
	$(document).ready(function(){

	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/sdata/messages/getMessages',
		dataType : 'json'
	}).then(
			function(data) {
				for(var username in data){
					for(var i=0;i<data[username].length;i++){
						console.log(data[username][i].content);
						$('#messages').append(username+ ': ' + data[username][i].content + '<br>');
					}
				}

			});
	});
	</script>
	

	<% } %>
	<input id="user" style="display:none" value="<%=session.getAttribute("username")%>" >
</body>
</html>



