<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    


<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>New ninja</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container w-75 mt-4">
	
		<div class="container w-75 ">
			<h1>New Dojo</h1>
			<form:form class="border border-3 p-4 border-dark mt-2" method="post" modelAttribute="ninja" action="">
				<div class="mb-3"> 
					<form:label path="dojo" class="form-label">Dojo:</form:label>
					<form:select  path="dojo" cssClass="form-control" cssErrorClass="form-control is-invalid" >
						<c:forEach items="${dojos}" var="dojo">
							<form:option value="${dojo.id}">
								<c:out value="${dojo.name}" />
							</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="dojo" cssClass="invalid-feedback"/>
				</div>
				<div class="mb-3"> 
					<form:label path="firstName" class="form-label">First Name:</form:label>
					<form:input  path="firstName" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
					<form:errors path="firstName" cssClass="invalid-feedback"/>
				</div>
				<div class="mb-3"> 
					<form:label path="lastName" class="form-label">Last Name:</form:label>
					<form:input  path="lastName" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
					<form:errors path="lastName" cssClass="invalid-feedback"/>
				</div>
				<div class="mb-3"> 
					<form:label path="age" class="form-label">Age:</form:label>
					<form:input  path="age" type="number" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
					<form:errors path="age" cssClass="invalid-feedback"/>
				</div>
				
				
			
				<input type="submit" value="create" class="btn btn-dark">
			</form:form>
		</div>
		
	</div>
    
	
</body>
</html>
