package cache;

import java.util.Random;

public class Randomizer {
	
	private static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	private static Random r = new Random();
	
	public static String createRandomString( int length ){
		StringBuilder sb = new StringBuilder( length );
		
		for( int i = 1 ; i <= length ; i++ ){
			sb.append( 
					letters.charAt( 
							r.nextInt(
									letters.length() ) ) );
		}
		return sb.toString();
	}
	
	public static int createRandomAge( int maxAge ){
		return r.nextInt( maxAge ) + 1 ;
	}

}
