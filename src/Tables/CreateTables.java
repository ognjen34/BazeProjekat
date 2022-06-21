package Tables;


import java.sql.*;

import Connection.ConnectionUtil_Basic;

public class CreateTables {
    public static void CreateTables() throws SQLException {
            Connection connection = ConnectionUtil_Basic.getConnection();
            Statement preparedStatement = connection.createStatement();
            if(!preparedStatement.execute(CreateBuyerTable()))System.out.println("Buyer Table Created!");
            if(!preparedStatement.execute(CreateCartTable()))System.out.println("Cart Table Created!");
            if(!preparedStatement.execute(CreateProductTable()))System.out.println("Product Table Created!");
            if(!preparedStatement.execute(CreateListingTable()))System.out.println("Listing Table Created!");
            if(!preparedStatement.execute(CreateCartItemTable()))System.out.println("CartItem Table Created!");
            if(!preparedStatement.execute(CreateReviewTable()))System.out.println("Review Table Created!");
            if(!preparedStatement.execute(CreateReceiptTable()))System.out.println("Receipt Table Created!");

    }

    private static String CreateBuyerTable() {
        String query = "Create Table BUYER (" +
                "IDB integer not NULL," +
                "FNAME varchar(20) NOT NULL," +
                "LNAME varchar(20) NOT NULL," +
                "EMAIL varchar(20) NOT NULL," +
                "PASS varchar(25) NOT NULL," +
                "PHONE varchar(25)," +
                "CONSTRAINT BUYER_PK PRIMARY KEY (IDB)" +
                ")";

        return query;
    }

    private static String CreateCartTable() {
        String query = "Create Table CART (" +
                "IDC integer not NULL," +
                "IDB integer not NULL," +
                "CONSTRAINT CART_PK PRIMARY KEY (IDC)," +
                "CONSTRAINT CART_FK FOREIGN KEY (IDB) REFERENCES BUYER(IDB)" +
                "ON DELETE CASCADE," +
                "CONSTRAINT CART_UK UNIQUE (IDB)" +
                ")";

        return query;
    }
    private static String CreateProductTable() {
        String query = "Create Table PRODUCT(" +
                "IDP integer not NULL," +
                "PNAME varchar(25) not NULL," +
                "CONSTRAINT PRODUCT_PK PRIMARY KEY (IDP)," +
                "CONSTRAINT Product_UK UNIQUE (PNAME)" +
                ")";

        return query;
    }
    private static String CreateListingTable() {
        String query = "Create Table LISTING(" +
                "IDL integer not NULL," +
                "DES varchar(200)," +
                "IDP integer not NULL," +
                "PRICE integer not NULL," +
                "CONSTRAINT LISTING_PK PRIMARY KEY (IDL)," +
                "CONSTRAINT LISTING_FK FOREIGN KEY (IDP) REFERENCES PRODUCT(IDP)" +
                "ON DELETE CASCADE," +
                "CONSTRAINT Listing_CH CHECK (PRICE>50) " +
                ")";

        return query;
    }
    private static String CreateCartItemTable() {
        String query = "Create Table CARTITEM (" +
                "IDC integer not NULL," +
                "IDL integer not NULL," +
                "QUANTITY integer not NULL," +
                "CONSTRAINT CARTITEM_PK PRIMARY KEY (IDL,IDC)," +
                "CONSTRAINT CARTITEM_FK FOREIGN KEY (IDC) REFERENCES CART(IDC)" +
                "ON DELETE CASCADE," +
                "CONSTRAINT CARTITEL_FK FOREIGN KEY (IDL) REFERENCES LISTING(IDL)" +
                "ON DELETE CASCADE" +
                ")";

        return query;
    }
    private static String CreateReviewTable() {
        String query = "Create Table REVIEW(" +
                "IDREV integer not null," +
                "IDL integer not null," +
                "LCOMMENT varchar(100) not null," +
                "LSCORE integer not null," +
                "Constraint REVIEW_PK PRIMARY KEY (IDREV,IDL)," +
                "CONSTRAINT REVIEW_FK FOREIGN KEY (IDL) REFERENCES LISTING(IDL)" +
                "ON DELETE CASCADE," +
                "CONSTRAINT REVIEWSCORE_CHL CHECK (lscore>0)," +
                "CONSTRAINT REVIEWSCORE_CHB CHECK (lscore<6)" +
                ")";

        return query;
    }
    private static String CreateReceiptTable() {
        String query = "Create Table RECEIPT(" +
                "IDR integer not NULL," +
                "IDC integer not NULL," +
                "RDATE varchar(15) not NULL," +
                "AMOUNT integer not NULL," +
                "CONSTRAINT RECEIPT_PK PRIMARY KEY (IDR,IDC)," +
                "CONSTRAINT RECEIPT_FK FOREIGN KEY (IDC) REFERENCES CART(IDC)" +
                "ON DELETE CASCADE" +
                ")";

        return query;
    }

}
