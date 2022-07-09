<%@page import="java.util.ArrayList"%>
<%@page import="com.mmit.entity.Student"%>
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
		<h3 class = "col-10">Student List</h3>
		<a href="student-add" class="btn btn-primary col"><i class = "fa-solid fa-plus fa-xl"></i>Add Student</a>
	</div>
	<hr />
	
	<table class="table">
		<thead>
			<tr>
				<th>No</th>
				<th>Student Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Batch</th>
				<th>Register Date</th>
				<th>Old Student</th>
			</tr>
		</thead>
		<tbody>
		<!-- Student lists -->
			<%
				List<Student> list = (ArrayList<Student>) session.getAttribute("students");
				if(list == null){
					list = new ArrayList<>();
				}
			
				for(int i = 0; i < list.size(); i++){
					Student tmp = list.get(i);
					%>
					<tr>
						<td><%= (i + 1) %></td>
						<td><%= tmp.getName() %></td>
						<td><%= tmp.getPhone()  %></td>
						<td><%= tmp.getEmail() %></td>
						<td><%= tmp.getBatch() %></td>
						<td><%= tmp.getRegisterDate() %></td>
						<td><%= tmp.isOldStudent() %></td>
					</tr>
				<%}
			%>
		</tbody>
	</table>
</div>

<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>