package Ej6;


/*
*
* Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
número de ellas.
Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
10$ y 4 de 1$.
* */

import java.util.ArrayList;
import java.util.List;

public class MonedaEj1 {

    private Integer M;

    public MonedaEj1(Integer M){
        this.M = M;
    }

    public List<Integer> mejorSolucion(List<Integer> monedas) {
        List<Integer> solucion = new ArrayList<>();
        int resto =0;
        while (!monedas.isEmpty() && !solucion(solucion)) {
            resto = M - sumar(solucion);
            Integer moneda = seleccionar(monedas, resto);
            if (moneda!=null) {
                if (esFactive(solucion, moneda)) {
                    System.out.println(moneda);
                    solucion.add(moneda);
                } else {
                    monedas.remove(moneda);
                }

            } else{
                resto = M-sumar(solucion);
                System.out.println("el resto es " + resto);
                return solucion;

            }
        }
        resto = M-sumar(solucion);
        System.out.println("el resto es " + resto);
        return solucion;
    }

    private boolean esFactive(List<Integer> solucion, int moneda) {
        return ((sumar(solucion) + moneda) <= M);
    }

    private Integer seleccionar(List<Integer> monedas, int resto) {
        for (Integer moneda : monedas) {
            if (moneda <= resto) {
                return moneda;
            }
        }
        return null;
    }

    private boolean solucion(List<Integer> solucion) {

        if (!solucion.isEmpty()) {
            int suma = sumar(solucion);

            if (suma == M) {
                return true;
            } else if (suma == 0) {
                return false;
            }
        }
        return false;
    }

    public int sumar(List<Integer> arr) {
        int suma = 0;
        for (Integer moneda : arr) {
            suma += moneda;
        }
        return suma;
    }
}
