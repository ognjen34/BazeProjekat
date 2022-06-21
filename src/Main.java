import CRUD.Create;
import CRUD.Delete;
import CRUD.Read;
import CRUD.Update;
import Queries.JoinQuery;
import Queries.ParamQuery;
import Queries.SimpleQuery;
import Queries.UpdateQuety;
import Tables.CreateTables;
import Tables.DropTables;
import Tables.FillTables;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        int opcija = 999;
        Scanner in = new Scanner(System.in);
        while (opcija != 0) {

            Prints.PrintOptions();
            opcija = in.nextInt();
            if (opcija == 1) {
                DropTables.DropTables();
            }
            if (opcija == 2) {
                CreateTables.CreateTables();
            }
            if (opcija == 3) {
                FillTables.FillTables();
            }
            if (opcija == 4) {
                Prints.PrintTables();
                int crudOption = in.nextInt();
                Prints.PrintCRUDOptions();
                int crudOption2 = in.nextInt();
                CRUDOptions(crudOption,crudOption2);
            }
            if (opcija == 5) {
                SimpleQuery.Print();
            }
            if (opcija == 6) {
                JoinQuery.Print();
            }
            if (opcija == 7) {
                ParamQuery.Print();
            }
            if (opcija == 8) {
                UpdateQuety.Update();
            }
            if (opcija == 9) {
                Reports.GenerateReportOne();
            }
            if (opcija == 10) {
                Reports.GenerateReportTwo();
            }


        }
        in.close();
    }

    public static void CRUDOptions(int option1,int option2) throws SQLException {
        if (option2 == 1){
            Create.Add(option1);
        }
        if (option2 == 2){
            Read.ReadTable(option1);
        }
        if (option2 == 3){
            Update.UpdateTable(option1);
        }
        if (option2 == 4){
            Delete.DeleteTable(option1);
        }
    }
}
