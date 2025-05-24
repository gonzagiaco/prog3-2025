public class Main {
    public static void main(String[] args) {

        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();


        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 20);
        grafo.agregarArco(2, 5, 30);
        grafo.agregarArco(3, 4, 40);
        grafo.agregarArco(4, 5, 50);

        HabitacionesBack<Integer> salasHentai = new HabitacionesBack<>(grafo);


        System.out.println( salasHentai.conjuntoDeSalas(1,5));

    }
}
