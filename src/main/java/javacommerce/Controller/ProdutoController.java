package javacommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javacommerce.DAO.ProdutoDAO;
import javacommerce.VO.Produto;

import java.io.IOException;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int operacao = Integer.parseInt(request.getParameter("op"));
        ProdutoDAO p = new ProdutoDAO();

        switch (operacao) {
            case 1 -> {
                Produto prod = new Produto();
                prod.setNome(request.getParameter("nome"));
                prod.setValorUnitario(Double.parseDouble(request.getParameter("valoruni")));
                prod.setDescricao(request.getParameter("descricao"));     
                response.sendRedirect("ProdutoCriado.jsp?result=" + p.inserir(prod));
            }
            case 2 -> {
            	response.sendRedirect("CadastroProduto.jsp?erro=" + "1");
            }
            
        }
	}

}
