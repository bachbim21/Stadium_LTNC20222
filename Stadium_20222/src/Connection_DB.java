import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection_DB {
    Connection c;
    Statement s;
    public Connection_DB() {
        try {
            c = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/stadium","root","1232213");
            s = c. createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}





