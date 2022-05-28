package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Usuario;

public class ListaVotantes {
	private ArrayList<Usuario> usuarios;
	public ListaVotantes() {
		usuarios =new ArrayList<Usuario>();
		Usuario usuario1=new Usuario("Carlos","carlo@gmail.com",LocalDate.parse("2022-09-05"), 0);
		usuarios.add(usuario1);
	}
	
	public ArrayList<Usuario> getUsuario(){
		return usuarios;
	}
	
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios=usuarios;
	}
}
