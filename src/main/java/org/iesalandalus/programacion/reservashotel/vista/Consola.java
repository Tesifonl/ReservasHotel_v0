package org.iesalandalus.programacion.reservashotel.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Regimen;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private Consola() {

	}
	
	public static void mostrarMenu() {
		
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Opciones: ");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
		System.out.println ("1º.-Insertar huesped");
		System.out.println ("2º.-Buscar huesped");
		System.out.println ("3º.-Borrar huesped");
		System.out.println ("4º.-Mostrar huespedes");
		System.out.println ("5º.-Insertar habitacion");
		System.out.println ("6º.-Buscar habitacion");
		System.out.println("7º.-Borrar habitacion");
		System.out.println("8.-Mostrar habitaciones");
		System.out.println ("9.-Insertar reserva");
		System.out.println ("10º-Anular reserva");
		System.out.println ("11º-Mostrar reserva");
		System.out.println ("12º-Consultar disponibilidad");
		System.out.println("");
		System.out.println("0º.-Salir");
		System.out.println("");
		
	}
	
	public static Opcion elegirOpcion() {
		int opciones;
		Opcion opcionElegida=Opcion.CONSULTAR_DISPONIBILIDAD;
		
		do {
			System.out.println("Introduzca la opcion a elegir");
			opciones=Entrada.entero();
		}while (opciones<0 || opciones>12);
		
		
		switch (opciones)
		
		{
			case 1:
				opcionElegida=Opcion.INSERTAR_HUESPED;
				break;
			case 2:
				opcionElegida=Opcion.BUSCAR_HUESPED;
				break;
			case 3:
				opcionElegida=Opcion.BORRAR_HUESPED;
				break;
			case 4:
				opcionElegida=Opcion.MOSTRAR_HUESPEDES;
				break;
			case 5:
				opcionElegida=Opcion.INSERTAR_HABITACION;
				break;
			case 6:
				opcionElegida=Opcion.BUSCAR_HABITACION;
				break;
			case 7:
				opcionElegida=Opcion.BORRAR_HABITACION;
				break;
			case 8:
				opcionElegida=Opcion.MOSTRAR_HABITACIONES;
				break;
			case 9:
				opcionElegida=Opcion.INSERTAR_RESERVA;
				break;
			case 10:
				opcionElegida=Opcion.ANULAR_RESERVA;
				break;
			case 11:
				opcionElegida=Opcion.MOSTRAR_RESERVAS;
				break;
			case 12:
				opcionElegida=Opcion.CONSULTAR_DISPONIBILIDAD;
				break;
			case 0:
				opcionElegida=Opcion.SALIR;
				break;
				
		}
		
		return opcionElegida;	
	}
	
	public static Huesped leerHuesped() {
		
		
		try {
			System.out.println("Introduce un nombre: ");
			String nombre=Entrada.cadena();
			System.out.println("Introduce un dni: ");
			String dni=Entrada.cadena();
			System.out.println("Introduce un correo: ");
			String correo=Entrada.cadena();
			System.out.println("Introduce un telefono: ");
			String telefono=Entrada.cadena();
			System.out.println("Introduce una fecha nacimiento: ");
			String pattern = "yyyy-MM-dd";
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern(pattern);
			LocalDate fechaNacimiento=LocalDate.parse(Entrada.cadena(), formatter);

			Huesped huesped=new Huesped( nombre, dni, correo, telefono, fechaNacimiento);
			return huesped;
			}
			catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return null;
			}
			catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
			}

	}
	
	public static Huesped getHuespedPorDni()  {
		try {
			System.out.println("Introduce un dni: ");
			String dni=Entrada.cadena();
			Huesped huesped=new Huesped( "Tesifon Linares", dni, "Tesi@gmail.com", "950112233", LocalDate.of(2002, 9, 15));
			return huesped;
			}
			catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
			return null;
			}
			catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
			}
	}

	public static LocalDate leerFecha(String mensaje ) {
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
           
            LocalDate fechaLocalDate = LocalDate.parse(mensaje, formatter);
            return fechaLocalDate;
            
        	} catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	public static Habitacion leerHabitacion( ) {
	
			try {
			System.out.println("Introduce un planta: ");
			int planta=Entrada.entero();
			System.out.println("Introduce un puerta: ");
			int puerta=Entrada.entero();
			System.out.println("Introduce un precio: ");
			double precio=Entrada.real();
			System.out.println("Introduce un identificador: ");
			String identificador=Entrada.cadena();
			System.out.println("Introduce una fecha tipo de habitacion: ");
			TipoHabitacion tipoHabitacion=TipoHabitacion.valueOf(Entrada.cadena());

			Habitacion habitacion=new Habitacion( planta,puerta,precio,identificador,tipoHabitacion);
			return habitacion;
			}
			catch(NullPointerException e) {
				System.out.println(e.getMessage());
				return null;
        }
		
	}
	
	public static Habitacion leerHabitacionPorIdentificador() {
		
		try {
		System.out.println("Introduce un planta: ");
		int planta=Entrada.entero();
		System.out.println("Introduce un puerta: ");
		int puerta=Entrada.entero();
		
		Habitacion habitacion=new Habitacion( planta, puerta, 0, "1001", TipoHabitacion.DOBLE);
		return habitacion;
		}
		catch(IllegalArgumentException e){
		System.out.println(e.getMessage());
		return null;
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		return null;
		}
	}
	
	public static TipoHabitacion leerTipoHabitacion() {
		int eleccion=0;
		TipoHabitacion tipoHabitacionElegida=null;
		
		System.out.println("Introduce una numero para elegir el tipo de habitacion: ");
	
		switch (eleccion)
		
		{
			case 1:
				tipoHabitacionElegida=TipoHabitacion.SIMPLE;
				break;
			case 2:
				tipoHabitacionElegida=TipoHabitacion.DOBLE;
				break;
			case 3:
				tipoHabitacionElegida=TipoHabitacion.TRIPLE;
				break;
			case 4:
				tipoHabitacionElegida=TipoHabitacion.SUITE;
				break;
		}
		
		return tipoHabitacionElegida;
	}
	
	public static Regimen leerRegimen() {
		int eleccion=0;
		Regimen RegimenElegido=null;
		
		System.out.println("Introduce una numero para elegir el tipo de regimen: ");
	
		switch (eleccion)
		
		{
			case 1:
				RegimenElegido=Regimen.SOLO_ALOJAMIENTO;
				break;
			case 2:
				RegimenElegido=Regimen.ALOJAMIENTO_DESAYUNO;
				break;
			case 3:
				RegimenElegido=Regimen.MEDIA_PENSION;
				break;
			case 4:
				RegimenElegido=Regimen.PENSION_COMPLETA;
				break;
		}
		
		return RegimenElegido;
	}
	
	
	public static Reserva leerReserva() {
		
		try {
			Huesped huesped=new Huesped(leerHuesped());
			Habitacion habitacion=new Habitacion(leerHabitacion());
			Regimen regimen=leerRegimen();
			System.out.println("Introduce una fecha de inicio de reserva");
			String fechaInicio=Entrada.cadena();
			LocalDate fechaInicioReserva=leerFecha(fechaInicio);
			System.out.println("Introduce una fecha de fin de reserva");
			String fechaFin=Entrada.cadena();
			LocalDate fechaFinReserva=leerFecha(fechaFin);
			System.out.println("Introduce el numero de personas");
			int numeroPersonas=Entrada.entero();

			

		Reserva reserva=new Reserva( huesped,habitacion, regimen,fechaInicioReserva,fechaFinReserva,numeroPersonas);
		return reserva;
		}
		catch(IllegalArgumentException e){
		System.out.println(e.getMessage());
		return null;
		}
		catch(NullPointerException e) {
		System.out.println(e.getMessage());
		return null;
		}
	}
	
}