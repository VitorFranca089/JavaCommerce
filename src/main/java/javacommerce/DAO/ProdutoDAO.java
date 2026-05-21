package javacommerce.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javacommerce.VO.Produto;
import javacommerce.conexao.Conexao;

public class ProdutoDAO {
	
	private final Conexao conexao;

	public ProdutoDAO() {
		conexao = new Conexao();
	}
	
	public boolean inserir(Produto p) {
        try {
            PreparedStatement ps;
            String sql = "insert into produto (nome,valor_unitario,descricao) values (?,?,?)";
            ps = conexao.conectar().prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getValorUnitario());
            ps.setString(3, p.getDescricao());
            return ps.executeUpdate() != 0;
        } catch (SQLException erro) {
            System.out.println("Exceção causada na inserção");
            return false;
        } finally {
            conexao.desconectar();
        }
    }
	
	// NOVO MÉTODO
    public ArrayList<Produto> listar() {

        ArrayList<Produto> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM produto";

            PreparedStatement ps =
                conexao.conectar().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValorUnitario(rs.getDouble("valor_unitario"));
                p.setDescricao(rs.getString("descricao"));

                lista.add(p);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar produtos");

        } finally {

            conexao.desconectar();
        }

        return lista;
    }

    public Produto buscarPorId(int id) {

        Produto p = null;

        try {

            String sql =
                "SELECT * FROM produto WHERE id = ?";

            PreparedStatement ps =
                conexao.conectar().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValorUnitario(rs.getDouble("valor_unitario"));
                p.setDescricao(rs.getString("descricao"));
            }

        } catch (Exception e) {

            System.out.println("Erro ao buscar produto");

        } finally {

            conexao.desconectar();
        }

        return p;
    }
    
}
