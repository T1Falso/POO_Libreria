import java.io.*;
import java.util.*;

abstract class Material {
    protected String codigo;
    protected String titulo;

    public Material(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public abstract String obtenerDatosParaGuardar();
    public abstract void modificarDatos(Scanner sc);
    public abstract String getTipo(); // Para saber el tipo
}

class Libro extends Material {
    private String autor;
    private int paginas;
    private String editorial;
    private String isbn;
    private int anio;
    private int unidades;

    public Libro(String codigo, String titulo, String autor, int paginas, String editorial, String isbn, int anio, int unidades) {
        super(codigo, titulo);
        this.autor = autor;
        this.paginas = paginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anio = anio;
        this.unidades = unidades;
    }

    @Override
    public String obtenerDatosParaGuardar() {
        return codigo + "," + titulo + "," + autor + "," + paginas + "," + editorial + "," + isbn + "," + anio + "," + unidades;
    }

    @Override
    public void modificarDatos(Scanner sc) {
        System.out.println("Información para modificar libro:");
        System.out.print("Nuevo título: ");
        this.titulo = sc.nextLine();
        System.out.print("Nuevo autor: ");
        this.autor = sc.nextLine();
        System.out.print("Nuevas páginas: ");
        this.paginas = Integer.parseInt(sc.nextLine());
        System.out.print("Nueva editorial: ");
        this.editorial = sc.nextLine();
        System.out.print("Nuevo ISBN: ");
        this.isbn = sc.nextLine();
        System.out.print("Nuevo año de publicación: ");
        this.anio = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevas unidades disponibles: ");
        this.unidades = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String getTipo() {
        return "libros";
    }
}

class Revista extends Material {
    private String editorial;
    private String periodicidad;
    private String fechaPublicacion;
    private int unidades;

    public Revista(String codigo, String titulo, String editorial, String periodicidad, String fechaPublicacion, int unidades) {
        super(codigo, titulo);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
        this.unidades = unidades;
    }

    @Override
    public String obtenerDatosParaGuardar() {
        return codigo + "," + titulo + "," + editorial + "," + periodicidad + "," + fechaPublicacion + "," + unidades;
    }

    @Override
    public void modificarDatos(Scanner sc) {
        System.out.println("Información para modificar revista:");
        System.out.print("Nuevo título: ");
        this.titulo = sc.nextLine();
        System.out.print("Nueva editorial: ");
        this.editorial = sc.nextLine();
        System.out.print("Nueva periodicidad: ");
        this.periodicidad = sc.nextLine();
        System.out.print("Nueva fecha de publicación: ");
        this.fechaPublicacion = sc.nextLine();
        System.out.print("Nuevas unidades disponibles: ");
        this.unidades = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String getTipo() {
        return "revistas";
    }
}

class CD extends Material {
    private String artista;
    private String genero;
    private int duracion;
    private int numCanciones;
    private int unidades;

    public CD(String codigo, String titulo, String artista, String genero, int duracion, int numCanciones, int unidades) {
        super(codigo, titulo);
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.numCanciones = numCanciones;
        this.unidades = unidades;
    }

    @Override
    public String obtenerDatosParaGuardar() {
        return codigo + "," + titulo + "," + artista + "," + genero + "," + duracion + "," + numCanciones + "," + unidades;
    }

    @Override
    public void modificarDatos(Scanner sc) {
        System.out.println("Información para modificar CD:");
        System.out.print("Nuevo título: ");
        this.titulo = sc.nextLine();
        System.out.print("Nuevo artista: ");
        this.artista = sc.nextLine();
        System.out.print("Nuevo género: ");
        this.genero = sc.nextLine();
        System.out.print("Nueva duración (minutos): ");
        this.duracion = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo número de canciones: ");
        this.numCanciones = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevas unidades disponibles: ");
        this.unidades = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String getTipo() {
        return "cds";
    }
}

class DVD extends Material {
    private String director;
    private int duracion;
    private String genero;

    public DVD(String codigo, String titulo, String director, int duracion, String genero) {
        super(codigo, titulo);
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
    }

    @Override
    public String obtenerDatosParaGuardar() {
        return codigo + "," + titulo + "," + director + "," + duracion + "," + genero;
    }

    @Override
    public void modificarDatos(Scanner sc) {
        System.out.println("Información para modificar DVD:");
        System.out.print("Nuevo título: ");
        this.titulo = sc.nextLine();
        System.out.print("Nuevo director: ");
        this.director = sc.nextLine();
        System.out.print("Nueva duración (minutos): ");
        this.duracion = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo género: ");
        this.genero = sc.nextLine();
    }

    @Override
    public String getTipo() {
        return "dvds";
    }
}

