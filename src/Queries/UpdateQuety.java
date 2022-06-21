package Queries;

import CRUD.Create;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import Connection.ConnectionUtil_Basic;

public class UpdateQuety {

    public static void Update() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter listing id: ");
        int idl = in.nextInt();
        System.out.println("Enter cart id: ");
        int idc = in.nextInt();
        System.out.println("Enter quantity: ");
        int quantity = in.nextInt();

        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        String query = "insert into cartitem(idc, idl, quantity) values (" + idc + ", " + idl + ", "+quantity+")";
        if (!statement.execute(query)) {
            System.out.println("CartItem added succesfully");
        }
        PreparedStatement preparedStatement2 = connection.prepareStatement("select max(idr) idr from receipt");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        resultSet2.next();
        int idr = resultSet2.getInt("idr") + 1;


        PreparedStatement preparedStatement = connection.prepareStatement("select price from listing where idl = "+idl+"");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int price = resultSet.getInt("price");
        String receiptQuery = "insert into receipt(idc, idr, rdate, amount) values ("+idc+","+idr+", '"+ LocalDate.now().toString() +"',"+price*quantity+")";
        if (!statement.execute(receiptQuery)) {
            System.out.println("Receipt added succesfully");
        }
        PrintReceipt(idr);


    }

    private static void PrintReceipt(int id) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("Select * from receipt where idr = "+id+"");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Receipts: ");
        System.out.printf("%-4s %-4s %-10s %-8s\n", "IDR", "IDC", "DATE", "AMOUNT");

        while (resultSet.next()) {
            int idr = resultSet.getInt("idr");
            int idc = resultSet.getInt("idc");
            String rdate = resultSet.getString("rdate");
            int amount = resultSet.getInt("amount");

            System.out.printf("%-4d %-4d %-10s %-8d\n", idr, idc, rdate, amount);
        }

    }


}
