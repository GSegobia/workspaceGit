package converterBytes;

import java.io.IOException;
import java.io.RandomAccessFile;

public class InputOutputRAF {
	
	public static void converter(String names, String dat){
		
		try{
			
			RandomAccessFile fileToRead = new RandomAccessFile(names, "rw");
			RandomAccessFile fileToWrite = new RandomAccessFile(dat, "rw");
			
			String currentLine="";
			
			while((currentLine = fileToRead.readLine()) != null)
				fileToWrite.writeUTF(currentLine + '\n');

			
			fileToRead.close();
			fileToWrite.close();		
		}
		catch (IOException e){
			
			e.printStackTrace();
		}	
	}
}