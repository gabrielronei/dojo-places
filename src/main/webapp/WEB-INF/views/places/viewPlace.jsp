<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>

    <h1>Places</h1>
    <table style="width: 60%">
        <tr>
            <th>Nome</th>
            <th>Cidade</th>
            <th>Bairro</th>
            <th>Código</th>
            <th>Data decriação</th>
            <th>data de atualização</th>
            <th>Editar</th>
            <th>Deletar</th>
        </tr>
        <c:forEach items="${places}" var="place">
            <tr>
                <td>${place.name}</td>
                <td>${place.city}</td>
                <td>${place.district}</td>
                <td>${place.code}</td>
                <td>${place.createdAt}</td>
                <td>${place.updatedAt}</td>
                <td><a>Editar</a></td>
                <td><a>Deletar</a></td>
            </tr>
        </c:forEach>
    </table>
    <h4><a href="/local/places/new">Novo local</a></h4>


</body>
</html>