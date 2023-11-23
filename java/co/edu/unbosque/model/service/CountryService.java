package co.edu.unbosque.model.service;

import co.edu.unbosque.model.dao.CountryDAO;
import co.edu.unbosque.model.entity.Country;
import co.edu.unbosque.util.MyLinkedList;

public class CountryService implements Service<Country, Integer>{
	
	private CountryDAO countrydao;
	
	public CountryService() {
		this.countrydao = new CountryDAO();
	}
	@Override
	public void create(Country objeto) {
		countrydao.saveOrUpdate(objeto);
	}

	@Override
	public void update(Country objeto) {
		countrydao.saveOrUpdate(objeto);
	}

	@Override
	public Country delete(Country objeto) {
		countrydao.delete(objeto);
		return objeto;
	}

	@Override
	public Country findById(Integer id) {
		return countrydao.get(id);
	}

	@Override
	public MyLinkedList<Country> findAll() {
		return countrydao.findAll();
	}

}
