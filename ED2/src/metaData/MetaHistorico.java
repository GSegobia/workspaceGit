package metaData;

import java.util.HashMap;
import java.util.Map;

public class MetaHistorico extends Metadado{

	private static Map<String, Integer> dados = new HashMap<String, Integer>();
	private static String []colunas;

	static{
		
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		
		
		aMap.put("id", 0);
		aMap.put("aluno_id", 1);
		aMap.put("disciplina_id", 2);
		aMap.put("nota", 3);
		aMap.put("ano", 4);
		aMap.put("periodo", 5);
		aMap.put("situacao", 6);
		
		dados = aMap;		
	}
	
	static{
		
		String []col = {"id", "aluno_id", "disciplina_id", "nota", "ano", "periodo", "situacao"};
		colunas = col;
	}

	public MetaHistorico(){

		super(7, 120056, dados, false, null, null, colunas);
	}
}
