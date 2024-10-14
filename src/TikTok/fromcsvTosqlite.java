package TikTok;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
//import java.sql.*;
import org.sqlite.*;

public class fromcsvTosqlite {
     public static void crearTablaVideos(Connection conn) {
        //String sql = "CREATE DATABASE IF NOT EXISTS tiktok ";
        String sql1 = "CREATE TABLE IF NOT EXISTS video (" +
                "nombre_video VARCHAR(255)," +
                "duracion FLOAT," +
                "autor VARCHAR(255)," +
                "likes INT," +
                "fecha_subida INT," +
                "etiqueta_1 VARCHAR(255)," +
                "etiqueta_2 VARCHAR(255)," +
                "etiqueta_3 VARCHAR(255)" +
                ");";

        try (Statement stmt = conn.createStatement()) {
            // Ejecuta la consulta SQL
            //stmt.execute(sql);
            stmt.execute(sql1);
            System.out.println("Tabla 'videos' creada correctamente.");
        } catch (SQLException e) {
            // Captura cualquier error en la creación de la tabla
            System.out.println("Error al crear la tabla 'videos': " + e.getMessage());
        }
    }

    public static void eliminarVideosCortaDuracion(Connection conn, float duracionMinima) {
        // SQL para eliminar videos cuya duración es menor que la duracionMinima
        String sql = "DELETE FROM  video WHERE duracion < ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Establece la duración mínima en el PreparedStatement
            pstmt.setFloat(1, duracionMinima);

            // Ejecuta la sentencia SQL
            int filasAfectadas = pstmt.executeUpdate();

            System.out.println(filasAfectadas + " videos eliminados que tenían duración menor a " + duracionMinima + " segundos.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar los videos: " + e.getMessage());
        }
    }

    public static void insertarVideos(Connection conn, ArrayList<Video> listaVideos) {
        // SQL para insertar un video en la tabla
        String sql = "INSERT INTO video (nombre_video, duracion, autor, likes, fecha_subida, etiqueta_1, etiqueta_2, etiqueta_3) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Recorre la lista de videos y los inserta en la base de datos
            for (Video video : listaVideos) {
                pstmt.setString(1, video.nombre_video);
                pstmt.setFloat(2, video.duracion);
                pstmt.setString(3, video.autor);
                pstmt.setInt(4, video.likes);
                pstmt.setInt(5, video.fecha_subida);
                pstmt.setString(6, video.etiquetas[0]);
                pstmt.setString(7, video.etiquetas[1]);
                pstmt.setString(8, video.etiquetas[2]);

                // Ejecuta la inserción para cada video
                pstmt.executeUpdate();
            }

            System.out.println("Videos insertados correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar los videos: " + e.getMessage());
        }
    }

    public static void actualizarLikesUsuarios(Connection conn, ArrayList<Integer> likes) {
        String sql = "UPDATE  video SET likes = ? WHERE autor = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Recorrer el ArrayList de likes y actualizar para cada usuario
            for (int i = 0; i < likes.size(); i++) {
                String nombreUsuario = "@usuario" + (i + 1);  // Generar nombre de usuario
                int numeroLikes = likes.get(i);  // Obtener el número de likes para el usuario
                
                // Asignar los valores al PreparedStatement
                pstmt.setInt(1, numeroLikes);
                pstmt.setString(2, nombreUsuario);
                
                // Ejecutar el UPDATE
                pstmt.executeUpdate();
                
                System.out.println("Likes actualizados para " + nombreUsuario + ": " + numeroLikes);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los likes: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");  // Registrar el controlador de SQLite
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }
        
        String url = "jdbc:sqlite:C:\\tiktok.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            fromcsvTodb Gestiondb=new fromcsvTodb();
            crearTablaVideos(conn);
            String rutaCSV="C:\\Users\\maider\\Desktop\\Ciudad_jardin\\workspace\\Tema3ADAT\\src\\TikTok\\TikTok2.csv";
            TikTok tiktok=new TikTok();
            ArrayList<Video> arrVideos=tiktok.CargarVideos(rutaCSV);
            insertarVideos(conn, arrVideos);
            Random random = new Random();
            ArrayList<Integer> likes = new ArrayList<>();
            eliminarVideosCortaDuracion(conn, 20);
            for (int i = 0; i < 30; i++) {
                int randomValue = random.nextInt(1001); // Genera un número aleatorio entre 0 y 1000
                likes.add(randomValue);
            }
            actualizarLikesUsuarios(conn,likes);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

}
}