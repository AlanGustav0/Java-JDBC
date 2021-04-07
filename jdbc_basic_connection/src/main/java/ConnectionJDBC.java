import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static Connection getConnection() throws SQLException {

        String urlConnection = "jdbc:mysql://localhost/universidade";
        Connection connection = null;
        try  {
            connection = DriverManager.getConnection(urlConnection, "root", "123");
            System.out.println("Conexão bem sucedida!");
        }catch(Exception e){
            System.out.printf("Falha na Conexão");
        }

        return connection;
    }
}
