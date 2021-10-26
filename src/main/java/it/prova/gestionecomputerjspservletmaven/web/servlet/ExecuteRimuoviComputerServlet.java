package it.prova.gestionecomputerjspservletmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecomputerjspservletmaven.service.MyServiceFactory;


/**
 * Servlet implementation class ExecuteRimuoviComputerServlet
 */
@WebServlet("/ExecuteRimuoviComputerServlet")
public class ExecuteRimuoviComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteRimuoviComputerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idPerRimozione = request.getParameter("idComputer");

		if (!NumberUtils.isCreatable(idPerRimozione)) {
			request.setAttribute("errorMessage", "Attenzione.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getComputerServiceInstance().rimuovi(MyServiceFactory.getComputerServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idPerRimozione)));

			request.setAttribute("listaComputerAttribute", MyServiceFactory.getComputerServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e1) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/computer/risultati.jsp").forward(request, response);
	}

}
