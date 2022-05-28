package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidato;

@Service("CandidatoServiceImpList")
public class CandidatoServiceImp implements ICandidatoService {

	@Autowired
	private ListaCandidato listaCandidato;
	
	@Override
	public Candidato getCandidato() {
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		boolean respuesta=true;
		for(Candidato can: listaCandidato.getCandidato()) {
			if(can.getCodigo()==candidato.getCodigo()) {
				respuesta=false;
			}
		}
		if(respuesta==true) {
			listaCandidato.getCandidato().add(candidato);
		}
		return respuesta;
	}

	@Override
	public ListaCandidato getListaCandidato() {
		// TODO Auto-generated method stub
		return listaCandidato;
	}
	@Override
	public Candidato buscarCandidato(int codigo) {
		// Busca un alumno por dni
		Optional<Candidato> candidato=listaCandidato.getCandidato().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return candidato.get();
	}
	@Override
	public void modificarCandidato(Candidato candidato) {
		for(Candidato can: listaCandidato.getCandidato()) {
			if(can.getCodigo()==candidato.getCodigo())
			{
				can.setNombre(candidato.getNombre());
				can.setGenero(candidato.getGenero());
				can.setDescripcion(candidato.getDescripcion());
			}
		}
	}
	@Override
	public void eliminarCandidato(int codigo) {
		int indice=0;
		for(int i=0;i<listaCandidato.getCandidato().size();i++) {
			if(listaCandidato.getCandidato().get(i).getCodigo()==codigo	)
			{
				indice=i;
			}
		}
		listaCandidato.getCandidato().remove(indice);
	}

}
