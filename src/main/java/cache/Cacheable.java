package cache;

public interface Cacheable {
	
	Object getObject();
	Object getIdentifier();
	boolean isExpired();
	

}
