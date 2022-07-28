<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    


<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>New dojo</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container w-75 mt-4">
	
		<div class="container w-75 ">
			<h1>New Dojo</h1>
			<form:form class="border border-3 p-4 border-dark mt-2" method="post" modelAttribute="dojo" action="/dojos">
				<div class="mb-3"> 
					<form:label path="name" class="form-label">Name:</form:label>
					<form:input  path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
					<form:errors path="name" cssClass="invalid-feedback"/>
				</div>
				
			
				<input type="submit" value="create" class="btn btn-dark">
			</form:form>
		</div>
		
	</div>
    
	
</body>
</html>
