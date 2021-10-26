package it.prova.gestionecomputerjspservletmaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionecomputerjspservletmaven.dao.ComputerDAO;
import it.prova.gestionecomputerjspservletmaven.model.Computer;
import it.prova.gestionecomputerjspservletmaven.web.listener.LocalEntityManagerFactoryListener;

public class ComputerServiceImpl implements ComputerService{

	private ComputerDAO computerDaoInstance;
	@Override
	public void setComputerDao(ComputerDAO computerDao) {
		this.computerDaoInstance=computerDao;
	}

	@Override
	public List<Computer> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			computerDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return computerDaoInstance.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Computer caricaSingoloElemento(Long idInput) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			computerDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return computerDaoInstance.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Computer input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			computerDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			computerDaoInstance.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Computer input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			computerDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			computerDaoInstance.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Computer input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			computerDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			computerDaoInstance.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Computer> findByExample(Computer input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
