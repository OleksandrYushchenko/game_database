import java.sql.Date;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        dao.create(4,"users", "'MisterX'", "'Strange'", "'toto'", 132456, "'example@mail.com'", "logo", "'2000/01/01'");
        dao.read("users");
    }
}
