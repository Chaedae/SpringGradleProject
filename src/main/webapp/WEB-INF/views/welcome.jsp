<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Welcome to the Daeyeong world</title>
	
	<style>
		th, td {border: 1px solid black;}
	</style>
</head>
<body>
	<div>
		<h1>
			Welcome Spring Gradle Project 
		</h1>
		<p>What time is it? ${time}.</p>
	</div>
	
	<div>
		<div>User ID : ${user.userId} / User Name : ${user.userNm}</div> 
		<div>
			<table class="table" style="border: 1px solid black;">
				<caption align="center"><h1>User List</h1></caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Join</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${userList}">
						<tr>
							<td>${item.userId}</td>
							<td>${item.userNm}</td>
							<td>${item.hpNo}</td>
							<td>${item.email}</td>
							<td>${item.regDt}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<script>
		var user = "${user}";
		var userList = "${userList}";
	</script>
</body>
</html>