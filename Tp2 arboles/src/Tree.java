

/*
Ejercicio 1
Implemente la estructura de Árbol Binario para búsquedas.
Métodos:
● Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(),
void add(Integer), boolean delete(Integer), int getHeight(),
void printPosOrder(), void printPreOrder(), void printInOrder(),
List getLongestBranch(), List getFrontera(), Integer getMaxElem(),
List getElemAtLevel(int)
1. ¿Cuál es la complejidad de cada uno de estos métodos?



Ejercicio 2
Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
que retorne la suma de todos los nodos internos del árbol.
* */

import java.util.ArrayList;

public class Tree {

    private TreeNode root;


    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    

    public int getHeight(){
        //en cada recursion bajamos un nivel
        int altura = 0;
        return getHeight(this.root, altura);

    }

    public ArrayList<Integer> getElemAtLevel(int level){
        ArrayList<Integer> elementos = new ArrayList<>();
        if(this.root == null){
            return new ArrayList<Integer>();
        }

        return getElemAtLevel(this.root, level, elementos);
    }

    private ArrayList<Integer>getElemAtLevel(TreeNode actual, int level, ArrayList<Integer> result){

        if (actual == null){
            return result;
        }

        if(level == 0){
            result.add(actual.getValue());
            return result;
        }


        getElemAtLevel(actual.getLeft(),level-1, result);
        getElemAtLevel(actual.getRight(),level-1, result);

        return result;

    }

    public TreeNode delete(Integer num){
        if(this.root == null){
            return null;
        }

        return delete(this.root, num);
    }

    private TreeNode delete(TreeNode actual, Integer num) {
        if (actual == null) {
            return null;
        }

        if (num < actual.getValue()) {
            actual.setLeft(delete(actual.getLeft(), num));
        } else if (num > actual.getValue()) {
            actual.setRight(delete(actual.getRight(), num));
        } else {
            // Nodo encontrado

            // Caso 1: es hoja
            if (actual.getLeft() == null && actual.getRight() == null) {
                return null;
            }

            // Caso 2: un solo hijo
            else if (actual.getLeft() == null) {
                return actual.getRight();
            } else if (actual.getRight() == null) {
                return actual.getLeft();
            }

            // Caso 3: dos hijos
            else {
                TreeNode tmp = NodoMasIzquierdo(actual.getRight());
                actual.setValue(tmp.getValue());
                actual.setRight(delete(actual.getRight(), tmp.getValue()));
                return actual;
            }
        }

        return actual;
    }


    public TreeNode NodoMasIzquierdo(TreeNode nodo) {
        if (nodo == null) return null;
        if (nodo.getLeft() == null) return nodo; // Si no hay izquierda, este es el más izquierdo
        return NodoMasIzquierdo(nodo.getLeft());
    }

    public Integer getMaxElem(){
        if(this.root == null){
            return -1;
        }
        return getMaxElem(this.root);
    }

    public Integer getMaxElem(TreeNode actual){

        if(actual.getRight() == null){
            return actual.getValue();
        }

        return getMaxElem(actual.getRight());
    }

    private int getHeight(TreeNode inicio, int altura){

        if (inicio == null) {
            return altura - 1; // porque llega a un null y hay que restarle el 1 sumado en la llamada recursiva.
        }

        int mayorAlturaIzq = getHeight(inicio.getLeft(), altura + 1);
        int mayorAlturaDer = getHeight(inicio.getRight(), altura + 1);


        return Math.max(mayorAlturaIzq, mayorAlturaDer);

    }

    public ArrayList<Integer> getFrontera(){
        ArrayList<Integer> resultado = new ArrayList<>();
        if (this.root == null){
            return  new ArrayList<>();
        }
        return getFrontera(this.root, resultado);
    }

    private ArrayList<Integer> getFrontera(TreeNode nodo, ArrayList<Integer> resultado){
        if(nodo == null){
            return new ArrayList<>();
        }

        getFrontera(nodo.getLeft(), resultado);
        getFrontera(nodo.getRight(), resultado);

        if(nodo.getLeft() == null && nodo.getRight() == null){
            resultado.add(nodo.getValue());
        }

        return resultado;

    }

    public ArrayList<Integer> getLongestBranch(){
        //Comparar las longitudes de la rama izquierda y la rama derecha.
        if(this.root == null){
            return new ArrayList<>();
        }
        return getLongestBranch(this.root);
    }

    private ArrayList<Integer> getLongestBranch(TreeNode nodo){
        if(nodo == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> ramaMasLargaIzq = getLongestBranch(nodo.getLeft());
        ArrayList<Integer> ramaMasLargaDer = getLongestBranch(nodo.getRight());

        // le pusimo >= para manejar el caso que sean iguales devolvemos la rama del lado izq
        if(ramaMasLargaIzq.size() >= ramaMasLargaDer.size()){
            ramaMasLargaIzq.add(nodo.getValue());
            return ramaMasLargaIzq;
        }else{
            ramaMasLargaDer.add(nodo.getValue());
            return ramaMasLargaDer;
        }
    }

/*
    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int subArbolIzquierdo = getHeight(root.getLeft());
        int subArbolDerecho = getHeight(root.getRight());


        return Math.max(subArbolIzquierdo,subArbolDerecho) + 1;
    }
*/
    public boolean hasElement(Integer valor){
        if(this.root == null){
            return false;
        }else{
            return hasElement(this.root, valor);
        }
    }

    private boolean hasElement(TreeNode nodo, Integer elem) {
        if (nodo.getValue().equals(elem)) {
            return true;
        }
        if (elem < nodo.getValue()) {
            if (nodo.getLeft() != null) {
                return hasElement(nodo.getLeft(), elem);
            } else {
                return false;
            }
        } else if (elem > nodo.getValue()) {
            if (nodo.getRight() != null) {
                return hasElement(nodo.getRight(), elem);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public Integer getRoot(){
       return this.root.getValue();
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public void imprimirPreOrden(){
        imprimirPreOrden(this.root);
    }

    private void imprimirPreOrden(TreeNode nodo)
    {
        if (nodo == null)
            return;
        System.out.print(nodo.getValue() + " ");
        imprimirPreOrden(nodo.getLeft());
        imprimirPreOrden(nodo.getRight());
    }

    public void imprimirPosOrden(){
        imprimirPosOrden(this.root);
    }

    private void imprimirPosOrden(TreeNode nodo)
    {
        if (nodo == null)
            return;
        imprimirPosOrden(nodo.getLeft());
        imprimirPosOrden(nodo.getRight());
        System.out.print(nodo.getValue() + " ");
    }

    public void imprimirEnOrden(){
        imprimirEnOrden(this.root);
    }

    private void imprimirEnOrden(TreeNode nodo)
    {
        if (nodo == null)
            return;
        imprimirEnOrden(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        imprimirEnOrden(nodo.getRight());
    }

    public int getSumatoria(){
        if(this.root == null){
            return -1;
        }
        return getSumatoria(this.root);

    }

    private int getSumatoria(TreeNode actual){
        if(actual == null){
            return 0;
        }

        int sumIzq = getSumatoria(actual.getLeft());
        int sumDer = getSumatoria(actual.getRight());

        int total = actual.getValue() + sumIzq + sumDer;

        return total;
    }


    // no se pregunta si el valor es mayor o menor a raiz
    //Llegamos a la hoja
    //if hoja.getValue() > K , lista.add(hoja.getValue());

    public ArrayList<Integer> ejercicio3(int k){
        ArrayList<Integer> resultado = new ArrayList<>();
        if(this.root == null){
            return new ArrayList<Integer>();
        }

        return ejercicio3(this.root, k, resultado);
    }

    private ArrayList<Integer> ejercicio3(TreeNode actual, int k, ArrayList<Integer> resultado){
        if(actual == null){
            return null;
        }

        if(actual.getLeft() == null && actual.getRight() == null){
            if(actual.getValue() > k){
                resultado.add(actual.getValue());
            }
        }

        // Recorremos ambos lados, sin cortar el flujo
        ejercicio3(actual.getLeft(), k, resultado);
        ejercicio3(actual.getRight(), k, resultado);

        return resultado;
    }

    //if(actual.hijo == null, actual.hijo = 0);
    //actual = actual.getRight() - actual.getLeft();

    //if(actual.getLeft() == null ? 0 : actual.getLeft().getValue();
    //if(actual.getRight() == null ? 0 : actual.getRight().getValue();

    public void ejercicio4(){
        ejercicio4(this.root);
    }

    private int ejercicio4(TreeNode nodo){
        if (nodo == null) {
            return 0;
        }

        if (nodo.getLeft() == null && nodo.getRight() == null) {
            return nodo.getValue(); // hoja
        }

        int valorIzquierdo = ejercicio4(nodo.getLeft());
        int valorDerecho = ejercicio4(nodo.getRight());

        nodo.setValue(valorDerecho - valorIzquierdo);

        return nodo.getValue();
    }


    private void ejercicio44(TreeNode actual){
        if(actual == null){
            return;
        }

        ejercicio4(actual.getLeft());
        ejercicio4(actual.getRight());

        //if (actual.getLeft() == null && actual.getRight() == null) return;

        if(actual.getValue() == null){
            int valorIzq = actual.getLeft() == null ? 0 : actual.getLeft().getValue();
            int valorDer = actual.getRight() == null ? 0 : actual.getRight().getValue();

            actual.setValue(valorDer - valorIzq);
        }

    }

}