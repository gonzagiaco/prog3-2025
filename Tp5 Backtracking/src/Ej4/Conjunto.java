package Ej4;

import java.util.ArrayList;
import java.util.List;

public class Conjunto {

    private Integer sumaDeElementosDelConjunto;
    private ArrayList<Integer> conjuntoParcial;
    private List<List<Integer>> soluciones;

    public Conjunto() {
        this.sumaDeElementosDelConjunto = 0;
        this.conjuntoParcial = new ArrayList<>();
        this.soluciones = new ArrayList<>();
    }

    public List<List<Integer>> obtenerConjuntoDisjunto(List<Integer> conjunto){
        int pos = 0, total = 0, cont = 0;
        for (Integer c : conjunto){
            total+=c;
            sumaDeElementosDelConjunto= total/2;
        }
        backConjuntoDisjunto(conjunto,conjuntoParcial,soluciones,sumaDeElementosDelConjunto, pos, cont);
        return soluciones;
    }

    private void backConjuntoDisjunto(List<Integer> conjunto, List<Integer> conjuntoParcial,List<List<Integer>> soluciones, Integer sumaDeElementosDelConjunto, int pos, int sumaParcial){


            if (sumaParcial == sumaDeElementosDelConjunto){
                System.out.println("Entre al if " + sumaParcial);
                soluciones.add(new ArrayList<>(conjuntoParcial));
                return;
            }

            if (pos >= conjunto.size() || sumaParcial > sumaDeElementosDelConjunto){
                System.out.println("entro a la poda");
                return;
            }

            conjuntoParcial.add(conjunto.get(pos));
            System.out.println("conjunto parcial " +conjuntoParcial);
            backConjuntoDisjunto(conjunto, conjuntoParcial, soluciones, sumaDeElementosDelConjunto, pos + 1, sumaParcial + conjunto.get(pos));

            System.out.println("back");
            conjuntoParcial.remove(conjuntoParcial.size()-1);
            System.out.println("conjunto parcial " + conjuntoParcial);
            System.out.println("-----");
            System.out.println("back de otra rama");
            backConjuntoDisjunto(conjunto,conjuntoParcial,soluciones,sumaDeElementosDelConjunto,pos+1,sumaParcial);


    }
}
