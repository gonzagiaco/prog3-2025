package Ej7;

/*
* Ejercicio 7
Tablero mágico. Dado un tablero de tamaño n x n, construir un algoritmo que ubique (si es posible)
n*n números naturales diferentes, entre 1 y un cierto k (con k>n*n), de manera tal que la suma de las
columnas y de las filas sea igual a S
*
* */

import java.util.List;

public class Ej7 {
    private Matriz solucion;

    public Matriz(Integer s, List<Integer>numeros,Matriz m){
        Matriz m = new Matriz();

        Iterator<Casillero> it = m.iterator();
        back(m,numeros,it,s);
        return solucion;
    }
    public Matriz back(Matriz m, List<Integer>numeros, Iterator<Casillero>it,Integer s){
        if(!it.hasNext()){
            //este mtodo se encarga de validad si la suma de las columas y las filas sean igual a S
            if(validarSolucion(m,s)){
                return m;
            }else{
                Casillero casillero = it.next();
                for (int indice =0; indice< numeros.size(); indice++) {
                    int num = numeros.get(indice);
                    m.add(casillero,num);
                    numeros.remove(indice);
                    //es una poda y esa funcion lo que hace es validar que si la suma parcial de fila y col no supero a S  siga haciendo back
                    if(m.sumaParcialValida(s)){
                        solucion = back(m,numeros,it,s);
                    }
                    if (solucion != null){
                        return solucion;
                    }
                    m.remove(casillero,num);
                    numeros.add(indice,num);
                }
            }
        }
    }
}
