import java.sql.*;

public class TestsMain {
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:mysql://localhost:6603/"
                        + "game_database?"
                        + "autoReconnect=true&"
                        + "useSSL=false&"
                        + "user=root&"
                        + "password=helloworld";
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();

                // Create and execute a SELECT SQL statement.
                String selectSql = "SELECT * FROM users";
                resultSet = statement.executeQuery(selectSql);

                // Print results from select statement
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
                }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

