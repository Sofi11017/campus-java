package s18demo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final ConexionFactory conexiones;

    public UsuarioDAO(ConexionFactory conexiones) {
        this.conexiones = conexiones;
    }

    public int registrar(Usuario usuario) throws SQLException {
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(
                     "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)")) {
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getCorreo());
            return sentencia.executeUpdate();
        }
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> resultado = new ArrayList<>();
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(
                     "SELECT id, nombre, correo FROM usuarios ORDER BY id");
             ResultSet filas = sentencia.executeQuery()) {
            while (filas.next()) {
                resultado.add(new Usuario(filas.getInt("id"), filas.getString("nombre"),
                        filas.getString("correo")));
            }
        }
        return resultado;
    }

    public int actualizarNombre(int id, String nombre) throws SQLException {
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(
                     "UPDATE usuarios SET nombre = ? WHERE id = ?")) {
            sentencia.setString(1, nombre);
            sentencia.setInt(2, id);
            return sentencia.executeUpdate();
        }
    }

    public int eliminar(int id) throws SQLException {
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement("DELETE FROM usuarios WHERE id = ?")) {
            sentencia.setInt(1, id);
            return sentencia.executeUpdate();
        }
    }
}
