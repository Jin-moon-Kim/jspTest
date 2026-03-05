<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>exam03_Login.jsp</title>
	<%@ include file="/include/bs5.jsp" %>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br/></p>
<div class="container">
	<form name="myform" method="post" action="<%=request.getContextPath()%>/login_cookie/Exam03_StoreCookie">
		<table class="table table-bordered text-center">
			<tr>
				<td colspan="2">Welcome Admin</td>			
			</tr>			
			<tr>
				<th>id</th>
				<td><input type="text" name="mid" id="mid" value="admin" autofocus required class="form-control" disabled /></td>			
			</tr>			
			<tr>
				<th>password</th>
				<td><input type="password" name="pwd" id="pwd" value="1234" required class="form-control" /></td>			
			</tr>						
			<tr>
				<td colspan="2">					 
					<button type="button" onclick="location.href='<%=request.getContextPath()%>/'" class="btn btn-info btn-sm me-2">back</button>
				</td>
			</tr>		
		</table>		
	</form>
</div>
	<jsp:include page="/include/footer.jsp" />
</body>
</html>