package it.prova.gestionecomputerjspservletmaven.service;

import it.prova.gestionecomputerjspservletmaven.dao.ComputerDAO;
import it.prova.gestionecomputerjspservletmaven.dao.ComputerDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static ComputerService COMPUTER_SERVICE_INSTANCE = null;
	private static ComputerDAO COMPUTERDAO_INSTANCE = null;

	public static ComputerService getComputerServiceInstance() {
		if (COMPUTER_SERVICE_INSTANCE == null)
			COMPUTER_SERVICE_INSTANCE = new ComputerServiceImpl();

		if (COMPUTERDAO_INSTANCE == null)
			COMPUTERDAO_INSTANCE = new ComputerDAOImpl();

		COMPUTER_SERVICE_INSTANCE.setComputerDao(COMPUTERDAO_INSTANCE);

		return COMPUTER_SERVICE_INSTANCE;
	}

}
