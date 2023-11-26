package co.edu.unbosque.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.model.entity.Card;
import co.edu.unbosque.model.entity.Continent;
import co.edu.unbosque.model.entity.Country;
import co.edu.unbosque.model.entity.Player;

/**
 * Clase utilizaria para manejar la configuracion y obtencia de la fabrica de
 * sessiones de Hibernate.
 * @author Sebastian Cardenas Garcia.
 */
public class HibernateUtil {
//
//	 private static SessionFactory sessionFactory;
//
//	    public HibernateUtil() {
//	    }
//
//	    public static SessionFactory getSessionFactory() {
//	        if (sessionFactory == null) {
//	        	try {
//	        		Configuration configuration = new Configuration();
//	        		configuration.configure("/hibernate.cfg.xml");
//	        		sessionFactory = configuration.buildSessionFactory();
//					
//				} catch (Exception e) {
//					System.err.println(e);
//				}
//	        }
//	        return sessionFactory;
//	    }
	
	/**
	 * Objeto que permite el incio de sessiones de hibernate.
	 */
	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	 /**
     * Obtiene la fábrica de sesiones de Hibernate. Si la fábrica aún no se ha creado, la crea y la devuelve.
     *
     * @return La fábrica de sesiones de Hibernate.
     */
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				@SuppressWarnings("deprecation")
				Configuration ac = new Configuration();
				ac.addAnnotatedClass(Card.class);
				ac.addAnnotatedClass(Continent.class);
				ac.addAnnotatedClass(Country.class);
				ac.addAnnotatedClass(Player.class);
				sessionFactory = ac.configure().buildSessionFactory();

			} catch (Throwable ex) {
				// Log the exception.
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}

}
