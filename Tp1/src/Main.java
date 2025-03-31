public class Main {

    public static void main(String[] args) {

        // Lista simplemente enlazada
        MySimpleLinkedList<Integer> listaSimple = new MySimpleLinkedList<>();
        System.out.println("Insertando en lista simplemente enlazada:");
        listaSimple.insertFront(5);
        listaSimple.insertFront(10);
        listaSimple.insertFront(15);
        System.out.println("Lista simple después de insertFront: " + listaSimple);

        // Lista doblemente enlazada
        MySimpleLinkedList<Integer> listaDoble = new MySimpleLinkedList<>();
        listaDoble.setDoubly(true);
        System.out.println("\nInsertando en lista doblemente enlazada:");
        listaDoble.insertFront(20);
        listaDoble.insertFront(25);
        listaDoble.insertFront(30);
        System.out.println("Lista doble después de insertFront: " + listaDoble);


/*
        MySimpleLinkedList<Integer> listaA = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listaB = new MySimpleLinkedList<Integer>();


        listaA.insertFront(1);
        listaA.insertFront(2);
        listaA.insertFront(3);
        listaA.insertFront(4);
        listaA.insertFront(5);
        listaA.insertFront(6);


        listaB.insertFront(60);
        listaB.insertFront(50);
        listaB.insertFront(40);
        listaB.insertFront(6);
        listaB.insertFront(4);
        listaB.insertFront(2);

        System.out.println("--ListaA--");
        for (Integer l1 : listaA) {
            System.out.println(l1);
        }

        System.out.println("--ListaB--");
        for (Integer l2 : listaB) {
            System.out.println(l2);
        }

        MySimpleLinkedList<Integer> listaComunes = listaA.buildList(listaA, listaB);

        System.out.println("--Lista Comunes--");
        for (Integer l : listaComunes) {
            System.out.println(l);
        }

        ///con otra clase//

        // Crear dos listas desordenadas
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();

        // Insertar elementos en ambas listas (desordenados)
        lista1.insertFront(5);
        lista1.insertFront(2);
        lista1.insertFront(8);
        lista1.insertFront(1);

        lista2.insertFront(3);
        lista2.insertFront(2);
        lista2.insertFront(8);
        lista2.insertFront(7);

        ListUtils<Integer> listUtils = new ListUtils<>();

        // Crear la lista de comunes
        MySimpleLinkedList<Integer> listaComunes2 = listUtils.construirListaComunNoOrdenada(lista1, lista2);

        System.out.println("Elementos comunes (desordenados a ordenados):");
        for (Integer valor : listaComunes2) {
            System.out.println(valor);
        }

        // Limpiar listaComunes para el siguiente caso
        listaComunes2 = new MySimpleLinkedList<>();


        // listas ordenadas
        lista1 = new MySimpleLinkedList<>();
        lista2 = new MySimpleLinkedList<>();
        lista1.insertFront(1);
        lista1.insertFront(2);
        lista1.insertFront(5);
        lista1.insertFront(8);

        lista2.insertFront(2);
        lista2.insertFront(3);
        lista2.insertFront(7);
        lista2.insertFront(8);

        // Construir lista de comunes con listas ordenadas
        listaComunes2 = listUtils.construirListaComunOrdenada(lista1, lista2);

        // Mostrar los resultados
        System.out.println("\nElementos comunes (listas ordenadas):");
        for (Integer valor : listaComunes2) {
            System.out.println(valor);
        }

*/




    }
}
