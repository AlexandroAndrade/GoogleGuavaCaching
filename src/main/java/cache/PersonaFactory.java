package cache;

import java.util.ArrayList;
import java.util.List;

public class PersonaFactory {
	
	public static List<Persona> createPersonas( int numOfPersons ){
		
		List<Persona> personas = new ArrayList<Persona>();
		
		for( int i = 1 ; i <= numOfPersons ; i++ ){
			Persona p = new Persona
								.Builder()
								.idPersona( new Long( i ))
								.nombre( Randomizer.createRandomString( 50 ) )
								.apellido( Randomizer.createRandomString( 50 ) )
								.edad( Randomizer.createRandomAge( 80 ) )
								.build();
			personas.add( p );
		}
		return personas;

	}

}
