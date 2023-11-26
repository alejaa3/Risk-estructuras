package co.edu.unbosque.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.hibernate.usertype.ParameterizedType;

import co.edu.unbosque.util.MyLinkedList;

/**
 * Implementacion generica de la interfaz DAO para operaciones CRUD con hibernate.
 * 
 * @param <T> El tipo de entidad manejada por el DAO.
 * @param <ID> El tipo de identficador unico de la entidad.
 * @author Sebastian Cardenas Garcia.
 */
public class GenericDAO<T, ID extends Serializable> implements DAO<T, ID> {

	/**
	 * EL tipo de entidad que manejara el DAO.
	 */
	private final Class<T> entityClass;
	
	/**
	 * Constructor que recibe el tipo de clase que manejara el DAO.
	 * 
	 * @param entityClass La clase de la entidad que manejara el DAO.
	 */
	public GenericDAO(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	/**
	 * Obtiene la clase de la entidad menejada por el DAO.
	 * 
	 * @return La clase de la entidad menejada por el DAO.
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}
	
	/**
	 * Guarda o Actualiza la entidad en la base de datos.
	 */
	@Override
	public void saveOrUpdate(T entity) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaccion = sesion.beginTransaction();
			sesion.merge(entity);
			transaccion.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sesion.close();
		}
	}

	/**
	 * Obtiene una entidad con el identificador unico asociado.
	 * 
	 *@return La entidad con el identificador unico asociado.
	 */
	@Override
	public T get(ID id) {
		T entity = null;
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			
			entity = sesion.get(getEntityClass(), id);
			if(entity == null) {
				String sql = "select p from "+getEntityClass().getName()+" p where p.id = :id";
				Query q = sesion.createQuery(sql);
				q.setParameter("id", id);
				
				
				List<T> resultList = q.list();
	            if (!resultList.isEmpty()) {
	                // Si la lista no está vacía, asigna la entidad encontrada
	                entity = resultList.get(0);
	            }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sesion.close();
		}
		
		
		return entity;
	}

	/**
	 * Elimina la entidad proporcionada en la base de datos.
	 */
	@Override
	public void delete(T entity) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.delete(entity);
	            transaction.commit();
	        }

	}

	/**
	 * Obtiene un lista enlazada de todos las entidades en la base de datos.
	 * 
	 * @return La {@link MyLinkedList} de las entidades en la base de datos
	 */
	@Override
	public MyLinkedList<T> findAll() {
		MyLinkedList<T> entities = new MyLinkedList<T>();
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from " + getEntityClass().getName();
			Query q = sesion.createQuery(hql);
			List<T> result = q.list();
	        entities.addAll(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sesion.close();
		}
		return entities;
	}
}
