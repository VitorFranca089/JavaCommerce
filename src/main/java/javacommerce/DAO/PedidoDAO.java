package javacommerce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javacommerce.VO.ItemPedido;
import javacommerce.VO.Pedido;
import javacommerce.VO.Produto;
import javacommerce.VO.Usuario;
import javacommerce.conexao.Conexao;

public class PedidoDAO {
	
	private final Conexao conexao;

    public PedidoDAO() {
        conexao = new Conexao();
    }

    public boolean inserir(Pedido pedido) {

        Connection conn = null;

        try {

            conn = conexao.conectar();

            // =====================================
            // INICIAR TRANSAÇÃO
            // =====================================

            conn.setAutoCommit(false);

            // =====================================
            // INSERIR PEDIDO
            // =====================================

            String sqlPedido =
                "INSERT INTO pedido (usuario_id) VALUES (?)";

            PreparedStatement psPedido =
                conn.prepareStatement(
                    sqlPedido,
                    PreparedStatement.RETURN_GENERATED_KEYS
                );

            psPedido.setInt(
                1,
                pedido.getUsuario().getId()
            );

            int resultadoPedido =
                psPedido.executeUpdate();

            if (resultadoPedido == 0) {

                conn.rollback();
                return false;
            }

            // =====================================
            // PEGAR ID GERADO DO PEDIDO
            // =====================================

            ResultSet rs =
                psPedido.getGeneratedKeys();

            Integer pedidoId = null;

            if (rs.next()) {

                pedidoId = rs.getInt(1);
            }

            if (pedidoId == null) {

                conn.rollback();
                return false;
            }

            // =====================================
            // INSERIR ITENS
            // =====================================

            String sqlItem =
                "INSERT INTO item_pedido " +
                "(pedido_id, produto_id, quantidade) " +
                "VALUES (?, ?, ?)";

            PreparedStatement psItem =
                conn.prepareStatement(sqlItem);

            for (ItemPedido item : pedido.getItensPedido()) {

                psItem.setInt(1, pedidoId);

                psItem.setInt(
                    2,
                    item.getProduto().getId()
                );

                psItem.setInt(
                    3,
                    item.getQuantidade()
                );

                psItem.executeUpdate();
            }

            // =====================================
            // CONFIRMAR TRANSAÇÃO
            // =====================================

            conn.commit();

            return true;

        } catch (SQLException e) {

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (SQLException ex) {

                ex.printStackTrace();
            }

            System.out.println(
                "Erro ao inserir pedido"
            );

            return false;

        } finally {

            try {

                if (conn != null) {

                    conn.setAutoCommit(true);
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }

            conexao.desconectar();
        }
    }
    
 // ==================================================
    // LISTAR PEDIDOS
    // ==================================================

    public ArrayList<Pedido> listar() {

        ArrayList<Pedido> lista =
            new ArrayList<>();

        try {

            String sql =
                "SELECT p.id AS pedido_id, " +
                "u.id AS usuario_id, " +
                "u.nome AS usuario_nome " +
                "FROM pedido p " +
                "INNER JOIN usuario u " +
                "ON p.usuario_id = u.id";

            PreparedStatement ps =
                conexao.conectar().prepareStatement(sql);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                Pedido pedido =
                    new Pedido();

                Usuario usuario =
                    new Usuario();

                usuario.setId(
                    rs.getInt("usuario_id")
                );

                usuario.setNome(
                    rs.getString("usuario_nome")
                );

                pedido.setId(
                    rs.getInt("pedido_id")
                );

                pedido.setUsuario(usuario);

                // =================================
                // CARREGAR ITENS DO PEDIDO
                // =================================

                pedido.setItensPedido(
                    listarItensPedido(
                        pedido.getId()
                    )
                );

                lista.add(pedido);
            }

        } catch (SQLException e) {

            System.out.println(
                "Erro ao listar pedidos"
            );

        } finally {

            conexao.desconectar();
        }

        return lista;
    }

    // ==================================================
    // LISTAR ITENS DE UM PEDIDO
    // ==================================================

    private ArrayList<ItemPedido> listarItensPedido(
        Integer pedidoId
    ) {

        ArrayList<ItemPedido> itens =
            new ArrayList<>();

        try {

            String sql =
                "SELECT ip.id, " +
                "ip.quantidade, " +
                "p.id AS produto_id, " +
                "p.nome " +
                "FROM item_pedido ip " +
                "INNER JOIN produto p " +
                "ON ip.produto_id = p.id " +
                "WHERE ip.pedido_id = ?";

            PreparedStatement ps =
                conexao.conectar().prepareStatement(sql);

            ps.setInt(1, pedidoId);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                Produto produto =
                    new Produto();

                produto.setId(
                    rs.getInt("produto_id")
                );

                produto.setNome(
                    rs.getString("nome")
                );

                ItemPedido item =
                    new ItemPedido();

                item.setId(
                    rs.getInt("id")
                );

                item.setQuantidade(
                    rs.getInt("quantidade")
                );

                item.setProduto(produto);

                itens.add(item);
            }

        } catch (SQLException e) {

            System.out.println(
                "Erro ao listar itens do pedido"
            );
        }

        return itens;
    }

}
