package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.imp.UsuarioServiceImp;

@Component
public class ListaUsuario {
	private ArrayList<Usuario> usuarios;
	public ListaUsuario() {
		usuarios =new ArrayList<Usuario>();
		Usuario usuario1=new Usuario("Carlos","carlo@gmail.com",LocalDate.parse("2000-09-05"),0);
		usuarios.add(usuario1);
	}
	
	public ArrayList<Usuario> getUsuario(){
		return usuarios;
	}
	
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios=usuarios;
	}
}
