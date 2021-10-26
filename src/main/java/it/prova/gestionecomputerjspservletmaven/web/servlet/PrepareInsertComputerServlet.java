package it.prova.gestionecomputerjspservletmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecomputerjspservletmaven.model.Computer;


/**
 * Servlet implementation class PrepareInsertComputerServlet
 */
@WebServlet("/PrepareInsertComputerServlet")
public class PrepareInsertComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareInsertComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("insertComputerAttribute", new Computer());
		request.getRequestDispatcher("/computer/insertComputer.jsp").forward(request, response);
	}


}
