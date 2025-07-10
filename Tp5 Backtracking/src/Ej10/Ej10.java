package Ej10;

import java.util.ArrayList;
import java.util.List;

public class Ej10 {
    /**
     * Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,
     * devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas
     * sean exactamente cero. Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos
     * que suman cero son: {-7, -1, 8} y {-3, -2, 5}.
     */
    private List<Integer> caminoParicial;
    private List<List<Integer>> solucion;

    public List<List<Integer>> ejercicio10(List<Integer> conjunto, int n) {
        caminoParicial = new ArrayList<>();
        solucion = new ArrayList<>();
        back(conjunto,n,0,0);
        return solucion;
    }

    private void back(List<Integer> conjunto, int n, int sumaParcial, int posicion) {
        if (caminoParicial.size() == n) {
            if (sumaParcial == 0) {
                solucion.add(new ArrayList<>(caminoParicial));
            }
        }else {
            if (posicion <= conjunto.size()) {
                int num = conjunto.get(posicion);
                caminoParicial.add(num);
                back(conjunto, n, sumaParcial + num, posicion + 1);
                caminoParicial.remove(caminoParicial.size() - 1);

                // NO incluir el número
                back(conjunto, n, sumaParcial, posicion + 1);
            }
        }

    }

}
