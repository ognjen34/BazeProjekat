package Tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Connection.ConnectionUtil_Basic;



public class DropTables {
    public static void DropTables() throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement preparedStatement = connection.createStatement();
        if(!preparedStatement.execute("drop table receipt"))System.out.println("Receipt Table Deleted!");
        if(!preparedStatement.execute("drop table review"))System.out.println("Review Table Deleted!");
        if(!preparedStatement.execute("drop table cartitem"))System.out.println("CartItem Table Deleted!");
        if(!preparedStatement.execute("drop table listing"))System.out.println("Listing Table Deleted!");
        if(!preparedStatement.execute("drop table product"))System.out.println("Product Table Deleted!");
        if(!preparedStatement.execute("drop table cart"))System.out.println("Cart Table Deleted!");
        if(!preparedStatement.execute("drop table buyer"))System.out.println("Buyer Table Deleted!");

    }
}
