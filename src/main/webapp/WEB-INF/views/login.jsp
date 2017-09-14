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

	<c:if test="${empty sessionScope.username}">

	<div>
		<label>Username:</label> <input id="username" type="text" />
	</div>
	<br />
	<div>
		<label>Password:</label> <input id="password" type="password" />
	</div>
	<br />
	<div>
		<input id="Login" type="submit" value="Login" />
	</div>
	<br />
	<div>
		<p id="error"></p>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
			$('#Login').click(function(){
				var username = $('#username').val();
				var password = $('#password').val();
				var user = {'username':username, 'password':password};
				$.ajax({
					url:'http://localhost:8080/sdata/login',
					type:'post',
					contentType:'application/json; charset=utf-8',
					async:true,
					data: JSON.stringify(user),
					success:function(data){
						location.reload();
					},
					failure:function(data){ }
				});
			});
		</script>
	</c:if>
	
	<c:if test="${not empty sessionScope.username}">
	Hello ${sessionScope.username}!
	<br><br>
	</c:if>

</body>
</html>
