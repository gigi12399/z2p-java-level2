<%@page import="java.util.ArrayList"%>
<%@page import="com.mmit.entity.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch</title>
<!-- bootstrap,jquery,fontawesome -->
<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<!-- nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>

	<!-- body -->
	<div class="container">
		<div class="row mt-4">
			<form action="batch-add" class="form col-4" method="post">
				<div class="mb-3">
					<label for="" class="form-label">Batch Name</label>
					<input type="text" class="form-control" name ="batch"/>
				</div>
				<div class="mb-3">
					<label for="" class="form-label">Start Date</label>
					<input type="Date" class="form-control" name ="start_date"/>
				</div>
				<div class="row mt-4">
					<div class="col ps-5">
						<button class="btn btn-danger" type="submit">Create</button>
					</div>
					<div class="col ps-5">
						<button class="btn btn-primary" type="reset">Reset</button>
					</div>
				</div>
			</form>
			
			<div class="col-8 ps-5">
				<h3>Batch List</h3>
				<table class="table">
					<thead>
						<tr>
							<th class = "text-center">Batch Name</th>
							<th class = "text-center">Start Date</th>
						</tr>
					</thead>
					<tbody>
					<!-- batch list -->
						<%
							List<Batch> list = (ArrayList<Batch>) application.getAttribute("batches");
							if(list == null){
								list = new ArrayList<>();
							}
							for(Batch b : list){
								%>
								<tr>
									<td class="text-center"><%= b.getName() %></td>
									<td class="text-center"><%= b.getStart_date() %></td>
								</tr>
							<%}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>