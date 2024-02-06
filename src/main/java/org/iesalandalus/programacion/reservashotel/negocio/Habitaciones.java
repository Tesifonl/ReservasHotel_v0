package org.iesalandalus.programacion.reservashotel.negocio;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;


public class Habitaciones {
	
	private int capacidad;
	private int tamano;
	private static Habitacion [] coleccionHabitaciones;
	//El atributo habitaciones debe llamarse coleccionHabitaciones, tal y como indica el diagrama de clases.
	
	//El constructor no inicializa el atributo capacidad al valor pasado como parámetro.
	public Habitaciones(int capacidad) {
		if(capacidad>0) {
			this.capacidad=capacidad;
			coleccionHabitaciones=new Habitacion [capacidad];
		}else {throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");}
	}
	

	public Habitacion [] get() {
		Habitacion[] copia=copiaProfundaHabitaciones();
		return copia;
	}
	
	
	private Habitacion [] copiaProfundaHabitaciones() {
		Habitacion [] copiahabitaciones=new Habitacion [coleccionHabitaciones.length];
		
		for (int i=0;i<coleccionHabitaciones.length;i++) {
			if (coleccionHabitaciones[i]!=null) {
				copiahabitaciones[i]=new Habitacion(coleccionHabitaciones[i]);}
		else {
			copiahabitaciones[i]=null;}
		}
		return copiahabitaciones;
	}

    //El método get del tipo de habitación tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public Habitacion [] get (TipoHabitacion tipoHabitacion) {
		
		if(tipoHabitacion!=null) {
			Habitacion [] nuevoArray=new Habitacion[coleccionHabitaciones.length];
			int contador=0;
			
			for (int i=0;i<coleccionHabitaciones.length;i++) {
				if(coleccionHabitaciones[i].getTipoHabitacion().equals(tipoHabitacion)) {
					contador++;
					nuevoArray[contador]=coleccionHabitaciones[i];
				}
			
			}return nuevoArray;
		}else {throw new  NullPointerException("ERROR: No se puede insertar un hu�sped nulo.");}
	}
	
    //El método getTamano tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public int getTamano() {
		int tamano=0;
		
		for (int i=0;i<coleccionHabitaciones.length;i++) {
		if(coleccionHabitaciones[i]!=null) {tamano++;}
		}
		return tamano;
	}
	
	public int getCapacidad() {
		System.out.println(coleccionHabitaciones.length);
		return coleccionHabitaciones.length;
	}
	
	public void insertar (Habitacion habitacion) throws OperationNotSupportedException {
		boolean noEncontrado=false;
		
		if(habitacion!=null) {
			for (int i=0;i<coleccionHabitaciones.length;i++) {
			if(coleccionHabitaciones[i] != null && coleccionHabitaciones[i].equals(habitacion)) {throw new OperationNotSupportedException("ERROR: Ya existe una habitaci�n con ese identificador.");}
			else {noEncontrado=true;}}
			
			if(noEncontrado==true && getTamano()<getCapacidad()){coleccionHabitaciones[getTamano()]=habitacion;}
			else{throw new OperationNotSupportedException("ERROR: No se aceptan m�s habitaciones.");} 
			
		}else {throw new NullPointerException("ERROR: No se puede insertar una habitaci�n nula.");}
	}
	
	//En el método buscarIndice, completa el mensaje de error si el objeto pasado como parámero es null.
	//En el método buscarIndice, la sentencia de la línea 95 no sé que sentido tiene.
	public int buscarIndice (Habitacion habitacion) {
		if(habitacion!=null) {
			//int contador=0;
			int posicion=0;
	
			for (int i=0;i<coleccionHabitaciones.length;i++) {
				//contador=i;
				//posicion=contador;
				
				if (coleccionHabitaciones[i]!=null && coleccionHabitaciones[i].equals(habitacion)) {posicion=i;}
				//{posicion=0;}
			}
			return posicion;		
		}else {throw new NullPointerException("ERROR: No se puede buscar un indice de una habitacion nula");}
	}
	
    //El método no se llama tamañoSuperado, se llama tamanoSuperado. Ten en cuenta que la ñ y las letras con tildes no las puedes poner como identificadores.
	public boolean tamanoSuperado(int indice) {
		boolean superado=false;
		
		if (indice> getTamano()) {superado=true;}
		else{superado=false;}
		
		return superado;
	}
	
	public boolean capacidadSuperada(int indice) {
		boolean superado=false;
		
		if (indice> getCapacidad()) {superado=true;}
		else{superado=false;}
		
		return superado;
	}
	
	//En el método buscar, completa el mensaje de error si el objeto pasado como parámero es null.
    //El método buscar tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public Habitacion buscar(Habitacion habitacion) {	
		if(habitacion!=null) {
			boolean encontrado=false;
			
			for (int i=0;i<coleccionHabitaciones.length;i++) {
			if(coleccionHabitaciones[i]!=null &&coleccionHabitaciones[i].equals(habitacion)) {encontrado=true;}}
			
			if (encontrado==true) {return new Habitacion (habitacion);}else {return null;}
		}else {throw new NullPointerException("ERROR: No se puede buscar una habitacion nula");}
	}
	
    //El método borrar tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public void borrar (Habitacion habitacion) throws OperationNotSupportedException {
		boolean encontrado=false;
		
		if(habitacion!=null) {
		int contador=0;
		int indice=0;
			for (int i=0;i<coleccionHabitaciones.length;i++) {
				contador=i;
				if(coleccionHabitaciones[i]!=null && coleccionHabitaciones[i].equals(habitacion)) {
				encontrado=true;indice=contador;}}
						
			if(encontrado==true){coleccionHabitaciones[indice]=null;
			desplazarUnaPosicionHaciaIzquierda(indice);}
			else {throw new OperationNotSupportedException("ERROR: No existe ninguna habitaci�n como la indicada.");}	
		
		}else {throw new NullPointerException("ERROR: No se puede borrar una habitaci�n nula.");}
	}
	
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<coleccionHabitaciones.length-1;i++) {
			coleccionHabitaciones[i]=coleccionHabitaciones[i+1];
			coleccionHabitaciones[coleccionHabitaciones.length-1]=null;}
			
	}
	
	/*
	 
    • El atributo habitaciones debe llamarse coleccionHabitaciones, tal y como indica el diagrama de clases.
    • El constructor no inicializa el atributo capacidad al valor pasado como parámetro. 
    • El método no se llama tamañoSuperado, se llama tamanoSuperado. Ten en cuenta que la ñ y las letras con tildes no las puedes poner como identificadores.
    • El método get del tipo de habitación tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
    • El método getTamano tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
    • En el método buscarIndice, completa el mensaje de error si el objeto pasado como parámero es null.
    • En el método buscarIndice, la sentencia de la línea 95 no sé que sentido tiene.
    • En el método buscar, completa el mensaje de error si el objeto pasado como parámero es null.
    • El método buscar tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
    • El método borrar tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
    • La clase no tiene el código correctamente indentado.
	 */
}


