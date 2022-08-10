<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<c:url value="/levels" var = "level"></c:url>
				<c:url value = "/batches" var = "batch"></c:url>
				<c:url value = "/courses" var = "course"></c:url>
				<a href=<%= request.getContextPath() %> aria-current = "page" class="nav-link me-5 ${empty title ? 'active' : ''}">Home</a>
				<c:url value="/batches" var = "batch"></c:url>
				<a href="${level}" class="nav-link me-5 ${title eq 'level' ? 'active' : ''}">Level</a>
				<a href="${batch}" class="nav-link me-5 ${title eq 'batch' ? 'active' : ''}">Batch</a>
				<a href="${course}" class="nav-link me-5 ${title eq 'course' ? 'active' : ''}">Course</a>
			</div>
		</div>
	</div>
</nav>