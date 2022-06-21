import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Connection.ConnectionUtil_Basic;
public class Reports {

    public static void GenerateReportOne() throws SQLException {
        List<Integer> idl = new ArrayList<>();
        List<String> pname = new ArrayList<>();
        List<Integer> totalSold = new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        String query = "select ct.idl,pname,sum(quantity) total_sold " +
                "from cartitem ct left outer join " +
                "(select idl,pname,des,price " +
                "from product p left outer join listing l on l.idp = p.idp)" +
                "jt on jt.idl = ct.idl " +
                "group by ct.idl,pname";
        Connection connection = ConnectionUtil_Basic.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            idl.add(resultSet.getInt("idl"));
            pname.add(resultSet.getString("pname"));
            totalSold.add(resultSet.getInt("total_sold"));
        }
        for (int i = 0;i<pname.size();i++)
        {
            PreparedStatement preparedStatement2 = connection.prepareStatement("select price from listing where idl = "+idl.get(i)+"");
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            resultSet2.next();
            int price = resultSet2.getInt("price");
            totalSold.set(i,totalSold.get(i)*price);
            if (!map.containsKey(pname.get(i)))
            {
                map.put(pname.get(i),totalSold.get(i));
            }
            else
            {
                map.put(pname.get(i),map.get(pname.get(i))+totalSold.get(i));
            }

        }
        System.out.println("");
        System.out.printf("%-10s %-2s %-10s\n","Product","|","Revenue");
        System.out.printf("%-22s\n","----------------------");
        for(Map.Entry m : map.entrySet()){
            System.out.printf("%-10s %-2s %-10d\n",m.getKey(),"|",m.getValue());
        }
        System.out.println("");

    }
    public static void GenerateReportTwo() throws SQLException
    {
        HashMap<String,Float> map=new HashMap<String,Float>();
        String query = "select r.idl,round(avg(lscore),2) average_score\n" +
                "from review r left outer join  listing l \n" +
                "on l.idl = r.idl\n" +
                "group by r.idl order by average_score desc";
        Connection connection = ConnectionUtil_Basic.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idl = resultSet.getInt("idl");
            Float averageScore = resultSet.getFloat("average_score");

            String query2 = "select pname from listing l left outer join product p  on l.idp = p.idp where idl = "+idl+"";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            resultSet2.next();
            String pname = resultSet2.getString("pname");
            if(!map.containsKey(pname))
            {
                map.put(pname,averageScore);
            }
            else
            {
                map.put(pname,((map.get(pname)+averageScore)/2));
            }

        }
        System.out.println("");
        System.out.printf("%-10s %-2s %-10s\n","Product","|","Average");
        System.out.printf("%-22s\n","----------------------");

        for(Map.Entry m : map.entrySet()){
            System.out.printf("%-10s %-2s %.2f\n",m.getKey(),"|",m.getValue());
        }
        System.out.println("");

    }
}
