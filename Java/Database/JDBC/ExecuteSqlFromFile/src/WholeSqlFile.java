import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Весь файл с SQL-скриптом выполняется за один запрос к БД.
 */
public class WholeSqlFile {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        StringBuilder query = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(WholeSqlFile.class.getResourceAsStream("big.sql")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                query.append(line);
                query.append("\n");
            }
        }
        String queryStr = query.toString().replace("\uFEFF", "");//Удаляем Byte Order Mark

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Statement statement = conn.createStatement();
        statement.executeUpdate(queryStr);

        ResultSet rs = statement.executeQuery("SELECT * FROM execute_sql");
        while (rs.next()) {
            System.out.printf("%d - %s\n", rs.getInt(1), rs.getString(2));
        }

        conn.close();
    }
}