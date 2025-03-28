package umg.edu.gt.desarrollo.estructuradedatos2025.clases;

import java.util.Objects;

/**
 * Clase de ejemplo para demostrar conceptos básicos de Java
 * Proyecto de Estructura de Datos 2025
 */
public class EjemploLombok {
    // Atributos sin anotaciones de Lombok
    private String nombre;
    private int edad;

    // Constructor por defecto
    public EjemploLombok() {
        // Constructor vacío para crear objetos sin parámetros
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EjemploLombok that = (EjemploLombok) o;
        return edad == that.edad &&
                Objects.equals(nombre, that.nombre);
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    // Método main para demostrar uso de la clase
    public static void main(String[] args) {
        // Creacion del objeto y se le asigno valores
        EjemploLombok miPersona = new EjemploLombok();

        // Establecemos valores
        miPersona.setNombre("Armando");
        miPersona.setEdad(20);

        // Imprimimos la información
        System.out.println("Datos de la persona: " + miPersona);
    }
}