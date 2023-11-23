package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entity.Card;

public class CardDAO extends GenericDAO<Card, Integer>{

	public CardDAO() {
		super(Card.class);
	}

}
