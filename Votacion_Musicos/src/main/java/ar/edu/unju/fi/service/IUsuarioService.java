package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.util.ListaUsuario;

public interface IUsuarioService {
	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public ListaUsuario getListaUsuario(); //Falta agregar esto
	public boolean guardarVoto(String mail);
	public Usuario buscarUsuario(String email);
	
}
