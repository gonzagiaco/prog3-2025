/*
* CLIENTE: DNI, Nombre, Apellido, fecha de nacimiento, domicilio, CP ciudad de origen, saldo
de la cuenta, nombre carrera estudia
*
* */

import java.time.LocalDate;
import java.util.Date;

public class Student {

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_nacimiento;
    private String domicilio;
    private int CP;
    private String ciudad_origen;
    private float saldo_cuenta;

    public Student(String nombre, String apellido, String dni, LocalDate fecha_nacimiento, int CP, String domicilio, String ciudad_origen, float saldo_cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.CP = CP;
        this.domicilio = domicilio;
        this.ciudad_origen = ciudad_origen;
        this.saldo_cuenta = saldo_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getDni(){
        return dni;
    }

    public int getCP() {
        return CP;
    }

    public String getCiudad_origen() {
        return ciudad_origen;
    }

    public float getSaldo_cuenta() {
        return saldo_cuenta;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", domicilio='" + domicilio + '\'' +
                ", CP=" + CP +
                ", ciudad_origen='" + ciudad_origen + '\'' +
                ", saldo_cuenta=" + saldo_cuenta ;
    }
}
