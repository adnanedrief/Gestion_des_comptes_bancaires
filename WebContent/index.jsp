<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
		<form action="Login" method="post">
			<table class="table table-striped" style="margin: 0 auto;width:30%;margin-top:3%;">
				<tr>
					<td colspan="2"><center>Identification</center></td>
				</tr>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" class="form-control" ></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pwd" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" value="login" class="btn btn-primary">
							<input type="reset" value="cancel"  class="btn btn-danger">
						</center>	
					</td>
				</tr>
			</table>
		</form>
</body>
</html>