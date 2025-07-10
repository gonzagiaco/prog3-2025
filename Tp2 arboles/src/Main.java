public class Main {
    public static void main(String[] args) {
        Tree arbol = new Tree();

        // Agregamos elementos al árbol
        arbol.add(null);
        arbol.add(null);
        arbol.add(null);
        arbol.add(3);
        arbol.add(7);
        arbol.add(12);
        arbol.add(18);
        arbol.add(null);



        System.out.println("Altura del árbol: " + arbol.getHeight());
        System.out.println(arbol.getLongestBranch());
        System.out.println(arbol.getFrontera());
        System.out.println(arbol.getMaxElem());
        System.out.println(arbol.getElemAtLevel(2));

        arbol.imprimirEnOrden();
        // arbol.delete(15);
        System.out.println(" ");
        arbol.imprimirEnOrden();
        System.out.println(" ");

        System.out.println("Ejercicio 2");
        System.out.println("La sumatoria total es de:  " +         arbol.getSumatoria());

        System.out.println("Ejercicio 3");
        System.out.println(arbol.ejercicio3(6));

        System.out.println("Ejercicio 4");
        arbol.ejercicio4();
        arbol.imprimirEnOrden();






    }
}