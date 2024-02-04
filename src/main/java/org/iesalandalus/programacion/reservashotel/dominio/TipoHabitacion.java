package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {
	SUITE ("Suite",4), SIMPLE ("Single",1), DOBLE("Doble",2), TRIPLE("Triple",3);
	
	private String cadenaAMostrar;
	private int numeroMaximoPersonas;
	
	private TipoHabitacion(String cadenaAMostrar,int numeroMaximoPersonas) {
		this.cadenaAMostrar=cadenaAMostrar;
		this.numeroMaximoPersonas=numeroMaximoPersonas;
	}
	
	public int getNumeroMaximoPersonas(){
		return numeroMaximoPersonas;
	}
	
	/* Correcto, aunque el método toString debe devolver una cadena de la forma: 1.-Solo Alojamiento. Haz uso de los métodos de la clase Enum, como por ejemplo, ordinal() para conseguirlo. No te penalizo pero para la próxima entrega tenlo corregido.*/ 

    @Override
    public String toString() {
        return (this.ordinal() + 1) + ".-" + cadenaAMostrar;
    }
	/* Correcto, aunque el método toString debe devolver una cadena de la forma: 1.-Solo Alojamiento. Haz uso de los métodos de la clase Enum, como por ejemplo, ordinal() para conseguirlo. No te penalizo pero para la próxima entrega tenlo corregido.*/ 
}
