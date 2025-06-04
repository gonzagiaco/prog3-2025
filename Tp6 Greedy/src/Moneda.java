import java.util.ArrayList;
import java.util.List;

public class Moneda {
    /**
     * Cambio de monedas: Dado un conjunto C de N tipos de monedas con un número ilimitado de
     * ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
     * número de ellas.
     * Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$, 25$, 10$, 5$ y 1$,
     * si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de 100$, 3 de 25$, 1 de
     * 10$ y 4 de 1$.
     *
     **/


    private List<Integer> candidato;
    private List<Integer> solucion;

    public Moneda(){

        this.candidato = new ArrayList<>();
        this.solucion = new ArrayList<>();
    }

    public void setCandidato(List<Integer> candidato) {
        this.candidato = candidato;
    }

    public List<Integer> greedy(Integer valorObjetivo){
        Integer sumaActual = 0;

        while (!candidato.isEmpty() && !solucion(valorObjetivo,sumaActual)){
            System.out.println("entre al whille");
            Integer x  = seleccionar(candidato);
            System.out.println("x "  + x);
            if (esFactible(x,sumaActual, valorObjetivo)){
                System.out.println("entre al factible");
                solucion.add(x);
                sumaActual+=x;
                System.out.println("suma actual " + sumaActual);

            }else {
                System.out.println("entro al remove " + x);
                candidato.remove(x);
            }
        }

        if (solucion(valorObjetivo,sumaActual)){
            return solucion;
        }

        System.out.println("No hay solucion");
        return null;
    }
    public boolean esFactible(Integer candidato, Integer sumaActual, Integer valorObje){
        return sumaActual + candidato <= valorObje  ;
    }

    public boolean solucion(int valorObjetivo, int sumaActual){
         return sumaActual == valorObjetivo;
    }
    public Integer seleccionar(List<Integer>candidato){
        Integer mayorValor = 0;
        for (Integer c : candidato){
            if (c>mayorValor){
                mayorValor=c;
            }
        }
        return mayorValor;
    }
}
