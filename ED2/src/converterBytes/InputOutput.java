package converterBytes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class InputOutput {
	
	//private static String stringDeBytes(String frase){}
	
	public static void encontraNome(String arquivoDat, String nome){
		
		byte[] b;
		Scanner reader;	
		String base = "";
		
		b = ConversorDados.converteString(nome);
		
		for(int i = 0; i < b.length; i++)
			if(i != b.length -1)
				base += Byte.toString(b[i]) + ".";
			else
				base += Byte.toString(b[i]);
		
		
		try {
			reader = new Scanner(new File(arquivoDat));
			
			
			if(reader.findWithinHorizon(base, 0) != null){
				MatchResult mr = reader.match();
				System.out.println(nome + " inicia na posição: " + mr.start() + " e termina na posição: " + mr.end());
			}
			else
				System.err.println("-1");
			
			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
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
					
					if(i != b.length - 1)
						bw.write(Byte.toString(b[i]) + ".");
					else
						bw.write(Byte.toString(b[i]));
				}
				bw.write("*");
			//	System.out.println(sCurrentLine);
			}
			bw.write("*");
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
