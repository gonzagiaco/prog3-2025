import java.time.LocalDate;

public class Biblioteca {
    private Integer id;
    private String titulo,autor,genero;
    private int anioPublicacion;
    private int cantEjemplares;

    public Biblioteca(int id,String titulo,String autor,String genero, int aniopubli,int cantEjem){
        this.titulo=titulo;
        this.id=id;
        this.autor=autor;
        this.genero=genero;
        this.anioPublicacion=aniopubli;
        this.cantEjemplares=cantEjem;

    }

    public String getTitulo() {
        return titulo;
    }
    public Integer getId(){
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    @Override
    public String toString(){
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", cantEjemplares=" + cantEjemplares +
                '}';
    }
}
