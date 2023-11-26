package co.edu.unbosque.model.service;

import java.util.List;

import co.edu.unbosque.model.dao.CardDAO;
import co.edu.unbosque.model.entity.Card;
import co.edu.unbosque.util.MyLinkedList;

/**
 * Servicio que proporciona operaciones CRUD para la entidad Card.
 * Utiliza un objeto CardDAO para acceder a la capa de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class CardService implements Service<Card, Integer>{
	
	/**
	 * Objeto que permite el acceso a la base de datos.
	 */
	private CardDAO carddao;
	
	/**
	 * Constructor que inicializa el CardService con un CarDAO.
	 */
	public CardService() {
		this.carddao = new CardDAO();
	}

	/**
	 * Guarda un objeto de la clase Card en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Card a guardar.
	 */
	@Override
	public void create(Card objeto) {
		carddao.saveOrUpdate(objeto);
	}

	/**
	 * Actualiza un objeto de la clase Card en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Card a actualizar.
	 */
	@Override
	public void update(Card objeto) {
		carddao.saveOrUpdate(objeto);
		
	}

	/**
	 * Elimina un objeto de la clase Card de la base de datos.
	 * 
	 * @param objeto El objeto de la clase Card a eliminar.
	 * @return El objeto que ha sido eliminado de la base de datos.
	 */
	@Override
	public Card delete(Card objeto) {
		carddao.delete(objeto);
		return objeto;
	}

	/**
	 * Obtiene el objeto de la clase Card de la base de datos segun su
	 * identificador unico.
	 * 
	 * @param El identificador unico de un objeto de la clase Card.
	 * @return El objeto tipo Card que corresponde con el identificador unico.
	 * Si no existe devuelve null.
	 */
	@Override
	public Card findById(Integer id) {
		return carddao.get(id);
	}

	/**
	 * Obtiene la lista de objetos tipo Card de la base de datos.
	 * 
	 * @return La {@link MyLinkedList} de objetos tipo Card.
	 */
	@Override
	public MyLinkedList<Card> findAll() {
		return carddao.findAll();
	}

}
