package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TesteSemLances {

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

	@Test
	void semLance() {
		leilao.setLances(new ArrayList<Lance>());
		avaliador = new Avaliador("Tiago");
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			avaliador.avalia(leilao);
		});
	}
		
	@Test
	void umLance() {
		leilao.setLances(new ArrayList<Lance>());
		Lance lance1 = new Lance(joao, 1000.0);
		leilao.propoe(lance1);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);

		assertEquals(1000.0, avaliador.getMaiorLance());
		assertEquals(1000.0, avaliador.getMenorLance());
	}
	
	@Test
	void umLanceNegativo() {
		leilao.setLances(new ArrayList<Lance>());
		Lance lance4 = new Lance(joao, -1000.0);
		leilao.propoe(lance4);
		avaliador = new Avaliador("Tiago");
		avaliador.avalia(leilao);

		assertEquals(Double.NEGATIVE_INFINITY, avaliador.getMaiorLance());
		assertEquals(Double.POSITIVE_INFINITY, avaliador.getMenorLance());
	}

}