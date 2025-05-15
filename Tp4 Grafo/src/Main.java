import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Crear el grafo dirigido
        GrafoDirigido<String> grafo = new GrafoDirigido<>();


        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar arcos
        grafo.agregarArco(1, 2, "A");
        grafo.agregarArco(1, 3, "B");
        grafo.agregarArco(2, 3, "C");
        grafo.agregarArco(4, 5, "D");
        grafo.agregarArco(5, 3, "E");

        // Mostrar cantidad de vértices y arcos
        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

        // Obtener e imprimir los vértices
        System.out.print("Vértices: ");
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while (verticesIterator.hasNext()) {
            System.out.print(verticesIterator.next() + " ");
        }
        System.out.println();

        // Obtener adyacentes de un vértice
        System.out.print("Vértices adyacentes a 1: ");
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(1);
        while (adyacentes.hasNext()) {
            System.out.print(adyacentes.next() + " ");
        }
        System.out.println();

        // Obtener arcos de un vértice
        System.out.print("Arcos salientes de 1: ");
        Iterator<Arco<String>> arcosDe1 = grafo.obtenerArcos(1);
        while (arcosDe1.hasNext()) {
            Arco<String> arco = arcosDe1.next();
            System.out.print("(" + arco.getVerticeOrigen() + "→" + arco.getVerticeDestino() + ":" + arco.getEtiqueta() + ") ");
        }
        System.out.println();

        // Obtener todos los arcos
        System.out.print("Todos los arcos: ");
        Iterator<Arco<String>> todosLosArcos = grafo.obtenerArcos();
        while (todosLosArcos.hasNext()) {
            Arco<String> arco = todosLosArcos.next();
            System.out.print("(" + arco.getVerticeOrigen() + "→" + arco.getVerticeDestino() + ":" + arco.getEtiqueta() + ") ");
        }
        System.out.println();

        // Borrar un arco
        grafo.borrarArco(1, 2);
        System.out.println("Se borró el arco de 1→2");

        // Verificar si el arco existe
        if (grafo.existeArco(1, 2)) {
            System.out.println("El arco 1→2 existe.");
        } else {
            System.out.println("El arco 1→2 no existe.");
        }

        // Borrar un vértice
        grafo.borrarVertice(3);
        System.out.println("Se borró el vértice 3");

        // Verificar cantidad de vértices y arcos después de borrado
        System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());


        GrafoDirigido<String> grafo2 = new GrafoDirigido<>();

        // Agregar vértices
        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(6);



        // Agregar arcos
        grafo2.agregarArco(1,2,"O");
        grafo2.agregarArco(2, 3, "A");
        grafo2.agregarArco(4, 5, "B");
        grafo2.agregarArco(3, 6, "C");
        grafo2.agregarArco(6,4,"D");


        // Instanciar la clase Recorridos
        Recorridos<String> recorridos = new Recorridos<>(grafo2);

        // Ejecutar el DFS
        recorridos.dfs();

        // Mostrar los resultados del recorrido
        System.out.println("Estado final de los vértices: " + recorridos.getVerticePintado());
        if (recorridos.isCiclo()) {
            System.out.println("Se encontró un ciclo en el grafo.");
        } else {
            System.out.println("No se encontró ningún ciclo.");
        }

        recorridos.ObtenerMayorCaminoEntre2Vertices(1,5);

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("EJERCICIO 5 ");
        // Crear el grafo dirigido
        GrafoDirigido<String> grafoEjercico5 = new GrafoDirigido<>();

// Agregar vértices
        grafoEjercico5.agregarVertice(1);
        grafoEjercico5.agregarVertice(2);
        grafoEjercico5.agregarVertice(3);
        grafoEjercico5.agregarVertice(4);
        grafoEjercico5.agregarVertice(5);

// Agregar arcos
        grafoEjercico5.agregarArco(1, 2, "A");
        grafoEjercico5.agregarArco(1, 3, "B");
        grafoEjercico5.agregarArco(2, 5, "C");
        grafoEjercico5.agregarArco(4, 5, "D");
        grafoEjercico5.agregarArco(5, 3, "E");


        Recorridos<String> recorridosej5 = new Recorridos<>(grafoEjercico5);

        recorridosej5.ejercicio5(3);

        System.out.println("");
        System.out.println("Ejercicio 6");

        recorridosej5.ejercio6_bfs(1,5,grafoEjercico5);


    }


}
