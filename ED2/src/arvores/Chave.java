package arvores;

public class Chave {

	private int valor;
	private Chave proxima;
	
	public Chave(int valor){
		
		this.valor = valor;
	}
	
	public int exibirValor(){
		
		return this.valor;
	}
	
	public void proximaChave(int valor){
		
		this.proxima = new Chave(valor);
	}
	
	public Chave consultaProxima(){
		
		return this.proxima;
	}
}
