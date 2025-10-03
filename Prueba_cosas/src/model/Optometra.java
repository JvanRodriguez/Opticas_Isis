package model;

import java.time.LocalDate;

public class Optometra extends Persona{

	public Optometra(String nombre, String numero_documento, 
			String numero_celular, int anio, int mes, int dia) {
		this.setNombre(nombre);
		this.setNumero_documento(numero_documento);
		this.setNumero_documento(numero_documento);
		this.setFecha_nacimiento(LocalDate.of(anio, mes, dia)); 
	}
	
	public Optometra(String numero_documento) {
		setNumero_documento(numero_documento);
	}
	
	
	
}
