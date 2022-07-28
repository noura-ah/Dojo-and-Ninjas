<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Show Dojo</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
	<div class="container w-75">
		<c:if test="${not empty success}">
			<div class="alert alert-success mt-4"><c:out value="${success}"/></div>
		</c:if>
		<h1 class="m-3"><c:out value="${dojo.name}"/> dojo</h1>
		<table class="table">
			<thead>
				<tr>
					
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="ninja">
					<tr>	
						<td ><c:out value="${ninja.firstName}"/></a></td>
						<td ><c:out value="${ninja.lastName}"/></td>
						<td ><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		
	</div>
    
	
</body>
</html>