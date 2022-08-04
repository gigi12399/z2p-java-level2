<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  Bootstrap  -->
<c:url var ="bsCss" value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"></c:url>
<c:url var="bsJs" value="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></c:url>

<!--  jQuery -->
<c:url var="jqJs" value="/webjars/jquery/3.6.0/jquery.min.js"></c:url>

<!-- Font awesome -->
<c:url var="faJs" value="/webjars/font-awesome/6.1.1/css/fontawesome.min.css"></c:url>

<!--  Bootstrap  -->
<link rel="stylesheet" href="${bsCss}" />
<script type="text/javascript" src="${bsJs }"></script>

<!--  jQuery -->
<script type="text/javascript" src="${jqJs}"></script>

<!-- Font awesome -->
<link rel="stylesheet" href="${faJs}" />
