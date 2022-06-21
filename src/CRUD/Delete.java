package CRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Connection.ConnectionUtil_Basic;
public class Delete {


    public static void Del(String table,String condition) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        String query = "delete "+table+" where "+condition+" ";
        if(!statement.execute(query))

        {
            System.out.println("Succesfully deleted!");
        }
    }

    public static void Del(String table) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter condition: ");
        String condition = in.nextLine();
        Del(table,condition);

    }

    public static void DeleteTable(int table) throws SQLException {
        if (table == 1)Del("buyer");
        if (table == 2)Del("cart");
        if (table == 3)Del("product");
        if (table == 4)Del("listing");
        if (table == 5)Del("cartitem");
        if (table == 6)Del("review");
        if (table == 7)Del("receipt");
    }
}
