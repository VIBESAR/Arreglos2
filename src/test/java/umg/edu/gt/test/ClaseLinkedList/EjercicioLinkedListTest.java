package umg.edu.gt.test.ClaseLinkedList;

import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class EjercicioLinkedListTest {

    @Test
    void testEliminarDuplicados() {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1); lista.add(2); lista.add(2); lista.add(3); lista.add(1);
        LinkedList<Integer> resultado = EjercicioLinkedList.eliminarDuplicados(lista);
        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1); esperado.add(2); esperado.add(3);
        assertEquals(esperado, resultado);
    }

    @Test
    void testInvertirLista() {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("a"); lista.add("b"); lista.add("c");
        EjercicioLinkedList.invertirLista(lista);
        LinkedList<String> esperado = new LinkedList<>();
        esperado.add("c"); esperado.add("b"); esperado.add("a");
        assertEquals(esperado, lista);
    }

    @Test
    void testIntercalarListas() {
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1); lista1.add(3); lista1.add(5);
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2); lista2.add(4); lista2.add(6);
        LinkedList<Integer> resultado = EjercicioLinkedList.intercalarListas(lista1, lista2);
        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1); esperado.add(2); esperado.add(3); esperado.add(4); esperado.add(5); esperado.add(6);
        assertEquals(esperado, resultado);
    }

    @Test
    void testForzarFallo() {
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1); lista1.add(3); lista1.add(5);
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2); lista2.add(4); lista2.add(6);
        LinkedList<Integer> resultado = EjercicioLinkedList.intercalarListas(lista1, lista2);
        LinkedList<Integer> esperadoErroneo = new LinkedList<>();
        esperadoErroneo.add(1); esperadoErroneo.add(3); esperadoErroneo.add(2); esperadoErroneo.add(4); esperadoErroneo.add(5); esperadoErroneo.add(6);
        assertEquals(esperadoErroneo, resultado);
    }
}
