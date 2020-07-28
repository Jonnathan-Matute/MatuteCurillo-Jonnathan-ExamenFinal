package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		try {
		String sql="SELECT sv FROM SignosVitales sv where sv.tipo='"+tipo+"'";
		Query query = em.createQuery(sql);
		sv = (SignosVitales) query.getSingleResult();
		}catch(Exception e) {

		}
		return sv;
	}

}
