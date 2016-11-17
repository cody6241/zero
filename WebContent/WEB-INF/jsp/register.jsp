<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getServletContext().getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<form>
	<table>
		<tbody>
		<tr><td>姓名：</td><td><input type="text" name="userName"/></td></tr>
		<tr><td>密码：</td><td><input type="password"/></td></tr>
		<tr><td>密码：</td><td><input type="password" name="password"/></td></tr>
		<tr><td><input type="button" value="提交" id="doRegister"></td></tr>
		</tbody>
	</table>
</form>
</body>
<script src="<%=ctx %>/js/jquery-1.10.2.min.js"></script>
<script src="<%=ctx %>/js/jquery.form-3.51.js"></script>
<script>
$("#doRegister").click(function(){
	var options={
		url:"<%=ctx %>/doRegister.html",
		success:function(data){
			if(data == "success"){
				alert("恭喜注册成功，请到登录页面登录");
				window.location.href="<%=ctx%>/login.html";
			}
		}
	};
	$("form").ajaxSubmit(options);
});
</script>
</html>