package umg.edu.gt.test.EjercicioTree;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EjercicioTreeSetAndMapTest {

    @TempDir
    Path tempDir;

    Path testFile;

    @BeforeEach
    void setUp() throws IOException {
        testFile = tempDir.resolve("test.txt");
        String content = """
                Este es un ejemplo de texto.
                Este texto se usa como ejemplo para contar palabras.
                El ejercicio de ejemplo debe contar frecuencias.""";
        Files.writeString(testFile, content);
    }

    @Test
    void testContarFrecuenciaPalabras() throws IOException {
        Map<String, Integer> resultado = EjercicioTreeSetAndMap.contarFrecuenciaPalabras(testFile.toString());
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty(), "El resultado no debe estar vacío");
        assertEquals(3, resultado.get("ejemplo"), "La palabra 'ejemplo' debe aparecer 3 veces");
        assertEquals(2, resultado.get("texto"), "La palabra 'texto' debe aparecer 2 veces");
    }

    @Test
    void testOrdenAlfabetico() throws IOException {
        Map<String, Integer> resultado = EjercicioTreeSetAndMap.contarFrecuenciaPalabras(testFile.toString());
        // Verifica que TreeMap mantiene el orden alfabético
        String[] palabrasOrdenadas = resultado.keySet().toArray(new String[0]);
        for (int i = 1; i < palabrasOrdenadas.length; i++) {
            assertTrue(palabrasOrdenadas[i-1].compareTo(palabrasOrdenadas[i]) < 0,
                    "Las palabras deben estar en orden alfabético");
        }
    }

    @Test
    void testAgregarYObtenerVersiones() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();
        gestor.agregarVersion("System.out.println('Hola Mundo');");
        gestor.agregarVersion("System.out.println('Hola Java');");

        assertEquals("System.out.println('Hola Java');", gestor.obtenerUltimaVersion());
        assertEquals("System.out.println('Hola Mundo');", gestor.obtenerVersion(1));
    }

    @Test
    void testEliminarVersion() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();
        gestor.agregarVersion("Código de prueba");
        gestor.eliminarVersion(1);

        assertEquals("Versión no encontrada", gestor.obtenerVersion(1));
    }

    @Test
    void testSistemaGestionEventos() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();
        // Crear eventos futuros
        LocalDateTime fechaFutura1 = LocalDateTime.now().plusMonths(1);
        LocalDateTime fechaFutura2 = LocalDateTime.now().plusMonths(2);

        gestor.agregarEvento(fechaFutura2, "Conferencia de Java", "Auditorio A");
        gestor.agregarEvento(fechaFutura1, "Taller de Machine Learning", "Sala 3");

        assertNotNull(gestor.obtenerProximoEvento(), "Debe devolver el próximo evento");
        assertEquals(2, gestor.obtenerEventos().size(), "Debe haber dos eventos registrados");

        // Verificar orden cronológico basado en la representación String que incluye fechas
        List<Object> eventos = gestor.obtenerEventos();
        String primerEvento = eventos.get(0).toString();
        String segundoEvento = eventos.get(1).toString();

        assertTrue(primerEvento.contains("Taller de Machine Learning"),
                "El primer evento debe ser el Taller de Machine Learning");
        assertTrue(segundoEvento.contains("Conferencia de Java"),
                "El segundo evento debe ser la Conferencia de Java");
    }

    @Test
    void testEliminarEventosPasados() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();
        // Crear un evento pasado
        LocalDateTime fechaPasada = LocalDateTime.now().minusDays(1);
        // Crear un evento futuro
        LocalDateTime fechaFutura = LocalDateTime.now().plusDays(1);

        gestor.agregarEvento(fechaPasada, "Evento Pasado", "Sala 1");
        gestor.agregarEvento(fechaFutura, "Evento Futuro", "Sala 2");

        // Al obtener eventos, el evento pasado debe ser eliminado automáticamente
        List<Object> eventos = gestor.obtenerEventos();

        assertEquals(1, eventos.size(), "Solo debe quedar un evento (el futuro)");
        assertTrue(eventos.get(0).toString().contains("Evento Futuro"),
                "El evento restante debe ser el futuro");
    }

    @Disabled("Este test está diseñado para fallar intencionalmente")
    @Test
    void testFalloForzado() {
        EjercicioTreeSetAndMap gestor = new EjercicioTreeSetAndMap();
        gestor.agregarVersion("Código erróneo");
        assertEquals("Otro código", gestor.obtenerUltimaVersion(), "Este test debe fallar");
    }
}