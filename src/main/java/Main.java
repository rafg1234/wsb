import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnector dbc = new DatabaseConnector();
        ResultSet rs = null;
        dbc.connect();
        //dbc.executeInsert("INSERT INTO test.person(\n" +
          //      "\tusername, email, password, enabled, id)\n" +
            //    "\tVALUES ('kubaczek', 'kuba@kuba.pl', '123', true, 3);");
        rs = dbc.executeSelect("select * from test.person");
        while (rs.next()){
            System.out.println("ID: " + rs.getInt("id"));
        }
        //System.out.print("ID " + dbc.ge);
    }
}
