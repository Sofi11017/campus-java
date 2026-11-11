package s18lab01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private final ConexionFactory conexiones;

    public ProductoDAO(ConexionFactory conexiones) {
        this.conexiones = conexiones;
    }

    public int registrar(Producto producto) throws SQLException {
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(
                     "INSERT INTO productos (nombre, stock) VALUES (?, ?)")) {
            sentencia.setString(1, producto.getNombre());
            sentencia.setInt(2, producto.getStock());
            return sentencia.executeUpdate();
        }
    }

    public List<Producto> listar() throws SQLException {
        List<Producto> resultado = new ArrayList<>();
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(
                     "SELECT id, nombre, stock FROM productos ORDER BY id");
             ResultSet filas = sentencia.executeQuery()) {
            while (filas.next()) {
                resultado.add(new Producto(
                        filas.getInt("id"),
                        filas.getString("nombre"),
                        filas.getInt("stock")
                ));
            }
        }
        return resultado;
    }

    public int actualizarStock(int id, int stock) throws SQLException {
        try (Connection conexion = conexiones.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(
                     "UPDATE productos SET stock = ? WHERE id = ?")) {
            sentencia.setInt(1, stock);
            sentencia.setInt(2, id);
            return sentencia.executeUpdate();
        }
    }
}

