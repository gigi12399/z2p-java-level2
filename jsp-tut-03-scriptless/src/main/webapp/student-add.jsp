<%@page import="com.mmit.entity.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<!-- bootstrap,jquery,fontawesome -->
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
<!-- nav -->
<jsp:include page="common/nav.jsp"></jsp:include>

<!-- body -->
<div class="container">
	<div class="row mt-4">
		<h3 class = "col-10">Add New Student</h3>
	</div>
	<hr />
	<c:url var="add" value="/add-student"></c:url>
	<form action="${add}" class="form col-5" method="post">
		<div class="mb-3">
			<label for="" class="form-label">Student Name</label>
			<input type="text" class="form-control" name="stdName" required="required"/>
		</div>
		<div class="mb-3">
			<label for="" class="form-label">Phone</label>
			<input type="text" class="form-control" name="phone" required="required"/>
		</div>
		<div class="mb-3">
			<label for="" class="form-label">Email</label>
			<input type="email" class="form-control" name="email" required="required"/>
		</div>
		<div class="mb-3">
			<label for="" class="form-label">Choose Batch</label>
			<select name="batch" id="" class="form-select">
			<c:forEach items="${batches}" var="b">
				<option value="${b.name}">${b.name}<option>
			</c:forEach>
			</select>
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" name="old" id="std"/>
			<label for="std" class="form-check-label">Old Student</label>
		</div>
		<div class="row">
			<div class="col">
				<button class="btn btn-danger w-100" type = "reset">Clear</button>
			</div>
			<div class="col">
				<button class="btn btn-primary w-100" type = "submit">Save</button>
			</div>
		</div>
	</form>
	
</div>

<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>