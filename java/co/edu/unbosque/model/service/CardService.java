package co.edu.unbosque.model.service;

import java.util.List;

import co.edu.unbosque.model.dao.CardDAO;
import co.edu.unbosque.model.entity.Card;
import co.edu.unbosque.util.MyLinkedList;

public class CardService implements Service<Card, Integer>{
	
	private CardDAO carddao;
	
	public CardService() {
		this.carddao = new CardDAO();
	}

	@Override
	public void create(Card objeto) {
		carddao.saveOrUpdate(objeto);
	}

	@Override
	public void update(Card objeto) {
		carddao.saveOrUpdate(objeto);
		
	}

	@Override
	public Card delete(Card objeto) {
		carddao.delete(objeto);
		return objeto;
	}

	@Override
	public Card findById(Integer id) {
		return carddao.get(id);
	}

	@Override
	public MyLinkedList<Card> findAll() {
		return carddao.findAll();
	}

}
