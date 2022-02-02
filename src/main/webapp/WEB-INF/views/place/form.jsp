<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Cadastrar local</h1>

<form:form modelAttribute="newPlaceDTO" method="post" action="/local/novo">

    <label for="name">Nome:</label>
    <form:input path="name" required="true" maxlength="100" />
    <form:errors path="name" cssStyle="color: red"/>

    <br/>
    <br/>

    <label for="code">Código:</label>
    <form:input path="code" required="true" />
    <form:errors path="code" cssStyle="color: red"/>

    <br/>
    <br/>

    <label for="neighborhood">Bairro:</label>
    <form:input path="neighborhood" required="true" maxlength="100" />
    <form:errors path="neighborhood" cssStyle="color: red"/>

    <br/>
    <br/>

    <label for="city">Cidade:</label>
    <form:input path="city" required="true" maxlength="100" />
    <form:errors path="city" cssStyle="color: red"/>

    <br/>
    <br/>

    <form:button value="Cadastrar">Cadastrar</form:button>

</form:form>
