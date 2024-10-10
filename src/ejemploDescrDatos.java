import java.sql.*;
public class ejemploDescrDatos {
    public static void main(String[] args) {
    try
    {
        Class. forName ("com.mysql.jdbc.Driver"); //Cargar el driver
        //Establecemos la conexión con la BD
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3304/EJEMPLO","user", "1234");
        DatabaseMetaData dbmd = conexion.getMetaData();//Creamos objeto
        ResultSet resul = null;
        String nombre = dbmd.getDatabaseProductName (); String driver = dbmd.getDriverName();
        String url = dbmd.getURL();
        String usuario = dbmd.getUserName() ;
        System.out.println ("INFORMACIÓN SOBRE LA BASE DE DATOS:");
        System.out.println("===================================");
        System.out.println ("Nombre : " + nombre );
        System.out.println ("Driver : " + driver );
        System.out.println ("URL : " + url );
        System.out.println("Usuario: " + usuario );
        //Obtener información de las tablas y vistas que hay
        resul = dbmd.getTables(null, "ejemplo", null, null);
        while (resul.next ()) {
            String catalogo = resul.getString(1); //columna 1 que devuelve ResulSet 
            String esquema = resul.getString(2); //columna 2
            String tabla = resul.getString(3); //columna 3
            String tipo = resul.getString(4); //columna 4
            System.out.println (tipo + " - Catalogo: " + catalogo +", Esquema : " + esquema + ", Nombre : " + tabla);
        }
        conexion.close(); //Cerrar conexión
    }
    catch (ClassNotFoundException en) {en.printStackTrace();}
    catch (SQLException e) {e.printStackTrace();}
    } 
    //fin de main
}
//fin de la clase

