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
		<h3 class="col-10">All Batch</h3>
		<c:url value="/add-batch" var = "add"></c:url>
		<a href="${add}" class="btn btn-primary col">Add Batch</a>
	</div>
	<hr />
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Batch Name</th>
				<th>Level Name</th>
				<th>Start Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<!-- batch list -->
			<c:forEach items="${batches}" var="b" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${b.name}</td>
					<td>${b.level.name}</td>
					<td>${b.startDate}</td>
					<td>
						<c:url value="/edit-batch" var = "edit">
							<c:param name="id">${b.id}</c:param>
						</c:url>
						<a href="${edit}" class="btn btn-outline-success btn-sm">Edit</a>
						<c:url value="/bootcampers" var = "bc">
							<c:param name="batchId">${b.id}</c:param>
						</c:url>
						<a href="${bc}" class="btn btn-outline-info btn-sm">Bootcamper(${b.totalBootcamper})</a>
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