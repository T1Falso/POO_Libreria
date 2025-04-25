import java.io.*;
import java.util.*;

public class ListarMateriales {

    static List<Material> materiales = new ArrayList<>();

    public static void main(String[] args) {
        cargarMaterialesDesdeArchivos();
        listarMateriales();
    }

    public static void cargarMaterialesDesdeArchivos() {
        // Listar los tipos de materiales
        String[] tipos = {"libros", "revistas", "cds", "dvds"};

        // Para cada tipo de material, leer el archivo correspondiente
        for (String tipo : tipos) {
            String archivo = tipo + ".txt";
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");
                    // Crear el objeto correspondiente según el tipo
                    Material material = crearMaterial(tipo, datos);
                    if (material != null) {
                        materiales.add(material);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al cargar el archivo " + archivo + ": " + e.getMessage());
            }
        }
    }

    public static Material crearMaterial(String tipo, String[] datos) {
        switch (tipo) {
            case "libros":
                return new Libro(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], datos[5], Integer.parseInt(datos[6]), Integer.parseInt(datos[7]));
            case "revistas":
                return new Revista(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5]));
            case "cds":
                return new CD(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
            case "dvds":
                return new DVD(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]);
            default:
                return null;
        }
    }

    public static void listarMateriales() {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
        } else {
            System.out.println("--- Lista de Materiales ---");
            for (Material material : materiales) {
                System.out.println(material.getTipo().toUpperCase() + " - " + material.getCodigo() + " - " + material.getTitulo());
            }
        }
    }
}
