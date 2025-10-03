package model;

public class Consultorio {
	private String id;
	private String direccion;
	private String ciudad;
	private EstadoConsultorio estadoConsultorio;
	
	public Consultorio(String id, String direccion, String ciudad) {
		this.id = id;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}
	
	public Consultorio(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public EstadoConsultorio getEstadoConsultorio() {
		return estadoConsultorio;
	}

	public void setEstadoConsultorio(EstadoConsultorio estadoConsultorio) {
		this.estadoConsultorio = estadoConsultorio;
	}
	
}
