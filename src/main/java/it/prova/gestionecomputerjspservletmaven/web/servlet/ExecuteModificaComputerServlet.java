package it.prova.gestionecomputerjspservletmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecomputerjspservletmaven.model.Computer;
import it.prova.gestionecomputerjspservletmaven.service.MyServiceFactory;
import it.prova.gestionecomputerjspservletmaven.utility.UtilityComputerForm;

/**
 * Servlet implementation class ExecuteModificaComputerServlet
 */
@WebServlet("/ExecuteModificaComputerServlet")
public class ExecuteModificaComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteModificaComputerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idPerModifica = request.getParameter("idComputer");

		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataRilascioStringParam = request.getParameter("dataRilascio");

		Computer compuerModifica = UtilityComputerForm.createComputerFromParams(marcaInputParam, modelloInputParam,
				prezzoInputStringParam, dataRilascioStringParam);
		

		if (!NumberUtils.isCreatable(idPerModifica)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		compuerModifica.setId(Long.parseLong(idPerModifica));

		if (!UtilityComputerForm.validateComputerBean(compuerModifica)) {
			request.setAttribute("computerDaInviareAPaginaModifica", compuerModifica);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/computer/modificaComputer.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getComputerServiceInstance().aggiorna(compuerModifica);
			request.setAttribute("listaComputerAttribute", MyServiceFactory.getComputerServiceInstance().listAll());
			request.setAttribute("successMessage", "Modifica effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/computer/risultati.jsp").forward(request, response);
	}

}
