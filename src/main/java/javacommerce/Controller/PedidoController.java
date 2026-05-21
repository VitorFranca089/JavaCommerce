package javacommerce.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javacommerce.DAO.PedidoDAO;
import javacommerce.DAO.ProdutoDAO;
import javacommerce.DAO.UsuarioDAO;
import javacommerce.VO.ItemPedido;
import javacommerce.VO.Pedido;
import javacommerce.VO.Produto;
import javacommerce.VO.Usuario;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class PedidoController
 */
@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PedidoController() {
        super();
    }

    /**
     * Carrega páginas e listas
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int operacao =
            Integer.parseInt(request.getParameter("op"));

        switch (operacao) {

            // ABRIR FORMULÁRIO DE PEDIDO
	        case 1 -> {
	
	            ProdutoDAO produtoDAO = new ProdutoDAO();
	            UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	            request.setAttribute(
	                "listaProdutos",
	                produtoDAO.listar()
	            );
	
	            request.setAttribute(
	                "listaUsuarios",
	                usuarioDAO.listar()
	            );
	
	            RequestDispatcher rd =
	                request.getRequestDispatcher(
	                    "CadastroPedido.jsp"
	                );
	
	            rd.forward(request, response);
	        }
        }
    }

    /**
     * Salvar pedido
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int operacao =
            Integer.parseInt(request.getParameter("op"));

        PedidoDAO pedidoDAO = new PedidoDAO();

        switch (operacao) {

            // INSERIR PEDIDO
            case 1 -> {

                Pedido pedido = new Pedido();

                // =========================
                // USUÁRIO
                // =========================

                Usuario usuario = new Usuario();

                usuario.setId(
                    Integer.parseInt(
                        request.getParameter("usuarioId")
                    )
                );

                pedido.setUsuario(usuario);

                // =========================
                // ITENS
                // =========================

                String[] produtosIds =
                    request.getParameterValues("produtoId");

                String[] quantidades =
                    request.getParameterValues("quantidade");

                ArrayList<ItemPedido> itens =
                    new ArrayList<>();

                for (int i = 0; i < produtosIds.length; i++) {

                	ProdutoDAO produtoDAO = new ProdutoDAO();

                	Produto produto =
                	    produtoDAO.buscarPorId(
                	        Integer.parseInt(produtosIds[i])
                	    );

                    ItemPedido item = new ItemPedido();

                    item.setProduto(produto);

                    item.setQuantidade(
                        Integer.parseInt(quantidades[i])
                    );

                    itens.add(item);
                }

                pedido.setItensPedido(itens);

                boolean resultado = pedidoDAO.inserir(pedido);

                if (resultado) {

                    request.setAttribute("pedido", pedido);

                    RequestDispatcher rd =
                        request.getRequestDispatcher("PedidoCriado.jsp");

                    rd.forward(request, response);

                } else {

                    response.sendRedirect(
                        "PedidoController?op=1&erro=1"
                    );
                }
            }

            default -> {

                response.sendRedirect(
                    "CadastroPedido.jsp?erro=1"
                );
            }
        }
    }

}
