package converterBytes;

import java.nio.ByteBuffer;

public class ConversorDados {
	
	public static byte converteBoolean(boolean valor){
		
		byte b;
		
		b = valor ? (byte) 1 : (byte) 0;
		
		return b;
	}
	
	public static boolean byteParaBoolean(byte b){
		
		boolean valor;
		
		valor = (b == 1) ? true : false;
		
		return valor;
	}
	
	public static byte[] converteShort(short valor){
		
		byte[] b = new byte[2];
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			b[i] = (byte)((valor >> shift) & 0xFF);
		}
		
		return b;
	}
	
	public static short byteParaShort(byte[] b){
		
		short valor = 0;
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			valor += (b[i] & 0x00FF) << shift;
		}
		
		return valor;
	}
	
	public static byte[] converteInt(int valor){
		
		byte[] b = new byte[4];
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			b[i] = (byte)((valor >> shift) & 0xFF);
		}
		
		return b;
	}
	
	public static int byteParaInt(byte[] b){
		
		int valor = 0;
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			valor += (b[i] & 0x000000FF) << shift;
		}
		
		return valor;
	}
	
	public static byte[] convertLong(long valor){
		
		byte[] b = new byte[8];
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			b[i] = (byte)((valor >> shift) & 0xFF);
		}
		
		return b;
	}
	
	public static long byteParaLong(byte[] b){
		
		long valor = 0;
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			valor += (b[i] & 0x00000000000000FF) << shift;
		}
		
		return valor;
	}
	
	public static byte[] converteFloat(float valor){
		
		byte[] b = new byte[4];
		int base = Float.floatToIntBits(valor);
		
		b = converteInt(base);
		
		return b;
	}
	
	public static float byteParaFloat(byte[] b){
		
		int base;
		float valor;
		
		base = byteParaInt(b);
		
		valor = Float.intBitsToFloat(base);
		
		return valor;
	}
	
	public static byte[] converteDouble(double valor){
		
		byte[] b = new byte[8];
		long base = Double.doubleToLongBits(valor);
		
		b = convertLong(base);
		
		return b;
	}
	
	public static double byteParaDouble(byte[] b){
		
		long base;
		double valor;
		
		base = byteParaLong(b);
		
		valor = Double.longBitsToDouble(base);
		
		return valor;
	}

	public static byte[] converteChar(char caractere){
		
		byte[] b = new byte[2];
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			b[i] = (byte)((caractere >> shift) & 0xFF);
		}
		
		return b;
	}
	
	public static char byteParaChar(byte[] b){
		
		char caractere = 0;
		
		for(int i = 0; i < b.length; i++){
			
			int shift = (b.length * 8) - ((i + 1) * 8);
			caractere += (b[i] & 0x00FF) << shift;
		}
		
		return caractere;
	}
	
	public static byte[] converteString(String frase){
		
		ByteBuffer b = ByteBuffer.wrap(frase.getBytes());
		byte []vetor;
		
		vetor = b.array();
		
		return vetor;
	}
	
	public static String byteParaString(byte[] b){
		
		String s = new String(b);
		
		return s;
	}
}
