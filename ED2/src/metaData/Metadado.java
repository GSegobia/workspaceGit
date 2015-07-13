package metaData;

import java.util.HashMap;
import java.util.Map;

public class Metadado {
	
	public int numColunas;
	public int numLinhas;
	public String []colunas;
	public Map<String, Integer> nomeColunas = new HashMap<>();
	public boolean ordenado;
	public String elementoOrdenado;
	public int []posicao;
	
	public Metadado(int numColunas, int numLinhas, Map<String, Integer> nomeColunas, boolean ordenado, String elementoOrdenado, int []posicao, String []colunas){
		
		this.numColunas = numColunas;
		this.numLinhas = numLinhas;
		this.nomeColunas = nomeColunas;
		this.ordenado = ordenado;
		this.colunas = colunas;
		this.elementoOrdenado = elementoOrdenado;
		this.posicao = posicao;
	}
}
