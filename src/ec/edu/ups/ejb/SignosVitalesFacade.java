package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.*;

@Stateless
public class SignosVitalesFacade extends AbstractFacade<SignosVitales> {

	@PersistenceContext(unitName = "MatuteCurillo-Jonnathan-ExamenFinal")
	private EntityManager em;

	public SignosVitalesFacade() {
		super(SignosVitales.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public SignosVitales buscarSignosVitales(String tipo) {
		SignosVitales sv = new SignosVitales();
		String sql="SELECT sv FROM SignosVitales sv where sv.nombres='"+tipo+"'";
		sv = (SignosVitales) em.createQuery(sql).getSingleResult();
		return sv;
	}

}
