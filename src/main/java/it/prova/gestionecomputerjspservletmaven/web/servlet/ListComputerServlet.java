package it.prova.gestionecomputerjspservletmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecomputerjspservletmaven.service.MyServiceFactory;


/**
 * Servlet implementation class ListComputerServlet
 */
@WebServlet("/ListComputerServlet")
public class ListComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListComputerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaComputerAttribute", MyServiceFactory.getComputerServiceInstance().listAll());
		} catch (Exception e) {
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/computer/risultati.jsp").forward(request, response);
	}


}
