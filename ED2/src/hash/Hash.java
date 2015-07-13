package hash;

public class Hash {
	
	public ElementoHash []elementos;
	
	public Hash(int m){
		elementos = new ElementoHash[m];
		
		for(int i = 0; i < m; i++)
			elementos[i]= new ElementoHash();
	}
	
	private int funcaoDispersao(String chavePrimaria){
		
		return converterHexa(chavePrimaria)%elementos.length;	
	}
	
	public void insereHash(String tupla){
		
		String []split = tupla.split("\t");
		
		int bucketDestino = funcaoDispersao(split[0]);
		
		if(elementos[bucketDestino].conteudo.isEmpty()){
			elementos[bucketDestino].conteudo.add(tupla);
		}
		
		else{
			if(!elementos[bucketDestino].conteudo.contains(tupla))
				elementos[bucketDestino].conteudo.add(tupla);
		}		
	}
	
	public String findHash(String tupla){
		
		int bucketDestino=funcaoDispersao(tupla);
		String dado = "";

		if(elementos[bucketDestino].conteudo.isEmpty()){
			System.out.println("Não possui conteudo nesse bucket");
			return null;
		}
		
		else{
			for(int i=0;i<elementos[bucketDestino].conteudo.size();i++){
				String split[] = elementos[bucketDestino].conteudo.get(i).split("\t");

				if(tupla.equals(split[0])){
					return elementos[bucketDestino].conteudo.get(i);
				}
			}
		}
		
		return dado;
	}

	private int converteChar(char a){
		
		switch(a){
			case '0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'a':
				return 10;
			case 'b':
				return 11;
			case 'c':
				return 12;
			case 'd':
				return 13;
			case 'e':
				return 14;
			case 'f':
				return 15;
			default:
				return -1;
		}
	}
	
	public boolean checaHexa(String chave){
		
		for (int i = 0; i < chave.length(); i++) {
			if (chave.charAt(i)== 'a' || chave.charAt(i)== 'b' || chave.charAt(i)== 'c' || chave.charAt(i)== 'd' || chave.charAt(i)== 'e' || chave.charAt(i)== 'f')
				return true;
		}
		
		return false;

	}
	
	private int converterHexa(String chavePrimaria){
		String split[] = chavePrimaria.split("-");
		
		int valor=0;
		
		for (int i = 0; i < split.length; i++) {
			for(int j=0;j<split[i].length();j++){
				valor+=converteChar(split[i].charAt(j));
			}	
		}	
		return valor;
	}
}