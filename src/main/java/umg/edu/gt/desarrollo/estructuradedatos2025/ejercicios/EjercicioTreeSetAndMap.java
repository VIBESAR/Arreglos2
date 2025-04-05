package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

public class EjercicioTreeSetAndMap {

    // EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
    public static Map<String, Integer> contarFrecuenciaPalabras(String filePath) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(filePath));
        Map<String, Integer> frecuencia = new TreeMap<>();

        for (String linea : lineas) {
            String[] palabras = linea.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }
        }
        return frecuencia;
    }

    // Método para imprimir frecuencia de palabras en orden alfabético
    public static void imprimirFrecuenciaPalabras(Map<String, Integer> frecuencia) {
        System.out.println("Frecuencia de palabras en orden alfabético:");
        for (Map.Entry<String, Integer> entry : frecuencia.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
    private final TreeMap<Integer, String> versiones = new TreeMap<>();
    private int versionActual = 0;

    public void agregarVersion(String codigo) {
        versiones.put(++versionActual, codigo);
    }

    public String obtenerVersion(int version) {
        return versiones.getOrDefault(version, "Versión no encontrada");
    }

    public String obtenerUltimaVersion() {
        return versiones.isEmpty() ? "No hay versiones disponibles" : versiones.lastEntry().getValue();
    }

    public void eliminarVersion(int version) {
        versiones.remove(version);
    }

    // EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
    static class Evento implements Comparable<Evento> {
        LocalDateTime fecha;
        String nombre;
        String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha);
        }

        @Override
        public String toString() {
            return nombre + ", " + fecha + ", " + ubicacion;
        }
    }

    private final TreeSet<Evento> eventos = new TreeSet<>();

    public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
        eventos.add(new Evento(fecha, nombre, ubicacion));
    }

    public List<Object> obtenerEventos() {
        // Eliminar eventos pasados automáticamente
        eliminarEventosPasados();
        return new ArrayList<>(eventos);
    }

    public Object obtenerProximoEvento() {
        // Eliminar eventos pasados automáticamente
        eliminarEventosPasados();
        return eventos.stream()
                .filter(e -> e.fecha.isAfter(LocalDateTime.now()))
                .findFirst()
                .orElse(null);
    }

    // Método para eliminar eventos pasados automáticamente
    private void eliminarEventosPasados() {
        LocalDateTime ahora = LocalDateTime.now();
        eventos.removeIf(e -> e.fecha.isBefore(ahora));
    }

    // Método para mostrar la lista de eventos en orden cronológico
    public void mostrarEventosOrdenados() {
        List<Object> listaEventos = obtenerEventos();
        System.out.println("Lista de eventos:");
        for (int i = 0; i < listaEventos.size(); i++) {
            System.out.println((i + 1) + ". " + listaEventos.get(i));
        }
    }
}