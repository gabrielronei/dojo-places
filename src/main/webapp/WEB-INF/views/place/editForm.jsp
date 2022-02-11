<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Editar local</h1>

<form:form modelAttribute="editPlaceForm" method="post" action="/local/editar">
    <form:hidden path="id" />

    <label for="name">Nome:</label><br/>
    <form:input path="name" maxlength="100" />
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <br/>

    <label for="code">Código:</label><br/>
    <form:input path="code" required="true" />
    <form:errors path="code" cssStyle="color: red"/>

    <br/>
    <br/>

    <label for="neighborhood">Bairro:</label><br/>
    <form:input path="neighborhood" required="true" maxlength="100" />
    <form:errors path="neighborhood" cssStyle="color: red"/>

    <br/>
    <br/>

    <label for="city">Cidade:</label><br/>
    <form:input path="city" required="true" maxlength="100" />
    <form:errors path="city" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button value="Editar">Editar</form:button>

</form:form>
