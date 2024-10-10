import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;

public class db4oejemplos {
    final static String BDPer = "C:/bd_db4o/DBPersonas.yap";

    public static void recuperarPorNombre(ObjectContainer db, String nombre){
        Persona per = new Persona(nombre,null);
        ObjectSet<Persona> result = db.queryByExample(per);
        if (result.size() == 0) {
            System.out.println("No existen Registros de Personas..");
        }else{
            System.out.println("Número de registros: "+result.size());
            while(result.hasNext()){
                Persona p = result.next();
                System.out.println("Nombre:" + p.getNombre( )+", Ciudad:" + p.getCiudad( ) );
            }
    }
    db.close();
}
    public static void recuperarPorCiudad(ObjectContainer db, String ciudad){
        Persona per = new Persona(null,ciudad);
        ObjectSet<Persona> result = db.queryByExample(per);
        if (result.size() == 0) {
            System.out.println("No existen Registros de Personas..");
        }else{
            System.out.println("Número de registros: "+result.size());
            while(result.hasNext()){
                Persona p = result.next();
                System.out.println("Nombre:" + p.getNombre( )+", Ciudad:" + p.getCiudad( ) );
            }
    }
    db.close();
    }
    public static void recuperarPersonas(ObjectContainer db){
        Persona per = new Persona(null,null);
        ObjectSet<Persona> result = db.queryByExample(per);
        if (result.size() == 0) {
            System.out.println("No existen Registros de Personas..");
        }else{
            System.out.println("Número de registros: "+result.size());
            while(result.hasNext()){
                Persona p = result.next();
                System.out.println("Nombre:" + p.getNombre( )+", Ciudad:" + p.getCiudad( ) );
            }
        }
        db.close();
    }

    public static void cargarPersonas(ObjectContainer db){
        Persona p2 = new Persona("Ana", "Madrid");
        Persona p3 = new Persona("Luis", "Granada");
        Persona p4 = new Persona("Pedro", "Asturias");
        //Almacenar objetos Persona en la base de datos db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.close(); //cerrar base de datos
        
    }

    public static void deleteObjeto(ObjectContainer db, String nombre){
        ObjectSet<Persona> result = db.queryByExample(new Persona(nombre,null));
        if (result. size () == 0) {
            System.out.println ("No existe esa persona...") ;}
        else {
            Persona existe = (Persona) result.next();
            System.out.println("Registros a borrar: "+ result.size());
            if (result.size()>1) { //varios objetos con nombre Juan while(result.hasNext()) 
                while(result.hasNext()) {
                    Persona p = result.next();
                    db.delete(p);
                    System.out.println("Borrado...." );
                    }          
        }
        db.delete(existe); //solo hay un objeto con nombre.Juan
        
        }
    }

    public static void modificarObjeto(ObjectContainer db, String nombre, String ciudad){
        ObjectSet<Persona> result = db.queryByExample(new Persona(nombre,null));
        if (result.size () == 0){
            System.out.println ("No existe esa persona...");
        } else{
            for(int i=0;i<result.size ();i++){
                Persona existe = (Persona) result.next(); 
                existe.setCiudad(ciudad);
                db.store(existe); //ciudad modificada
            }
        
        //consultar los datos
         }
    }
    public static void main(String[] args) {
        ObjectContainer db= Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDPer);
        cargarPersonas(db);
        //recuperarPersonas(db);
        //recuperarPorNombre(db, "Luis");
        //recuperarPorCiudad(db, "Granada");
        //modificarObjeto(db, "Luis","Toledo");
        //recuperarPersonas(db);
        //recuperarPorNombre(db, "Luis");
        //modificarObjeto(db, "Ana","Toledo");
        //recuperarPorNombre(db, "Ana");
        //deleteObjeto(db, "Ana");
        //recuperarPersonas(db);
        //deleteObjeto(db, "Luis");
        //recuperarPersonas(db);
} 

}
