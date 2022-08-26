<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<div class="row mt-3">
		<h3 class="col-10">All Courses</h3>
		<c:url value="/add-course" var = "add"></c:url>
		<a href="${add}" class="btn btn-primary col">Add Course</a>
	</div>
	<hr />
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Course Name</th>
				<th>Level Name</th>
				<th>Created At</th>
				<th>Updated At</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<!-- Course list -->
			<c:forEach items="${courses}" var= "course" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${course.name}</td>
					<td>${course.level.name}</td>
					<td>${course.created_at}</td>
					<td>${course.updated_at}</td>
					<td>
						<c:url value="/edit-course" var ="edit">
							<c:param name="id">${course.id}</c:param>
						</c:url>
						<a href="${edit}" class="btn btn-outline-success btn-sm">Edit</a>
						<a href="#" class="btn btn-outline-danger btn-sm btn-remove" data-id="${course.id}">
						<i class="fa-solid fa-circle-trash"></i>Remove</a>
					</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	$(document).ready(function(){
		$('.btn-remove').click(function(){
			//alert('hi');
			let courseId = $(this).data('id');
			//alert(courseId);
			if(confirm('Are you sure to delete?')) {
				window.location.href = "delete-course?id=" + courseId;
			}
		});		
	});
</script>

<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>