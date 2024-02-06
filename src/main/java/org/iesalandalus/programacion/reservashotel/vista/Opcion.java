package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
	
	
	SALIR ("0.-Salir"), 
	INSERTAR_HUESPED ("1.-Insertar huesped"),
	BUSCAR_HUESPED ("2.-Buscar huesped"),
	BORRAR_HUESPED ("3.-Borrar huesped"),
	MOSTRAR_HUESPEDES ("4.-Mostrar huespedes"),
	INSERTAR_HABITACION ("5.-Insertar habitacion"),
	BUSCAR_HABITACION ("6.-Buscar habitacion"),
	BORRAR_HABITACION ("7.-Borrar habitacion"),
	MOSTRAR_HABITACIONES ("8.-Mostrar habitaciones"),
	INSERTAR_RESERVA ("9.-Insertar reserva"),
	ANULAR_RESERVA ("10-Anular reserva"),
	MOSTRAR_RESERVAS ("11-Mostrar reserva"),
	CONSULTAR_DISPONIBILIDAD ("12-Consultar disponibilidad");
	
	private String mensajeAMostrar;
	
	
	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar=mensajeAMostrar;
	
	}
	
	
    @Override
    public String toString() {
        return (this.ordinal() + 1) + ".-" + mensajeAMostrar;
    }
	
    /*
     Correcto, aunque el método toString debe devolver una cadena de la forma: 1.-Insertar huésped.... Haz uso de los métodos de la clase Enum, como por ejemplo, ordinal() para conseguirlo. No te penalizo pero para la próxima entrega tenlo corregido.
    */
     

}
