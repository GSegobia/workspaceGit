package arvores;

public class Pagina {

	protected int []chaves;
	protected int minimo;
	protected Pagina []filhos;
	protected int numChaves;
	protected boolean folha;
	
	public Pagina(int minimo, boolean folha){
		
		this.minimo = minimo;
		this.folha = folha;
		this.numChaves = 0;
		chaves = new int[2 * this.minimo - 1];
		filhos = new Pagina[2 * this.minimo];
	}
	
	public Pagina busca(int chave){
		
		int i = 0;
		
		while(i < this.numChaves & chave > this.chaves[i])
			i++;
		
		if(this.chaves[i] == chave)
			return this;
		
		if(folha == true)
			return null;
		
		return filhos[i].busca(chave);
	}
	
	public void inserirNaoCheio(int chave){
		
		int i = this.numChaves - 1;
		
		if(this.folha){
			
			while(i >= 0 && this.chaves[i] > chave){
				
				this.chaves[i+1] = this.chaves[i];
				i--;
			}
			
			this.chaves[i + 1] = chave;
			this.numChaves++;
		}
		else{
			
			while(i >= 0 && this.chaves[i] > chave)
				i--;
			
			if(this.filhos[i + 1].numChaves == 2 * minimo - 1){
				
				cisao(i + 1, this.filhos[i + 1]);
				
				if(this.chaves[i+1] > chave)
					i++;
			}
			
			this.filhos[i + 1].inserirNaoCheio(chave);
		}
			
	}
	
	public void cisao(int i, Pagina pag){
		
		Pagina z = new Pagina(pag.minimo, pag.folha);
		
		z.numChaves = this.minimo - 1;
		
		for(int j = 0; j < this.minimo - 1; j++)
			z.chaves[j] = pag.chaves[j + this.minimo];
		
		if(!pag.folha)
			for(int j = 0; j < this.minimo; j++)
				z.filhos[j] = pag.filhos[j + this.minimo];
		
		pag.numChaves = this.minimo - 1;
		
		for(int j = this.numChaves; j >= i + 1; j--)
			this.filhos[j+1] = this.filhos[j];
		
		this.filhos[i + 1] = z;
		
		for(int j = this.numChaves - 1; j >= i; j--)
			this.chaves[j + 1] = this.chaves[j];
		
		this.chaves[i] = pag.chaves[minimo - 1];
		
		this.numChaves++;
	}
}
