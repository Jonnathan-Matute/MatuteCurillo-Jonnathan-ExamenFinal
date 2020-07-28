package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CitaMedica
 *
 */
@Entity

public class CitaMedica implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String fechaHora;
	
	@ManyToOne
	private SignosVitales signosVitales;
	
	private String sintomas;
	private String alegrias;
	private String enfermedadesPrevias;

	@Transient
	private boolean editable;
	
	@ManyToOne
	private Paciente paciente;
	
	
	public CitaMedica() {
		super();
	}


	public CitaMedica(String fechaHora, SignosVitales signosVitales, String sintomas, String alegrias,
			String enfermedadesPrevias, Paciente paciente) {
		super();
		this.fechaHora = fechaHora;
		this.signosVitales = signosVitales;
		this.sintomas = sintomas;
		this.alegrias = alegrias;
		this.enfermedadesPrevias = enfermedadesPrevias;
		this.paciente = paciente;
	}



	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}


	public SignosVitales getSignosVitales() {
		return signosVitales;
	}


	public void setSignosVitales(SignosVitales signosVitales) {
		this.signosVitales = signosVitales;
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


	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
