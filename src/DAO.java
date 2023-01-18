import java.sql.*;

public class DAO {
    ResultSet resultSet = null;
    public DbConnector dbConnector = DbConnector.getInstance();
    Connection connection = dbConnector.connect();

    public void DAO(){
    }
    public void read(String table) throws SQLException {
        try {
            String result = "";
            Statement statement = connection.createStatement();
            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM" + " " + table;
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            ResultSetMetaData rsmd =resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            System.out.println(columnCount);
            while (resultSet.next()) {
                // The column count starts from 1
                for (int i = 1; i <= columnCount; i++ ) {
                    System.out.print(resultSet.getString(i) + " | ");
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null || !connection.isClosed()) {
                connection.close();
            }
        }
    }
    public void create(int id, String table, String first_name, String last_name, String nickname, int password, String email, String logo, String age ) {
        try {
            Statement statement = dbConnector.connect().createStatement();
            // Create and execute a SELECT SQL statement.
            String selectSql = "INSERT INTO " + table + " VALUES" + "("
                    + id + ", " + first_name + ", " + last_name + ", " + nickname + ", " + password + ", " + email + ", " + logo + ", " + age + ")";
            System.out.println(selectSql);
            statement.executeUpdate(selectSql);
            // Print results from select statement
            System.out.println("OK");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
//    public Connection connect() {
//        String connectionUrl =
//                "jdbc:mysql://localhost:6603/"
//                        + "game_database?"
//                        + "autoReconnect=true&"
//                        + "useSSL=false&"
//                        + "user=root&"
//                        + "password=helloworld";
//        ResultSet resultSet = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(connectionUrl);
//            Statement statement = connection.createStatement();
//
//            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT * FROM users";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + "|" +resultSet.getString(3));
//            }
//        }
//        catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//}