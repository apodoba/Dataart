<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.app_title" /></title>
</head>
<body>

<%-- <h2><spring:message code="label.welcome_title" />, 
		 <spring:message code="label.login" />		
	</h2>--%>

<h3><spring:message code="label.profile" /></h3>
<c:if test="${!empty userProfile}">
	<table class="data">
		<tr>
			<td><spring:message code="label.fullname" />
			</td><td>${user.fullname}</td>
		</tr>
		<tr>
			<td><spring:message code="label.email" /></td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td><spring:message code="label.telephone" />
			</td><td>${user.telephone}</td>
		</tr>
	</table>
</c:if>

<c:if test="${userAdmin}">
<a href="<c:url value="/allUsers" />">
	<spring:message code="label.allUsers" />
</a><br/>
</c:if>



	<!-- <td><a href="change/${user.id}"><spring:message code="label.changeProfile" /></a></td>-->
			
	<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" /></a>
	

</body>
</html>
