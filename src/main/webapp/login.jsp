
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Language" content="ru">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="http://fonts.googleapis.com/css?family=family=Open+Sans:400,700,300|Comfortaa&amp;subset=all" rel="stylesheet" type="text/css">
    <style type="text/css">
      html {font-size: 95%;}
      @media all and (min-resolution: 120dpi) {html, x:-moz-any-link {font-size: 68.75%;}}
      body,html {margin: 0px; padding: 0px; font-family: open sans, sans}
      #logo {margin: 30px 15px;}
      #menu {position: relative; float: left; top: 0px; left 0px; width: auto; height: 100%; background-color: #ececec;}
      .button {margin: 30px 15px; width: 100%;}
      .button:hover{opacity: 0.8;}
      .button img {height: 35px;}
      .button A { display: block; width: 100%; height: 100%; color: black; text-decoration: none;}
      #login_container {width: 250px; height: 250px; position: absolute; top: 50%; margin-top: -175px; left: 50%; margin-left: -175px; padding: 15px;}
      #login_container form { background-color: lightgrey; text-align: center; color: grey;}
      #login_container input { border: none; outline: none; height: 2em; text-align: center; margin: 5px;}
      #container {position: relative; float: left; left: 20px; top: 50px; padding: 30px; min-width: 50%;}
      .section {display: none; position: absolute; top: 0px; left: 0px; background-color: #ececec; padding: 30px;}
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
    <title><spring:message code="label.appTitle" /></title>
  </head>
  <body>
    <div id="login_container">
     <img src="<%= request.getContextPath() %>/images/logo_big.png"><br><br>
    <c:if test="${not empty param.error}">
		<font color="red"> <spring:message code="label.loginError" />
			Неправильно введен логин или пароль
		</font>
	</c:if>
      <form action="<c:url value="/j_spring_security_check" />" method="POST">
        <spring:message code="label.login" /><br>
        <input type="text" name="j_username">
        <br>
        <spring:message code="label.password" /><br>
        <input type="password" name="j_password"><br>
        <input type="submit" value="Login">
        <input type="reset" value="Reset" />
        <br><br>
      </form>
    </div>
  </body>
</html>