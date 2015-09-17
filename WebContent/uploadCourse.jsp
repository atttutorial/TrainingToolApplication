<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.inputform {
	float: left;
	margin-left: 0%;
	margin-top: -.5%;
	width: 500px;
	border: 1px solid #0066CC;
	border-radius: 10px;
	padding: 10px;
}

.inputform table tr td input,textarea,select {
	width: 200px;
}

#register {
	margin-left: 100px;
	width: 100px;
	margin-top: 10%;
}

#login {
	margin-left: 100px;
	width: 100px;
	margin-top: 10%;
}

.design {
	background-color: #0066CC;
	color: white;
	padding-left: 38%;
}

#password {
	width: 120%;
	margin-top: 10%
}

#email {
	width: 120%;
	margin-top: 10%
}
</style>
<body>

	<div class="inputform" style="float: left;">
		<h2 class="design">Upload Course</h2>
		<form action="InsertCourseDetails" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td >Course Name:</td>
					<td><input type="text" id="email" name="cname"
						value="<c:out value="${user.userid}" />" />
					</td>
				</tr>
				<tr>
					<td>Course Min Duration:</td>
					<td><input id="password" type="text" name="cminDuration"
						value="<c:out value="${user.userid}" />" />
					</td>
				</tr>
				<tr>
					<td>Course Max Duration:</td>
					<td><input id="password" type="text" name="cmaxDuration"
						value="<c:out value="${user.userid}" />" />
					</td>
				</tr>
				<tr>
					<td>Course Author:</td>
					<td><input id="password" type="text" name="cauthor"
						value="<c:out value="${user.userid}" />" />
					</td>
				</tr>
				<tr>
					<td>User Role :</td>
					<td ><select name="userRole" style ="width :123%;">
							<option>Test Analyst</option>
							<option>Manager</option>
							<option>Team Lead</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>File:</td>
					<td><input id="password" type="file" name="file" />
					</td>
				</tr>
				<tr>
					<td><input id="login" type="submit" value="Submit" />
					</td>
					<td><input id="register" type="reset" value="Reset" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
