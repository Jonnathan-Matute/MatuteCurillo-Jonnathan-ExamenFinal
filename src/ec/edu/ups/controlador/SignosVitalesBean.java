package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import ec.edu.ups.ejb.SignosVitalesFacade;
import ec.edu.ups.modelo.SignosVitales;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SignosVitalesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private SignosVitalesFacade signosVitalesFacade;
	private List<SignosVitales> listSignosVitales;
	private String tipo;
	private SignosVitales signosVitales;

	public SignosVitalesBean() {
	}

	@PostConstruct
	public void init() {
		listSignosVitales = signosVitalesFacade.findAll();
	}

	public SignosVitales getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(SignosVitales signosVitales) {
		this.signosVitales = signosVitales;
	}

	public List<SignosVitales> getListSignosVitales() {
		return listSignosVitales;
	}

	public void setListSignosVitales(List<SignosVitales> listSignosVitales) {
		this.listSignosVitales = listSignosVitales;
	}

	public SignosVitalesFacade getSignosVitalesFacade() {
		return signosVitalesFacade;
	}

	public void setSignosVitalesFacade(SignosVitalesFacade signosVitalesFacade) {
		this.signosVitalesFacade = signosVitalesFacade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String add() {

		SignosVitales sv = new SignosVitales(this.tipo);
		System.out.println(sv);
		signosVitalesFacade.create(sv);
		listSignosVitales = signosVitalesFacade.findAll();
		return null;
	}

	public String remove(SignosVitales sv) {
		signosVitalesFacade.remove(sv);
		listSignosVitales = signosVitalesFacade.findAll();
		return null;
	}

	public String edit(SignosVitales sv) {
		sv.setEditable(true);
		return null;
	}

	public String save(SignosVitales sv) {
		signosVitalesFacade.edit(sv);
		sv.setEditable(false);
		return null;
	}
}
