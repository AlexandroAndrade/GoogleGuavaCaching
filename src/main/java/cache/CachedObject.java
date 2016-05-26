package cache;

import java.util.Calendar;
import java.util.Date;

public class CachedObject implements Cacheable {
	
	private Date   dateOfExpiration = null;
	private Object identifier       = null;
	private Object  object           = null;
	
	public CachedObject( Object obj, Object id, int minutesToLive ){
		this.object = obj;
		this.identifier = id;
		if( minutesToLive != 0 ){
			dateOfExpiration = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime( dateOfExpiration );
			cal.add( Calendar.MINUTE, minutesToLive );
			dateOfExpiration = cal.getTime();
		}
	}
	
	public Object getObject() {
		return this.object;
	}
	public Object getIdentifier() {
		return this.identifier;
	}
	
	public boolean isExpired() {
		if( this.dateOfExpiration != null ){
			if( this.dateOfExpiration.before( new Date() ) ) {
				App.escribe( "Cache is Expired --> " + this.object ) ;
				return true;
			}else{
				return false;
			}
		}
		return false;

	}
	
}



