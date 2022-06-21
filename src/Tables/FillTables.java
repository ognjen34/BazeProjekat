package Tables;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Connection.ConnectionUtil_Basic;

public class FillTables {
    public static void FillTables() throws SQLException {
        Connection connection = ConnectionUtil_Basic.getConnection();
        Statement preparedStatement = connection.createStatement();
        FillBuyerTable(preparedStatement);
        FillProductTable(preparedStatement);
        FillCartTable(preparedStatement);
        FillListingTable(preparedStatement);
        FillCartItemTable(preparedStatement);
        FillReviewTable(preparedStatement);
        FillReceiptTable(connection);


    }
    public static void FillBuyerTable(Statement preparedStatement) throws SQLException {
        List<String> querys = new ArrayList<String>();
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (001, 'Piter', 'Parker'," +
                "'piter@gmail.com', 'sifra123', '062112222')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (002, 'Dejan', 'Strvina'," +
                "'dejan@gmail.com', 'sifra123', '062345222')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (003, 'Goran', 'Breg'," +
                "'goran@gmail.com', 'sifra123', '0623325672')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (004, 'Simi', 'Simi'," +
                "'simi@gmail.com', 'sifra123', '062333222')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (005, 'Darko', 'Lazic'," +
                "'darko@gmail.com', 'sifra123', '063331112')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (006, 'Kristijan', 'Golubovic'," +
                "'kiki@gmail.com', 'sifra123', '065675222')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (007, 'Aca', 'Lukas'," +
                "'coa@gmail.com', 'sifra123', '067634532')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (008, 'Nenad', 'Turcin'," +
                "'turcin@gmail.com', 'sifra123', '06456432')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (009, 'Novak', 'Djokovic'," +
                "'nole@gmail.com', 'sifra123', '067567232')");
        querys.add("insert into Buyer(idb, fname, lname, email," +
                "pass, phone) values (010, 'Dusan', 'Debilovic'," +
                "'duki@gmail.com', 'sifra123', '06645642')");
        int counter = 1;
        for(String query : querys){
            if (preparedStatement.execute(query) == false) {
                System.out.println("Buyer"+counter++ + " " +  "added succesfuly");
            }
        }
    }
    public static void FillProductTable(Statement preparedStatement) throws SQLException {
        List<String> querys = new ArrayList<String>();
        querys.add("insert into Product(idp, pname) values (001, 'Laptop')");
        querys.add("insert into Product(idp, pname) values (002, 'Telefon')");
        querys.add("insert into Product(idp, pname) values (003, 'Zvucnik')");
        querys.add("insert into Product(idp, pname) values (004, 'Kokain')");
        querys.add("insert into Product(idp, pname) values (005, 'Patike')");
        querys.add("insert into Product(idp, pname) values (006, 'Avion')");
        querys.add("insert into Product(idp, pname) values (007, 'Kamion')");
        querys.add("insert into Product(idp, pname) values (008, 'Pantalone')");
        querys.add("insert into Product(idp, pname) values (009, 'Metla')");
        querys.add("insert into Product(idp, pname) values (010, 'Burger')");

        int counter = 1;
        for(String query : querys){
            if (preparedStatement.execute(query) == false) {
                System.out.println("Product"+counter++ + " " +  "added succesfuly");
            }
        }
    }

    public static void FillCartTable(Statement preparedStatement) throws SQLException {
        List<String> querys = new ArrayList<String>();
        querys.add("insert into Cart(idc, idb) values (001, 009)");
        querys.add("insert into Cart(idc, idb) values (002, 006)");
        querys.add("insert into Cart(idc, idb) values (003, 010)");
        querys.add("insert into Cart(idc, idb) values (004, 005)");
        querys.add("insert into Cart(idc, idb) values (005, 003)");
        querys.add("insert into Cart(idc, idb) values (006, 004)");
        querys.add("insert into Cart(idc, idb) values (007, 002)");
        querys.add("insert into Cart(idc, idb) values (008, 001)");
        querys.add("insert into Cart(idc, idb) values (009, 007)");
        querys.add("insert into Cart(idc, idb) values (010, 008)");


        int counter = 1;
        for(String query : querys){
            if (preparedStatement.execute(query) == false) {
                System.out.println("Cart"+counter++ + " " +  "added succesfuly");
            }
        }
    }

    public static void FillListingTable(Statement preparedStatement) throws SQLException {
        List<String> querys = new ArrayList<String>();
        querys.add("insert into Listing(idl, des, idp, price) values (001, 'mnogo dobro leti', 006, 10000)");
        querys.add("insert into Listing(idl, des, idp, price) values (002, 'ukusan do neba', 010, 100)");
        querys.add("insert into Listing(idl, des, idp, price) values (003, 'cisti sve nema premca', 009, 200)");
        querys.add("insert into Listing(idl, des, idp, price) values (004, '1000 giga rama brz ko munja', 001, 1000)");
        querys.add("insert into Listing(idl, des, idp, price) values (005, 'kamijon sve moze da prenese da ne poverujete', 007, 5000)");
        querys.add("insert into Listing(idl, des, idp, price) values (006, 'zove do druge planete rade sve igrice', 002, 1000)");
        querys.add("insert into Listing(idl, des, idp, price) values (007, 'mnogo dobar', 004, 3000)");
        querys.add("insert into Listing(idl, des, idp, price) values (008, 'bluetooth cuje se bas jako', 003, 500)");
        querys.add("insert into Listing(idl, des, idp, price) values (009, 'nova moda iz pariza', 008, 300)");
        querys.add("insert into Listing(idl, des, idp, price) values (010, 'patike za trcanje', 005, 1000)");
        querys.add("insert into Listing(idl, des, idp, price) values (011, 'leti mnogo visoko', 006, 11000)");
        querys.add("insert into Listing(idl, des, idp, price) values (012, 'kul izgleda', 006, 101)");
        querys.add("insert into Listing(idl, des, idp, price) values (013, 'od drveta prirodna', 009, 300)");
        querys.add("insert into Listing(idl, des, idp, price) values (014, 'ajfon kida', 002, 1040)");
        querys.add("insert into Listing(idl, des, idp, price) values (015, 'saomi njbolji odnos cene i kvaliteta', 002, 5040)");
        querys.add("insert into Listing(idl, des, idp, price) values (016, 'staromodni', 002, 1010)");
        querys.add("insert into Listing(idl, des, idp, price) values (017, 'kidalica', 004, 3500)");
        querys.add("insert into Listing(idl, des, idp, price) values (018, 'kasetofon', 003, 500)");
        querys.add("insert into Listing(idl, des, idp, price) values (019, 'zvonarice iz 80ih', 008, 300)");
        querys.add("insert into Listing(idl, des, idp, price) values (020, 'somotne pantalone', 008, 1200)");
        querys.add("insert into Listing(idl, des, idp, price) values (021, 'uske', 008, 10000)");
        querys.add("insert into Listing(idl, des, idp, price) values (022, 'od piletine', 010, 110)");
        querys.add("insert into Listing(idl, des, idp, price) values (023, 'dobar bas obecavamo', 010, 310)");
        querys.add("insert into Listing(idl, des, idp, price) values (024, 'namunjen bas', 001, 2000)");
        querys.add("insert into Listing(idl, des, idp, price) values (025, 'kvantni racunar iz nase', 001, 5000)");
        querys.add("insert into Listing(idl, des, idp, price) values (026, 'adike', 005, 500)");
        querys.add("insert into Listing(idl, des, idp, price) values (027, 'balencijage vrhunske', 005, 3000)");
        querys.add("insert into Listing(idl, des, idp, price) values (028, 'ko za exit', 003, 500)");
        querys.add("insert into Listing(idl, des, idp, price) values (029, 'puska', 001, 300)");
        querys.add("insert into Listing(idl, des, idp, price) values (030, 'new balance nove iz kine', 005, 1200)");


        int counter = 1;
        for(String query : querys){
            if (preparedStatement.execute(query) == false) {
                System.out.println("Listing"+counter++ + " " +  "added succesfuly");
            }
        }
    }
    public static void FillCartItemTable(Statement preparedStatement) throws SQLException {
        List<String> querys = new ArrayList<String>();
        List<String> IN = new ArrayList<>();
        for (int i = 1;i< 51;i++) {

            int idc = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            int idl = ThreadLocalRandom.current().nextInt(1, 30 + 1);
            int quantity = ThreadLocalRandom.current().nextInt(1, 5 + 1);
            if(!IN.contains(idc+"-"+idl)) {
                querys.add("insert into CartItem(idc, idl, quantity) values ("+idc+", "+idl+", "+quantity+")");
                IN.add(idc+"-"+idl);
            }

        }



        int counter = 1;
        for(String query : querys){
            if (preparedStatement.execute(query) == false) {
                System.out.println("CartItem"+counter++ + " " +  "added succesfuly");
            }
        }
    }

    public static void FillReviewTable(Statement preparedStatement) throws SQLException {
        List<String> querys = new ArrayList<String>();
        List<String> comments = Arrays.asList("nista ne valja", "kida","lose","dobro","onako..","glupo","pusketina!!",
                                              "Kida","Skupo ko sam djavo","nisam zadovoljan","moze bolje","odusevljenje!",
                                              "zajebalo vek!","magicno!");

        for (int i = 1;i< 51;i++) {

            int idl = ThreadLocalRandom.current().nextInt(1, 30 + 1);
            int index = ThreadLocalRandom.current().nextInt(0, comments.size());
            int score = ThreadLocalRandom.current().nextInt(1, 5 + 1);
            querys.add("insert into Review(idrev, idl, lcomment, lscore) values ("+i+", "+idl+", '"+comments.get(index)+"', "+score+")");

        }


        int counter = 1;
        for(String query : querys){
            if (preparedStatement.execute(query) == false) {
                System.out.println("Review"+counter++ + " " +  "added succesfuly");
            }
        }
    }

    public static void FillReceiptTable(Connection connection) throws SQLException {
        List<String> querys = new ArrayList<String>();

        String query1 = "select idc,sum(quantity*price) amount from cartitem ci left outer join listing l on l.idl = ci.idl group by idc";
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        Statement statement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 1;
        while (resultSet.next()) {
            int idc = resultSet.getInt("idc");
            int amount = resultSet.getInt("amount");

            querys.add("insert into receipt(idc, idr, rdate, amount) values ("+idc+","+counter+", '2022-"+counter+"-"+counter+"',"+amount+")");
            counter++;
        }
        counter = 1;
        for(String query : querys){
            //System.out.println(query);
            if (statement.execute(query) == false) {
                System.out.println("Receipt"+counter++ + " " +  "added succesfuly");
            }
        }
    }





}