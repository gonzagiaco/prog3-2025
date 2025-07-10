package Ej9;

import java.util.List;

public class Ej9 {
    private int N = 4;
    private int [][] solucion;

    public int[][] ejercicio9(int[][] tablero, int posFila, int posColumna) {
        solucion = new int[N][N];
        back(tablero, posFila, posColumna);
        return solucion;
    }

    private void back(int[][] tablero,int fila,int columna) {
        if (esTableroOrdenado(tablero) && tablero[N - 1][N - 1] == 0) {
            solucion=tablero;
        }else {
            List<int[]> contiguos = obtenerContiguos(fila,columna);
            for(int[] pos : contiguos){
                int x=pos[0]; //fila vecina
                int y=pos[1]; //col vecina

                cambiarContiguos(tablero,fila,columna,x,y);
                back(tablero,x,y);
                deshacerContiguos(tablero,fila,columna,x,y);
            }
        }
    }
}
