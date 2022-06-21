package CRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Connection.ConnectionUtil_Basic;
public class Update {

    public static void Update(String table, String change)throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        String query = "update "+table+" set "+change+" ";
        if(!statement.execute(query))

        {
            System.out.println("Succesfully Updated!");
        }
    }

    public static void Update(String table, String change, String condition)throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        String query = "update "+table+" set "+change+" where "+condition+"";
        System.out.println(query);
        if(!statement.execute(query))

        {
            System.out.println("Succesfully Updated!");
        }
    }

    public static void Upd(String table) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter change: ");
        String change = in.nextLine();
        System.out.println("Enter condition/or 0 for none: ");
        String condition = in.nextLine();
        if (condition.equals("0")) Update(table,change);
        else {Update(table,change,condition); }

    }
    public static void UpdateTable(int table) throws SQLException {
        if (table == 1)Upd("buyer");
        if (table == 2)Upd("cart");
        if (table == 3)Upd("product");
        if (table == 4)Upd("listing");
        if (table == 5)Upd("cartitem");
        if (table == 6)Upd("review");
        if (table == 7)Upd("receipt");
    }

}
