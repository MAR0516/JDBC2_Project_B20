package day1 ;
import java.sql.*;
public class TestConnection {
    public static void main(String[] args) throws SQLException {
        // REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER

        // get a connection
        String connectionStr = "jdbc:oracle:thin:@52.23.222.108:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        // object that can run / execute a query
        Statement stmnt = conn.createStatement();
        //
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;
        rs.next(); // currently we are at the very first row    // "result set . getString"


       // rs.getString(column index) can be used to read the data of that column / row
        System.out.println("first column value using index: --> " +  rs.getString(1)   );
        System.out.println("second column value using index: --> " +  rs.getString(2)   );

        //rs.getString(column names)
        System.out.println("Region_ID at this row is: " + rs.getString("REGION_ID"));
        System.out.println("Region_Name at this row is: " + rs.getString("REGION_NAME"));

        rs.next();
        System.out.println("Region_ID at this row is: " + rs.getString("REGION_ID"));
        System.out.println("Region_Name at this row is: " + rs.getString("REGION_NAME"));

        rs.next();
        System.out.println("Region_ID at this row is: " + rs.getString("REGION_ID"));
        System.out.println("Region_Name at this row is: " + rs.getString("REGION_NAME"));

        rs.next();
        System.out.println("Region_ID at this row is: " + rs.getString("REGION_ID"));
        System.out.println("Region_Name at this row is: " + rs.getString("REGION_NAME"));
    }
}