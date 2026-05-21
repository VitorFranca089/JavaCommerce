<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="javacommerce.VO.Pedido"%>
<%@page import="javacommerce.VO.ItemPedido"%>
<%@page import="java.util.ArrayList"%>

<%
    Pedido pedido =
        (Pedido) request.getAttribute("pedido");

    double totalGeral = 0;
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Pedido Criado</title>

<style>

    body {
        font-family: Arial, sans-serif;
        margin: 40px;
        background-color: #f4f4f9;
    }

    .container {

        max-width: 800px;
        margin: auto;

        background: white;
        padding: 25px;

        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }

    table {

        width: 100%;
        border-collapse: collapse;

        margin-top: 20px;
    }

    th, td {

        border: 1px solid #ddd;
        padding: 10px;

        text-align: center;
    }

    th {
        background-color: #007bff;
        color: white;
    }

    .total {

        font-weight: bold;
        background-color: #f1f1f1;
    }

    .success {
        color: #28a745;
        font-size: 18px;
        font-weight: bold;
    }

    a {

        display: inline-block;
        margin-top: 20px;

        padding: 10px 15px;

        background-color: #007bff;
        color: white;

        text-decoration: none;
        border-radius: 5px;
    }

    a:hover {
        background-color: #0069d9;
    }

</style>

</head>

<body>

<div class="container">

    <h2>Pedido Criado</h2>

    <div class="success">
        Pedido registrado com sucesso!
    </div>

    <table>

        <thead>

            <tr>
                <th>ID Produto</th>
                <th>Nome Produto</th>
                <th>Quantidade</th>
                <th>Total</th>
            </tr>

        </thead>

        <tbody>

        <%
            for(ItemPedido item : pedido.getItensPedido()) {

                double totalItem =
                    item.getProduto().getValorUnitario()
                    * item.getQuantidade();

                totalGeral += totalItem;
        %>

            <tr>

                <td><%= item.getProduto().getId() %></td>

                <td><%= item.getProduto().getNome() %></td>

                <td><%= item.getQuantidade() %></td>

                <td>R$ <%= String.format("%.2f", totalItem) %></td>

            </tr>

        <%
            }
        %>

        <tr class="total">

            <td colspan="3">Total a Pagar</td>

            <td>R$ <%= String.format("%.2f", totalGeral) %></td>

        </tr>

        </tbody>

    </table>

    <a href="PedidoController?op=1">
        Criar novo pedido
    </a>

</div>

</body>

</html>