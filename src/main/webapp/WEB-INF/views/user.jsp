<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><spring:message code="label.appTitle" /></title>
</head>
<body>

	<%-- <h2><spring:message code="label.welcomeTitle" /></h2>--%>

	<c:if test="${!empty userProfile}">
	   <input type="hidden" name="pid" value=${userProfile.getId()} />
		<h3>
			<spring:message code="label.profile" />
		</h3>
		<table class="data">
			<tr>
				<td><spring:message code="label.fullName" /></td>
				<td>${userProfile.getFullName()}</td>
			</tr>
			<tr>
				<td><spring:message code="label.userName" /></td>
				<td>${userProfile.getUserName()}</td>
			</tr>
			<tr>
				<td><spring:message code="label.email" /></td>
				<td>${userProfile.getEmail()}</td>
			</tr>
			<tr>
				<td><spring:message code="label.telephone" /></td>
				<td>${userProfile.getPhone()}</td>
			</tr>
		</table>
	</c:if>

	<br />
	<br />
	<!-- <td><a href="change/${user.id}"><spring:message code="label.changeProfile" /></a></td>-->

	<a href="<c:url value="/logout" />"> <spring:message
			code="label.logout" /></a>

	<a href="<c:url value="/payments/service.jsp" />"> 
	   <spring:message code="label.PaymentService" />
	</a>
	<a href="<c:url value="payments/account.jsp" />"> 
		<spring:message code="label.PaymentHuman" />
	</a>
</body>
</html>
