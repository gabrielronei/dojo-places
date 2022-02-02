<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Locais</h1>

<table>
    <tr>
        <th>Nome</th>
        <th>Código</th>
        <th>Bairro</th>
        <th>Cidade</th>
    </tr>
    <c:forEach items="${places}" var="place">
        <tr>
            <td>${place.name}</td>
            <td>${place.code}</td>
            <td>${place.neighborhood}</td>
            <td>${place.city}</td>
        </tr>
    </c:forEach>
</table>
