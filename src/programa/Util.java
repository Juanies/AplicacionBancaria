package programa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection con(){
        String url = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String password = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos MySQL!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL:");
            e.printStackTrace();
        }

        return connection;
    }
}
