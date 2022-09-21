package claserdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

public class trabajoProp {
    public static void main(String[] args){
        Model model = ModelFactory.createDefaultModel();
        String uri = "http://www.pucp.edu.pe/";
        String prefijo ="pucp";
        model.setNsPrefix(prefijo,uri);
        
        Property LenguajesRentables = crearPropiedad(uri, "LenguajesRentables",model);
        Property LenguajesMobile = crearPropiedad(uri, "LenguajesMobile",model);
        Property LenguajesWeb = crearPropiedad(uri, "LenguajesWeb",model);
        Property Frontend = crearPropiedad(uri, "Frontend",model);
        Property Backend = crearPropiedad(uri, "Backend",model);
        //PROPIEDADES
        
        model.add(LenguajesMobile, RDFS.subPropertyOf, LenguajesRentables);
        model.add(LenguajesWeb, RDFS.subPropertyOf, LenguajesRentables);
        model.add(Frontend, RDFS.subPropertyOf, LenguajesWeb);
        model.add(Backend, RDFS.subPropertyOf, LenguajesWeb);
        
        Resource Kotlin = crearRecurso(uri + "Kotlin",model);
        Resource Swift = crearRecurso(uri + "Swift",model);
        Resource Javascript = crearRecurso(uri + "Javascript",model);
        Resource PHP = crearRecurso(uri + "PHP",model);
        Resource RankingTop = crearRecurso(uri + "RankingTop",model);
        Resource RankingJob = crearRecurso(uri + "RankingJob", model);
        
        model.add(Kotlin, LenguajesMobile, RankingTop);
        model.add(Swift, LenguajesMobile, RankingTop);
        model.add(Javascript, LenguajesWeb, RankingTop);
        model.add(PHP, Backend, RankingJob);
        
        System.out.println("Escribir RDF/XML...");
        model.write(System.out, "RDF/XML");
        
        FileOutputStream output = null;
        try {
                output = new FileOutputStream("relaciones_trabajadores.rdf");
        } catch (FileNotFoundException e){
            System.out.println("No se guardo el archivo");
        }
        
        model.write(output, "RDF/XML");
    }

    public static Property crearPropiedad(String uri_base, String id, Model model){
        return model.createProperty(uri_base, id);
    }
    
    public static Resource crearRecurso(String id, Model model){
        return model.createResource(id);
    }
}


