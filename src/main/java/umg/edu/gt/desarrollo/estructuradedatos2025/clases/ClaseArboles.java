package umg.edu.gt.desarrollo.estructuradedatos2025.clases;

import java.util.TreeMap;
import java.util.TreeSet;

public class ClaseArboles {

    // basado en un arbol red-black


    // O(lon n)


    public void TreeSetExample() {


        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(5);

        treeSet.add(2);

        treeSet.add(8);

        treeSet.add(1);


        System.out.println(treeSet); // 1 2 5 8

    }

    // basado en un arbol red-black

    // O(lon n)

    public void TreeMapExample() {

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("Armando", 25);

        treeMap.put("Sergio", 28);

        treeMap.put("Saul", 17);

        System.out.println(treeMap); // { Armando=25, Sergio=28, Saul=17 }


    }

}