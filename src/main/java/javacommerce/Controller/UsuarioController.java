package javacommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javacommerce.DAO.UsuarioDAO;
import javacommerce.VO.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
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
		        UsuarioDAO u = new UsuarioDAO();

		        switch (operacao) {
		            case 1 -> {
		                Usuario user = new Usuario();
		                user.setNome(request.getParameter("nome"));
		                user.setSenha(request.getParameter("senha"));
		                user.setCpf(request.getParameter("cpf"));
		                user.setEndereco(request.getParameter("endereco"));    
		                response.sendRedirect("UsuarioCriado.jsp?result=" + u.inserir(user));
		            }
		            case 2 -> {
		            	response.sendRedirect("UsuarioCriado.jsp?erro=" + "1");
		            }
		            
		        }
	}

}
