package it.prova.gestionecomputerjspservletmaven.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecomputerjspservletmaven.model.Computer;
import it.prova.gestionecomputerjspservletmaven.service.MyServiceFactory;
import it.prova.gestionecomputerjspservletmaven.utility.UtilityComputerForm;

/**
 * Servlet implementation class ExecuteInsertComputerServlet
 */
@WebServlet("/ExecuteInsertComputerServlet")
public class ExecuteInsertComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteInsertComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataRilascioStringParam = request.getParameter("dataRilascio");

		Computer computerInstance = UtilityComputerForm.createComputerFromParams(marcaInputParam,
				modelloInputParam, prezzoInputStringParam, dataRilascioStringParam);

		if (!UtilityComputerForm.validateComputerBean(computerInstance)) {
			request.setAttribute("insertComputerAttribute", computerInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/computer/insertComputer.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getComputerServiceInstance().inserisciNuovo(computerInstance);
			request.setAttribute("listaComputerAttribute", MyServiceFactory.getComputerServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/computer/risultati.jsp").forward(request, response);
	}

}
