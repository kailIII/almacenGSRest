package es.home.rsgae.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.home.rsgae.bean.Libro;
import es.home.rsgae.json.LibroJson;
import es.home.rsgae.persistence.EMF;

@Controller
@RequestMapping("/books/**")
public class LibroRest {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	protected Mapper mapper;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	LibroJson create(@RequestBody final LibroJson form) {
		logger.info("LibroRest - create - init");
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		logger.info("Transaction actived ? - " + transaction.isActive());
		transaction.begin();
		logger.info("Transaction actived ? - " + transaction.isActive());
		try {
			Libro bean = mapper.map(form, Libro.class);
			em.persist(bean);
			transaction.commit();
		} catch (Exception except) {
			transaction.rollback();
			logger.error("Error al crear el libro: ", except);
		} finally {
			em.close();
		}
		return form;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<LibroJson> findAll() {
		logger.info("LibroRest - findAll - init");
		EntityManager em = EMF.get().createEntityManager();
		List<LibroJson> exit = new ArrayList<LibroJson>();
		try {
			String query = "select l from " + Libro.class.getName() + " l";
			List<Libro> beans = em.createQuery(query).getResultList();

			if (beans != null) {
				LibroJson json = null;
				for (Libro bean : beans) {
					json = mapper.map(bean, LibroJson.class);
					exit.add(json);
				}
				logger.info("Listado size: " + exit.size());
			} else {
				logger.info("Listado nulo");
			}
		} catch (Exception except) {
			logger.error("Error al obtener el libro: ", except);
		} finally {
			em.close();
		}
		logger.info("LibroRest - findAll - end");
		return exit;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
	public @ResponseBody
	LibroJson findById(@PathVariable final String id) {
		logger.info("LibroRest - findById - init");
		EntityManager em = EMF.get().createEntityManager();
		LibroJson json = null;
		try {
			Libro bean = em.find(Libro.class, id);
			json = mapper.map(bean, LibroJson.class);
		} catch (Exception except) {
			logger.error("Error al obtener el libro: ", except);
		} finally {
			em.close();
		}
		return json;
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void merge(@PathVariable(value = "id") final Long id,
			@RequestBody final LibroJson form) {
		logger.info("LibroRest - merge - init");
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		logger.info("Transaction actived ? - " + transaction.isActive());
		transaction.begin();
		logger.info("Transaction actived ? - " + transaction.isActive());
		try {
			Libro bean = mapper.map(form, Libro.class);
			// Libro beanAct = em.find(Libro.class, id);
			// beanAct.setArgumento(bean.getArgumento());
			// beanAct.setAutor(bean.getAutor());
			// beanAct.setNombre(bean.getNombre());
			// beanAct.setPaginas(bean.getPaginas());
			em.merge(bean);
			transaction.commit();
		} catch (Exception except) {
			transaction.rollback();
			logger.error("Error al actualizar el libro: ", except);
		} finally {
			em.close();
		}
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void remove(@PathVariable(value = "id") final Long id) {
		logger.info("LibroRest - remove - init");
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		logger.info("Transaction actived ? - " + transaction.isActive());
		transaction.begin();
		logger.info("Transaction actived ? - " + transaction.isActive());
		try {
			logger.info("Vamos a borrar a: " + id);
			Libro bean = em.find(Libro.class, id);
			em.remove(bean);
			transaction.commit();
		} catch (Exception except) {
			transaction.rollback();
			logger.error("Error al borrar el libro: ", except);
		} finally {
			em.close();
		}
	}

}
