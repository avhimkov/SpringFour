package ch6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainContactDao implements ContactDao {
    static {
        try {
            Class.forName("com.mesql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    private Connection getConnetction() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ch6",
                "spring4", "spring4");
    }

    private void closeConnection(Connection connection){
        if (connection == null);{
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
