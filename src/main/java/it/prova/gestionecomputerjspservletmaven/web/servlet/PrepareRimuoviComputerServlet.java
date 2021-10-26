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


/**
 * Servlet implementation class PrepareRimuoviComputerServlet
 */
@WebServlet("/PrepareRimuoviComputerServlet")
public class PrepareRimuoviComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareRimuoviComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idComputerParam= request.getParameter("idComputer");
		
		Computer result = null;
		
		if (!NumberUtils.isCreatable(idComputerParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			result = MyServiceFactory.getComputerServiceInstance().caricaSingoloElemento(Long.parseLong(idComputerParam));
			request.setAttribute("computerDaInviareAPaginaRimuovi", result);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/computer/showBeforeDelete.jsp").forward(request, response);
	}


}
