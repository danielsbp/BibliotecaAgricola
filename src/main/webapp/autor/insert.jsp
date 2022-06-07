<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--Define todas as linhas de código a seguir como HTML5-->
<!DOCTYPE html>
<!--Define a linguagem da página e começa o HTML-->
<html lang="pt-br">
    
    <head>
        <!-- Define o codec de caracteres a ser utilizado como utf-8 -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Novo Autor</title>
        <!-- Importação do css do bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body>
        <!-- Define o conteúdo principal da página -->
        <main class="container">
            <h1>Novo Autor</h1>
            <hr />
            <!-- Define o formulário com o action "insert", o que significa que ao clicar num botão submit, os dados serão passados com HTTP como POST para a rota /insert-->
            <form action="insert" method="post">
                <!-- Nas próximas linhas é criado o campo "nome".-->
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" class="form-control" />
                </div>
                <hr />
                <!-- Botão que redireciona o usuário para a rota list-->
                <a href="/autor/list" class="btn btn-primary">Voltar</a>
                <!-- Botão do tipo submit que ao clicado, envia os dados no método POST para a rota definida em "action" no formulário-->
                <input type="submit" value="Salvar" class="btn btn-success" />
            </form>
        </main>
        <!-- Iportação do popper e do bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    </body>
</html>