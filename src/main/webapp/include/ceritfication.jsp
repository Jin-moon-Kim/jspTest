<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!-- ceritfication.jsp -->

<%
	String login = session.getAttribute("sLogin")==null ? "" : (String)session.getAttribute("sLogin");
	if(login.equals("")) {
		out.print("<script>");
		out.print("alert('login plz');");
		out.println("location.href='"+request.getContextPath()+"/Login?loginSw=main_Login'");
		out.print("</script>");
	};
%>