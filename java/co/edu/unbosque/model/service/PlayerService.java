package co.edu.unbosque.model.service;

import co.edu.unbosque.model.dao.PlayerDAO;
import co.edu.unbosque.model.entity.Player;
import co.edu.unbosque.util.MyLinkedList;

/**
 * Servicio que proporciona operaciones CRUD para la entidad Player.
 * Utiliza un objeto PlayerDAO para acceder a la capa de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class PlayerService implements Service<Player, Integer>{
	
	/**
	 * Objeto que permite el acceso a la base de datos.
	 */
	private PlayerDAO playerdao;
	
	/**
	 * Constructor que incializar el PlayerService con un PlayerDAO.
	 */
	public PlayerService() {
		this.playerdao = new PlayerDAO();
	}

	/**
	 * Guarda un objeto de la clase Player en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Player a guardar.
	 */
	@Override
	public void create(Player objeto) {
		playerdao.saveOrUpdate(objeto);
	}

	/**
	 * Actualiza un objeto de la clase Player en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Player a actualizar.
	 */
	@Override
	public void update(Player objeto) {
		playerdao.saveOrUpdate(objeto);
	}

	/**
	 * Elimina un objeto de la clase Player de la base de datos.
	 * 
	 * @param objeto El objeto de la clase Player a eliminar.
	 * @return El objeto que ha sido eliminado de la base de datos.
	 */
	@Override
	public Player delete(Player objeto) {
		playerdao.delete(objeto);
		return objeto;
	}

	/**
	 * Obtiene el objeto de la clase Player de la base de datos segun su
	 * identificador unico.
	 * 
	 * @param El identificador unico de un objeto de la clase Player.
	 * @return El objeto tipo Player que corresponde con el identificador unico.
	 * Si no existe devuelve null.
	 */
	@Override
	public Player findById(Integer id) {
		return playerdao.get(id);
	}

	/**
	 * Obtiene la lista de objetos tipo Player de la base de datos.
	 * 
	 * @return La {@link MyLinkedList} de objetos tipo Player.
	 */
	@Override
	public MyLinkedList<Player> findAll() {
		return playerdao.findAll();
	}
	
	

}
