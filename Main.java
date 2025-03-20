public class Main {

    public static void main(String[] args) {

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


        MySimpleLinkedList<Integer> listaComunes = listaA.buildList(listaA, listaB);

        System.out.println("--ListaA--");
        for (Integer l1 : listaA) {
            System.out.println(l1);
        }

        System.out.println("--ListaB--");
        for (Integer l2 : listaB) {
            System.out.println(l2);
        }

        System.out.println("--Lista Comunes--");
        for (Integer l : listaComunes) {
            System.out.println(l);
        }
    }
}
