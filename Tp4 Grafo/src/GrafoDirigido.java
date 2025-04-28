
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, HashSet<Arco<T>>> vertices;


    public GrafoDirigido(){
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (vertices.containsKey(verticeId)) {
            throw new IllegalArgumentException("El vértice con ID " + verticeId + " ya existe.");
        }
        vertices.put(verticeId, new HashSet<>());
    }


    @Override
    public void borrarVertice(int verticeId) {
        if (cantidadArcos() > 0){
            Iterator<Arco<T>> arcoIterator = obtenerArcos(verticeId);
            while (arcoIterator.hasNext()){
                arcoIterator.next();
                arcoIterator.remove();
            }
        }
        this.vertices.remove(verticeId);
    }


    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!existeArco(verticeId1,verticeId2)){
            Arco<T> arco = new Arco<>(verticeId1,verticeId2,etiqueta);
            //vamos al vertice 1 (inicial) y le agregamos el arco
            this.vertices.get(verticeId1).add(arco);
        }

    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Iterator<Arco<T>> arco = obtenerArcos(verticeId1);
        while (arco.hasNext()) {
            Arco<T> ar = arco.next();
            if (ar.getVerticeOrigen() == verticeId1 && ar.getVerticeDestino() == verticeId2) {
                arco.remove();
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1)){
            return false;
        }
        //Usamos this.vertices.get(verticeId1)
        //para obtener el conjunto de arcos (salientes) desde el vértice verticeId1.
        for (Arco<T> arco: vertices.get(verticeId1)){
            if (arco.getVerticeDestino() == verticeId2){
                return true;
            }
        }
        return false;
    }


    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(existeArco(verticeId1,verticeId2)){
            for (Arco<T> arco: vertices.get(verticeId1)){
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino()==verticeId2){
                    return arco;
                }
            }
        }
        return null;
    }



    @Override
    public int cantidadVertices() {
        return this.vertices.size();
    }

    /*
    * Vértice(o nodo)	Arcos(o aristas) salientes
    1	1→2, 1→4 // 2
    2	2→3 //1
    3	- // 0
    4	4→5 // 1
    5	5→3 // 1
    *
    * 2+1+0+1+1 = 5 arcos.
    *
    * */

    @Override
    public int cantidadArcos() {
        int cant = 0;
        for (HashSet<Arco<T>> ar : vertices.values()){
            cant+= ar.size();
        }
        return cant;
    }


    /*
    * En resumen, la razon por la que usamos keySet() es para obtener un Iterator<Integer>  porque el keySet() te da las claves (vértices),
    *  mientras que las otras vistas (values() y entrySet()) te dan valores o pares clave-valor, que no es lo que buscas en este caso.
    * */
    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.vertices.keySet().iterator();
    }


    /*
    * un vértice es adyacente a otro si podés llegar a él en un solo paso (una arista directa).
    * */

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Iterator<Arco<T>> arco = obtenerArcos(verticeId);
       // { (1→2),
        //  (1→3) },
        HashSet<Integer> adyacente = new HashSet<>();
        while (arco.hasNext()){
            Arco<T> ar = arco.next();
            adyacente.add(ar.getVerticeDestino());
        }
        return adyacente.iterator(); //{2,3}
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        HashSet<Arco<T>> arcos = new HashSet<>();
        /*porque values?
        * porque cada "valor" del HashMap es un HashSet<Arco<T>>, o sea, el conjunto de arcos salientes de cada vertice.
        *
        * .values()	 Te da todos los conjuntos de arcos (los valores del HashMap).
           addAll()	 Junta todos los arcos de todos los vértices en un único conjunto.
        * */

        for (HashSet<Arco<T>> ar : vertices.values()){
            /*
            * Junta todos los arcos de todos los vértices en un unico conjunto
            * [
                  { (1→2), (1→3) },
                  { (2→3) },
                  { (3→1) }
               ]
            * */
            arcos.addAll(ar);
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            throw new IllegalArgumentException("El vértice con ID " + verticeId + " no existe.");
        }

        //¿Qué hace .iterator()? | Solo crea un "cursor" para recorrer, pero no empieza a recorrer.
        return this.vertices.get(verticeId).iterator();
    }

}
