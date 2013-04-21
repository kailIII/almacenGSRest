/**
 * 
 */
package es.home.rsgae.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author xe29197
 * 
 */
public class EMF {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	public static EntityManagerFactory get() {
		return emfInstance;
	}

	private EMF() {
	}

}
