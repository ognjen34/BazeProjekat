package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Connection.ConnectionUtil_Basic;
public class ParamQuery {

    public static void Print() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Carts with more items than: ");
        int number = sc.nextInt();
        String query = "select idc,sum(quantity) total_quantity from cartitem group by idc having sum(quantity) > "+number+" order by sum(quantity) desc";
        Connection connection = ConnectionUtil_Basic.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.printf("%-4s %-10s\n", "IDC", "TOTAL");

        while (resultSet.next()) {
            int idc = resultSet.getInt("idc");
            int total = resultSet.getInt("total_quantity");

            System.out.printf("%-4d %-10s\n", idc, total);
        }
    }
}
