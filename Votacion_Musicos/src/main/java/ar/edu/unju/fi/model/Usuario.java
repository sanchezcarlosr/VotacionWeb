package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	@Size(min=3, max=100, message="El nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty
	private String nombre;
	@Email
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fnac;
	@Max(3)
	private int cont_voto;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String nombre, String email, LocalDate fnac, int cont_voto) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fnac = fnac;
		this.cont_voto = cont_voto;
	}
	public int getAge(){
		Period period = Period.between(this.fnac,LocalDate.now());
		return period.getYears();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFnac() {
		return fnac;
	}
	public void setFnac(LocalDate fnac) {
		this.fnac = fnac;
	}
	public int getCont_voto() {
		return cont_voto;
	}
	public void setCont_voto(int cont_voto) {
		this.cont_voto = cont_voto;
	}

}
