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




/**public static void main(String args[]) {
 try {
 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1232213");
 Statement statement = connection.createStatement();
 ResultSet resultSet = statement.executeQuery("select * from testdb.student");
 while (resultSet.next()){
 System.out.println(resultSet.getString("name") + " " + resultSet.getString("address"));
 }
 }
 catch (Exception e){
 e.printStackTrace();
 }
 }*/
