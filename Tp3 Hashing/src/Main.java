import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        /*HashMap<String, String> cliente = new HashMap<>();

        cliente.put("40289369", "Luciano");

        System.out.println(cliente.get("40289369"));

        System.out.println(cliente.containsKey("Luciano"));
        System.out.println(cliente.containsValue("Luciano"));
        */
    try{
    /*    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha1 = LocalDate.parse("19/05/1997", formatter);
        LocalDate fecha2 = LocalDate.parse("29/12/1999", formatter);
        LocalDate fecha3 = LocalDate.parse("29/12/1999", formatter);



        Student alumno1 = new Student("Luciano","Oroquieta","40289369",fecha1,7020,"9 de julio 1257","Benito Juarez", 5000.67F);
        Student alumno2 = new Student("Nicolas","Pollano","42109380",fecha2,5490,"caca esquina 256","Las Varillas", 2000.3F);
        Student alumno3 = new Student("Martiniano","Weber","43109400",fecha3,7020,"algun barrio 123","Benito Juarez", 3000.3F);



        HashMap<String, Student> alumnos = new HashMap<>();
        alumnos.put(alumno1.getDni(), alumno1);
        alumnos.put(alumno2.getDni(), alumno2);
        alumnos.put(alumno3.getDni(), alumno3);

        //Ejercicio 3-A
        //a) Dado un DNI de cliente, responder el saldo de su cuenta.
        System.out.println("Ejercicio 3-A");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese su DNI para buscar el saldo de su cuenta: ");
        String dniIngresado = reader.readLine();

        Student buscado = alumnos.get(dniIngresado);

        if(buscado!= null){
            System.out.println("el saldo de la cuenta de " + buscado.getNombre() + " " + buscado.getApellido() + " $" + buscado.getSaldo_cuenta());
        }else{
            System.out.println("No se encontro un alumno con ese DNI");
        }


        //Ejercicio 3-B
        //b) Imprimir un listado de Nombre y Apellido de todos los clientes que tienen en su saldo
        //de cuenta menos de un valor X dado.
        System.out.println("");
        System.out.println("Ejercicio 3-B");

        float valorX = 5000.0f;
        List<Student> listadoEstudiantes = new ArrayList<>();
        listadoEstudiantes.add(alumno1);
        listadoEstudiantes.add(alumno2);
        listadoEstudiantes.add(alumno3);

        System.out.println("Clientes con saldo menor a $" + valorX);
        for (Student s: listadoEstudiantes){
            if (s.getSaldo_cuenta() < valorX){
                System.out.println(s.getNombre() + " " + s.getApellido() + " el saldo que tienen es de: " + s.getSaldo_cuenta());
            }
        }


        //Ejercicio 3-C
        //c) Dado un código postal, listar todos los clientes que provengan de esa ciudad.
        System.out.println("");
        System.out.println("Ejercicio 3-C");

        int cp = 7020;

        for (Student s: listadoEstudiantes){
            if (s.getCP() == cp){
                System.out.println(s.getNombre() + " " + s.getApellido() + " proveniente de : " + s.getCiudad_origen() + " cp: " + s.getCP());
            }
        }

        //con hashmap
        for (Map.Entry<String, Student> entry : alumnos.entrySet()) {
            Student s = entry.getValue();
            if (s.getCP() == cp) {
                System.out.println(s.getNombre() + " " + s.getApellido() + " proveniente de: " + s.getCiudad_origen() + " (CP: " + s.getCP() + ")");
            }
        }

        */


    }catch (Exception exc){
        System.out.println(exc);
    }


        Biblioteca b1 = new Biblioteca(1,"La cabra vol.1","DjLulox","Sexo",1997,2);
        Biblioteca b2 = new Biblioteca(2,"50 sombras de mica", "Mica","Romance",2020,5);
        Biblioteca b3 = new Biblioteca(3,"obra y vida de los downs","ElTomiii","Psicologia",1957,20);
        Biblioteca b4 = new Biblioteca(3,"freud y los gays","freud","Psicologia",2009,5);
        Biblioteca b5 = new Biblioteca(3,"el psicoanalisis del el tomiii","ElTomiii","Psicologia",2000,10);


        HashMap<Integer,Biblioteca> libros = new HashMap<>();

        libros.put(b1.getId(),b1);
        libros.put(b1.getId(),b2);
        libros.put(b1.getId(),b3);

        //Obtener la cantidad de ejemplares de un libro dado su identificador único.

        System.out.println("Ejercicio 4-A");
        Integer idBuscado = 1;
        Biblioteca buscado = libros.get(idBuscado);
        System.out.println("Cantidad de ejemplares: " + buscado.getCantEjemplares() + " del id: " + buscado);

        System.out.println("");
        System.out.println("Ejercicio 4-B");

        //Obtener todos los libros de un género dado.
        String generoBuscado = "Psicologia";

        List<Biblioteca>bibliotecas = new ArrayList<>();
        bibliotecas.add(b1);
        bibliotecas.add(b2);
        bibliotecas.add(b3);
        bibliotecas.add(b4);
        bibliotecas.add(b5);

        for (Biblioteca b : bibliotecas){
            if(b.getGenero().equals(generoBuscado)){
                System.out.println(b);
            }
        }

        System.out.println("");
        System.out.println("Ejercicio 4-C");
        //Obtener todos los libros publicados entre dos años de publicación dados.
        int fecha1 = 1997, fecha2 = 2020;

        for (Biblioteca b : bibliotecas){
            if (b.getAnioPublicacion()>=fecha1 && b.getAnioPublicacion()<=fecha2){
                System.out.println(b);
            }
        }




    }
}