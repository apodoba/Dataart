<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><spring:message code="label.appTitle" /></title>
</head>
<body>

	<h2><spring:message code="label.welcomeTitle" /></h2>

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

	<a href="<c:url value="/payment/service" />"> 
	   <spring:message code="label.PaymentService" />
	</a>
	<a href="<c:url value="/payment/account" />"> 
		<spring:message code="label.PaymentHuman" />
	</a>
</body>
</html> --%>


<html>
  <head>
    <meta http-equiv="Content-Language" content="ru">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="http://fonts.googleapis.com/css?family=family=Open+Sans:400,700,300|Comfortaa&amp;subset=all" rel="stylesheet" type="text/css">
    <style type="text/css">
      html {font-size: 95%;}
      @media all and (min-resolution: 120dpi) {html, x:-moz-any-link {font-size: 68.75%;}}
      body,html {margin: 0px; padding: 0px; font-family: open sans, sans}
      input,select { border: none; outline: none; margin: 5px; background-color: white}
      h3 {margin:5px 0px}
      #logo {margin: 30px 15px;}
      #menu {position: relative; float: left; top: 0px; left 0px; width: auto; height: 100%; background-color: #ececec;}
      .button {margin: 30px 15px; width: 100%;}
      .button:hover{opacity: 0.8;}
      .button img {height: 35px;}
      .button A { display: block; width: 100%; height: 100%; color: black; text-decoration: none;}
      #login_container {width: 250px; height: 250px; position: absolute; top: 50%; margin-top: -175px; left: 50%; margin-left: -175px; padding: 15px;}
      #login_container form { background-color: lightgrey; text-align: center; color: grey;}
      #login_container input {text-align: center; height: 2em;}
      #container {position: relative; float: left; left: 20px; top: 20px; padding: 30px; min-width: 50%;}
      .section {position: absolute; top: 0px; left: 0px; background-color: #ececec; padding: 30px; width: 100%;}
      thead {font-weight: bold;}
      /* <!-- to fix header height --> */
      #menu:before,
      #menu:after {
      content:"";
      display:table;
      }
      #menu:after {
      clear:both;
      }
      #menu {
      zoom:1;
      }
    </style>
    <title>TeamBanking</title>
  </head>
  <body>
    <div id="menu">
      <img id="logo" src="<%= request.getContextPath() %>/images/logo_small.png">
      <div class="button">
        <a href="<c:url value="/index"/>">
          <img src="<%= request.getContextPath() %>/images/profile.png"><br>Профиль
        </a>
      </div>
      <c:if test="${admin==null || !admin}">
      <div class="button">
        <a href="<c:url value="/payment/service"/>">
          <img src="<%= request.getContextPath() %>/images/communal.png"><br>Оплатить услуги
        </a>
      </div>
      </c:if>
      <c:if test="${admin==null || !admin}">
      <div class="button">
        <a href="<c:url value="/payment/account"/>">
          <img src="<%= request.getContextPath() %>/images/transfer_money.png"><br>Перевод средств
        </a>
      </div>
      </c:if>
      <c:if test="${admin==null || !admin}">
      <div class="button">
        <a href="<c:url value="/payment/increase"/>">
          <img src="<%= request.getContextPath() %>/images/fill_account.png"><br>Пополнить счет
        </a>
      </div>
      </c:if>
      <c:if test="${admin==null || !admin}">
      <div class="button">
        <a href="<c:url value="/account/transactions"/>">
          <img src="<%= request.getContextPath() %>/images/transactions.png"><br>Журнал транзакций
        </a>
      </div>
      </c:if>
      <c:if test="${admin}">
      <div class="button">
        <a href="<c:url value="/list/users"/>">
          <img src="<%= request.getContextPath() %>/images/log.png"><br>Лог
        </a>
      </div>
      </c:if>
      <div class="button" id="exit">
        <a href="<c:url value="/logout" />"><img src="<%= request.getContextPath() %>/images/exit.png">&nbsp;Выход</a>
      </div>
    </div class="button">
    <div id="container">
       <c:if test="${!empty userProfile}">
      <div id="profile" class="section">
       	<h3>
			<spring:message code="label.profile" />
		</h3>
		<spring:message code="label.fullName" />&nbsp;
			${userProfile.getFullName()}<br>
		<spring:message code="label.userName" />&nbsp;
			${userProfile.getUserName()}<br>
		<spring:message code="label.email" />&nbsp;
			${userProfile.getEmail()}<br>
		<spring:message code="label.telephone" />&nbsp;
			${userProfile.getPhone()}<br>
	<c:if test="${!empty userAccount && !admin}">
		<h4><spring:message code="label.accountNumber" />&nbsp;
			${userAccount.getName()}</h4>
		<h4><spring:message code="label.accountBalance" />&nbsp;
			${userAccount.getBalance()}</h4>
	
    </c:if>
      </div>
      </c:if>
      <%-- <c:if test="${not empty error}"> --%>
	<%-- </c:if> --%>
       <c:if test="${!empty services}">
      <div id="pay_for_services" class="section">
      	<c:set var="error" value="<%= request.getParameter(\"error\") %>" />
      	<c:if test="${!empty error}">
        <font color="red"> <%= request.getParameter("error") %>
		</font>
       </c:if>
        <h3>Оплата услуг</h3>
        
        <form:form method="post" action="/dataart/account/moveBalance/Service" commandName="money">
          <table>
            <tr>
              <td>Тип услуги:</td>
              <td><c:set var="selectedService" value="${selectedService}" />
						<c:set var="selectedFlag" value="${!empty selectedService}" /> 
						<select	name=locale>
							<c:forEach var="lservice" items="${services}">
								<c:choose>
									<c:when test="${selectedFlag}">
										<c:choose>
											<c:when
												test="${lservice.getName().equals(selectedService.getName())}">
												<option selected>${lservice.getName()}</option>
											</c:when>
											<c:otherwise>
												<option>${lservice.getName()}</option>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<option>${lservice.getName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select><br>
              </td>
            </tr>
            <tr>
              <td>Номер счета:</td>
              <td><input type="text" size="15" name="number"></td>
            </tr>
            <tr>
              <td>Сумма:</td>
              <td><input type="text" size="10" name="money"></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><input type="submit" value="Отправить"></td>
            </tr>
          </table>
        </form:form>
      </div>
      </c:if>
       <c:if test="${payAccount}">
      <div id="money_transfer" class="section">
      <c:set var="error" value="<%= request.getParameter(\"error\") %>" />
      	<c:if test="${!empty error}">
        <font color="red"> <%= request.getParameter("error") %>
		</font>
       </c:if>
        <h3>Перевод денег</h3>
        <form:form method="post" action="/dataart/account/moveBalance/Human" commandName="money">
          <table>
            <tr>
              <td>Номер счета:</td>
              <td><input type="text" size="15" name="account"></td>
            </tr>
            <tr>
              <td>Сумма:</td>
              <td><input type="text" size="10" name="money"></td>
            </tr>
            <tr>
              <td colspan="2" align="center"><input type="submit" value="Отправить"></td>
            </tr>
          </table>
        </form:form>
      </div>
      </c:if>
       <c:if test="${transactions != null}">
      <div id="transactions" class="section">
        <h3>Журнал транзакций</h3>
        <div style="height: 500px; overflow:auto;">
          <table width="100%">
            <thead>
              <td>Дата</td>
              <td>Сумма</td>
              <td>Номер оплаты</td>
              <td>Тип</td>
            </thead>
            <c:forEach items="${transactions}" var="transaction">
   				<tr>
              		<td><c:out value="${transaction.getDate()}"></c:out></td>
              		<td><c:out value="${transaction.getAmount()}"></c:out></td>
              		<td><c:out value="${transaction.getDescription()}"></c:out></td>
              		<td>
              			<c:set var="transactionType" value="${transaction.getTransactionType().getName()}" /> 
						<c:if test="${transactionType.equals('SERVICE_PAYMENT')}">
							Оплата услуги
						</c:if>
						<c:if test="${transactionType.equals('HUMAN_PAYMENT')}">
							Перевод стредств
						</c:if>
						<c:if test="${transactionType.equals('INCREASE_ACCOUNT_PAYMENT')}">
							Поплнение счета
						</c:if>
					</td>
            	</tr>
			</c:forEach>
          </table>
        </div>
      </div>
      </c:if>
       <c:if test="${increaseAccount}">
      <div id="fill_account" class="section">
        <h4>Пополнить счет</h4>
        <form:form method="post" action="/dataart/account/increase" commandName="money">
          <table>
            <tr>
              <td>Код пополнения:</td>
              <td><input type="text" size="15" name="money"></td>
            </tr>
            <tr>
              <td><input type="submit" value="Отправить"></td>
            </tr>
          </table>
        </form:form>
        </div>
      </c:if>
      
       <c:if test="${!empty userList && admin}">
       <div id="logs" class="section">
        <h4>System logs</h4>
      <form:form method="post" action="/dataart/users/transactions" commandName="user1">
          <table>
            <tr>
              <td>Select User:</td>
              <td>
              
            <c:set var="selectedUser" value="${selectedUser}" />
						<c:set var="selectedFlag" value="${!empty selectedUser}" /> 
						<select	name=locale>
							<c:forEach var="user" items="${userList}"  >
								<c:choose>
									<c:when test="${selectedFlag}">
										<c:choose>
											<c:when
												test="${user.getUserName().equals(selectedUser.getUserName())}">
												<option selected>${user.getUserName()}</option>
											</c:when>
											<c:otherwise>
												<option>${user.getUserName()}</option>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<option>${user.getUserName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> 
              <input type="submit" value="Отправить">
              </td>
            </tr>
          </table>
        </form:form>
        <hr>
         <table width="100%">
            <thead>
              <td>Дата</td>
              <td>Сумма</td>
              <td>Номер оплаты</td>
              <td>Тип</td>
            </thead>
            <c:forEach items="${transactionsUsers}" var="transaction">
   				<tr>
              		<td><c:out value="${transaction.getDate()}"></c:out></td>
              		<td><c:out value="${transaction.getAmount()}"></c:out></td>
              		<td><c:out value="${transaction.getDescription()}"></c:out></td>
              		<td>
              			<c:set var="transactionType" value="${transaction.getTransactionType().getName()}" /> 
						<c:if test="${transactionType.equals('SERVICE_PAYMENT')}">
							Оплата услуги
						</c:if>
						<c:if test="${transactionType.equals('HUMAN_PAYMENT')}">
							Перевод стредств
						</c:if>
						<c:if test="${transactionType.equals('INCREASE_ACCOUNT_PAYMENT')}">
							Поплнение счета
						</c:if>
					</td>
            	</tr>
			</c:forEach>
          </table>
      </div>
      </c:if>
      
    </div>
  </body>
</html>
