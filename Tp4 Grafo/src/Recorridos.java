import java.util.*;

public class Recorridos<T> {
    private Grafo<T> grafo;
    //clave(k) tipo integer = representan vertices del grafo
    //y los valores(v) son de tipo String
    // (que representan el color de cada vértice, como "BLANCO", "AMARILLO", "NEGRO")
    private HashMap<Integer,String>verticePintado;
    private boolean ciclo;
    private Deque<Integer> pila;


    public boolean isCiclo() {
        return ciclo;
    }

    public Recorridos(Grafo<T> grafo) {
        this.grafo = grafo;
        verticePintado=new HashMap<>();
        this.ciclo=false;
        pila = new ArrayDeque<>();
    }

    public void dfs(){


        Iterator<Integer> vertices =grafo.obtenerVertices();

        while (vertices.hasNext()){
            /*este los va a pintar a todos de blanco , una vez que pinto todos de blanco , va a ir al dfs_visit*/
            verticePintado.put(vertices.next(),"BLANCO");
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

    private void dfs_visit(Integer vertice){
        System.out.println("Visitando Vertice: "+vertice);
        verticePintado.put(vertice,"AMARILLO");
        pila.addLast(vertice);  // <-- push

        Iterator<Integer>adyacentes=grafo.obtenerAdyacentes(vertice);

        while (adyacentes.hasNext()){
            Integer actual= adyacentes.next();
            if (verticePintado.get(actual).equalsIgnoreCase("BLANCO")){
                dfs_visit(actual);
            }else if (verticePintado.get(actual).equalsIgnoreCase("AMARILLO")) {
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
        verticePintado.put(vertice,"NEGRO");
        System.out.println("Vertice Terminado: "+vertice);
    }


    public void dfs_ej4(Integer inicio, Integer destino){
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> mayorCamino = new ArrayList<>();
        System.out.println(mayorCamino);
        Iterator<Integer> vertices =grafo.obtenerVertices();

        while (vertices.hasNext()){
            /*este los va a pintar a todos de blanco , una vez que pinto todos de blanco , va a ir al dfs_visit*/
            verticePintado.put(vertices.next(),"BLANCO");
        }

        for (Integer vertice : verticePintado.keySet()) {
            String color = verticePintado.get(vertice);
            if (color.equalsIgnoreCase("BLANCO")) {
                dfs_visit_ej4(inicio, destino,caminoActual,mayorCamino);
            }
        }
        System.out.println("Camino maasssssssssssssss largo entre " + inicio + " y " + destino + ": " + mayorCamino);

    }

    private void dfs_visit_ej4(Integer inicio, Integer destino,List<Integer> caminoActual,List<Integer> mayorCamino){
        System.out.println("Visitando Vertice: "+inicio);
        verticePintado.put(inicio,"AMARILLO");

        Iterator<Integer>adyacentes=grafo.obtenerAdyacentes(inicio);
        if (inicio.equals(destino)){
            if (caminoActual.size()>mayorCamino.size()){
                mayorCamino.clear();
                mayorCamino.addAll(caminoActual);
            }
        }
        caminoActual.add(inicio);
        while (adyacentes.hasNext()){

            Integer actual= adyacentes.next();
            if (verticePintado.get(actual).equalsIgnoreCase("BLANCO")){
                dfs_visit_ej4(actual,destino,caminoActual,mayorCamino);
            }else if (verticePintado.get(actual).equalsIgnoreCase("AMARILLO")) {
                // Si encontramos un vértice "AMARILLO", hay un ciclo
                ciclo = true;
            }


        }
        verticePintado.put(inicio,"BLANCO");
        caminoActual.remove(caminoActual.size()-1);
    }


    public void bfs() {
        // Vaciar y pintar todos los vértices de blanco (NO_VISITADO)
        Iterator<Integer> vertices = grafo.obtenerVertices();
        verticePintado.clear();
        while (vertices.hasNext()) {
            verticePintado.put(vertices.next(), "BLANCO");
        }

        // Recorrer cada vértice
        for (Integer vertice : verticePintado.keySet()) {
            if (verticePintado.get(vertice).equals("BLANCO")) {
                bfs_visit(vertice);
            }
        }
    }

    private void bfs_visit(Integer origen) {
        Queue<Integer> fila = new LinkedList<>();
        verticePintado.put(origen, "GRIS"); // GRIS puede representar VISITADO pero no terminado
        fila.offer(origen);

        while (!fila.isEmpty()) {
            Integer actual = fila.poll();
            System.out.println("Visitando vértice: " + actual);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                Integer ady = adyacentes.next();
                if (verticePintado.get(ady).equals("BLANCO")) {
                    verticePintado.put(ady, "GRIS");
                    fila.offer(ady);
                }
            }

            verticePintado.put(actual, "NEGRO"); // NEGRO puede representar terminado
            System.out.println("Vértice terminado: " + actual);
        }
    }


    public void ObtenerMayorCaminoEntre2Vertices(Integer origen, Integer destino){
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
        
        /*
        * el primer camino es 1 2 3 4 5
        * remuevo actual osea el 5
        * y edspues remueve el size - 4  ( 1 2 3)
        * */
    }

    public HashMap<Integer, String> getVerticePintado() {
        return verticePintado;
    }



}
