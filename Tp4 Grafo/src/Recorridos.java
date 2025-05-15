import java.util.*;

public class Recorridos<T> {
    private Grafo<T> grafo;
    //clave(k) tipo integer = representan vertices del grafo
    //y los valores(v) son de tipo String
    // (que representan el color de cada vértice, como "BLANCO", "AMARILLO", "NEGRO")
    private HashMap<Integer, String> verticePintado;
    private boolean ciclo;
    private Deque<Integer> pila;
    private HashMap<Integer, Boolean> verticeVisitado;


    public boolean isCiclo() {
        return ciclo;
    }

    public Recorridos(Grafo<T> grafo) {
        this.grafo = grafo;
        verticePintado = new HashMap<>();
        this.ciclo = false;
        pila = new ArrayDeque<>();
        verticeVisitado = new HashMap<>();
    }

    public void dfs() {


        Iterator<Integer> vertices = grafo.obtenerVertices();

        while (vertices.hasNext()) {
            /*este los va a pintar a todos de blanco , una vez que pinto todos de blanco , va a ir al dfs_visit*/
            verticePintado.put(vertices.next(), "BLANCO");
        }

        for (Integer vertice : verticePintado.keySet()) {
            String color = verticePintado.get(vertice);
            if (color.equalsIgnoreCase("BLANCO")) {
                dfs_visit(vertice);
            }
        }

     /*
     esta es la forma clasica, el for de arriba es la forma mas simple dehacer esto
     for (Map.Entry<Integer,String> entry:verticePintado.entrySet()) {
            Integer vertice=entry.getKey();
            String color=entry.getValue();
            if (color.equalsIgnoreCase("BLANCO")){
                dfs_visit(vertice);
            }
        }*/
        System.out.println();

    }

    private void dfs_visit(Integer vertice) {
        System.out.println("Visitando Vertice: " + vertice);
        verticePintado.put(vertice, "AMARILLO");
        pila.addLast(vertice);  // <-- push

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);

        while (adyacentes.hasNext()) {
            Integer actual = adyacentes.next();
            if (verticePintado.get(actual).equalsIgnoreCase("BLANCO")) {
                dfs_visit(actual);
            } else if (verticePintado.get(actual).equalsIgnoreCase("AMARILLO")) {
                // Si encontramos un vértice "AMARILLO", hay un ciclo
                ciclo = true;
                // reconstruir el camino
                List<Integer> camino = new ArrayList<>(pila);
                int idx = camino.indexOf(actual);
                List<Integer> caminoPrevioAlCiclo = camino.subList(idx, camino.size());
                //cerramos el ciclo volviendo al punto de inicio
                caminoPrevioAlCiclo.add(actual);
                System.out.println("Ciclo encontrado: " + caminoPrevioAlCiclo);
            }


        }
        pila.removeLast();   // <-- pop remueve cuando un grafo fue visitado osea sale del while
        verticePintado.put(vertice, "NEGRO");
        System.out.println("Vertice Terminado: " + vertice);
    }


    public void dfs_ej4(Integer inicio, Integer destino) {
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> mayorCamino = new ArrayList<>();
        System.out.println(mayorCamino);
        Iterator<Integer> vertices = grafo.obtenerVertices();

        while (vertices.hasNext()) {
            /*este los va a pintar a todos de blanco , una vez que pinto todos de blanco , va a ir al dfs_visit*/
            verticePintado.put(vertices.next(), "BLANCO");
        }

        for (Integer vertice : verticePintado.keySet()) {
            String color = verticePintado.get(vertice);
            if (color.equalsIgnoreCase("BLANCO")) {
                dfs_visit_ej4(inicio, destino, caminoActual, mayorCamino);
            }
        }
        System.out.println("Camino maasssssssssssssss largo entre " + inicio + " y " + destino + ": " + mayorCamino);

    }

    private void dfs_visit_ej4(Integer inicio, Integer destino, List<Integer> caminoActual, List<Integer> mayorCamino) {
        System.out.println("Visitando Vertice: " + inicio);
        verticePintado.put(inicio, "AMARILLO");

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(inicio);
        if (inicio.equals(destino)) {
            if (caminoActual.size() > mayorCamino.size()) {
                mayorCamino.clear();
                mayorCamino.addAll(caminoActual);
            }
        }
        caminoActual.add(inicio);
        while (adyacentes.hasNext()) {

            Integer actual = adyacentes.next();
            if (verticePintado.get(actual).equalsIgnoreCase("BLANCO")) {
                dfs_visit_ej4(actual, destino, caminoActual, mayorCamino);
            } else if (verticePintado.get(actual).equalsIgnoreCase("AMARILLO")) {
                // Si encontramos un vértice "AMARILLO", hay un ciclo
                ciclo = true;
            }


        }
        verticePintado.put(inicio, "BLANCO");
        caminoActual.remove(caminoActual.size() - 1);
    }


    public void Bfs() {
        pila.clear();
        Iterator<Integer> vertice = grafo.obtenerVertices();
        while (vertice.hasNext()) {
            Integer verticeId = vertice.next();
            verticeVisitado.put(verticeId, false);
        }
        for (Integer verticeId : verticeVisitado.keySet()) {
            if (!verticeVisitado.get(verticeId)) {
                bfsVisit(verticeId, grafo);
            }
        }
    }

    private void bfsVisit(Integer verticeId, Grafo<T> grafo) {
        verticeVisitado.put(verticeId, true);
        pila.add(verticeId);
        while (!pila.isEmpty()) {
            Integer verticeActual = pila.poll();
            System.out.println("Visitando: " + verticeActual);
            Iterator<Integer> adyacente = grafo.obtenerAdyacentes(verticeActual);
            if (adyacente.hasNext()) {
                Integer adyacenteId = adyacente.next();
                if (!verticeVisitado.get(adyacenteId)) {
                    verticeVisitado.put(adyacenteId, true);
                    pila.add(adyacenteId);
                }
            }

        }
    }


    public void ObtenerMayorCaminoEntre2Vertices(Integer origen, Integer destino) {
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> mayorCamino = new ArrayList<>();
        HashSet<Integer> visitados = new HashSet<>();
        obtenerMayorCaminoDFS(origen, destino, caminoActual, mayorCamino, visitados);

        if (mayorCamino.isEmpty()) {
            System.out.println("No hay camino entre " + origen + " y " + destino);
        } else {
            System.out.println("Mayor camino entre " + origen + " y " + destino + ": " + mayorCamino);
        }
    }


    private void obtenerMayorCaminoDFS(Integer actual, Integer destino, List<Integer> caminoActual, List<Integer> mayorCamino, HashSet<Integer> visitados) {
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual.equals(destino)) {
            if (caminoActual.size() > mayorCamino.size()) {
                mayorCamino.clear();
                mayorCamino.addAll(caminoActual);
            }
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                Integer ady = adyacentes.next();
                if (!visitados.contains(ady)) {
                    obtenerMayorCaminoDFS(ady, destino, caminoActual, mayorCamino, visitados);
                }
            }
        }
        // backtrack
        visitados.remove(actual);
        caminoActual.remove(caminoActual.size() - 1);

    }

    public HashMap<Integer, String> getVerticePintado() {
        return verticePintado;
    }

    public void ejercicio5(Integer verticeDestino) {
        ArrayList<Integer> verticesConCamino = new ArrayList<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();

        while (vertices.hasNext()) {
            verticePintado.put(vertices.next(), "BLANCO");

        }
        for (Integer v : verticePintado.keySet()) {
            String color = verticePintado.get(v);
            if (color.equalsIgnoreCase("BLANCO")) {
                if (existeCamino(v, verticeDestino)) {
                    System.out.println(" Hay camino desde " + v + " a " + verticeDestino);
                    verticesConCamino.add(v);
                } else {
                    System.out.println(" No hay camino desde " + v + " a " + verticeDestino);
                }
            }
        }
        //usamos remove para no incluir el numero destino por definicion de grafos
        verticesConCamino.remove(verticeDestino);

        System.out.println("\n Vértices que llegan a " + verticeDestino + ": " + verticesConCamino);
    }

    private boolean existeCamino(Integer vertice, Integer verticeDestino) {
        System.out.println(" Entrando a " + vertice + " (buscando " + verticeDestino + ")");
        verticePintado.put(vertice, "AMARILLO");

        boolean encontrado = false;
        if (vertice.equals(verticeDestino)) {
            System.out.println(" Llegamos al destino: " + vertice);
            encontrado = true;
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
            while (adyacentes.hasNext() && !encontrado) {
                Integer ady = adyacentes.next();
                System.out.println(vertice + " → " + ady + " (estado: " + verticePintado.get(ady) + ")");
                if (verticePintado.get(ady).equals("BLANCO")) {
                    if (existeCamino(ady, verticeDestino)) {
                        encontrado = true;
                    }
                }
            }
        }

        // backtracking siempre
        verticePintado.put(vertice, "BLANCO");

        if (!encontrado) {
            System.out.println(" Backtracking desde " + vertice);
        }
        return encontrado;
    }

    /**
     * ejercicio 6
     * Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
     * es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
     * esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
     * cantidad de cuadras posible.
     */


    public void ejercio6_bfs(Integer inicio, Integer destino, Grafo<T> grafo) {
        HashMap<Integer, Integer> padre = new HashMap<>();
        boolean noEcontroDestino = true;

        verticeVisitado.put(inicio, true);
        pila.add(inicio);
        padre.put(inicio, null);

        while (!pila.isEmpty() && noEcontroDestino) {

            Integer verticeActual = pila.poll();
            if (verticeActual.equals(destino)) {
                noEcontroDestino = false;
            }

            Iterator<Integer> adyacente = grafo.obtenerAdyacentes(verticeActual);
            if (adyacente.hasNext()) {
                Integer adyacenteId = adyacente.next();
                if (!verticeVisitado.getOrDefault(adyacenteId, false)) {
                    verticeVisitado.put(adyacenteId, true);
                    pila.add(adyacenteId);
                    padre.put(adyacenteId, verticeActual);

                }

            }

        }
        System.out.println("Camino mas corto " + recostruirCamino(inicio,destino,padre) + " inicio del grafo: " + inicio + " destino: " + destino);
    }

    public List<Integer>recostruirCamino(Integer inicio,  Integer destino, HashMap<Integer,Integer>padre){
        List<Integer>camino = new ArrayList<>();
        Integer caminoActual = destino;
        while (caminoActual!=null){
            camino.add(0,caminoActual); //inserta siempre al principio
            caminoActual = padre.get(caminoActual);
        }
        if (!camino.isEmpty() && camino.get(0).equals(inicio)){
            return camino;
        }else {
            return new ArrayList<>();
        }
    }


}

