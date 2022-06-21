package Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConnectionUtil_Basic;
public class JoinQuery {

    public static void Print() throws SQLException {
        String query = "select b.idb,fname,lname,pname,des,price,quantity,price * quantity Amount " +
                "from buyer b left outer join" +
                "(select idb,pname,des,price,quantity from cart c left outer join " +
                "(select idc,des,pname,price,quantity from cartitem ci left outer join " +
                "(select * from listing l left outer join product p  on l.idp = p.idp)" +
                "ii on ci.idl = ii.idl) " +
                "sl on c.idc = sl.idc) ls on ls.idb = b.idb where pname is not null order by fname,lname";
        Connection connection = ConnectionUtil_Basic.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Every buyers purchase");
        System.out.printf("%-4s %-10s %-10s %-10s %-50s %-6s %-6s %-6s\n",
                "IDB", "NAME", "LNAME" , "PNAME", "DESC", "PRICE", "QUANTIY" , "AMOUNT");

        while (resultSet.next()) {
            int idb = resultSet.getInt("idb");
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            String pname = resultSet.getString("pname");
            String desc = resultSet.getString("des");
            int price = resultSet.getInt("price");
            int quantity = resultSet.getInt("quantity");
            int amount = resultSet.getInt("amount");

            System.out.printf("%-4d %-10s %-10s %-10s %-50s %-6d %-6d %-6d\n", idb, fname, lname,pname,desc,price,quantity,amount);
        }
    }
}
