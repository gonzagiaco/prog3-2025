import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HabitacionesBack<T> {

    private Grafo<T> grafo;
    List<Integer> mayorCamino;
    HashSet<Integer> visitados;

    public HabitacionesBack(Grafo<T>grafo) {
        this.mayorCamino = new ArrayList<>();
        this.visitados = new HashSet<>();
        this.grafo = grafo;
    }



    public List<Integer> conjuntoDeSalas(Integer origen, Integer destino) {
        visitados.clear();
        mayorCamino.clear();
        List<Integer> caminoActual = new ArrayList<>();

        visitados.add(origen);
        caminoActual.add(origen);

        Backtracking(origen, destino, caminoActual);
        return mayorCamino;
    }

    private void Backtracking(Integer origen, Integer destino, List<Integer> caminoParcial){
        //estado final
        if(origen.equals(destino)){
            //solucion posible
            if (caminoParcial.size() >= mayorCamino.size()){
                mayorCamino.clear();
                mayorCamino.addAll(caminoParcial);

            }
        }else{
            Iterator<Integer> puertasAdyacentes = this.grafo.obtenerAdyacentes(origen);
            while (puertasAdyacentes.hasNext()){

                Integer sala = puertasAdyacentes.next();

                if (!visitados.contains(sala)){
                    //genero nuevo estado
                    caminoParcial.add(sala);
                    visitados.add(sala);
                    //llamada recursiva

                    Backtracking(sala,destino,caminoParcial);
                    //aca aplicamos back, volvemos al estado anterior
                    caminoParcial.remove(sala);
                    visitados.remove(sala);

                }
            }
        }





    }
}
