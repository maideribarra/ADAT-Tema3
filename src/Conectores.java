import java.sql.Connection;
import java.sql.DriverManager;

public class Conectores {
    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC") ;
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:://localhost:5900");

        }catch (Exception e) {e.printStackTrace();}
}
}
