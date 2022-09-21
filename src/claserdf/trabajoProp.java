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
        
        Property LenguajeTop = crearPropiedad(uri, "LenguajeTop",model);
        Property BestLangMobil = crearPropiedad(uri, "BestLangMobil",model);
        Property BestLangFront = crearPropiedad(uri, "LenguajesWeb",model);
        Property BestLangBack = crearPropiedad(uri, "Frontend",model);
        
        //PROPIEDADES
        
        model.add(BestLangMobil, RDFS.subPropertyOf, LenguajeTop);
        model.add(BestLangFront, RDFS.subPropertyOf, LenguajeTop);
        model.add(BestLangBack, RDFS.subPropertyOf, LenguajeTop);
        
        Resource Kotlin = crearRecurso(uri + "Kotlin",model);
        Resource Swift = crearRecurso(uri + "Swift",model);
        Resource Javascript = crearRecurso(uri + "Javascript",model);
        Resource PHP = crearRecurso(uri + "PHP",model);
        Resource Ranking1 = crearRecurso(uri + "Ranking1",model);
        Resource Ranking2 = crearRecurso(uri + "Ranking2", model);
        
        model.add(Kotlin, LenguajeTop, Ranking2);
        model.add(Kotlin, BestLangMobil, Ranking1);
        model.add(Javascript,LenguajeTop, Ranking1 );
        model.add(Javascript,BestLangFront,Ranking1 );
        
        System.out.println("Escribir RDF/XML...");
        model.write(System.out, "RDF/XML");
        
        FileOutputStream output = null;
        try {
                output = new FileOutputStream("propiedades.rdf");
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


