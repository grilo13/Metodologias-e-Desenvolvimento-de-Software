package trabalhomdsfinal1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FaltasTeste {
	
	FaltasTeste teste;

	@Before
	public void setUp() throws Exception {
		
		teste = new FaltasTeste("Maxime Lucero","063", "0.50");
	}

	@After
	public void tearDown() throws Exception {
		
		teste = null;
	}
	
	@Test   //teste
	public void testSetNome() {
		
		teste.setNome("Maxime Luceiro");
		String valor = teste.getNome();
		assertEquals("Maxime Luceiro", valor);
	}
	
	@Test
	public void testSetCartao() {
		
		teste.setCarto("063");
		String valor = teste.getCarto();
		assertEquals("Valor dever ser igual a 062",valor, "062");
	}
	
	@Test
	public void testSetValor_falta() {
		
		teste.setCarto("1.00");
		String valor = teste.getValor_falta();
		assertEquals("Valor deve ser igual a 1.00",valor, "1.00");
	}
	
	
	

	@Test
	public void testGetNome() {
		
		String valor = teste.getNome();
		assertEquals("Valor deve ser Maxime Lucero" , valor, "Maxime Lucero");
		
	}
	
	@Test
	public void testGetCarto() {
		
		String valor = teste.getCarto();
		assertEquals("O valor dever ser igual ao numero do cartao 063" , valor, "063");
		
	}
	
	
	@Test
	public void testgetValor_falta() {
		
		Double valor = teste.getValor_falta();
		assertEquals("O valor dever ser igual a 0.50" , valor, "0.50");
		
	}
}
