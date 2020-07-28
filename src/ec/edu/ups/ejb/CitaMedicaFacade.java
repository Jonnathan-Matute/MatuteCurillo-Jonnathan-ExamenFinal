package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.*;

@Stateless
public class CitaMedicaFacade extends AbstractFacade<CitaMedica> {

	@PersistenceContext(unitName = "MatuteCurillo-Jonnathan-ExamenFinal")
	private EntityManager em;

	public CitaMedicaFacade() {
		super(CitaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
