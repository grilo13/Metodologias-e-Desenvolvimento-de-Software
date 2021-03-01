package trabalhomdsfinal1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AulaTeste {
	
	Aula teste;

	@Before   //faz sempre antes de cada teste
	public void setUp() throws Exception {
		
		teste = new Aula("2020-06-01", "10:00");
	}

	@After   //faz sempre depois de cada teste
	public void tearDown() throws Exception {
		
		teste = null;
	}

	@Test   //teste
	public void testSetData() {
		
		teste.setData("2020-06-02");
		String valor = teste.getData();
		assertEquals("2020-06-02", valor);
		
	}
	
	@Test
	public void testSetHora() {
		
		teste.setHora("10:00");
		String valor = teste.getHora();
		assertEquals("10:00", valor);
	}
	
	@Test
	public void testGetData() {
		
		String valor = teste.getHora();
		assertEquals("Valor deve ser 10:00" , valor, "10:00");
		
	}
	
	@Ignore("Not ready to run")
	@Test
	public void shouldReturnDateNotNull() {
		
		String valor = teste.getData();
		
		if(valor == null) {
			
			throw new IllegalArgumentException("A data da classe data não pode ser um valor null");
			
		}
	}
	
	@Ignore("Not ready to run")
	@Test
	public void shouldReturnHoraNotNull() {
		
		String valor = teste.getHora();
		
		if(valor == null) {
			
			throw new IllegalArgumentException("A hora da classe data não pode ser um valor null");
			
		}
	}
	
	

}
