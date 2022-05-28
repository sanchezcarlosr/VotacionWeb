package ar.edu.unju.fi.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Candidato {
	@Min(value = 1, message = "*El valor del código debe ser mayor o igual a 1")
	@Max(value = 9999, message = "*El valor del codigo debe ser menor o igual a 9999")
	private int codigo;
	
	@Size(min=3, max=100, message = "*El nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty(message= "*Debe ingresar un nombre")
	private String nombre;
	
	@NotEmpty(message = "*Debe ingresar un género")
	private String genero;
	
	@NotEmpty(message = "*Debe ingresar una descripción")
	private String descripcion;
	
	private int votos;
	
	public Candidato() {
		// TODO Auto-generated constructor stub
	}
	public Candidato(int codigo, String nombre,String genero,String descripcion, int votos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.votos = votos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
}
