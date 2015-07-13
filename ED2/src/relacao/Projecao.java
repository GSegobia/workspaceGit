package relacao;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import metaData.MetaAlunos;
import metaData.MetaCursos;
import metaData.MetaDisciplinas;
import metaData.MetaHistorico;
import metaData.Metadado;

public class Projecao {
	
	private static final String endereco = "D:/GitHub/workspaceGit/ED2/src/arquivos/";
	private static final String tipo = "projecao";
	
	public static void projecao(String tabela, String coluna) throws IOException{
		
		String base = tabela.toLowerCase();

		File file = new File(endereco + tipo + base + ".dat");
		
		if(file.exists())
			file.delete();
;
		
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
			
			posicaoColuna = metaPrincipal.nomeColunas.get(coluna);
			
			linhaAtualPrincipal = '*' + metaPrincipal.colunas[posicaoColuna] + '\n';
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
				}
				
				linhaAtualPrincipal = '*' + auxiliarSplit[posicaoColuna] + '\n';
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
				
			arquivo.writeUTF(auxiliarSplit[posicaoColuna] + '\n');
		}
		
		arquivo.close();
		tabelaPrincipal.close();
		
	}

	public static void projecao(String tabela, String coluna, String colunaSecundaria) throws IOException{

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
		int posicaoColunaSecundaria = -1;
		
		if(metaPrincipal != null){
			
			posicaoColuna = metaPrincipal.nomeColunas.get(coluna);
			posicaoColunaSecundaria = metaPrincipal.nomeColunas.get(colunaSecundaria);
			
			linhaAtualPrincipal = '*' + metaPrincipal.colunas[posicaoColuna] + '\t' + metaPrincipal.colunas[posicaoColunaSecundaria] +'\n';
		}
		else{
			
			linhaAtualSecundaria = tabelaPrincipal.readUTF();
			
			if(linhaAtualSecundaria.charAt(0) == '*'){
				
				linhaAtualSecundaria = linhaAtualSecundaria.substring(1, linhaAtualSecundaria.length() - 1);
				auxiliarSplit = linhaAtualSecundaria.split("\t");

				for(int j = 0; j < auxiliarSplit.length; j++){
					
					if(auxiliarSplit[j].equals(coluna))
						posicaoColuna = j;
					
					if(auxiliarSplit[j].equals(colunaSecundaria))
						posicaoColunaSecundaria = j;
					
					System.out.println(auxiliarSplit[j]);
				}
				
				linhaAtualPrincipal = '*' + auxiliarSplit[posicaoColuna] + '\t' + auxiliarSplit[posicaoColunaSecundaria] +'\n';
			}
		}

		arquivo.writeUTF(linhaAtualPrincipal);
		linhaAtualPrincipal = "";
		linhaAtualSecundaria = "";
		
		System.out.println(posicaoColuna);
		System.out.println(posicaoColunaSecundaria);

		while(tabelaPrincipal.getFilePointer() < tabelaPrincipal.length()){
				
			base = tabelaPrincipal.readUTF();
			base = base.substring(0, base.length() - 1);
				
			auxiliarSplit = base.split("\t");	
				
			arquivo.writeUTF(auxiliarSplit[posicaoColuna] + '\t' + auxiliarSplit[posicaoColunaSecundaria] +'\n');
		}
		
		arquivo.close();
		tabelaPrincipal.close();	
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
