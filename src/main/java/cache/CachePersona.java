package cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CachePersona {
	
	private CachePersona(){}
	
	public static LoadingCache<Long, Persona> personasCache;
	private static List<Persona> personasDataBase = new ArrayList<Persona>();
	
	static{
		
		personasDataBase.addAll( PersonaFactory.createPersonas( 1000 ) );
		
		personasCache = CacheBuilder.newBuilder()
				.maximumSize( 100 )
				.expireAfterWrite(  30, TimeUnit.MINUTES )
				.expireAfterAccess( 30, TimeUnit.MINUTES )
				.build(
						new CacheLoader<Long, Persona>(){
							
							@Override
							public Persona load(Long idPersona) throws Exception {
								return getPersonaById( idPersona );
							}
						}
				);
	}
	
	public static Persona retievePersonaById( Long idPesona ) throws ExecutionException {
		return personasCache.get( idPesona );
	}
	
	public static Persona getPersonaById( Long idPersona ){
		
		if( idPersona == null || idPersona <= 0 ){
			return null;
		}
		
		for( Persona p : personasDataBase ) {
			if( p.getIdPersona().longValue() == idPersona.longValue() ){
				return p;
			}
		}
		return null;
	} 

}
