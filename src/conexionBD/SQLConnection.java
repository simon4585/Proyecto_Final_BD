package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            String host = System.getenv("DB_HOST");
            String port = System.getenv("DB_PORT");
            String dbName = System.getenv("DB_NAME");
            String user = System.getenv("DB_USER");
            String pass = System.getenv("DB_PASS");

            String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexión exitosa a la base de datos.");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver JDBC no encontrado: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
        }
        return conn;
    }
}
