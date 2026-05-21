<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produto criado</title>
</head>
<body>
	
	<center>
        <h1>

            <%
                boolean resultado = Boolean.parseBoolean(request.getParameter("result"));

                if (resultado) {
                    out.print("Sucesso ao inserir");
                } else {
                    out.print("Erro ao inserir");
                }

            %>

        </h1>


        <br><br><br>
        <a href="index.html">Página inicial</a>
    </center>
	
</body>
</html>