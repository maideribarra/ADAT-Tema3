import java.sql.*;
public class jdbcEjemploApacheDerby {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try
        {

            // Cargar el driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // Establecemos la conexión con la BD
         // Establecer la conexión
            Connection conexion = DriverManager.getConnection("jdbc:derby://192.168.0.1:1526/home/user/db/Derby/ejemplo;create=true");
            Statement sentencia = conexion.createStatement();
            // Preparamos la consulta
            //PreparedStatement sentencia = conexion.prepareStatement("select * from SYS.SysTables");
            
            
            //PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO departamentos VALUES ( ?, ?, ?)");
            // Asignamos valores a los parámetros
            //sentencia.setInt(1, 11);        // Primer valor (por ejemplo, id)
            //sentencia.setString(2, "Conta"); // Segundo valor (nombre del departamento)
            //sentencia.setString(3, "Sevilla"); // Tercer valor (localización)

            // Ejecutamos la sentencia
            //sentencia.executeUpdate();
            ResultSet resul = sentencia.executeQuery ("select * from SYS.SysTables");
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resul.next()) {
                System.out.println (resul.getInt(1) + " " + resul.getString(2)+ " " + resul.getString(3));
            }
            resul.close();
            // Cerrar ResultSet sentencia
            sentencia.close();
    }catch (SQLException e) {e.printStackTrace();} catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    }//fin de la clase

}
