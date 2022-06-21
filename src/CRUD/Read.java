package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionUtil_Basic;

public class Read {




    public static void ReadReceipt(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from receipt");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Receipts: ");
        System.out.printf("%-4s %-4s %-10s %-8s\n", "IDR", "IDC", "DATE", "AMOUNT");

        while (resultSet.next()) {
            int idr = resultSet.getInt("idr");
            int idc = resultSet.getInt("idc");
            String rdate = resultSet.getString("rdate");
            int amount = resultSet.getInt("amount");

            System.out.printf("%-4d %-4d %-10s %-8d\n", idr, idr, rdate, amount);
        }

    }

    public static void ReadBuyers(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from buyer");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Buyers: ");
        System.out.printf("%-4s %-10s %-10s %-20s %-10s %-10s\n", "IDR", "FNAME", "LNAME", "EMAIL", "PASS", "PHONE");

        while (resultSet.next()) {
            int idb = resultSet.getInt("idb");
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            String email = resultSet.getString("email");
            String pass = resultSet.getString("pass");
            String phone = resultSet.getString("phone");

            System.out.printf("%-4d %-10s %-10s %-20s %-10s %-10s\n", idb, fname, lname, email, pass, phone);
        }

    }

    public static void ReadCart(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from cart");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Carts: ");
        System.out.printf("%-4s %-4s\n", "IDC", "IDB");

        while (resultSet.next()) {
            int idc = resultSet.getInt("idc");
            int idb = resultSet.getInt("idb");


            System.out.printf("%-4d %-4d\n", idc, idb);
        }

    }

    public static void ReadProduct(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from product");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Carts: ");
        System.out.printf("%-4s %-10s\n", "IDP", "PNAME");

        while (resultSet.next()) {
            int idp = resultSet.getInt("idp");
            String pname = resultSet.getString("pname");
            System.out.printf("%-4d %-10s\n", idp, pname);
        }

    }

    public static void ReadListing(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from listing");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Carts: ");
        System.out.printf("%-4s %-4s %-50s %-10s\n", "IDL", "IDP", "DESCRIPTION", "PRICE");

        while (resultSet.next()) {
            int idl = resultSet.getInt("idl");
            int idp = resultSet.getInt("idp");
            String des = resultSet.getString("des");
            int price = resultSet.getInt("price");
            System.out.printf("%-4d %-4d %-50s %-10s\n", idl, idp, des, price);
        }

    }

    public static void ReadCartItem(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from cartitem");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Carts: ");
        System.out.printf("%-4s %-4s %-10s\n", "IDc", "IDL", "QUANTITY");

        while (resultSet.next()) {
            int idc = resultSet.getInt("idc");
            int idl = resultSet.getInt("idl");
            int quantity = resultSet.getInt("quantity");
            System.out.printf("%-4d %-4d %-10s\n", idc, idl, quantity);
        }

    }

    public static void ReadReview(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from review");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Carts: ");
        System.out.printf("%-4s %-4s %-40s %-4s\n", "IDREV", "IDL", "COMMENT","SCORE");

        while (resultSet.next()) {
            int idrev = resultSet.getInt("idrev");
            int idl = resultSet.getInt("idl");
            String comment = resultSet.getString("lcomment");
            int lscore = resultSet.getInt("lscore");
            System.out.printf("%-4d %-4d %-40s %-4s\n", idrev, idl, comment, lscore);
        }

    }


    public static void ReadTable(int choince) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        if (choince == 1){ReadBuyers(connection);}
        if (choince == 2){ReadCart(connection);}
        if (choince == 3){ReadProduct(connection);}
        if (choince == 4){ReadListing(connection);}
        if (choince == 5){ReadCartItem(connection);}
        if (choince == 6){ReadReview(connection);}
        if (choince == 7){ReadReceipt(connection);}
    }
}