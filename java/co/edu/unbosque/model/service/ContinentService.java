package co.edu.unbosque.model.service;

import co.edu.unbosque.model.dao.ContinentDAO;
import co.edu.unbosque.model.entity.Continent;
import co.edu.unbosque.util.MyLinkedList;

/**
 * Servicio que proporciona operaciones CRUD para la entidad Continent.
 * Utiliza un objeto ContinentDAO para acceder a la capa de acceso a datos.
 * @author Sebastian Cardenas Garcia.
 */
public class ContinentService implements Service<Continent, Integer>{
	
	/**
	 * Objeto que permite el acceso a la base de datos.
	 */
	private ContinentDAO continentdao;
	
	/**
	 * Constructor que incializar el ContinentService con un ContinentDAO.
	 */
	public ContinentService() {
		this.continentdao = new ContinentDAO();
	}
	
	/**
	 * Guarda un objeto de la clase Continent en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Continent a guardar.
	 */
	@Override
	public void create(Continent objeto) {
		continentdao.saveOrUpdate(objeto);
	}

	/**
	 * Actualiza un objeto de la clase Continent en la base de datos.
	 * 
	 * @param objeto El objeto de la clase Continent a actualizar.
	 */
	@Override
	public void update(Continent objeto) {
		continentdao.saveOrUpdate(objeto);
	}

	/**
	 * Elimina un objeto de la clase Continent de la base de datos.
	 * 
	 * @param objeto El objeto de la clase Continent a eliminar.
	 * @return El objeto que ha sido eliminado de la base de datos.
	 */
	@Override
	public Continent delete(Continent objeto) {
		continentdao.delete(objeto);
		return objeto;
	}

	/**
	 * Obtiene el objeto de la clase Continent de la base de datos segun su
	 * identificador unico.
	 * 
	 * @param El identificador unico de un objeto de la clase Continent.
	 * @return El objeto tipo Continent que corresponde con el identificador unico.
	 * Si no existe devuelve null.
	 */
	@Override
	public Continent findById(Integer id) {
		return continentdao.get(id);
	}

	/**
	 * Obtiene la lista de objetos tipo Continent de la base de datos.
	 * 
	 * @return La {@link MyLinkedList} de objetos tipo Continent.
	 */
	@Override
	public MyLinkedList<Continent> findAll() {
		return continentdao.findAll();
	}

}
