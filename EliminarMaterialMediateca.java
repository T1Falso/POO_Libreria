
// ConexionBD.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/mediateca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

// GestorBD.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestorBD {
    public static boolean eliminarMaterial(String codigo) {
        String tabla = "";
        if (codigo.startsWith("LIB")) tabla = "libros";
        else if (codigo.startsWith("REV")) tabla = "revistas";
        else if (codigo.startsWith("CDA")) tabla = "cds_audio";
        else if (codigo.startsWith("DVD")) tabla = "dvds";
        else return false;

        String sql = "DELETE FROM " + tabla + " WHERE codigo = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

// EjemploUso.java
import javax.swing.*;

public class EjemploUso {
    public static void main(String[] args) {
        JButton btnEliminar = new JButton("Eliminar de BD");
        btnEliminar.addActionListener(e -> {
            String codigo = JOptionPane.showInputDialog("Ingrese el código del material a eliminar:");
            if (codigo != null && !codigo.trim().isEmpty()) {
                boolean eliminado = GestorBD.eliminarMaterial(codigo);
                if (eliminado) {
                    JOptionPane.showMessageDialog(null, "Material eliminado de la base de datos.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el material o ocurrió un error.");
                }
            }
        });

        JFrame frame = new JFrame("Eliminar Material");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.add(btnEliminar);
        frame.setVisible(true);
    }
}
