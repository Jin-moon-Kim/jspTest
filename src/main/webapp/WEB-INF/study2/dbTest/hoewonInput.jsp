<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>.jsp</title>
  <%@ include file="/include/bs5.jsp" %>
</head>
<style>
	th {
		text-align: center;
		background-color: #eee !important;
	}
</style>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br/></p>
<div class="container">
  <h2 class="text-center mb-3">회원등록</h2>
  
  <form name="myform" method="post" action="HoewonInputOk.db">
	  <table class="table table-bordered">
	    <tr>
	      <th>이름</th>
	      <td><input type="text" name="name" id="name" placeholder="enter the name" class="form-control" autofocus required /></td>
	    </tr>
	    <tr>
	      <th>나이</th>
	      <td><input type="number" name="age" id="age" placeholder="enter the age" class="form-control" required /></td>
	    </tr>
	    <tr>
	    <tr>
	      <th>성별</th>
	      <td>
	      	<input type="radio" name="gender" value="남자" /> 남자 &nbsp;
	      	<input type="radio" name="gender" value="여자" checked /> 여자
	      </td>
	    </tr>
	    <tr>
	      <th>주소</th>
	      <td><input type="text" name="address" id="addresss" placeholder="enter the address" class="form-control" /></td>
	    </tr>
	    <tr>
	      <td colspan="2" class="text-center">
	        <input type="button" value="가입하기" onclick="fCheck()" class="btn btn-success"/>
	        <input type="reset" value="다시입력" class="btn btn-warning"/>
  				<a href="DbTest.db" class="btn btn-info">back</a>
	      </td>
	    </tr>
	  </table>
  </form>
  <hr/>
</div>
<p><br/></p>
<jsp:include page="/include/footer.jsp" />

<script>
  'use strict';
  
  function fCheck() {
  	let name = document.getElementById("name");
  	let age = document.getElementById("age");
  	//let gender = document.myform.gender.value;
  	//let address = document.getElementById("address").value;
  	
  	if(name.value.trim() == "") {
  		alert("enter the name");
  		name.focus();
  		return false;
  	}
  	else if(age.value.trim() == "") {
  		alert("enter the age");
  		age.focus();
  		return false;
  	}
  	else {
  		document.myform.submit();
  	}
  }
</script>
</body>
</html>