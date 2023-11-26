package co.edu.unbosque.model.service;

import co.edu.unbosque.model.dao.CountryDAO;
import co.edu.unbosque.model.entity.Country;
import co.edu.unbosque.util.MyLinkedList;

/**
 * Servicio que proporciona operaciones CRUD para la entidad Country.
 * Utiliza un objeto CountryDAO para acceder a la capa de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class CountryService implements Service<Country, Integer>{
	
	/**
	 * Objeto que permite el acceso a la base de datos.
	 */
	private CountryDAO countrydao;
	
	/**
	 * Constructor que incializar el CountryService con un CountryDAO.
	 */
	public CountryService() {
		this.countrydao = new CountryDAO();
	}
	
	/**
	 * Guarda un objeto de la clase Country en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Country a guardar.
	 */
	@Override
	public void create(Country objeto) {
		countrydao.saveOrUpdate(objeto);
	}

	/**
	 * Actualiza un objeto de la clase Country en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Country a actualizar.
	 */
	@Override
	public void update(Country objeto) {
		countrydao.saveOrUpdate(objeto);
	}

	/**
	 * Elimina un objeto de la clase Country de la base de datos.
	 * 
	 * @param objeto El objeto de la clase Country a eliminar.
	 * @return El objeto que ha sido eliminado de la base de datos.
	 */
	@Override
	public Country delete(Country objeto) {
		countrydao.delete(objeto);
		return objeto;
	}

	/**
	 * Obtiene el objeto de la clase Country de la base de datos segun su
	 * identificador unico.
	 * 
	 * @param El identificador unico de un objeto de la clase Country.
	 * @return El objeto tipo Country que corresponde con el identificador unico.
	 * Si no existe devuelve null.
	 */
	@Override
	public Country findById(Integer id) {
		return countrydao.get(id);
	}

	/**
	 * Obtiene la lista de objetos tipo Country de la base de datos.
	 * 
	 * @return La {@link MyLinkedList} de objetos tipo Country.
	 */
	@Override
	public MyLinkedList<Country> findAll() {
		return countrydao.findAll();
	}

}
