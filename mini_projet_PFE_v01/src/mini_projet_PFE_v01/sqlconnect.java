import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnect {
    public static Connection conn() {
        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, "projetjava2", "0000");
            System.out.println("Connected to Oracle database!");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading Oracle JDBC driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error connecting to Oracle database");
            e.printStackTrace();
        }
        return connection;
    }
}
