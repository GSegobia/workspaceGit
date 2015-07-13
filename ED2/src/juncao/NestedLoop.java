package juncao;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import metaData.MetaAlunos;
import metaData.MetaCursos;
import metaData.MetaDisciplinas;
import metaData.MetaHistorico;
import metaData.Metadado;

public class NestedLoop {
	
	private static final String endereco = "D:/GitHub/workspaceGit/ED2/src/arquivos/";
	private static final String tipo = "nested";
	
	public static void join(String tabela1, String colunaPrincipal, String tabela2, String colunaSecundaria) throws IOException{
			
		String base1 = tabela1.toLowerCase();
		String base2 = tabela2.toLowerCase();
		
		File file = new File(endereco + base1 + tipo + base2 + ".dat");
		
		if(file.exists())
			file.delete();
			
		RandomAccessFile tabelaPrincipal = new RandomAccessFile(endereco + base1 + ".dat", "r");
		RandomAccessFile tabelaSecundaria = new RandomAccessFile(endereco + base2 + ".dat", "r");
		RandomAccessFile arquivo = new RandomAccessFile(endereco + base1 + tipo + base2 + ".dat", "rw");
		
		String linhaAtualPrincipal = "";
		String linhaAtualSecundaria = "";
		String []auxiliarSplit;
		String []basePrincipal;
		String []baseSecundaria;
		
		Metadado metaPrincipal = definirMeta(base1);
		Metadado metaSecundaria = definirMeta(base2);

		int posicaoColunaPrincipal = -1;
		int posicaoColunaSecundaria = -1;
		
		if(metaPrincipal != null){
			
			for(int j = 0; j < metaPrincipal.colunas.length; j++){
				
				if(j == 0)
					linhaAtualPrincipal += "*" + base1 + "_" + metaPrincipal.colunas[j] + "\t";
				else
					linhaAtualPrincipal += base1 + "_" + metaPrincipal.colunas[j] + "\t";
			}
			
			posicaoColunaPrincipal = metaPrincipal.nomeColunas.get(colunaPrincipal);
		}
		else{
			
			linhaAtualSecundaria = tabelaPrincipal.readUTF();
			
			if(linhaAtualSecundaria.charAt(0) == '*'){
				
				linhaAtualSecundaria = linhaAtualSecundaria.substring(1, linhaAtualSecundaria.length() -1);
				auxiliarSplit = linhaAtualSecundaria.split("\t");
				
				for(int j = 0; j < auxiliarSplit.length; j++){
					
					if(auxiliarSplit[j].equals(colunaPrincipal)){
						
						posicaoColunaPrincipal = j;
					}
					
					if(j == 0)
						linhaAtualPrincipal += '*' + base1 + '_' + auxiliarSplit[j] + '\t';
					else
						linhaAtualPrincipal += base1 + '_' + auxiliarSplit[j] + '\t';
				}	
			}
		}
		
		if(metaSecundaria != null){
			for(int j = 0; j < metaSecundaria.colunas.length; j++){
				
				if(j != metaSecundaria.colunas.length - 1){
					
					linhaAtualPrincipal += base2 + "_" + metaSecundaria.colunas[j] + "\t";
				}
				else{
					linhaAtualPrincipal += base2 + "_" + metaSecundaria.colunas[j] + "\n";

				}
			}
			
			posicaoColunaSecundaria = metaSecundaria.nomeColunas.get(colunaSecundaria);
		}
		else{
			
			linhaAtualSecundaria = tabelaSecundaria.readUTF();
			
			if(linhaAtualSecundaria.charAt(0) == '*'){
				
				linhaAtualSecundaria = linhaAtualSecundaria.substring(1, linhaAtualSecundaria.length() - 1);
				auxiliarSplit = linhaAtualSecundaria.split("\t");
				
				for(int j = 0; j < auxiliarSplit.length; j++){
					
					if(auxiliarSplit[j].equals(colunaSecundaria)){
						
						posicaoColunaSecundaria = j;
					}
					
					if(j != auxiliarSplit.length)
						linhaAtualPrincipal += base2 + '_' + auxiliarSplit[j] + '\t';
					else
						linhaAtualPrincipal += base2 + '_' + auxiliarSplit[j] + '\n';
				}	
			}
		}
		
		arquivo.writeUTF(linhaAtualPrincipal);
		linhaAtualPrincipal = "";
		linhaAtualSecundaria = "";
		
			while(tabelaPrincipal.getFilePointer() < tabelaPrincipal.length()){
				
				linhaAtualPrincipal = tabelaPrincipal.readUTF();
				linhaAtualPrincipal = linhaAtualPrincipal.substring(0, linhaAtualPrincipal.length() - 1);
				
				basePrincipal = linhaAtualPrincipal.split("\t");

				tabelaSecundaria.seek(0);
				
				
				while((tabelaSecundaria.getFilePointer() < tabelaSecundaria.length())){
					
					linhaAtualSecundaria = tabelaSecundaria.readUTF();
					linhaAtualSecundaria = linhaAtualSecundaria.substring(0, linhaAtualSecundaria.length() - 1);
					
					baseSecundaria = linhaAtualSecundaria.split("\t");
					
					if(baseSecundaria[posicaoColunaSecundaria].equals(basePrincipal[posicaoColunaPrincipal]))
						arquivo.writeUTF(linhaAtualPrincipal + '\t' + linhaAtualSecundaria + '\n');
				}
			
			}
			
			tabelaPrincipal.close();
			tabelaSecundaria.close();
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
