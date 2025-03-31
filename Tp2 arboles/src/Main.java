public class Main {
    public static void main(String[] args) {
        Tree arbol = new Tree();

        // Agregamos elementos al árbol
        arbol.add(10);
        arbol.add(5);
        arbol.add(15);
        arbol.add(3);
        arbol.add(7);
        arbol.add(12);
        arbol.add(18);
        arbol.add(20);


        System.out.println("Altura del árbol: " + arbol.getHeight());
        System.out.println(arbol.getLongestBranch());
        System.out.println(arbol.getFrontera());

    }
}