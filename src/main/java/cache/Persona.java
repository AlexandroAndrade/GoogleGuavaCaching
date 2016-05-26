package cache;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Persona {
	
	private Long idPersona;
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona( Long idPersona, String nombre, String apellido, int edad ) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	private Persona(Builder builder){
		this.idPersona = builder.idPersona;
		this.nombre = builder.nombre;
		this.apellido = builder.apellido;
		this.edad = builder.edad;
	}
	
	/**
	 * @return the idPersona
	 */
	public Long getIdPersona() {
		return idPersona;
	}
	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public boolean equals( Object o ){
		
		if( o == null || ! ( o instanceof Persona ) ) {
			return false;
		}
		
		if( this == o ){
			return true;
		}
		
		Persona p = ( Persona ) o ;
		return new EqualsBuilder().append( this.idPersona , p.idPersona ).isEquals();

	}

	@Override
	public String toString(){
		return new ToStringBuilder( this, ToStringStyle.NO_CLASS_NAME_STYLE )
			.append( "idPersona", this.idPersona )
			.append( "Nombre"   , this.nombre    )
			.append( "Apellido" , this.apellido  )
			.append( "Edad"     , this.edad      ).toString();

	}
	
	public int hashCode(){
		return new HashCodeBuilder().append( this.idPersona ).hashCode();
	}
	
	
	public static class Builder{
			
		private Long idPersona;
		private String nombre;
		private String apellido;
		private int edad;
		
		
		public Builder idPersona( Long idPersona ) {
			this.idPersona = idPersona;
			return this;
		}
		
		public Builder nombre( String nombre ) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder apellido( String apellido ) {
			this.apellido = apellido;
			return this;
		} 
		
		public Builder edad( int edad ) {
			this.edad = edad;
			return this;
		}
		
		public Persona build(){
			return new Persona( this );
		}
		
	}

}