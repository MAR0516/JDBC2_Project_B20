package day1;
import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) throws SQLException {
        // REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER

        // get a connection
        String connectionStr = "jdbc:oracle:thin:@52.23.222.108:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        // object that can run / execute a query
        Statement stmnt = conn.createStatement();
        //
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        rs.next(); // method will return boolean value
        // if there is next row --> return true and move the pointer/cursor to the next row

        // if there is no next row ---> return false

      //  while(rs.next()){
            System.out.println("Region_ID at this row is: " + rs.getString("REGION_ID"));
      //  }
        // iterate over all countries
         rs= stmnt.executeQuery("SELECT * FROM COUNTRIES");
     //   System.out.println(rs.getString(1));

        while(rs.next()){
            System.out.println(rs.getString(1)  ) ;
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }
    }
}