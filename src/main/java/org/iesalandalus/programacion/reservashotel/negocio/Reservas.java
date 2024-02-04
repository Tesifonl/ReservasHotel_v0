package org.iesalandalus.programacion.reservashotel.negocio;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

public class Reservas {
	
	private int capacidad;
	private int tamano;
	private static Reserva [] coleccionReservas;
    //El atributo reservas debe llamarse coleccionReservas, tal y como indica el diagrama de clases.

    //El constructor no inicializa el atributo capacidad al valor pasado como parámetro. 
	public Reservas (int capacidad) {
		if(capacidad>0) {
			this.capacidad=capacidad;
			coleccionReservas=new Reserva [capacidad];
		}else {throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");}
	}
	

	public Reserva [] get() {
		Reserva[] copia=copiaProfundaReservas();
		return copia;
	}
	
	
	private Reserva [] copiaProfundaReservas() {
		Reserva [] copiaReservas=new Reserva [coleccionReservas.length];
		
		for (int i=0;i<coleccionReservas.length;i++) {
			if (coleccionReservas[i]!=null) {copiaReservas[i]=new Reserva(coleccionReservas[i]);}
			else {copiaReservas[i]=null;}
		}
		return copiaReservas;
	}

	
    //El método getTamano tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public int getTamano() {
		int tamano=0;
		
		for (int i=0;i<coleccionReservas.length;i++) {
		if(coleccionReservas[i]!=null) {tamano++;}
		}
		return tamano;
	}
	
	public int getCapacidad() {
		System.out.println(coleccionReservas.length);
		return coleccionReservas.length;
	}
	
	public void insertar (Reserva reserva) throws OperationNotSupportedException {
		boolean noEncontrado=false;
		
		if(reserva!=null) {
			for (int i=0;i<coleccionReservas.length;i++) {
			if(coleccionReservas[i] != null && coleccionReservas[i].equals(reserva)) {throw new OperationNotSupportedException("ERROR: Ya existe una reserva igual.");}
			else {noEncontrado=true;}}
			
			if(noEncontrado==true && getTamano()<getCapacidad()){coleccionReservas[getTamano()]=reserva;}
			else{throw new OperationNotSupportedException("ERROR: No se aceptan m�s reservas.");} 
			
		}else {throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");}
	}
	
    //En el método buscarIndice, completa el mensaje de error si el objeto pasado como parámero es null.
    //En el método buscarIndice, la sentencia de la línea 95 no sé que sentido tiene.
	public int buscarIndice (Reserva reserva) {
		if(reserva!=null) {
			//int contador=0;
			int posicion=0;
	
			for (int i=0;i<coleccionReservas.length;i++) {
				//contador=i;
				//posicion=contador;
				
				if (coleccionReservas[i]!=null && coleccionReservas[i].equals(reserva)) {posicion=i;}
				//{posicion=0;}
			}
			return posicion;		
		}else {throw new NullPointerException("ERROR:No se puede buscar el indice de una reserva nula");}
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
	
    // En el método buscar, completa el mensaje de error si el objeto pasado como parámero es null.
    // El método buscar tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public Reserva buscar(Reserva reserva) {	
		if(reserva!=null) {
			boolean encontrado=false;
			
			for (int i=0;i<coleccionReservas.length;i++) {
			if(coleccionReservas[i]!=null && coleccionReservas[i].equals(reserva)) {encontrado=true;}}
			
			if (encontrado==true) {return new Reserva(reserva);}else {return null;}
		}else {throw new NullPointerException("ERROR: No se puede buscar una reserva nula");}
	}
	
    // El método borrar tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public void borrar (Reserva reserva) throws OperationNotSupportedException {
		boolean encontrado=false;
		
		if(reserva!=null) {
		int contador=0;
		int indice=0;
			for (int i=0;i<coleccionReservas.length;i++) {
				contador=i;
				if(coleccionReservas[i]!=null && coleccionReservas[i].equals(reserva)){
					encontrado=true;indice=contador;}}
			
			if(encontrado==true){coleccionReservas[indice]=null;	
			desplazarUnaPosicionHaciaIzquierda(indice);}
			else {throw new OperationNotSupportedException("ERROR: No existe ninguna reserva como la indicada.");}	
		
		}else {throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");}
	}
	
	
	public void desplazarUnaPosicionHaciaIzquierda(int indice) {
		
		for (int i=indice;i<coleccionReservas.length-1;i++) {
			coleccionReservas[i]=coleccionReservas[i+1];
			coleccionReservas[coleccionReservas.length-1]=null;}
			
	}
	
	/*El método getReservas de un huesped lo has implementado muy enrevesado. 
	 * Cuando encuentras en el atributo reservas al huesped, añádelo al nuevoArray 
	 * al valor de la variable posicion.
	 */
	public Reserva [] getReservas (Huesped huesped) {
	
		if(huesped!=null) {
			Reserva [] nuevoArray=new Reserva[coleccionReservas.length];
			boolean encontrado=false;
			int posicion=0;
		
			//Recorrer el array de reservas
			for (int i=0;i<coleccionReservas.length;i++) {
				
				//Si el huesped de la reserva coincide con el que buscamos
				if(coleccionReservas[i].getHuesped().equals(huesped)) {
					encontrado = true;
					//Añadimos en la posicion del nuevo array el huesped de la posicion i
					nuevoArray[posicion]=coleccionReservas[i];
					//Incremento la posicion para el siguiente
					posicion++;
				}
			}
				
			if (encontrado == false) {
				return null;
			}
				
			return nuevoArray;
		}
		else {throw new  NullPointerException("ERROR: No se pueden buscar reservas de un huesped nulo.");}
	}
	
    // El método get del tipo de habitación tiene mensajes con sysout. Las clases internas nunca deben escribir nada por pantalla. Borra dichos mensajes para la próxima entrega.
	public Reserva [] getReservas (TipoHabitacion tipoHabitacion) {
		
		if(tipoHabitacion!=null) {
			Reserva [] nuevoArray=new Reserva[coleccionReservas.length];
			boolean encontrado=false;
			int posicion=0;
			
			for (int i=0;i<coleccionReservas.length;i++) {
				
				if(coleccionReservas[i].getHabitacion().getTipoHabitacion().equals(tipoHabitacion)) {
				encontrado=true;
				nuevoArray[posicion]=coleccionReservas[i];
				posicion++;
				}
			}
				
			if (encontrado==false) {
				return null;
			}
			
		return nuevoArray;
		}
		else {throw new  NullPointerException("ERROR: No se pueden buscar reservas de un tipo de habitaci�n nula.");}
	}
	
	
	public Reserva [] getReservasFuturas (Habitacion habitacion) {

	if(habitacion!=null) {
		Reserva [] nuevoArray=new Reserva[coleccionReservas.length];
		boolean encontrado=false;
		int posicion=0;
		
		for (int i=0;i<coleccionReservas.length;i++) 
			if(coleccionReservas[i].getHabitacion().equals(habitacion) && coleccionReservas[i].getFechaInicioReserva().isAfter(LocalDate.now())) {
				//System.out.println(coleccionReservas[i].getHuesped());
				encontrado=true;
				nuevoArray[posicion]=coleccionReservas[i];
				posicion++;
		}
			
		if (encontrado==false) {
			return null;
		}
		
		return nuevoArray;

	}else {throw new  NullPointerException("ERROR: No se pueden buscar reservas de una habitaci�n nula.");}
	}
	
/*
 
    • El atributo reservas debe llamarse coleccionReservas, tal y como indica el diagrama de clases.
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
    • El método getReservas de un huesped lo has implementado muy enrevesado. Cuando encuentras en el atributo reservas al huesped, añádelo al nuevoArray al valor de la variable posicion.
    • Lo mismo te digo para getReservas por tipo de habitación.
    • Idem para getReservasFuturas.
 */
}
