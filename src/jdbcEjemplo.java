import java.sql.*;
public class jdbcEjemplo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try
        {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establecemos la conexión con la BD
            Connection conexión = DriverManager.getConnection("jdbc:mysql://192.168.173.85:3304/EJEMPLO","user", "1234");
            // Preparamos la consulta
            Statement sentencia = conexión.createStatement();
            ResultSet resul = sentencia.executeQuery ("SELECT * FROM departamentos");
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resul.next()) {
                System.out.println (resul.getInt(1) + " " + resul.getString(2)+ " " + resul.getString(3));
            }
            resul.close();
            // Cerrar ResultSet sentencia
            
    }catch (ClassNotFoundException cn) {cn.printStackTrace();}
    catch (SQLException e) {e.printStackTrace();}
    }//fin de la clase

}
