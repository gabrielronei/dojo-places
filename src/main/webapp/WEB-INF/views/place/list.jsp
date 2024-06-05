<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Locais</h1>

<a href="/local/novo">Novo local</a>

<br>
<br>

<c:choose>
    <c:when test="${empty places}">
        <p>Sem locais cadastrados</p>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Código</th>
                <th>Data criação</th>
                <th>Dias desde a última atualização</th>
                <th colspan="2">Ações</th>
            </tr>
            <c:forEach items="${places}" var="place">
                <tr>
                    <td>${place.id}</td>
                    <td>${place.name}</td>
                    <td>${place.code}</td>
                    <td>${place.createdAtFormatted}</td>
                    <td>${place.daysSinceLastUpdate}</td>
                    <td><a href="/local/editar/${place.id}">Editar</a></td>
                    <td><a href="/local/remover/${place.id}">Remover</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
