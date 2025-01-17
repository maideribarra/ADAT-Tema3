package TikTok;
import java.io.Serializable;

public class Video implements Serializable {
    public String nombre_video;
    public float duracion;
    public String autor;
    public int likes;
    public int fecha_subida;
    public String [] etiquetas=new String [3];
    

    public Video(String nombre_video,float duracion,String autor,int likes,int fecha_subida,String etiquetado_1,String etiquetado_2,String etiquetado_3){
        this.nombre_video=nombre_video;
        this.duracion=duracion;
        this.autor=autor;
        this.likes=likes;
        this.fecha_subida=fecha_subida;
        this.etiquetas[0]=etiquetado_1;
        this.etiquetas[1]=etiquetado_2;
        this.etiquetas[2]=etiquetado_3;
    }

    @Override
    public String toString() {
        return "Video: "+this.nombre_video+" "+this.duracion+" "+this.autor+" "+this.likes+" "+this.fecha_subida+" "+"["+this.etiquetas[0]+" "+this.etiquetas[1]+" "+this.etiquetas[2]+"]";
    }

    public String getNombre_video() {
        return nombre_video;
    }
    public void setNombre_video(String nombre_video) {
        this.nombre_video = nombre_video;
    }
    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public int getFecha_subida() {
        return fecha_subida;
    }
    public void setFecha_subida(int fecha_subida) {
        this.fecha_subida = fecha_subida;
    }
    public String[] getEtiquetas() {
        return etiquetas;
    }
    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }
    

}
