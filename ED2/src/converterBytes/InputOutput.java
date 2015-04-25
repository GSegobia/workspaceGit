package converterBytes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutput {
	
	//private static String stringDeBytes(String frase){}
	
	public static void encontraNome(String path, String nome){
	
		BufferedReader br = null;
		String finalString=new String();
		String convertidoNome = new String();
		
		byte[] b;
		
		b = ConversorDados.converteString(nome);

		for(int i = 0; i < b.length; i++)
			convertidoNome += Byte.toString(b[i]);
			

		try {
			String sCurrentLine;
			
			br = new BufferedReader(new FileReader(path));
 
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.compareTo(convertidoNome)==0){
					System.out.println("Achei esta caralha");
					break;
				}
						
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	public static void lerArquivo(String arquivoNomes, String arquivoDat){
		
		BufferedReader br = null;
		
		try {
			
			String sCurrentLine;
			byte[] b;
			
			File file = new File(arquivoDat);
			
			if (!file.exists())
				file.createNewFile();
			
			
			br = new BufferedReader(new FileReader(arquivoNomes));
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			while ((sCurrentLine = br.readLine()) != null) {
				
				b = ConversorDados.converteString(sCurrentLine);
				
				for(int i = 0; i < b.length; i++){
						bw.write(Byte.toString(b[i]));
				}
				bw.write("\n");
			//	System.out.println(sCurrentLine);
			}
			bw.close();
 
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
