<%@page import="java.util.ArrayList"%>
<%@page import="com.mmit.entity.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= request.getAttribute("title") %></title>
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
	<form action="add-student" class="form col-5" method="post">
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
				<%
					List<Batch> list = (ArrayList<Batch>)application.getAttribute("batches");
					if(list == null)
						list = new ArrayList<>();
					for(Batch b : list){
						%>
						<option value="<%= b.getName() %>"><%= b.getName() %></option>
					<% }
				%>
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