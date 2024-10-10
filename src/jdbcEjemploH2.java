import java.sql.*;
public class jdbcEjemploH2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try
        {
            // Cargar el driver
            Class.forName("org.h2.Driver");
            // Establecemos la conexión con la BD
            //Connection conexión = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/test","sa", "");
            Connection conexión = DriverManager.getConnection("jdbc:h2:tcp://localhost:1521/test","sa", "");
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
