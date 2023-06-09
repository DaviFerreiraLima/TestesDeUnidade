package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteAvaliador {

	static Usuario joao;
	static Usuario maria;
	static Usuario jose;
	static Leilao leilao;
	static Avaliador avaliador;

	@BeforeAll
	static void setUp() {
		joao = new Usuario("João");
		maria = new Usuario("Maria");
		jose = new Usuario("José");
		leilao = new Leilao("Playstation 5");
	}
	
	@BeforeEach

	void beforeEachSetup() {
		leilao.setLances(new ArrayList<Lance>());
		avaliador = new Avaliador("Tiago");
	}
		
	@Test  
	void semLance() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			avaliador.avalia(leilao);
			
		});
	}
	//testado
	@Test
	void umLance() {
		
		Lance lance1 = new Lance(joao, 1000.0);
		leilao.propoe(lance1);
		
		avaliador.avalia(leilao);

		assertEquals(1000.0, avaliador.getMaiorLance());
		assertEquals(1000.0, avaliador.getMenorLance());
	}

	@Test
	void umLanceNegativo() { 
		
		Lance lance4 = new Lance(joao, -1000.0);
		leilao.propoe(lance4);
		
		avaliador.avalia(leilao);
		
		assertEquals(-1000, avaliador.getMaiorLance());
		 assertEquals(-1000, avaliador.getMenorLance());
		
	}

	@Test
	void umLanceZero() {
	    System.out.println("-------------Um Lance Zero-------------");
	    
	    Lance lance5 = new Lance(joao, 0.0);
	    leilao.propoe(lance5);
	    
	    avaliador.avalia(leilao);
	    assertEquals(0.0, avaliador.getMaiorLance());
	    assertEquals(0.0, avaliador.getMenorLance());
	}

	@Test
	void doisLancesCrescentes() {
	    System.out.println("-------------Dois Lances Crescentes-------------");
	    
	    Lance lance1 = new Lance(joao, 1000.0);
	    Lance lance2 = new Lance(maria, 1500.0);
	    leilao.propoe(lance1);
	    leilao.propoe(lance2);
	    
	    avaliador.avalia(leilao);
	    assertEquals(1500.0, avaliador.getMaiorLance());
	    assertEquals(1000.0, avaliador.getMenorLance());
	}

	@Test
	void doisLancesDecrescentes() {
	    System.out.println("-------------Dois Lances Decrescentes-------------");
	    
	    Lance lance1 = new Lance(joao, 1500.0);
	    Lance lance2 = new Lance(maria, 1000.0);  // Trocar sequencia de lances
	    leilao.propoe(lance1);
	    leilao.propoe(lance2);
	    
	    avaliador.avalia(leilao);
	    assertEquals(1500.0, avaliador.getMaiorLance());
	    assertEquals(1000.0, avaliador.getMenorLance());
	}

	@Test
	void tresLancesCrescentes() {
	    System.out.println("-------------Três Lances Crescentes-------------");
	    
	    Lance lance1 = new Lance(joao, 1000.0);
	    Lance lance2 = new Lance(maria, 1500.0);
	    Lance lance3 = new Lance(jose, 2000.0);
	    leilao.propoe(lance1);
	    leilao.propoe(lance2);
	    leilao.propoe(lance3);
	    
	    avaliador.avalia(leilao);
	    assertEquals(2000.0, avaliador.getMaiorLance());
	    assertEquals(1000.0, avaliador.getMenorLance());
	}

	@Test
	void tresLancesDecrescentes() {
	    System.out.println("-------------Três Lances Decrescentes-------------");
	    
	    Lance lance1 = new Lance(joao, 2000.0);
	    Lance lance2 = new Lance(maria, 1500.0);
	    Lance lance3 = new Lance(jose, 1000.0);
	    leilao.propoe(lance1);
	    leilao.propoe(lance2);
	    leilao.propoe(lance3);
	    
	    avaliador.avalia(leilao);
	    
	    assertEquals(2000, avaliador.getMaiorLance());
	    assertEquals(1000,avaliador.getMenorLance());
	}
	
	@Test
	void tresLancesMisturados() {
	    System.out.println("-------------Três Lances Misturados-------------");
	    
	    Lance lance1 = new Lance(joao, 1000.0);
	    Lance lance2 = new Lance(maria, 1500.0);
	    Lance lance3 = new Lance(jose, 1200.0);
	    leilao.propoe(lance1);
	    leilao.propoe(lance2);
	    leilao.propoe(lance3);
	    
	    avaliador.avalia(leilao);
	    assertEquals(1500.0, avaliador.getMaiorLance());
	    assertEquals(1000.0, avaliador.getMenorLance());
	}

}
