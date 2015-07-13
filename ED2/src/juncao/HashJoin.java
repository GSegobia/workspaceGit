package juncao;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

import hash.*;
import metaData.*;

public class HashJoin {
	
	private static final String endereco = "D:/GitHub/workspaceGit/ED2/src/arquivos/";
	private static final String tipo = "hash";
	
	public static void join(String tabela1, String tabela2, String colunaSecundaria) throws IOException{
		
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
		
		Metadado metaHash = definirMeta(base1);
		Metadado metaSecundaria = definirMeta(base2);
		
		int posicaoColunaSecundaria = -1;
		
		if(metaHash != null){
			
			for(int j = 0; j < metaHash.colunas.length; j++){
				
				if(j == 0)
					linhaAtualPrincipal += "*" + base1 + "_" + metaHash.colunas[j] + "\t";
				else
					linhaAtualPrincipal += base1 + "_" + metaHash.colunas[j] + "\t";
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
		
		Hash hash = new Hash(metaHash.numLinhas);
		
		while(tabelaPrincipal.getFilePointer() < tabelaPrincipal.length()){
			
			linhaAtualPrincipal = tabelaPrincipal.readUTF();
			linhaAtualPrincipal = linhaAtualPrincipal.substring(0, linhaAtualPrincipal.length() - 1);
			hash.insereHash(linhaAtualPrincipal);
		}
		
		while(tabelaSecundaria.getFilePointer() < tabelaSecundaria.length()){
			
			linhaAtualSecundaria = tabelaSecundaria.readUTF();
			linhaAtualSecundaria = linhaAtualSecundaria.substring(0, linhaAtualSecundaria.length() - 1);
			auxiliarSplit = linhaAtualSecundaria.split("\t");
			
			linhaAtualPrincipal = hash.findHash(auxiliarSplit[posicaoColunaSecundaria]);
			
			arquivo.writeUTF(linhaAtualPrincipal + '\t' + linhaAtualSecundaria + '\n');
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
