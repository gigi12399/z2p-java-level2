<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  jQuery -->
<c:url var="jqJs" value="/webjars/jquery/3.6.0/jquery.min.js"></c:url>
<!--  Bootstrap  -->
<c:url var ="bsCss" value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"></c:url>
<c:url var="bsJs" value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></c:url>
<c:url var="popper" value="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></c:url>
<!-- Font awesome -->
<c:url var="faCss" value="/webjars/font-awesome/6.1.1/css/all.min.css"></c:url>
<c:url var="faJs" value="/webjars/font-awesome/6.1.1/js/all.min.js"></c:url>
<!-- Summer Note -->
<c:url var="summerCss" value="/webjars/summernote/0.8.10/summernote.css"></c:url>
<c:url var="summerJs" value="/webjars/summernote/0.8.10/summernote.min.js"></c:url>


<!--  jQuery -->
<script type="text/javascript" src="${jqJs}"></script>
<!--  Bootstrap  -->
<link rel="stylesheet" href="${bsCss}" />
<script type="text/javascript" src="${bsJs}"></script>
<script type="text/javascript" src="${popper}"></script>
<!-- Font awesome -->
<link rel="stylesheet" href="${faCss}" />
<script src="${faJs}"></script>
<!-- Summer note -->
<link rel="stylesheet" href="${summerCss}" />
<script src="${summerJs}"></script>