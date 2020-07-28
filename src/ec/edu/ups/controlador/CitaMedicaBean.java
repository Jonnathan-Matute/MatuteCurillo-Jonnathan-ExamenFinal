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
	private String signosVitales;
	private List<CitaMedica> listCitaMedica;

	private CitaMedica citaMedica;

	private String paciente;

	@PostConstruct
	public void init() {
		this.citaMedica = new CitaMedica();
		listCitaMedica = citaMedicaFacade.findAll();
		new ArrayList<>();
	}

	public CitaMedicaFacade getCitaMedicaFacade() {
		return citaMedicaFacade;
	}


	public void setSignosVitales(String signosVitales) {
		this.signosVitales = signosVitales;
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

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
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

	public String getSignosVitales() {
		return signosVitales;
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
		Paciente ca = new Paciente();
		ca = citaMedicaFacade.validar(paciente);
		System.out.println(ca.toString());
		System.out.println(ca.getCodigo());
		return ca;

	}
	
	private SignosVitales buscarSignosVitales() {
		SignosVitales sv  = new SignosVitales();
		sv = signosVitalesFacade.buscarSignosVitales(signosVitales);
		System.out.println(sv);
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
