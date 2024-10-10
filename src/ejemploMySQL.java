import java.sql.*;
public class ejemploMySQL {

        public static void main(String[] args) {
        try
        {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establecemos la conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3304/EJEMPLO","user", "1234");
            
            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery ("SELECT * FROM departamentos");
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resul.next()) {
                System.out.println (resul.getInt(1) + " " + resul.getString(2)+ " " + resul.getString(3));
            }
            resul.close();// Cerrar ResultSet sentencia.cióse();// Cerrar Statement 
            conexion.close();//Cerrar conexión
        }catch (ClassNotFoundException cn) {cn.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
        }//fin de main
}//fin de la clase
