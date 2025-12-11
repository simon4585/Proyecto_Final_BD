package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    public static Connection getConnection() throws SQLException {
        String host = System.getenv("localhost");
        String port = System.getenv("5432");
        String dbName = System.getenv("ProyectoBD");
        String user = System.getenv("postgres");
        String pass = System.getenv("");

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC no encontrado: " + e.getMessage());
        }
        return null;
    }
}

