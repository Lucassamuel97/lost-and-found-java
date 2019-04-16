<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Formulario cadastro</h1>
	<div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${user != null}">
            			Editar Usuario
            		</c:if>
					<c:if test="${user == null}">
            			Adicionar usuario
            		</c:if>
				</h2>
			</caption>
			<c:if test="${user != null}">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			</c:if>
			<tr>
				<th>Login:</th>
				<td><input type="text" name="login" size="45"
					value="<c:out value='${user.login}' />" />
				</td>
			</tr>
			<tr>
				<th>Senha:</th>
				<td><input type="text" name="senha" size="45" />
				</td>
			</tr>
			<tr>
				<th>Telefone:</th>
				<td><input type="text" name="telefone" size="5"
					value="<c:out value='${user.getTelefone()}' />" />
				</td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="email" size="5"
					value="<c:out value='${user.getEmail()}' />" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>