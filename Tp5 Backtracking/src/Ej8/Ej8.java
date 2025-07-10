package Ej8;
import java.util.List;
public class Ej8 {

    /**
     * Ejercicio 8
     * Colocar un entero positivo (menor que un cierto valor entero k dado) en cada casilla de una
     * pirámide de base B (valor entero dado) de modo que cada número sea igual a la suma de las
     * casillas sobre las que está apoyado. Los números de todas las casillas deben ser diferentes
     */

        private  List<Casillero> usados;
        private List<List<Casillero>>solucion;

        public void ejercicio8(List<List<Casillero>> piramide, int k, int b){
            int totalCasilleros = b*(b+1)/2;
            back(0,totalCasilleros,k,piramide);

        }
        public void back(int pos, int totalCasilleros,int k,List<List<Casillero>>piramide){
            //si ya se recurrio el total de casilleros
            if(i==totalCasilleros){
                if(esSolucionValida(piramide)){
                    solucion.addAll(piramide);
                }
            }else {
                Casillero actual = getCasilleroenPos(pos, piramide);
                for(int num = 1; num <k; num++){
                    if(!usados.contains(num)){
                        actual.setValor(num);
                        usados.add(actual);
                        piramide.add(pos,actual);
                        if (esValido(piramide,actual)){//esValido verificaria que la suma de la fila y col del casillero sea iugal al que estta apoyado
                            back(pos+1,totalCasilleros,k,piramide);
                        }
                        usados.remove(actual);
                        actual.setValor(0);
                    }
                }
            }
        }

    }


