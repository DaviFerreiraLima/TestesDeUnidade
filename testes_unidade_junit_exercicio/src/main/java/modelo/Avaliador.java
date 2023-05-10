package modelo;

import java.util.List;

public class Avaliador {
	
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private String nome;
	
	public Avaliador(String nome){
		this.nome = nome;
	}
	
	public void avalia(Leilao leilao){
		
		List<Lance> listaLances = leilao.getLances();
		Lance[] lances = leilao.getLances().toArray(new Lance[listaLances.size()]);
		sortLances(lances);
		
		if (lances.length > 0) {
		    menorDeTodos = lances[0].getValor();
		    maiorDeTodos = lances[lances.length - 1].getValor();
		} else {
			throw new IndexOutOfBoundsException("O array de lances está vazio."); //tratamento dessa exception
		}
		
	}
	
	//algoritmo de ordenacao insertion sort
	private void sortLances(Lance[] vetor) {
		int j;
	    Lance key;
	    int i;
	    // ir� percorrer todo o vetor come�ando do segundo elemento e atribuindo o mesmo a uma vari�vel chamada key.
	    for (j = 0; j < vetor.length; j++)
	    {
	      key = vetor[j];
	      // o segundo la�o itera sobre os valores que est�o antes da vari�vel key
	      for (i = j; (i >= 0) && (vetor[i].getValor() > key.getValor()); i--)
	      {
	         vetor[i + 1] = vetor[i];
	       }
	        vetor[i] = key; //alteração nesse metodo
	    }
	}
	
	public double getMaiorLance(){
		return maiorDeTodos;
	}
	
	public double getMenorLance(){
		return menorDeTodos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
