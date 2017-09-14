<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style>
			ul {
			    list-style-type: none;
			    margin: 0;
			    padding: 0;
			    overflow: hidden;
			    background-color: #333;
			}
			
			li {
			    float: left;
			}
			
			li a {
			    display: block;
			    color: white;
			    text-align: center;
			    padding: 14px 16px;
			    text-decoration: none;
			}
			
			li a:hover:not(.active) {
			    background-color: #111;
			}
			
			.active {
			    background-color: #4CAF50;
			}
		</style>
	</head>
	
	<body>
		<ul>
			<li> <a href="/sdata">Home</a> </li>
			<c:if test="${empty sessionScope.username}">
			<li style="float:right"><a class="active" href="login">Login</a> </li>
			</c:if>
			
			<c:if test="${not empty sessionScope.username}">
			<li> <a href="friends">Friends</a> </li>
			<li> <a href="messages">Messages</a> </li>
			<li style="float:right"><a class="active" href="logout">Logout</a> </li>
			</c:if>
			<li> <a href="about">About</a> </li>
		</ul>
	</body>
</html>
