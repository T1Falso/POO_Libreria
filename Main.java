import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

public class Main {
    static List<Material> materiales = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Agregar material");
            System.out.println("2. Modificar material");
            System.out.println("3. Listar materiales");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregarMaterial(sc);
                case 2 -> modificarMaterial(sc);
                case 3 -> listarMateriales(sc);
                default -> System.out.println("Opción no válida.");
            }

            System.out.print("¿Desea realizar otra acción? (s/n): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("¡Gracias por usar el sistema de la mediateca!");
    }

    public static void guardarEnArchivo(Material material) {
        String archivo = material.getTipo() + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(material.obtenerDatosParaGuardar());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static void sobrescribirArchivo(String tipo) {
        String archivo = tipo + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Material m : materiales) {
                if (m.getTipo().equals(tipo)) {
                    bw.write(m.obtenerDatosParaGuardar());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir archivo: " + e.getMessage());
        }
    }

    public static void listarMateriales(Scanner sc) {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }

        // Crear las columnas para el JTable
        String[] columnas = {"Tipo", "Código", "Título"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Llenar la tabla con los materiales
        for (Material material : materiales) {
            modelo.addRow(new Object[]{material.getTipo().toUpperCase(), material.getCodigo(), material.titulo});
        }

        // Crear la tabla y mostrarla en una ventana
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        JFrame frame = new JFrame("Lista de Materiales");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(scroll);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void agregarMaterial(Scanner sc) {
        System.out.println("--- Agregar Material ---");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. CD de audio");
        System.out.println("4. DVD");
        System.out.print("Seleccione el tipo de material: ");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1 -> agregarLibro(sc);
            case 2 -> agregarRevista(sc);
            case 3 -> agregarCD(sc);
            case 4 -> agregarDVD(sc);
            default -> System.out.println("Opción no válida.");
        }
    }

    public static void modificarMaterial(Scanner sc) {
        System.out.print("Ingrese el código del material a modificar: ");
        String codigo = sc.nextLine();

        Material material = buscarMaterial(codigo);
        if (material != null) {
            System.out.print("¿Desea modificar este material? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                material.modificarDatos(sc);
                sobrescribirArchivo(material.getTipo());
                System.out.println("Material modificado.");
            } else {
                System.out.println("Modificación cancelada.");
            }
        } else {
            System.out.println("Material no encontrado.");
        }
    }

    public static Material buscarMaterial(String codigo) {
        for (Material material : materiales) {
            if (material.codigo.equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    public static void agregarLibro(Scanner sc) {
        String codigo = "LIB" + String.format("%05d", materiales.size() + 1);
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Número de páginas: ");
        int paginas = Integer.parseInt(sc.nextLine());
        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Unidades disponibles: ");
        int unidades = Integer.parseInt(sc.nextLine());

        Libro libro = new Libro(codigo, titulo, autor, paginas, editorial, isbn, anio, unidades);
        materiales.add(libro);
        guardarEnArchivo(libro);
        System.out.println("Libro agregado con código: " + codigo);
    }

    public static void agregarRevista(Scanner sc) {
        String codigo = "REV" + String.format("%05d", materiales.size() + 1);
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Periodicidad: ");
        String periodicidad = sc.nextLine();
        System.out.print("Fecha de publicación: ");
        String fecha = sc.nextLine();
        System.out.print("Unidades disponibles: ");
        int unidades = Integer.parseInt(sc.nextLine());

        Revista revista = new Revista(codigo, titulo, editorial, periodicidad, fecha, unidades);
        materiales.add(revista);
        guardarEnArchivo(revista);
        System.out.println("Revista agregada con código: " + codigo);
    }

    public static void agregarCD(Scanner sc) {
        String codigo = "CDA" + String.format("%05d", materiales.size() + 1);
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Artista: ");
        String artista = sc.nextLine();
        System.out.print("Género: ");
        String genero = sc.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(sc.nextLine());
        System.out.print("Número de canciones: ");
        int canciones = Integer.parseInt(sc.nextLine());
        System.out.print("Unidades disponibles: ");
        int unidades = Integer.parseInt(sc.nextLine());

        CD cd = new CD(codigo, titulo, artista, genero, duracion, canciones, unidades);
        materiales.add(cd);
        guardarEnArchivo(cd);
        System.out.println("CD agregado con código: " + codigo);
    }

    public static void agregarDVD(Scanner sc) {
        String codigo = "DVD" + String.format("%05d", materiales.size() + 1);
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Director: ");
        String director = sc.nextLine();
        System.out.print("Duración (minutos): ");
        int duracion = Integer.parseInt(sc.nextLine());
        System.out.print("Género: ");
        String genero = sc.nextLine();

        DVD dvd = new DVD(codigo, titulo, director, duracion, genero);
        materiales.add(dvd);
        guardarEnArchivo(dvd);
        System.out.println("DVD agregado con código: " + codigo);
    }
}
