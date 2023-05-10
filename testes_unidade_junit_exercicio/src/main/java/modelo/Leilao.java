package modelo;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	
	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao){
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance){
		this.lances.add(lance);
	}
	
	public List<Lance> getLances(){
		return this.lances;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public void removeProposta(Usuario usuario) {
		List<Lance> lancesToRemove = new ArrayList<Lance>();
		
		for(Lance lance : this.lances){
			if(lance.getUsuario().equals(usuario)){
				lancesToRemove.add(lance);
			}
		}
		
		for(Lance lance : lancesToRemove){
			this.lances.remove(lance);
		}
	}

}
