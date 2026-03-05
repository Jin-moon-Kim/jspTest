<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>dbTest.jsp</title>
  <%@ include file="/include/bs5.jsp" %>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br/></p>
<div class="container">
	<h2>DB</h2>
  <hr/>
  <div class="row">
  	<div class="col"><a href="HoewonList.db" class="btn btn-success">member list</a></div>
  	<div class="col"><a href="HoewonInput.db" class="btn btn-primary">member Input</a></div>
  	<div class="col"><a href="javascript:nameSearch('u')" class="btn btn-warning">member Update</a></div>
  	<div class="col"><a href="javascript:nameSearch('d')" class="btn btn-danger">member Delete</a></div>
  	<div class="col"><a href="javascript:nameSearch('s')" class="btn btn-info">member search</a></div>
  </div>
  <hr/>
  <div id="demo" class="text-center"></div>
</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp" />
</body>
<script>
	'use strict';
	
	function nameSearch(flag){
		let str = '<div class="input-group">';
		str += '<div class="input-group-text">이름</div>';
		str += '<input type="text" name="name" id="name" placeholder="검색할 이름 입력" class="form-control">';
		str += '<input type="button" value="search" onclick="searchName(\''+flag+'\')" class="btn btn-info">';
		str += '</div>';
		demo.innerHTML = str;
	}
	
	function searchName(flag) {
		let name = document.getElementById("name").value;
		if(flag == 'u')	location.href = "HoewonUpdate.db?name="+name;
		else if(flag == 'd')	location.href = "HoewonDelete.db?name="+name;
    else if(flag == 's') location.href = "HoewonSearch.db?name="+name;
	}
</script>
</html>