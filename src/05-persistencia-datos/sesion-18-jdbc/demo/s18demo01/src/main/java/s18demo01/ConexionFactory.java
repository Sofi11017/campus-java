package s18demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionFactory {
    public Connection abrir() throws SQLException {
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String clave = System.getenv("DB_PASSWORD");
        if (url == null || url.isBlank() || usuario == null || usuario.isBlank() || clave == null) {
            throw new IllegalArgumentException("Configura DB_URL, DB_USER y DB_PASSWORD en IntelliJ.");
        }
        return DriverManager.getConnection(url, usuario, clave);
    }
}
