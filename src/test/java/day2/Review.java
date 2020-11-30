package day2;

import utility.DB_Utility;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {
        // get a connection
        DB_Utility.createConnection();

        ResultSet rs   =   DB_Utility.runQuery("SELECT * FROM JOBS") ;
        // I want to read the first row

        rs.next();
        System.out.println("First column value in jobs" + rs.getString(1));
        System.out.println("Second column value in jobs" + rs.getString(2));

        // move to row number 7 and get above 2 columns values

        rs.absolute(7);
        System.out.println("First column value in Jobs in row 7 "+ rs.getString(1));
        System.out.println("Second column value in Jobs in row 7 "+ rs.getString(2));

        rs.last();
        System.out.println("First column value in Jobs in last row  "+ rs.getString(1));
        System.out.println("Second column value in Jobs in last row  "+ rs.getString(2));

        rs.previous();
        System.out.println("First column value in Jobs in previous row  "+ rs.getString(1));
        System.out.println("Second column value in Jobs in previous/ 2nd row from last  "+ rs.getString(2));


        System.out.println("\n ----Loop from first row to last row----");

        rs.beforeFirst();
        while (rs.next()){
            System.out.println("loop first column" + rs.getString("Job_ID"));

        }

        System.out.println("\n _____Loop from last row till first row get MIN_Salary column as number___");
// we're currently at - after the last location
        // if you want to make sure and explicilitly say so, we can do so below
        rs.afterLast();

        while(rs.previous()){
            // nothing wrong with getting it as string, just for sake of demo, we did as double
            System.out.println("Main salary column as number  $" + rs.getDouble("Min_salary"));
        }
// clean up connection, statement, and resultset object after usage-- CLOSING OUT
        // aka closing connection
        DB_Utility.destroy();

    }
}
