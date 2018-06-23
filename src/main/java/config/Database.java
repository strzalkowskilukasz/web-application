package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final static String URL = "jdbc:mysql://localhost:3306/java_app";
    private final static String USER = "root";
    private final static String PASSWORD = "root";

    private Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Brak drivera do bazy");
            System.exit(-1); // Wychodzimy z aplikacji z kodem błędu "-1" - minusowa wartość mówi o błędzie. Przyjęte -1 z dupy.
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) { // zalezy nam na tym, że łączyć się jak najrzadziej z bazą.
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
