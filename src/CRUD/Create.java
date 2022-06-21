package CRUD;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import Connection.ConnectionUtil_Basic;
public class Create {





    public static void CreateBuyer(String fname,String lname, String email, String pass, String phone) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select max(idb) idb from buyer");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id  = resultSet.getInt("idb") +1;
        String query = "insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values ("+id+", '"+fname+"', '"+lname+"'," +
                "'"+email+"', '"+pass+"', '"+phone+"')";
        if(!statement.execute(query))

            {
                System.out.println("Buyer added succesfully");
            }



    }

    public static void CreateProduct(String pname) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select max(idp) idp from product");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id  = resultSet.getInt("idp") +1;
        String query = "insert into Product(idp, pname) values ("+id+", '"+pname+"')";
        if(!statement.execute(query))

        {
            System.out.println("Product added succesfully");
        }

    }

    public static void CreateCart(int idb) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select max(idc) idc from cart");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt("idc") + 1;
        String query = "insert into cart(idc, idb) values (" + id + ", " + idb + ")";
        if (!statement.execute(query)) {
            System.out.println("Cart added succesfully");
        }

    }

    public static void CreateListing(int idp,String des, int price) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select max(idl) idl from listing");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt("idl") + 1;
        String query = "insert into listing(idl, des, idp, price) values (" + id + ", '" + des + "', "+idp+", "+price+")";
        if (!statement.execute(query)) {
            System.out.println("Listing added succesfully");
        }

    }

    public static void CreateCartItem(int idc, int idl , int quantity) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        String query = "insert into cartitem(idc, idl, quantity) values (" + idc + ", " + idl + ", "+quantity+")";
        if (!statement.execute(query)) {
            System.out.println("CartItem added succesfully");
        }

    }

    public static void CreateReview(int idl,String lcomment, int lscore) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select max(idrev) idrev from review");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id = resultSet.getInt("idrev") + 1;
        String query = "insert into review(idrev, idl, lcomment, lscore) values (" + id + ", " + idl + ", '"+lcomment+"', "+lscore+")";
        if (!statement.execute(query)) {
            System.out.println("Review added succesfully");
        }

    }

    public static void CreateReceipt (int id) throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        String query1 = "select idc,sum(quantity*price) amount from cartitem ci left outer join listing l on l.idl = ci.idl group by idc having idc = "+id+"";
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        PreparedStatement preparedStatement2 = connection.prepareStatement("select max(idr) idr from receipt");
        Statement statement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        resultSet.next();
        resultSet2.next();
        int idr = resultSet2.getInt("idr") + 1;
        int idc = resultSet.getInt("idc");
        int amount = resultSet.getInt("amount");
        String date = LocalDate.now().toString();

        String query = "insert into receipt(idr, idc, rdate, amount) values (" + idr + ", " + idc + ", '"+date+"', "+amount+")";
        if (!statement.execute(query)) {
            System.out.println("Receipt added succesfully");
        }

    }
    public static void AddBuyer() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String fname = in.nextLine();
        System.out.println("Enter last name: ");
        String lname = in.nextLine();
        System.out.println("Enter email: ");
        String email = in.nextLine();
        System.out.println("Enter password: ");
        String pass = in.nextLine();
        System.out.println("Enter phone: ");
        String phone = in.nextLine();
        CreateBuyer(fname,lname,email,pass,phone);
        //in.close();
    }
    public static void AddCart() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter buyer id: ");
        int idb = in.nextInt();
        CreateCart(idb);
        //in.close();
    }
    public static void AddProduct() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String pname = in.nextLine();
        CreateProduct(pname);
        //in.close();
    }
    public static void AddListing() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter product id: ");
        int idp = in.nextInt();
        System.out.println("Enter listing description: ");
        in.nextLine();
        String des = in.nextLine();
        System.out.println("Enter product price: ");
        int price = in.nextInt();

        CreateListing(idp,des,price);
        //in.close();
    }

    public static void AddCartItem() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter listing id: ");
        int idl = in.nextInt();
        System.out.println("Enter cart id: ");
        int idc = in.nextInt();
        System.out.println("Enter quantity: ");
        int quantity = in.nextInt();

        CreateCartItem(idc,idl,quantity);
        //in.close();
    }

    public static void AddReview() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter listing id: ");
        int idl = in.nextInt();
        System.out.println("Enter comment: ");
        in.nextLine();
        String lcomment = in.nextLine();
        System.out.println("Enter score: ");
        int lscore = in.nextInt();

        CreateReview(idl,lcomment,lscore);
        //in.close();
    }

    public static void AddReceipt() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter cart id: ");
        int idc = in.nextInt();

        CreateReceipt(idc);
        //in.close();
    }

    public static void Add(int table) throws SQLException {
        if (table == 1)AddBuyer();
        if (table == 2)AddCart();
        if (table == 3)AddProduct();
        if (table == 4)AddListing();
        if (table == 5)AddCartItem();
        if (table == 6)AddReview();
        if (table == 7)AddReceipt();
    }

}
