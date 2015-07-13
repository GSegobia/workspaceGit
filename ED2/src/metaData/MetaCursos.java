package metaData;

import java.util.HashMap;
import java.util.Map;

public class MetaCursos extends Metadado{

	private static Map<String, Integer> dados = new HashMap<String, Integer>();
	private static int []posicao;
	private static String []colunas;

	static{
		
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		
		
		aMap.put("id", 0);
		aMap.put("nome", 1);
		
		dados = aMap;		
	}
	
	static{
		
		int []aInt = {308, 581, 853, 1153, 1452, 1721, 2000};
		posicao = aInt;
	}
	
	static{
		
		String []col = {"id", "nome"};
		colunas = col;
	}
	
	public MetaCursos(){

		super(4, 2000, dados, true, "id", posicao, colunas);
	}
}