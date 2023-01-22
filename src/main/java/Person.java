import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    Integer id;
    String username;
    String email;
    String password;
    Boolean active;

    public Person (Integer id, String username, String email, String password, Boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    DatabaseConnector dbc = new DatabaseConnector();

    public void create (Person sql) throws SQLException {
        dbc.connect();
        String insert = "Insert into test.person values ('" +
                sql.username + "', '" +
                sql.email + "', '" +
                sql.password + "', '" +
                sql.active + "' " + ")";
        dbc.executeInsert(insert);
    }

    public ResultSet read (Person sql) throws SQLException {
        dbc.connect();
        String read = "Select * from test.person WHERE username = '" + sql.username + "'";
        ResultSet rs = dbc.executeSelect(read);
        return rs;
    }

    public void update (Person sql) throws SQLException {
        dbc.connect();
        String updateEmail = "UPDATE test.person SET email = '" + sql.email + "' WHERE username = '" + sql.username + "'";
        String updateHaslo = "UPDATE test.person SET password = '" + sql.password + "' WHERE username = '" + sql.username + "'";
        String updateActive = "UPDATE test.person SET enabled = '" + sql.active + "' WHERE username = '" + sql.username + "'";
        dbc.executeUpdateOrDelete(updateEmail);
        dbc.executeUpdateOrDelete(updateHaslo);
        dbc.executeUpdateOrDelete(updateActive);
    }

    public void delete (Person sql) throws SQLException {
        dbc.connect();
        String delete = "DELETE FROM test.person WHERE username = '" + sql.username + "'";
        dbc.executeUpdateOrDelete(delete);
    }
}
