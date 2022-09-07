package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.Filme;
import negocio.Genero;
import negocio.Locacao;
import negocio.Transacao;

public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Locacao locacao4;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Filme filme4;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		locacao4 = new Locacao();
		
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

		locacao1.alugar(new Cliente("Izaias", 2, Situacao.ATIVO), filme1);
		locacao2.alugar(new Cliente("Thiago", 3, Situacao.ATIVO), filme2);
		locacao3.alugar(new Cliente("Lucas", 4, Situacao.INATIVO), filme3);		
		locacao4.alugar(new Cliente("Jose", 4, Situacao.ATIVO), filme4);	

		transacao = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valorLocacaoTotalTest() {
		System.out.println("Inicio teste [valorLocacaoTotalTest]");
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Izaias");
		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id == 20);
		assertEquals(150, transacao.valorLocacaoTotal(), 0.1);
		System.out.println("Fim teste [valorLocacaoTotalTest]");
	}

	@Test
	public void valorLocacaoTotalTest2() {
		System.out.println("Inicio teste [valorLocacaoTotalTest2]");

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao2);
		assertEquals(200, transacao.valorLocacaoTotal(), 0.1);
		System.out.println("Fim teste [valorLocacaoTotalTest2]");
	}

	@Test 
	public void buscaClienteIdTest() {
		System.out.println("Inicio teste [buscaClienteIdTest]");
		
		transacao.alugueis.add(locacao2);
		assertEquals("Thiago",transacao.buscaCliente(3).nome);
		System.out.println("Fim teste [buscaClienteIdTest]");
	}
	
	@Test 
	public void calculoLucroTest() {
		System.out.println("Inicio teste [calculoLucroTest]");
		
		locacao2.setValorAluguel(25);
		transacao.alugueis.add(locacao2);
		
		assertEquals(50, transacao.calculoLucro(20), 0.01);
		System.out.println("Fim teste [calculoLucroTest]");
	}
	
	@Test
	public void validaAluguelComClienteInativoTest() {
		System.out.println("Inicio teste [validaAluguelComClienteInativoTest]");

		transacao.alugueis.add(locacao3);
		assertNull(transacao.alugueis.get(0).cliente);
		
		System.out.println("Fim teste [validaAluguelComClienteInativoTest]");
	}
	
	@Test
	public void getGenerosMaisAlugadosTest() {
		System.out.println("Inicio teste [getGenerosMaisAlugadosTest]");
		
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao4);
		
		Genero generoMaisAlugado = transacao.getGenerosMaisAlugados(transacao.alugueis);
		
		assertEquals(Genero.ROMANCE, generoMaisAlugado);
		System.out.println("Fim teste [getGenerosMaisAlugadosTest]");
	}

	@Test
	public void aplicarDescontoTest() {
		System.out.println("Inicio teste [aplicarDescontoTest]");
		
		locacao4.setValorAluguel(100);
		transacao.alugueis.add(locacao4);
		transacao.alugueis = transacao.aplicarDesconto(transacao.alugueis, Genero.COMEDIA, 50);
		assertEquals(50, transacao.alugueis.get(0).valorAluguel , 0.1);
		System.out.println("Fim teste [aplicarDescontoTest]");
	}
	
	public void test1() {

		assertEquals(Math.PI, 3.14, 0.01);
		assertTrue("java".equalsIgnoreCase("Java"));
		Filme f = new Filme("a", Genero.ROMANCE);
		assertNull(f); // assertNotNull();
		Filme f2 = new Filme("a", Genero.ROMANCE);

		assertTrue(f==f2);
		
		assertSame(f, f2); // asserNotSame)();

		assertTrue("Comparacao de objetos", f == f2);

	}

}
