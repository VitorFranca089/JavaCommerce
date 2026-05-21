package javacommerce.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javacommerce.VO.Usuario;
import javacommerce.conexao.Conexao;

public class UsuarioDAO {
	
	private final Conexao conexao;

	public UsuarioDAO() {
		conexao = new Conexao();
	}
	
	public boolean inserir(Usuario u) {

        try {

            PreparedStatement ps;

            String sql =
                "insert into usuario " +
                "(nome,senha,cpf,endereco) " +
                "values (?,?,?,?)";

            ps =
                conexao.conectar().prepareStatement(sql);

            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getEndereco());

            return ps.executeUpdate() != 0;

        } catch (SQLException erro) {

            System.out.println(
                "Exceção causada na inserção"
            );

            System.err.println(
                "Mensagem: " + erro.getMessage()
            );

            return false;

        } finally {

            conexao.desconectar();
        }
    }

    // =========================================
    // LISTAR USUÁRIOS
    // =========================================

    public ArrayList<Usuario> listar() {

        ArrayList<Usuario> lista =
            new ArrayList<>();

        try {

            String sql =
                "SELECT * FROM usuario";

            PreparedStatement ps =
                conexao.conectar().prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                Usuario u =
                    new Usuario();

                u.setId(
                    rs.getInt("id")
                );

                u.setNome(
                    rs.getString("nome")
                );

                u.setSenha(
                    rs.getString("senha")
                );

                u.setCpf(
                    rs.getString("cpf")
                );

                u.setEndereco(
                    rs.getString("endereco")
                );

                lista.add(u);
            }

        } catch (SQLException erro) {

            System.out.println(
                "Erro ao listar usuários"
            );

            System.err.println(
                "Mensagem: " + erro.getMessage()
            );

        } finally {

            conexao.desconectar();
        }

        return lista;
    }


}
