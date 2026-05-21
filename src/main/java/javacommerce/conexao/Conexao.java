package javacommerce.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
    private final String bd;
    private final String usuario;
    private final String senha;
    private Connection connection;

    public Conexao(){
        bd = "jdbc:mysql://localhost/javacommerce";
        usuario = "root";
        senha = "";
        connection = null;
    }    

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(bd,usuario, senha);
            return connection;
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println(erro);
            return null;
        }
    }

    public void desconectar(){
         try {
            connection.close();
         }catch (SQLException erro) {
            System.out.println(erro);
        }
    }
 
}