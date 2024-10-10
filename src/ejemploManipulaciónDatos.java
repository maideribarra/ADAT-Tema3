import java.sql.*;
public class ejemploManipulaciónDatos {
   
    public static void main (String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //Cargar el driver
            //Establecemos la conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3304/EJEMPLO","user", "1234");
            
            //recuperar argumentos de main
            String dep=args[0]; // num. departamento
            String dnombre=args[1]; // nombre
            String loc=args[2]; // localidad
            //construir orden INSERT
            String sql= "INSERT INTO departamentos VALUES (" + dep + ",\'" + dnombre + "\',\'"+loc+ "\');";
            System.out.println(sql);
            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql); System.out.println("Filas afectadas: "+filas);
            sentencia.close (); // Cerrar Statement
            conexion.close(); //Cerrar conexión
            }
        catch (ClassNotFoundException en) {en.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
        }//fin de main
}
