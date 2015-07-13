package principal;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import juncao.HashJoin;
import juncao.MergeNested;
import juncao.NestedLoop;
import relacao.Projecao;
import relacao.Selecao;

public class Querys {
	
	private static final String endereco = "D:/GitHub/workspaceGit/ED2/src/arquivos/";
	private static final String enderecoResposta = "D:/GitHub/workspaceGit/ED2/src/respostas/";
	
	public static void query1(String curso) throws IOException{
		
		String nomeCurso = curso.toUpperCase();
		
		MergeNested.join("Cursos", "id", "Alunos", "curso_id");
		Selecao.selecao("cursosmergealunos", "cursos_nome", nomeCurso);
		Projecao.projecao("selecaocursosmergealunos", "alunos_matricula","alunos_nome");
		
		gerarResposta("projecaoselecaocursosmergealunos", "query1");
	}
	
	public static void query2(String matricula) throws IOException{
		
		Selecao.selecao("Historico", "nota", "10");
		NestedLoop.join("selecaohistorico", "disciplina_id", "Disciplinas", "id");
		HashJoin.join("Alunos", "selecaohistoriconesteddisciplinas", "selecaohistorico_aluno_id");
		Selecao.selecao("alunoshashselecaohistoriconesteddisciplinas", "alunos_matricula", matricula);
		Projecao.projecao("selecaoalunoshashselecaohistoriconesteddisciplinas", "selecaohistoriconesteddisciplinas_disciplinas_nome");
		
		gerarResposta("projecaoselecaoalunoshashselecaohistoriconesteddisciplinas", "query2");
	}
	
	public static void query3(String matricula, String ano, String periodo) throws IOException{
		
		Selecao.selecao("Alunos", "matricula", matricula);
		NestedLoop.join("selecaoalunos", "id", "Historico", "aluno_id");
		NestedLoop.join("selecaoalunosnestedhistorico", "historico_disciplina_id", "Disciplinas", "id");
		Selecao.selecao("selecaoalunosnestedhistoriconesteddisciplinas", "selecaoalunosnestedhistorico_historico_ano", ano);
		Selecao.selecao("selecaoselecaoalunosnestedhistoriconesteddisciplinas", "selecaoalunosnestedhistorico_historico_periodo", periodo);
		Projecao.projecao("selecaoselecaoselecaoalunosnestedhistoriconesteddisciplinas", "disciplinas_nome", "selecaoalunosnestedhistorico_historico_nota");
		
		gerarResposta("projecaoselecaoselecaoselecaoalunosnestedhistoriconesteddisciplinas", "query3");
	}
	
	private static void gerarResposta(String resposta, String query) throws IOException{
		
		File file = new File(enderecoResposta + query + ".txt");
		
		if(file.exists())
			file.delete();
		
		RandomAccessFile r = new RandomAccessFile(endereco + resposta + ".dat", "r");
		PrintWriter pw = new PrintWriter(enderecoResposta + query + ".txt");
		
		String base = "";
		
		r.readUTF();
		
		while(r.getFilePointer() < r.length()){
			
			base = r.readUTF();
			pw.print(base);	
		}
		
		r.close();
		pw.close();
	}
}
