<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}| ${course.id == 0 ? 'Add' : 'Edit'}</title>
<!-- bootstrap,jquery,fontawesome -->
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
<!-- nav -->
<jsp:include page="common/nav.jsp"></jsp:include>

<!-- body -->
<div class="container">
	<div class="row mt-3">
		<h3 class="col-10">${course.id == 0 ? 'Add' : 'Edit'} Course</h3>
		<c:url value="/courses" var = "back"></c:url>
		<a href="${back}" class="btn btn-primary col">Back</a>
	</div>
	<hr />
	<c:url value="/add-course" var="save"></c:url>
	<form action="${save}" class="form col-5 offset-3" method="post">
		
		<input value="${course.id}" name = "courseId" type="hidden" class="form-control"/>
		
		<div class="mb-3">
			<label class="form-label">Level</label>
			<select name="level" class="form-select">
				<c:forEach items="${levels}" var ="lvl">
					<option value="${lvl.id}">${lvl.name}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Course</label>
			<input id="name" value="${course.name}" type="text" name = "name" class="form-control" placeholder="Enter Course Name" />
		</div>
		
		<div class="mb-3">
			<label class="form-label">Content</label>
			<textarea name ="outline" id="summernote" class="form-control">${course.content}</textarea>
		</div>
		<div class="mb-3">
			<button class="btn btn-success" type ="submit">Save</button>
			<button class="btn btn-danger" type="reset">Clear</button>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$('#summernote').summernote();

		$('.form').submit(function(event){
			let name = $('#name').val();
			if(name == ""){
				alert("Please fill course name");
				event.preventDefault();
			}
		});
	});
</script>
<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>