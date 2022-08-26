<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}| ${bootcamper.id == 0 ? 'Add' : 'Edit'}</title>
<!-- bootstrap,jquery,fontawesome -->
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
<!-- nav -->
<jsp:include page="common/nav.jsp"></jsp:include>

<!-- body -->
<div class="container mb-5">
	<div class="row mt-3">
		<h3 class="col-10">${bootcamper.id == 0 ? 'Add' : 'Edit'} Batch</h3>
		<c:url value="/bootcampers" var = "back"></c:url>
		<a href="${back}" class="btn btn-primary col">Back</a>
	</div>
	<hr />
	<c:url value="/add-bootcamper" var="save"></c:url>
	<form action="${save}" class="form col-5 offset-3 mb-5" method="post">
		
		<input value="${bootcamper.id}" name = "bootcamperId" type="hidden" class="form-control"/>
		
		<div class="mb-3">
			<label class="form-label">Level</label>
			<select name="level" class="form-select btn-select" data-id="${bootcamper.id}">
				<c:forEach items="${levels}" var ="lvl">
					<option value="${lvl.id}" ${lvl.id == levelId ? 'selected = "selected"' : '' }>${lvl.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<label class="form-label">Batch</label>
			<select name="batch" class="form-select">
				<c:forEach items="${batchlist}" var ="blist">
					<option value="${blist.id}" ${blist.id == batchId ? 'selected = "selected"' : '' }>${blist.name}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Name</label>
			<input value="${bootcamper.name}" type="text" name = "name" class="form-control" placeholder="Enter Name" required="required"/>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Phone</label>
			<input value="${bootcamper.phone}" type="text" name = "phone" class="form-control" placeholder="Enter Phone Number" required="required"/>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Email</label>
			<input value="${bootcamper.email}" type="email" name = "email" class="form-control" placeholder="Enter Email" required="required"/>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Address</label>
			<input value="${bootcamper.address}" type="text" name = "address" class="form-control" placeholder="Enter Address" required="required"/>
		</div>
		<div class="mb-3">
			<button class="btn btn-success" type ="submit">Save</button>
			<button class="btn btn-danger" type="reset">Clear</button>
		</div>
	</form>
</div>
<script>
	$(document).ready(function(){
		$('.btn-select').change(function(){
			let id = $(this).val();
			let bootcamperId = $(this).data('id');
			if(bootcamperId != "")
				window.location.href = "select-level?levelId=" + id + "&id=" + bootcamperId;
			else
				window.location.href = "select-level?levelId=" + id;
		});
	});
</script>

<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>