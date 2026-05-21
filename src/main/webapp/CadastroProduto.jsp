<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Produto</title>
<style>
    /* Um estilo CSS simples para organizar o formulário no ecrã */
    
    body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
    
    .container { max-width: 400px; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
    
    .form-group { margin-bottom: 15px; }
    
    label { display: block; margin-bottom: 5px; font-weight: bold; }
    
    input[type="text"], input[type="number"], textarea { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
    
    button { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
    
    button:hover { background-color: #218838; }
</style>
</head>
<body>

<div class="container">
    <h2>Registo de Produto</h2>
    
    <form name="frm" action="ProdutoController?op=1" method="POST">
    
        <div class="form-group">
            <label for="nome">Nome do Produto:</label>
            <input type="text" id="nome" name="nome" required placeholder="Ex: Caderno Universitário">
        </div>
        
        <div class="form-group">
            <label for="valoruni">Valor Unitário (R$):</label>
            <input type="number" id="valoruni" name="valoruni" step="0.01" min="0" required placeholder="0.00">
        </div>
        
        <div class="form-group">
            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao" rows="4" placeholder="Digite uma breve descrição do produto..."></textarea>
        </div>
        
        <button type="submit">Gravar Produto</button>
        
    </form>
</div>

</body>
</html>