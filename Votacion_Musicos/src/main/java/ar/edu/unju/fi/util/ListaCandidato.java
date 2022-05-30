package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Candidato;

@Component
public class ListaCandidato {
		private ArrayList<Candidato> candidatos;
	
	public ListaCandidato(){
		candidatos = new ArrayList<Candidato>();
		Candidato candidato1= new Candidato(2, "Callejeros", "Rock Nacional", "Cantante principal: Pato Fontanet",0);
		Candidato candidato2= new Candidato(1, "Los Piojos", "Rock Nacional", "Año de creación: 1988",0);
		Candidato candidato3= new Candidato(0, "Los Redondos", "Rock Nacional", "Año de creación: 1977",0);
		Candidato candidato4= new Candidato(3, "Ninguno", "---", "No me gusta ningun candidato",0);
		candidatos.add(candidato1);
		candidatos.add(candidato2);
		candidatos.add(candidato3);
		candidatos.add(candidato4);
	}
	public int totalVotos(){
		int total =0;
		for(Candidato c:this.getCandidato()){
			total += c.getVotos();

		}
		return total;
	}
	public ArrayList<Candidato> getCandidato() {
		return candidatos;
	}

	public void setCandidato(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
