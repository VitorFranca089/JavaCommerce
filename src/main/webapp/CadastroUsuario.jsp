<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Usuario</title>
<style>
    /* Um estilo CSS simples para organizar o formulário no ecrã */
    
    body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
    
    .container { max-width: 400px; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
    
    .form-group { margin-bottom: 15px; }
    
    label { display: block; margin-bottom: 5px; font-weight: bold; }
    
    input[type="text"], input[type="number"], input[type="password"], textarea { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
    
    button { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
    
    button:hover { background-color: #218838; }
</style>
</head>
<body>

<div class="container">
    <h2>Registo de Usuário</h2>
    
    <form name="frm" action="UsuarioController?op=1" method="POST">
    
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>
        </div>
        
        <div class="form-group">
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha">
        </div>
        
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="number" id="cpf" name="cpf" required>
        </div>
        
        <div class="form-group">
            <label for="nome">Endereço:</label>
            <input type="text" id="endereco" name="endereco" required>
        </div>
        
        <button type="submit">Salvar Usuário</button>
        
    </form>
</div>

</body>
</html>