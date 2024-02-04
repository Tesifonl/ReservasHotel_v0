package org.iesalandalus.programacion.reservashotel;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.negocio.Reservas;
import org.iesalandalus.programacion.reservashotel.vista.Consola;
import org.iesalandalus.programacion.reservashotel.vista.Opcion;

public class MainApp {
    
	public static final int CAPACIDAD=100;
	public static Huespedes huespedes;
	public static Habitaciones habitaciones;
	public static Reservas reservas;
	//Indicamos variables static para que se puedan utilizar en los metodos
	//static de la clase MainApp.
	//Los metodos de la clase MainApp son static para que se puedan utilizar en el main
	//sin necesidad de llamarlos con un objeto MainApp
	
	private static void ejecutarOpcion(Opcion opcion) throws OperationNotSupportedException {

		do {

			if (opcion.equals(Opcion.INSERTAR_HUESPED)) {
				insertarHuesped();
			}
			
			if (opcion.equals(Opcion.BUSCAR_HUESPED)) {
				buscarHuesped();
			}
			
			if (opcion.equals(Opcion.BORRAR_HUESPED)) {
				borrarHuesped();
			}
			
			if (opcion.equals(Opcion.MOSTRAR_HUESPEDES)) {
				mostrarHuespedes();
			}
			
			if (opcion.equals(Opcion.INSERTAR_HABITACION)) {
				insertarHabitacion();
			}
			
			if (opcion.equals(Opcion.BUSCAR_HABITACION)) {
				buscarHabitacion();
			}
				
			if (opcion.equals(Opcion.BORRAR_HABITACION)) {
				borrarHabitacion();
			}		
			
			if (opcion.equals(Opcion.MOSTRAR_HABITACIONES)) {
				mostrarHabitacion(); }
			
			if (opcion.equals(Opcion.INSERTAR_RESERVA)) {
				insertarReserva();
			}
			
			if (opcion.equals(Opcion.ANULAR_RESERVA)) {
				anularReserva();
				}
		
			if (opcion.equals(Opcion.MOSTRAR_RESERVAS)) {
				mostrarReservas();
			}
			
			if (opcion.equals(Opcion.CONSULTAR_DISPONIBILIDAD)) {reservas.getReservas(Consola.leerTipoHabitacion());}

		} while(opcion!=Opcion.SALIR);
	}
	
	private static void insertarHuesped() {
		try{
			huespedes.insertar(Consola.leerHuesped());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void buscarHuesped() {
		try{
			huespedes.buscar(Consola.getHuespedPorDni());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void borrarHuesped() {
		try{
			huespedes.borrar(Consola.getHuespedPorDni());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void mostrarHuespedes() {
		if(huespedes.getTamano()>0) {
			System.out.println(huespedes.get());
		}
		else {
			System.out.println("No hay ningun huesped");
		} 
	}
	
	public static void insertarHabitacion() {
		try{habitaciones.insertar(Consola.leerHabitacion());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
		}
	
	public static void buscarHabitacion() {
		try{habitaciones.buscar(Consola.leerHabitacionPorIdentificador());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
	}
	
	public static void borrarHabitacion() {
		try{habitaciones.borrar(Consola.leerHabitacionPorIdentificador());
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
	}
	
	public static void mostrarHabitacion() {
		if(habitaciones.getTamano()>0) {
			
			Habitacion [] listaHabitaciones = habitaciones.get();
			
			//Bucle que las muestra
			for (int i = 0; i < listaHabitaciones.length; i++) {
				System.out.println(listaHabitaciones[i]);
			}
			
		}
		else {System.out.println("No hay ningun huesped");}
	}
	
	public static void insertarReserva() {
		try{
			Reserva nuevaReserva = Consola.leerReserva();
		
			if (consultarDisponibilidad(nuevaReserva.getHabitacion().getTipoHabitacion(), 
					                    nuevaReserva.getFechaInicioReserva(),
					                    nuevaReserva.getFechaFinReserva()) != null){
				reservas.insertar(nuevaReserva);
			}
			else {
				System.out.println("No hay disponibilida para las fechas solicitadas en la reserva.");
			}
		}
		catch(OperationNotSupportedException e){
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());}
	}
	
	public static void listarReservas(Huesped huesped) {
		/*pdte*/
		//Llamamos al metodo getReservas de la la clase Reservas que busca
		//las reservas para el huesped
		Reserva[] listadoReservas = reservas.getReservas(huesped);
		
		//Si el metodo nos ha devuelto un listado distinto de null
		if (listadoReservas != null) {
			
			//Bucle que las muestra segun el toString de Reserva
			for (int i = 0; i < listadoReservas.length; i++) {
				System.out.println(listadoReservas[i]);
			}
		}
		//Si no tienes reservas mostramos mensaje
		else {
			System.out.println("No existen reservas para ese huesped.");
		}
	
	}
	
	public static void listarReservas(TipoHabitacion tipoHabitacion) {
		/*pdte*/
	}
	
	public static Reserva[] getReservasAnulables(Reserva [] reservasAAnular) {
		
		Reserva[] listaAnulables = new Reserva[reservasAAnular.length];
		int posicion = 0;
		
		//Reccorremos lista reservas a anular
		for (int i = 0; i < reservasAAnular.length; i++) {
			
			//si la fecha de inicio es posterior a la de hoy
			if(reservasAAnular[i].getFechaInicioReserva().isAfter(LocalDate.now())) {
				//Añado la reserva a la lista
				listaAnulables[posicion] = reservasAAnular[i];
				posicion++;
			}		
		}
		
		if (posicion > 0) {
			return listaAnulables; 
		}
		else {
			return null;
		}
	}
	
	public static void anularReserva() throws OperationNotSupportedException {
		
		//Recogemos las reservas del huesped según su DNI
		Reserva [] reservaHuesped=reservas.getReservas(Consola.getHuespedPorDni());
		
		//Si tiene reservas
		if (reservaHuesped.length > 0) {
			
			//Filtrar aquellas reservas que son anulables
			Reserva [] reservaAnulables=getReservasAnulables(reservaHuesped);
			
			//Si tiene reservas que son anulables
			if (reservaAnulables.length > 0) {

				//Recorremos la lista de reservas anulables
				for (int i=0;i<reservaAnulables.length;i++) {
					//Si la reserva anulable tiene datos
					if (reservaAnulables[i]!=null) {
						//borro la reserva de la lista general
						reservas.borrar(reservaAnulables[i]);
					}
				}
			}
			else {
				System.out.println("No existe ninguna reserva anulable para este huesped");
			}
		}
		else {
			System.out.println("No existe ninguna reserva para este huesped");
		}
	}
	
	public static void mostrarReservas() {
		if(reservas.getTamano()>=1) {
			reservas.get();
		}else {System.out.println("No hay reservas");}
	}
	
	public static Habitacion consultarDisponibilidad(TipoHabitacion tipoHabitacion, LocalDate fechaInicioReserva, LocalDate fechaFinReserva) {
		
		Habitacion habitacion = null;
		
		//Recorremos la lista de habitaciones
		for (int i = 0; i < habitaciones.getTamano() && habitacion == null; i++) {
			
			boolean reservada = true;
			
			//Buscar si hay una reserva para esa habitacion en las fechas indicadas
			for (int j = 0; j < reservas.getTamano(); j++) {
				//Si la habitacion es igual a la habitacion de la reserva
				//Y el fin de la reserva es anterior a la fecha de entrada elegida
				//O el inicio de la reserva es posterior a la fecha de salida
				if (reservas.get()[j].getHabitacion().equals(habitaciones.get()[i]) 
					&& (reservas.get()[j].getFechaFinReserva().isBefore(fechaInicioReserva)
					|| reservas.get()[j].getFechaInicioReserva().isAfter(fechaFinReserva))){
					reservada = false;
				}
			}
			
			//Si la habitacion no está reserva
			if (reservada == false) {
				//La asigno para devolverla
				habitacion = habitaciones.get()[i];
			}
		}
	
		return habitacion; 
	}

    public static void main(String[] args) throws OperationNotSupportedException {
    	

		Consola.mostrarMenu();
		Opcion opcion = Consola.elegirOpcion();
		ejecutarOpcion(opcion);
		
		}
 /* 
    • Los atributos declarados en las líneas 20,21 y 22 no los usas porque vuelves a declarar tres variables con el mismo nombre dentro del método main. Debes usar los tres atributos ya que es lo que se muestra en el diagrama de clases.
    • Te faltan casi todos los métodos indicados en el diagrama de clases por implementar. Lo has hecho todo en el main, y lo que debe hacer el main es llamar al método ejecutar opción con la opción elegida.
*/
}
	


