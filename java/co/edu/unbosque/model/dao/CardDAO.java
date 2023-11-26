package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entity.Card;

/**
 * Implementación específica de un DAO para la entidad Card.
 * Extiende GenericDAO para obtener funcionalidad genérica de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class CardDAO extends GenericDAO<Card, Integer>{
	
	/**
     * Constructor que inicializa el CardDAO con la clase de entidad Card.
     */
	public CardDAO() {
		super(Card.class);
	}

}
