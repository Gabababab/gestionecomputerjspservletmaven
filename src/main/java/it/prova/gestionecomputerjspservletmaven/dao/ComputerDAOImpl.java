package it.prova.gestionecomputerjspservletmaven.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionecomputerjspservletmaven.model.Computer;

public class ComputerDAOImpl implements ComputerDAO{
	
	private EntityManager entityManager;

	@Override
	public List<Computer> list() throws Exception {
		return entityManager.createQuery("from Computer", Computer.class).getResultList();
	}

	@Override
	public Computer findOne(Long id) throws Exception {
		return entityManager.find(Computer.class, id);
	}

	@Override
	public void update(Computer input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.merge(input);
	}

	@Override
	public void insert(Computer input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Computer input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

}
