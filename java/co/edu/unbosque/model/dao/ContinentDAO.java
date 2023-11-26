package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entity.Continent;

/**
 * Implementación específica de un DAO para la entidad Continent.
 * Extiende GenericDAO para obtener funcionalidad genérica de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class ContinentDAO extends GenericDAO<Continent, Integer>{

	/**
     * Constructor que inicializa el ContinentDAO con la clase de entidad Continent.
     */
	public ContinentDAO() {
		super(Continent.class);
		// TODO Auto-generated constructor stub
	}

}
