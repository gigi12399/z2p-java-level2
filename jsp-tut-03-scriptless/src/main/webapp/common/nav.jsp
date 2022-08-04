<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<c:url value="/students" var = "student"></c:url>
				<a href=<%= request.getContextPath() %> aria-current = "page" class="nav-link me-5 ${empty title ? 'active' : ''}">Home</a>
				<c:url value="/batches" var = "batch"></c:url>
				<a href="${batch}" class="nav-link me-5 ${title eq 'Batch' ? 'active' : ''}">Batch</a>
				<a href="${student}" class="nav-link me-5 ${title eq 'Student' or title eq 'Student|Add' ? 'active' : ''}">Student</a>
			</div>
		</div>
	</div>
</nav>