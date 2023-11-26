package co.edu.unbosque.model.dao;

import co.edu.unbosque.model.entity.Country;

/**
 * Implementación específica de un DAO para la entidad Country.
 * Extiende GenericDAO para obtener funcionalidad genérica de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class CountryDAO extends GenericDAO<Country, Integer>{

	/**
     * Constructor que inicializa el CountryDAO con la clase de entidad Country.
     */
	public CountryDAO() {
		super(Country.class);
		// TODO Auto-generated constructor stub
	}

}
