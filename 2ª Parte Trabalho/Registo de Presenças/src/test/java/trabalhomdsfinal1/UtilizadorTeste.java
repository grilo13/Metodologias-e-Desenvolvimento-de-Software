package trabalhomdsfinal1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UtilizadorTeste {
	
	Utilizador teste;

	@Before
	public void setUp() throws Exception {
		
		teste = new Utilizador("Maxime Lucero","062", "aluno");
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
	public void testSetCartão() {
		
		teste.setCartão("063");
		String valor = teste.getCartão();
		assertEquals("Valor deverá ser igual a 063",valor, "063");
	}
	
	@Test
	public void testSetPapel() {
		
		teste.setPapel("docente");
		String valor = teste.getPapel();
		assertEquals("Valor deverá ser igual a docente",valor, "docente");
	}
	
	@Test
	public void testGetNome() {
		
		String valor = teste.getNome();
		assertEquals("Valor deve ser Maxime Lucero (dado na função setUp como new Utilizador para o teste" , valor, "Maxime Lucero");
		
	}
	
	@Test
	public void testGetCartão() {
		
		String valor = teste.getCartão();
		assertEquals("O valor dever ser igual ao número do cartão que será 062" , valor, "062");
		
	}
	
	@Test
	public void testGetPapel() {
		
		String valor = teste.getPapel();
		assertEquals("O valor deverá ser igual à função do utilizador, neste caso aluno" , valor, "aluno");
		
	}
	
	@Ignore("Not ready to run")
	@Test
	public void shouldReturnNameNotNull() {
		
		String valor = teste.getNome();
		
		if(valor == null) {
			
			throw new IllegalArgumentException("O nome não pode ter valor null");
			
		}
	}
	
	@Ignore("Not ready to run")
	@Test
	public void shouldReturnCardNotNull() {
		
		String valor = teste.getCartão();
		
		if(valor == null) {
			
			throw new IllegalArgumentException("O cartão não pode ter um valor null");
			
		}
	}
	
	@Ignore("Not ready to run")
	@Test
	public void shouldReturnRoleNotNull() {
		
		String valor = teste.getCartão();
		
		if(valor == null) {
			
			throw new IllegalArgumentException("O papel do utilizador não pode ter valor null");
			
		}
	}
	
	}
