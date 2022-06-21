package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionUtil_Basic;
public class SimpleQuery {

    public static void Print() throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select idb,fname,lname from buyer where phone  like '062%'");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Buyers whos phones start with 062: ");
        System.out.printf("%-4s %-10s %-10s\n", "IDB", "NAME", "LNAME");

        while (resultSet.next()) {
            int idb = resultSet.getInt("idb");
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");

            System.out.printf("%-4d %-10s %-10s\n", idb, fname, lname);
        }
    }
}
