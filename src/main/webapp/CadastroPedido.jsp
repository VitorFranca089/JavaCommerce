<%@page import="java.util.ArrayList"%>
<%@page import="javacommerce.VO.Produto"%>
<%@page import="javacommerce.VO.Usuario"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    ArrayList<Produto> listaProdutos =
        (ArrayList<Produto>) request.getAttribute("listaProdutos");

    ArrayList<Usuario> listaUsuarios =
        (ArrayList<Usuario>) request.getAttribute("listaUsuarios");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Registro de Pedido</title>

<style>

    body {
        font-family: Arial, sans-serif;
        margin: 40px;
        background-color: #f4f4f9;
    }

    .container {
        max-width: 700px;
        background: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="number"],
    select {

        width: 100%;
        padding: 8px;
        box-sizing: border-box;

        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .item-pedido {

        border: 1px solid #ddd;
        padding: 15px;

        border-radius: 6px;
        margin-bottom: 15px;

        background-color: #fafafa;
    }

    .btn-add {

        width: 100%;
        padding: 10px;

        margin-bottom: 15px;

        background-color: #007bff;
        color: white;

        border: none;
        border-radius: 4px;

        cursor: pointer;
        font-size: 16px;
    }

    .btn-add:hover {
        background-color: #0069d9;
    }

    .btn-submit {

        width: 100%;
        padding: 10px;

        background-color: #28a745;
        color: white;

        border: none;
        border-radius: 4px;

        cursor: pointer;
        font-size: 16px;
    }

    .btn-submit:hover {
        background-color: #218838;
    }

    .btn-remove {

        width: 100%;
        padding: 10px;

        background-color: #dc3545;
        color: white;

        border: none;
        border-radius: 4px;

        cursor: pointer;
        margin-top: 10px;
    }

    .btn-remove:hover {
        background-color: #c82333;
    }

</style>

<script>

    function adicionarItem() {

        const container =
            document.getElementById("itens-container");

        const div =
            document.createElement("div");

        div.className = "item-pedido";

        div.innerHTML = `
        
            <div class="form-group">

                <label>Produto:</label>

                <select name="produtoId" required>

                    <option value="">
                        Selecione um produto
                    </option>

                    <% for(Produto p : listaProdutos){ %>

                        <option value="<%= p.getId() %>">

                            <%= p.getId() %> -
                            <%= p.getNome() %>

                        </option>

                    <% } %>

                </select>

            </div>

            <div class="form-group">

                <label>Quantidade:</label>

                <input
                    type="number"
                    name="quantidade"
                    min="1"
                    required
                >

            </div>

            <button
                type="button"
                class="btn-remove"
                onclick="removerItem(this)"
            >
                Remover Item
            </button>
        
        `;

        container.appendChild(div);
    }

    function removerItem(botao) {

        botao.parentElement.remove();
    }

</script>

</head>

<body>

<div class="container">

    <h2>Registro de Pedido</h2>

    <form
        name="frm"
        action="PedidoController?op=1"
        method="POST"
    >

        <!-- USUÁRIO -->

        <div class="form-group">

            <label for="usuarioId">
                Usuário:
            </label>

            <select
                id="usuarioId"
                name="usuarioId"
                required
            >

                <option value="">
                    Selecione um usuário
                </option>

                <% for(Usuario u : listaUsuarios){ %>

                    <option value="<%= u.getId() %>">

                        <%= u.getId() %> -
                        <%= u.getNome() %>

                    </option>

                <% } %>

            </select>

        </div>

        <!-- ITENS -->

        <h3>Itens do Pedido</h3>

        <div id="itens-container">

            <div class="item-pedido">

                <div class="form-group">

                    <label>Produto:</label>

                    <select
                        name="produtoId"
                        required
                    >

                        <option value="">
                            Selecione um produto
                        </option>

                        <% for(Produto p : listaProdutos){ %>

                            <option value="<%= p.getId() %>">

                                <%= p.getId() %> -
                                <%= p.getNome() %>

                            </option>

                        <% } %>

                    </select>

                </div>

                <div class="form-group">

                    <label>Quantidade:</label>

                    <input
                        type="number"
                        name="quantidade"
                        min="1"
                        required
                    >

                </div>

            </div>

        </div>

        <button
            type="button"
            class="btn-add"
            onclick="adicionarItem()"
        >
            + Adicionar Item
        </button>

        <button
            type="submit"
            class="btn-submit"
        >
            Gravar Pedido
        </button>

    </form>

</div>

</body>
</html>