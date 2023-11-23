package co.edu.unbosque.model.service;

import co.edu.unbosque.model.dao.ContinentDAO;
import co.edu.unbosque.model.entity.Continent;
import co.edu.unbosque.util.MyLinkedList;

public class ContinentService implements Service<Continent, Integer>{
	
	private ContinentDAO continentdao;
	
	public ContinentService() {
		this.continentdao = new ContinentDAO();
	}
	
	@Override
	public void create(Continent objeto) {
		continentdao.saveOrUpdate(objeto);
	}

	@Override
	public void update(Continent objeto) {
		continentdao.saveOrUpdate(objeto);
	}

	@Override
	public Continent delete(Continent objeto) {
		continentdao.delete(objeto);
		return objeto;
	}

	@Override
	public Continent findById(Integer id) {
		return continentdao.get(id);
	}

	@Override
	public MyLinkedList<Continent> findAll() {
		return continentdao.findAll();
	}

}
