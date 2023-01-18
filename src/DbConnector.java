import java.sql.*;

public class DbConnector {
    private Connection connection;
    private static DbConnector instance;
    private DbConnector() {
        // Этот код эмулирует медленную инициализацию.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static DbConnector getInstance() {
        if (instance == null) {
            instance = new DbConnector();
        }
        return instance;
    }
    public Connection connect() {
        String connectionUrl =
                "jdbc:mysql://localhost:6603/"
                        + "game_database?"
                        + "autoReconnect=true&"
                        + "useSSL=false&"
                        + "user=root&"
                        + "password=helloworld";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

