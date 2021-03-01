package trabalhomdsfinal1;

import java.util.ArrayList;

public class Presença {
	
	String nome;
	String cartão;
	ArrayList<String> lista_presenças = new ArrayList<String>();
	double valor_presença;
	ArrayList<String> lista_data_presenças = new ArrayList<String>();
	//ArrayList<String> valor_presença = new ArrayList<String>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCartão() {
		return cartão;
	}
	public void setCartão(String cartão) {
		this.cartão = cartão;
	}
	public ArrayList<String> getLista_presenças() {
		return lista_presenças;
	}
	public void setLista_presenças(ArrayList<String> lista_presenças) {
		this.lista_presenças = lista_presenças;
	}

}
