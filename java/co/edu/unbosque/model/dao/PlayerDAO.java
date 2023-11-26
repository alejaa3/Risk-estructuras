package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entity.Player;

/**
 * Implementación específica de un DAO para la entidad Player.
 * Extiende GenericDAO para obtener funcionalidad genérica de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class PlayerDAO extends GenericDAO<Player, Integer>{

	/**
     * Constructor que inicializa el PlayerDAO con la clase de entidad Player.
     */
	public PlayerDAO() {
		super(Player.class);
		// TODO Auto-generated constructor stub
	}

}
