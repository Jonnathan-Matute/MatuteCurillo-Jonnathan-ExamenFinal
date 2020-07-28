package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.Query;
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

	public Paciente validar(String paciente) {
		Paciente pa=new Paciente();
		try {
			String sql="SELECT p FROM Paciente p where p.nombres='"+paciente+"'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			pa= (Paciente) query.getSingleResult();
			System.out.println("Aqui llego"+paciente);	
		} catch (Exception e) {
			System.out.println("Nombre"+e.getMessage());
		}
			
		return pa;
		
	}
	
}
