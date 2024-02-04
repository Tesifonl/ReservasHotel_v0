package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {
	
	SOLO_ALOJAMIENTO ("Solo Alojamiento", 0), ALOJAMIENTO_DESAYUNO ("Alojamiento y Desayuno",15),
	MEDIA_PENSION ("MediaPension",30),PENSION_COMPLETA ("Pension Completa",50);
	
	private String cadenaAMostrar;
	private double incrementoPrecio;
	
	private Regimen(String cadenaAMostrar,int incrementoPrecio) {
		this.cadenaAMostrar=cadenaAMostrar;
		this.incrementoPrecio=incrementoPrecio;
	}
	
	public double getIncrementoPrecio() {
		return incrementoPrecio;
	}
	
	/*Correcto, aunque el método toString debe devolver una cadena de la forma: 1.-Suite. Haz uso de los métodos de la clase Enum, como por ejemplo, ordinal() para conseguirlo. No te penalizo pero para la próxima entrega tenlo corregido.*/

    @Override
    public String toString() {
        return (this.ordinal() + 1) + ".-"+ cadenaAMostrar;
    }
    /*Correcto, aunque el método toString debe devolver una cadena de la forma: 1.-Suite. Haz uso de los métodos de la clase Enum, como por ejemplo, ordinal() para conseguirlo. No te penalizo pero para la próxima entrega tenlo corregido.*/
}
