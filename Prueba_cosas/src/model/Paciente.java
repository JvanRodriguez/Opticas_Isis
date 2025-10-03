package model;

import java.time.LocalDate;

public class Paciente extends Persona{
	
	public Paciente (String nombre, String numero_documento, 
			String numero_celular, int anio, int mes, int dia) {
		this.setNombre(nombre);
		this.setNumero_documento(numero_documento);
		this.setNumero_documento(numero_documento);
		this.setFecha_nacimiento(LocalDate.of(anio, mes, dia)); 
	}
	
	public Paciente(String numero_documento) {
		this.setNumero_documento(numero_documento);
	}

}
