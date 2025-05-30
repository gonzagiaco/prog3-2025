package Ej5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainEj5 {
    private HashMap<String, List<Integer>> mejorSolucion = new HashMap<>();
    //hay que inicializarlo con un valor maximo porque sino siempre seria menor a cualquier tiempo de la tarea asignada al proce
    private int mejorTiempo = Integer.MAX_VALUE;

    public void ejercicio5(List<Integer> tareas, int cantProcesador) {
        HashMap<String, List<Integer>> procesadores = new HashMap<>();
        for (int i = 0; i < cantProcesador; i++) {
            procesadores.put("P" + (i + 1), new ArrayList<>());
        }
        backtracking(tareas, 0, procesadores);

        // Mostrar resultados
        System.out.println("\nMejor tiempo encontrado: " + mejorTiempo);
        System.out.println("Mejor asignación encontrada:");

        for (String procesador : mejorSolucion.keySet()) {
            List<Integer> tareasAsignadas = mejorSolucion.get(procesador);
            int suma = 0;
            for (int tarea : tareasAsignadas) {
                suma += tarea;
            }
            System.out.printf("%s: %s (Suma: %d)%n", procesador, tareasAsignadas, suma);
        }
    }

    private void backtracking(List<Integer> tareas, int pos, HashMap<String, List<Integer>> procesadores) {
        // Caso base: todas las tareas asignadas
        if (pos == tareas.size()) {
            int tiempoActual = calcularTiempoMaximo(procesadores);
            if (tiempoActual < mejorTiempo) {
                mejorTiempo = tiempoActual;
                copiarSolucion(procesadores);
            }
            return;
        }

        int tareaActual = tareas.get(pos);

        // Probar asignar la tarea actual a cada procesador
        for (String proc : procesadores.keySet()) {
            // Asignar la tarea al procesador actual
            procesadores.get(proc).add(tareaActual);

            // Solo continuar si el tiempo parcial no supera el mejor tiempo encontrado (poda)
            int tiempoParcial = calcularTiempoMaximo(procesadores);
            if (tiempoParcial < mejorTiempo) {
                backtracking(tareas, pos + 1, procesadores);
            }
            // Backtrack: quitar la tarea del procesador
            procesadores.get(proc).remove(procesadores.get(proc).size() - 1);
        }
    }

    private void copiarSolucion(HashMap<String, List<Integer>> procesadores) {
        mejorSolucion.clear();
        for (Map.Entry<String, List<Integer>> entry : procesadores.entrySet()) {
            mejorSolucion.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
    }

    private int calcularTiempoMaximo(HashMap<String, List<Integer>> procesadores) {
        int maxTiempo = 0;

        // Recorrer todos los procesadores
        for (List<Integer> tareasProcesador : procesadores.values()) {
            int sumaTareas = 0;

            // Sumar las tareas del procesador actual
            for (int tiempo : tareasProcesador) {
                sumaTareas += tiempo;
            }

            // Actualizar el máximo si encontramos un tiempo mayor
            if (sumaTareas > maxTiempo) {
                maxTiempo = sumaTareas;
            }
        }

        return maxTiempo;
    }

    public static void main(String[] args) {
        List<Integer> tareas = List.of(2, 4, 7);
        MainEj5 ej = new MainEj5();
        ej.ejercicio5(tareas, 2);
    }
}

