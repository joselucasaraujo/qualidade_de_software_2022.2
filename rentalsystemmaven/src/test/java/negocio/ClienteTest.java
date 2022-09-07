package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente cliente1;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Filme filme4;
	
	@Before
	public void setUp() throws Exception {
		
		cliente1 = new Cliente("Jose Lucas", 1, Situacao.ATIVO);
		
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;

		filme2 = new Filme("JavaScript", Genero.ROMANCE);
		filme2.valorCompra = 50;
		filme2.id = 20;
		
		filme3 = new Filme("Golang", Genero.DRAMA);
		filme3.valorCompra = 80;
		filme3.id = 21;
		
		filme4 = new Filme("PostgreSQL", Genero.COMEDIA);
		filme4.valorCompra = 90;
		filme4.id = 22;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setFilmeFavoritoTest() {
		System.out.println("Inicio teste [setFilmeFavoritoTest]");
		cliente1.setFilmeFavorito(filme1);
		cliente1.setFilmeFavorito(filme3);
		
		assertNotNull(cliente1.filmesFavoritos);
		assertEquals(filme3, cliente1.filmesFavoritos.get(1));
		System.out.println("Fim teste [setFilmeFavoritoTest]");
	}

}
