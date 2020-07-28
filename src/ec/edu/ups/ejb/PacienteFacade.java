package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.modelo.Paciente;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {

	@PersistenceContext(unitName = "MatuteCurillo-Jonnathan-ExamenFinal")
	private EntityManager em;

	public PacienteFacade() {
		super(Paciente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Paciente buscarPaciente(String nombres) {
		Paciente p = new Paciente();
		String sql="SELECT p FROM Paciente p where p.nombres='"+nombres+"'";
		p = (Paciente) em.createQuery(sql).getSingleResult();
		return p;
	}

}