package cache;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {
	
	private static Map<Object, Cacheable> mapaPersonas =
			new ConcurrentHashMap<Object, Cacheable>();
	
//	static{
//		try{
//			Thread threadCleanerUpper =
//					new Thread(new Runnable() {
//						
//						//1 Minute
//						int milliSecondSleepTime = 5000;
//						
//						public void run() {
//							try{
//								while( true ){
//									Set<Object> keySet = mapaPersonas.keySet();
//									Iterator<Object> iterator = keySet.iterator();
//									while( iterator.hasNext() ){
//										Object idPersona = iterator.next();
//										Cacheable cachedObject = mapaPersonas.get(idPersona);
//										if( cachedObject.isExpired() ){
//											iterator.remove();
//										}
//									}
//									Thread.sleep( this.milliSecondSleepTime );
//								}
//							}catch( Exception e ){
//								App.escribe( e.getMessage() );
//							}
//							return;
//						}
//					});
//			
//			threadCleanerUpper.setPriority( Thread.MIN_PRIORITY );
//			threadCleanerUpper.start();
//			
//			
//		}catch( Exception e ){
//			App.escribe( e.getMessage() );
//		}
//		
//	}

	public static void putCache(Cacheable objectToCache ){
		mapaPersonas.put( objectToCache.getIdentifier(), objectToCache );
	}
	
	public static Cacheable getCacheable( Object identifier ){
		Cacheable object = mapaPersonas.get( identifier );
		if( object == null ){
			return null;
		}
		if( object.isExpired() ){
			mapaPersonas.remove( identifier );
			return null;
		}
		return object;
	}
	
}
