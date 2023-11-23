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


public class GenericDAO<T, ID extends Serializable> implements DAO<T, ID> {

	private final Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}


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

	@Override
	public void delete(T entity) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.delete(entity);
	            transaction.commit();
	        }

	}

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
