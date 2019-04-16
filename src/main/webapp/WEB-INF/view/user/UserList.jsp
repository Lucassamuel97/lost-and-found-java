<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Achados e Perdidos</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="user" items="${listUsers}">
                <tr>
                    <td><c:out value="${user.getId()}" /></td>
                    <td><c:out value="${user.getLogin()}" /></td>
                    <td><c:out value="${user.getTelefone()}" /></td>
                    <td><c:out value="${user.getEmail()}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${user.getId()}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${user.getId()}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>	
</body>
</html>
