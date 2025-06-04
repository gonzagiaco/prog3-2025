import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Moneda m1 = new Moneda();
        List<Integer> moneda = new ArrayList<>();
        moneda.add(100);
        moneda.add(25);
        moneda.add(50);
        moneda.add(10);
        moneda.add(5);
        moneda.add(1);

        m1.setCandidato(moneda);
        System.out.println(m1.greedy(289));
    }
}