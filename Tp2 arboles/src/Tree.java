

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
* */

import java.sql.Array;
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

}