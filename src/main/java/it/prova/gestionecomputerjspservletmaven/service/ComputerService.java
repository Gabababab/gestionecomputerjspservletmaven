package it.prova.gestionecomputerjspservletmaven.service;

import java.util.List;

import it.prova.gestionecomputerjspservletmaven.dao.ComputerDAO;
import it.prova.gestionecomputerjspservletmaven.model.Computer;


public interface ComputerService {

	public void setComputerDao(ComputerDAO computerDao);

	public List<Computer> listAll() throws Exception;

	public Computer caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Computer input) throws Exception;

	public void inserisciNuovo(Computer input) throws Exception;

	public void rimuovi(Computer input) throws Exception;

	public List<Computer> findByExample(Computer input) throws Exception;
}
