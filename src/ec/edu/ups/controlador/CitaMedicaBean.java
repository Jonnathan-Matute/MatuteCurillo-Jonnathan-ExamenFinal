package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.ejb.SignosVitalesFacade;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Paciente;
import ec.edu.ups.modelo.SignosVitales;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitaMedicaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private CitaMedicaFacade citaMedicaFacade;
	@EJB
	private PacienteFacade pacienteFacade;
	@EJB
	private SignosVitalesFacade signosVitalesFacade;
	private String fechaHora;
	private String sintomas;
	private String alegrias;
	private String enfermedadesPrevias;
	private String signosVitales2;
	private List<CitaMedica> listCitaMedica;

	private CitaMedica citaMedica;
	private SignosVitales signosVitales;

	private Paciente paciente;
	private String paciente2;

	@PostConstruct
	public void init() {
		this.citaMedica = new CitaMedica();
		listCitaMedica = citaMedicaFacade.findAll();
		this.listCitaMedica = new ArrayList<>();
	}

	public CitaMedicaFacade getCitaMedicaFacade() {
		return citaMedicaFacade;
	}

	public void setCitaMedicaFacade(CitaMedicaFacade citaMedicaFacade) {
		this.citaMedicaFacade = citaMedicaFacade;
	}

	public PacienteFacade getPacienteFacade() {
		return pacienteFacade;
	}

	public void setPacienteFacade(PacienteFacade pacienteFacade) {
		this.pacienteFacade = pacienteFacade;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public SignosVitalesFacade getSignosVitalesFacade() {
		return signosVitalesFacade;
	}

	public void setSignosVitalesFacade(SignosVitalesFacade signosVitalesFacade) {
		this.signosVitalesFacade = signosVitalesFacade;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getPaciente2() {
		return paciente2;
	}

	public void setPaciente2(String paciente2) {
		this.paciente2 = paciente2;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getAlegrias() {
		return alegrias;
	}

	public void setAlegrias(String alegrias) {
		this.alegrias = alegrias;
	}

	public String getEnfermedadesPrevias() {
		return enfermedadesPrevias;
	}

	public void setEnfermedadesPrevias(String enfermedadesPrevias) {
		this.enfermedadesPrevias = enfermedadesPrevias;
	}

	public List<CitaMedica> getListCitaMedica() {
		return listCitaMedica;
	}

	public void setListCitaMedica(List<CitaMedica> listCitaMedica) {
		this.listCitaMedica = listCitaMedica;
	}

	public CitaMedica getCitaMedica() {
		return citaMedica;
	}

	public void setCitaMedica(CitaMedica citaMedica) {
		this.citaMedica = citaMedica;
	}

	public String add() {
		citaMedicaFacade.create(new CitaMedica(this.fechaHora, buscarSignosVitales(), this.sintomas, this.alegrias,
				this.enfermedadesPrevias, buscar()));
		listCitaMedica = citaMedicaFacade.findAll();
		return null;
	}
 
	private Paciente buscar() {
		Paciente p = new Paciente();
		p = pacienteFacade.buscarPaciente(paciente2);
		System.out.println(p.toString());
		return p;

	}
	
	private SignosVitales buscarSignosVitales() {
		SignosVitales sv  = new SignosVitales();
		sv = signosVitalesFacade.buscarSignosVitales(signosVitales2);
		System.out.println(sv.toString());
		return sv;

	}
	

	public String remove(CitaMedica cm) {
		citaMedicaFacade.remove(cm);
		listCitaMedica = citaMedicaFacade.findAll();
		return null;
	}

	public String edit(CitaMedica cm) {
		cm.setEditable(true);
		return null;
	}

	public String save(CitaMedica cm) {
		citaMedicaFacade.edit(cm);
		cm.setEditable(false);
		return null;
	}
}
