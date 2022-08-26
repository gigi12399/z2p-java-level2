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
		<h3 class="col-10">All Bootcampers</h3>
		<c:url value="/add-bootcamper" var = "add"></c:url>
		<a href="${add}" class="btn btn-primary col">Add Bootcamper</a>
	</div>
	<hr />
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Level</th>
				<th>Batch</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<!-- bootcamper list -->
			<c:forEach items="${bootcampers}" var="bc" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${bc.name}</td>
					<td>${bc.batch.level.name}</td>
					<td>${bc.batch.name}</td>
					<td>${bc.phone}</td>
					<td>${bc.address}</td>
					<td>
						<c:url value="/edit-bootcamper" var = "edit">
							<c:param name="id">${bc.id}</c:param>
							<c:param name="levelId">${bc.batch.level.id}</c:param>
							<c:param name="batchId">${bc.batch.id}</c:param>
						</c:url>
						<a href="${edit}" class="btn btn-outline-success btn-sm">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<!-- footer -->
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>