package Ej3;

import java.util.ArrayList;
import java.util.List;

public class MainEj3 {
    public static void main(String[] args) {
        List<Integer> lista = List.of(2, 4, 6, 10);
        int objetivo = 16;

        List<List<Integer>> soluciones = sumaDeSubconjuntos(lista, objetivo);

        System.out.println("Subconjuntos cuya suma es " + objetivo + ":");
        for (List<Integer> s : soluciones) {
            System.out.println(s);
        }
    }

    public static List<List<Integer>> sumaDeSubconjuntos(List<Integer> lista, int valorObjetivo) {
        List<List<Integer>> soluciones = new ArrayList<>();
        List<Integer> caminoParcial = new ArrayList<>();

        back(lista, 0, caminoParcial, 0, valorObjetivo, soluciones);

        return soluciones;
    }

    private static void back(List<Integer> lista, int pos, List<Integer> caminoParcial, int sumaParcial, int valorObjetivo, List<List<Integer>> soluciones) {

        if (sumaParcial == valorObjetivo) {
            soluciones.add(new ArrayList<>(caminoParcial));
            return;
        }


        if (pos >= lista.size() || sumaParcial > valorObjetivo) {
            return;
        }

        // Incluir el número actual
        caminoParcial.add(lista.get(pos));
        back(lista, pos + 1, caminoParcial, sumaParcial + lista.get(pos), valorObjetivo, soluciones);
        caminoParcial.remove(caminoParcial.size() - 1); // backtrack

        // No incluir el número actual
        back(lista, pos + 1, caminoParcial, sumaParcial, valorObjetivo, soluciones);
    }
}
