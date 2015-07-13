package arvores;

public class ArvoreB {

	private Pagina raiz;
	private int grauMinimo;
	
	public ArvoreB(int grauMinimo){
		
		this.raiz = null;
		this.grauMinimo = grauMinimo;
	}
	
	public Pagina busca(int chave){
		
		if(this.raiz != null)
			return this.raiz.busca(chave);
		
		return null;
	}
	
	public void insere(int chave){
		
		if(this.raiz == null){
			
			this.raiz = new Pagina(this.grauMinimo, true);
			this.raiz.chaves[0] = chave;
			this.raiz.numChaves = 1;
		}
		else if(this.raiz.numChaves == 2 * this.grauMinimo - 1){
		
			
			Pagina page = new Pagina(grauMinimo, false);
			
			page.filhos[0] = this.raiz;
			page.cisao(0, this.raiz);
			
			int i  = 0;
			
			if(page.chaves[0] < chave)
				i++;
			
			page.filhos[i].inserirNaoCheio(chave);
			
			this.raiz = page;
		}
		else{
			
			raiz.inserirNaoCheio(chave);
		}
		
	}
}
