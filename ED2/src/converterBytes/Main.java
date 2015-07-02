package converterBytes;

import java.util.ArrayList;
import java.io.RandomAccessFile;

import converterBytes.InputOutputRAF;

import java.io.IOException;

import ui.MainFrame;
import metaData.Query;
import juncao.NestedLoop;


public class Main {

	public static void main(String[] args) {
		
//		String dat = "/home/gsegobia/workspace/AA_ED2/src/arquivos/Alunos_bytes.dat";
		
//		InputOutputRAF.converter("/home/gsegobia/workspace/AA_ED2/src/arquivos/Alunos.txt", "/home/gsegobia/workspace/AA_ED2/src/arquivos/Alunos_bytes.dat");
//		InputOutputRAF.converter("/home/gsegobia/workspace/AA_ED2/src/arquivos/Cursos.txt", "/home/gsegobia/workspace/AA_ED2/src/arquivos/Cursos_bytes.dat");
//		InputOutputRAF.converter("/home/gsegobia/workspace/AA_ED2/src/arquivos/DisciplinaHistorico.txt", "/home/gsegobia/workspace/AA_ED2/src/arquivos/DisciplinaHistorico_bytes.dat");
//		InputOutputRAF.converter("/home/gsegobia/workspace/AA_ED2/src/arquivos/Disciplinas.txt", "/home/gsegobia/workspace/AA_ED2/src/arquivos/Disciplinas_bytes.dat");

//		String s = "";
//		int contador = 0;
//
//		
//		try{
//			
//			RandomAccessFile raf = new RandomAccessFile("/home/gsegobia/workspace/AA_ED2/src/arquivos/Alunos_bytes.dat", "r");
//			String base = "";
//			while(raf.getFilePointer() < raf.length()){
//				
//				contador++;
//				base = raf.readUTF();
//				s = base.substring(0, base.length() - 1);
//				System.out.println(s);	
//				
//				if(contador == 100)
//					break;
//			}
//			
//			System.out.println(contador);
//			
//			raf.close();
//		}
//		catch(IOException e){
//			
//			e.printStackTrace();
//		}
		

//		
//		ArrayList<Query> q = InputOutputRAF.searchCol("/home/gsegobia/workspace/AA_ED2/src/arquivos/Alunos_bytes.dat", "2002113902", 3);
//		
//		System.out.println(q.size());
//		
//		System.out.println(q.get(7).dados[0]);
		
//		System.out.println(a.get(0).dados[0]);
		
//		System.out.println(InputOutputRAF.findFirst("D:/GitHub/java-dev/ED2/src/arquivos/Alunos_bytes.dat","2007113902"));
//		String dat = "/home/gsegobia/workspace/AA_ED2/src/arquivos/Disciplinas_bytes.dat";
//		
//		ArrayList<Query> a = InputOutputRAF.searchCol(dat,"1",3);
//		
//		System.out.println(a.get(0).dados[1]);
		
//		String tabela1 = "D:/GitHub/workspaceGit/ED2/src/arquivos/Alunos_bytes.dat";
//		String tabela2 = "D:/GitHub/workspaceGit/ED2/src/arquivos/Cursos_bytes.dat";		
//		
//		NestedLoop.busca(tabela1, tabela2, 1, 0);
//					
//		ArrayList<Query> q = InputOutputRAF.findTuplas("D:/GitHub/workspaceGit/ED2/src/temporarios/temp.dat", "ADMINISTRACAO");
//
//		System.out.println(q.size());
		
		MainFrame frame = new MainFrame();
		
	}
}

