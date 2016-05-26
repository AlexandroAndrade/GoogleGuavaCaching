package cache;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public class App {
	
	public static void main( String[] params ) {
		
		escribe( "Cache Size : " + CachePersona.personasCache.size() );
		
		try{
			
			
			Persona cachedPersona = CachePersona.retievePersonaById( 1L ) ;
			escribe( cachedPersona );
			
			escribe( "Cache Size : " + CachePersona.personasCache.size() );
			
			
			cachedPersona = CachePersona.retievePersonaById( 1L );
			escribe( cachedPersona );
			
			for( long l = 1L; l <= 1000 ; l++ ){
				cachedPersona = CachePersona.retievePersonaById( l );
				escribe( cachedPersona ) ;
			}
			escribe( "Cache Size : " + CachePersona.personasCache.size() );

		}catch( ExecutionException ee ){
			escribe( "Execution Exception : " + ee.getMessage() ) ;
		}catch( Exception e ){
			escribe( "Some Other Exception Ocurred : " + e.getMessage() ) ;
		}
		
		
	}
	
	public static void escribe( Object o ) {
		System.out.println( o );
	}

}
