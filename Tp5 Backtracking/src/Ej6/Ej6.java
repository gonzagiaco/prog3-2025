package Ej6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió a
ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas todavía
había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que deduzca el
recorrido completo que hizo el caballo.
*
* */
public class Ej6 {

    List<Integer> solucion;
    List<Integer> caminoParcial;
    List<Integer>visitados;
    Grafo<Integer> grafo;


    public List<Integer> ej6(Integer origen){
        solucion = new ArrayList<>();
        caminoParcial = new ArrayList<>();
        visitados.add(origen);
        back(origen,origen);
        return solucion;

    }

    private void back(Integer origen, Integer actual){
        if (actual.equals(origen) && caminoParcial.size() == grafo.cantidadDeVertices() + 1){
            solucion.addAll(caminoParcial);
        }else{
            Iterator<Integer> ady =grafo.obtenerAdyacentes(actual);
            while (ady.hasNext()){
                Integer vecino = ady.next();
                if (!visitados.contains(vecino)){
                    caminoParcial.add(vecino);
                    back(origen,vecino);
                    caminoParcial.remove(caminoParcial.size()-1);
                    visitados.remove(visitados.size()-1);

                }
            }
        }
    }



}
