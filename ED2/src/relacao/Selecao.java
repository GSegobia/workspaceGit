package relacao;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import metaData.*;

public class Selecao {
	
	private static final String endereco = "D:/GitHub/workspaceGit/ED2/src/arquivos/";
	private static final String tipo = "selecao";
	
	public static void selecao(String tabela, String coluna,String compara) throws IOException{
		
		String base = tabela.toLowerCase();

		File file = new File(endereco + tipo + base + ".dat");
		
		if(file.exists())
			file.delete();
	
		RandomAccessFile tabelaPrincipal = new RandomAccessFile(endereco + base + ".dat", "r");
		RandomAccessFile arquivo = new RandomAccessFile(endereco + tipo + base + ".dat", "rw");
		
		String linhaAtualPrincipal = "";
		String linhaAtualSecundaria = "";
		String []auxiliarSplit;
		
		Metadado metaPrincipal = definirMeta(base);
		
		if(metaPrincipal == null)
			System.out.println("Eh null");

		int posicaoColuna = -1;
		
		if(metaPrincipal != null){
			
			for(int j = 0; j < metaPrincipal.colunas.length; j++){
				
				if(j == 0)
					linhaAtualPrincipal += "*" + metaPrincipal.colunas[j] + "\t";
				else if(j == metaPrincipal.colunas.length - 1)
					linhaAtualPrincipal += metaPrincipal.colunas[j] + "\n";
				else
					linhaAtualPrincipal += metaPrincipal.colunas[j] + "\t";
			}
			
			posicaoColuna = metaPrincipal.nomeColunas.get(coluna);

		}
		else{
			
			linhaAtualSecundaria = tabelaPrincipal.readUTF();
			
			if(linhaAtualSecundaria.charAt(0) == '*'){
				
				linhaAtualSecundaria = linhaAtualSecundaria.substring(1, linhaAtualSecundaria.length() - 1);
				auxiliarSplit = linhaAtualSecundaria.split("\t");
				
				for(int j = 0; j < auxiliarSplit.length; j++){
					
					if(auxiliarSplit[j].equals(coluna)){
						
						posicaoColuna = j;
					}
					
					if(j == 0)
						linhaAtualPrincipal += "*" + auxiliarSplit[j] + '\t';
					else if(j == auxiliarSplit.length - 1)
						linhaAtualPrincipal += auxiliarSplit[j] + '\n';
					else
						linhaAtualPrincipal +=  auxiliarSplit[j] + '\t';
				}	
			}
		}

		arquivo.writeUTF(linhaAtualPrincipal);
		linhaAtualPrincipal = "";
		linhaAtualSecundaria = "";
		
		System.out.println(posicaoColuna);

		while(tabelaPrincipal.getFilePointer() < tabelaPrincipal.length()){
				
			base = tabelaPrincipal.readUTF();
			base = base.substring(0, base.length() - 1);
			
			auxiliarSplit = base.split("\t");
				
			if(auxiliarSplit[posicaoColuna].equals(compara))
				arquivo.writeUTF(base + '\n');
		}
			
		tabelaPrincipal.close();
		arquivo.close();	
	}
	
	private static Metadado definirMeta(String nome){
		
		Metadado m = null;
		
		switch (nome) {
		case "alunos":
			m = new MetaAlunos();
			return m;
		case "historico":
			m = new MetaHistorico();
			return m;
		case "cursos":
			m = new MetaCursos();
			return m;
		case "disciplinas":
			m = new MetaDisciplinas();
			return m;
		default:
			return m;
		}
	}
}
