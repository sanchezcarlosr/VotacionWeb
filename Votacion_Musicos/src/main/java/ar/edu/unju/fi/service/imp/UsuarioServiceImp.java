package ar.edu.unju.fi.service.imp;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.util.ListaUsuario;

@Service("UsuarioServiceImpList")
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private ListaUsuario listaUsuario;
	
	@Override
	public Usuario getUsuario() {
		// retornar un objeto de la clase Usuario
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		// guardar un objeto
		boolean respuesta=listaUsuario.getUsuario().add(usuario);//Controlar que no se agreguen repetidos
		return respuesta;
	}

	@Override
	public ListaUsuario getListaUsuario() {
		// TODO Auto-generated method stub
		return listaUsuario;
	}
	
	@Override
	public boolean guardarVoto(String mail) {
		boolean respuesta=false;
		for(Usuario usu: listaUsuario.getUsuario()){
			if(usu.getEmail().equals(mail)) {
				usu.setCont_voto(usu.getCont_voto()+1);
				respuesta=true;
			}
		}
		return respuesta;
	}
	@Override
	public Usuario buscarUsuario(String email) {
		Optional<Usuario> usuario=listaUsuario.getUsuario().stream().filter(a -> a.getEmail().equals(email)).findFirst();
		return usuario.get();
	}


}
