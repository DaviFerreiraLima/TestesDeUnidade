package modelo;

import java.util.ArrayList;

public class TesteManualAvaliador {

	public static void main(String[] args) {
		
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("José");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		Avaliador avaliador;
		
		// 1,7 Não tem lance
		System.out.println("-------------Sem Lance-------------");
		leilao.setLances(new ArrayList<Lance>());
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(Double.NEGATIVE_INFINITY + " == " + avaliador.getMaiorLance());
		System.out.println(Double.POSITIVE_INFINITY + " == " + avaliador.getMenorLance());
		
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//um lance (menor e maior)
		//valor > 0
		System.out.println("-------------Um Lance-------------");
		leilao.setLances(new ArrayList<Lance>());
		Lance lance1 = new Lance(joao, 1000.0);
		leilao.propoe(lance1);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//um lance (menor e maior)
		//valor < 0 lance com valor negativo
		System.out.println("-------------Um Lance Negativo-------------");
		leilao.setLances(new ArrayList<Lance>());
		Lance lance4 = new Lance(joao, -1000.0);
		leilao.propoe(lance4);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(Double.NEGATIVE_INFINITY + " == " + avaliador.getMaiorLance());
		System.out.println(Double.POSITIVE_INFINITY + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//um lance (menor e maior)
		//valor = 0 lance com valor zero
		System.out.println("-------------Um Lance Zero-------------");
		leilao.setLances(new ArrayList<Lance>());
		Lance lance5 = new Lance(joao, 0.0);
		leilao.propoe(lance5);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(Double.NEGATIVE_INFINITY + " == " + avaliador.getMaiorLance());
		System.out.println(Double.POSITIVE_INFINITY + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//dois lances (crescente)
		//valor > 0
		System.out.println("-------------Dois Lances Crescentes-------------");
		leilao.setLances(new ArrayList<Lance>());
		Lance lance2 = new Lance(maria, 1500.0);
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1500.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//dois lances (crescente)
		//valor < 0 lance com valor negativo
		System.out.println("-------------Dois Lances Crescentes Valor Negativo-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance4);
		leilao.propoe(lance1);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//dois lances (crescente)
		//valor < 0 lance com valor negativo
		System.out.println("-------------Dois Lances Crescentes Valor Zero-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance5);
		leilao.propoe(lance1);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		// 1,2,4,5,6,1,... Pelo menos um lance menor
		//dois lances (decrescente)
		//valor > 0
		System.out.println("-------------Dois Lances Decrescentes-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance2);
		leilao.propoe(lance1);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1500.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//dois lances (crescente)
		//valor < 0 lance com valor negativo
		System.out.println("-------------Dois Lances Decrescentes Valor Negativo-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance1);
		leilao.propoe(lance4);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//dois lances (crescente)
		//valor < 0 lance com valor negativo
		System.out.println("-------------Dois Lances Decrescentes Valor Zero-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance1);
		leilao.propoe(lance5);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(1000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		//três lances (crescente)
		//valor > 0
		System.out.println("-------------Três Lances Crescentes-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance1);
		leilao.propoe(lance2);
		Lance lance3 = new Lance(jose, 2000.0);
		leilao.propoe(lance3);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(2000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,3,6,1,... Pelo menos um lance maior
		// 1,2,4,5,6,1,... Pelo menos um lance menor
		//três lances (decrescente)
		//valor > 0
		System.out.println("-------------Três Lances Decrescentes-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance3);
		leilao.propoe(lance2);
		leilao.propoe(lance1);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(2000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());
		
		// 1,2,4,6,1,... Pelo menos um lance que não é maior nem menor
		//três lances (misturado)
		//valor > 0
		System.out.println("-------------Três Lances Misturados-------------");
		leilao.setLances(new ArrayList<Lance>());
		leilao.propoe(lance1);
		leilao.propoe(lance3);
		leilao.propoe(lance2);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);
		System.out.println(2000.0 + " == " + avaliador.getMaiorLance());
		System.out.println(1000.0 + " == " + avaliador.getMenorLance());	
	}

}
