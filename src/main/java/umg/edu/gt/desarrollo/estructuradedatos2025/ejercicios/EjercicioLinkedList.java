package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.HashSet;
import java.util.LinkedList;

public class EjercicioLinkedList {

    /**
     * Elimina los duplicados de una LinkedList de enteros.
     *
     * @param lista La LinkedList de entrada.
     * @return Una nueva LinkedList sin duplicados.
     */
    public static LinkedList<Integer> eliminarDuplicados(LinkedList<Integer> lista) {
        HashSet<Integer> elementosVistos = new HashSet<>();
        LinkedList<Integer> resultado = new LinkedList<>();

        for (Integer elemento : lista) {
            if (!elementosVistos.contains(elemento)) {
                elementosVistos.add(elemento);
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    /**
     * Invierte una LinkedList de cadenas sin usar listas o ArrayLists auxiliares.
     *
     * @param lista La LinkedList de entrada.
     */
    public static void invertirLista(LinkedList<String> lista) {
        int tamanio = lista.size();
        for (int indice = 0; indice < tamanio / 2; indice++) {
            String temporal = lista.get(indice);
            lista.set(indice, lista.get(tamanio - 1 - indice));
            lista.set(tamanio - 1 - indice, temporal);
        }
    }

    /**
     * Intercala dos LinkedLists ordenadas de enteros en una nueva LinkedList ordenada.
     *
     * @param lista1 La primera LinkedList ordenada.
     * @param lista2 La segunda LinkedList ordenada.
     * @return Una nueva LinkedList que contiene los elementos intercalados y ordenados.
     */
    public static LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
        LinkedList<Integer> resultado = new LinkedList<>();
        int indice1 = 0;
        int indice2 = 0;

        while (indice1 < lista1.size() && indice2 < lista2.size()) {
            if (lista1.get(indice1) < lista2.get(indice2)) {
                resultado.add(lista1.get(indice1++));
            } else {
                resultado.add(lista2.get(indice2++));
            }
        }

        while (indice1 < lista1.size()) {
            resultado.add(lista1.get(indice1++));
        }

        while (indice2 < lista2.size()) {
            resultado.add(lista2.get(indice2++));
        }

        return resultado;
    }
}