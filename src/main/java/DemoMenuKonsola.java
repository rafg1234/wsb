import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class DemoMenuKonsola
{
    String username;
    String email;
    String password;
    Boolean active;
    static Scanner in = new Scanner( System.in );

    void opcjaPierwsza() throws SQLException {
        System.out.println( "Witaj!" );
        this.username = in.nextLine();
        System.out.println( "Podaj nazwę użytkownika: " );
        this.username = in.nextLine();
        System.out.println( "Podaj email: " );
        this.email = in.nextLine();
        System.out.println( "Podaj hasło: " );
        this.password = in.nextLine();
        System.out.println( "Czy użytkownik aktywny (true/false): " );
        this.active = in.nextBoolean();
        Person person = new Person(-1, username, email, password, active);
        person.create(person);
    }

    void opcjaDruga() throws SQLException {
        System.out.println("Witaj!");
        this.username = in.nextLine();
        System.out.println("Podaj nazwę użytkownika, którego chcesz odczytać: ");
        this.username = in.nextLine();
        Person person = new Person(-1, username, "", "", true);
        ResultSet rs = person.read(person);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Username: " + rs.getString("username"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Password: " + rs.getString("password"));
            System.out.println("Active: " + rs.getBoolean("enabled"));
        }
    }

    void opcjaTrzecia() throws SQLException {
        System.out.println( "Witaj!" );
        this.username = in.nextLine();
        System.out.println( "Podaj nazwę użytkownika którego chcesz edytować: " );
        this.username = in.nextLine();
        System.out.println( "Podaj email: " );
        this.email = in.nextLine();
        System.out.println( "Podaj hasło: " );
        this.password = in.nextLine();
        System.out.println( "Czy użytkownik aktywny (true/false): " );
        this.active = in.nextBoolean();
        Person person = new Person(-1, username, email, password, active);
        person.update(person);
    }

    void opcjaCzwarta() throws SQLException {
        System.out.println("Witaj!");
        this.username = in.nextLine();
        System.out.println("Podaj nazwę użytkownika, którego chcesz usunąć: ");
        this.username = in.nextLine();
        Person person = new Person(-1, username, "", "", true);
        person.delete(person);
    }

    static void pokazMenu()
    {
        System.out.print( "Wybierz opcję:\n1. Dodaj nowy rekord\n2. Odczytaj rekord\n3. Zaktualizuj rekord\n4. Usuń rekord\n5. Koniec\n>> " );
    }

    public void menu() throws SQLException {
        int nrOpcji;
        do
        {
            pokazMenu();
            nrOpcji = in.nextInt();
            switch( nrOpcji )
            {
                case 1 : opcjaPierwsza();
                    break;
                case 2 : opcjaDruga();
                    break;
                case 3 : opcjaTrzecia();
                    break;
                case 4 : opcjaCzwarta();
                    break;
            }
        }
        while( nrOpcji != 5 );
    }
}