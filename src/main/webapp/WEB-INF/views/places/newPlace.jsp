<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cadastro de lugares</title>
</head>
<body>
    <h1>Cadastro de Lugares</h1>

    <form action="/local/places" method="post" >
        <label for="name">Nome:</label>
        <input type="text" name="name" id="name" />
        <form:errors path="newPlaceForm.name" cssClass="color: red" />
        <br>
        <label for="district">Bairro:</label>
        <input type="text" name="district" id="district" />
        <form:errors path="newPlaceForm.district" cssClass="color: red" />
        <br>
        <label for="city">Cidade:</label>
        <input type="text" name="city" id="city" />
        <form:errors path="newPlaceForm.city" cssClass="color: red" />
        <br>
        <label for="code">Code:</label>
        <input type="text" name="code" id="code" />
        <form:errors path="newPlaceForm.code" cssClass="color: red" />
        <br>
        <button type="submit">Salvar</button>
    </form>
</body>
</html>