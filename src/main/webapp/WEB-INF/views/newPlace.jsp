<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
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

        <label for="district">Bairro:</label>
        <input type="text" name="district" id="district" />

        <label for="city">Cidade:</label>
        <input type="text" name="city" id="city" />

        <label for="code">Code:</label>
        <input type="text" name="code" id="code" />

        <button type="submit">Salvar</button>

    </form>
</body>
</html>