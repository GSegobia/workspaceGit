package metaData;

import java.util.HashMap;
import java.util.Map;

public class MetaDisciplinas extends Metadado{

	private static Map<String, Integer> dados = new HashMap<String, Integer>();
	private static String []colunas;

	static{
		
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		
		
		aMap.put("id", 0);
		aMap.put("nome", 1);
		aMap.put("curso_id", 2);
	
		dados = aMap;		
	}
	
	static{
		
		String []col = {"id", "nome","curso_id"};
		colunas = col;
	}

	public MetaDisciplinas(){

		super(3, 303, dados, true, "id", null, colunas);
	}
}