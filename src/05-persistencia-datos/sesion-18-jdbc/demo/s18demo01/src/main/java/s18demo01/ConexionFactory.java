package s18demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/campus_java_s18";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Campus2023!";

    public Connection abrir() throws SQLException {
        /*String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String clave = System.getenv("DB_PASSWORD");*/
        if (URL == null || URL.isBlank() || DB_USER == null || DB_USER.isBlank() || DB_PASSWORD == null) {
            throw new IllegalArgumentException("Configura DB_URL, DB_USER y DB_PASSWORD en IntelliJ.");
        }
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }
}
