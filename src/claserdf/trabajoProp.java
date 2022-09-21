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
        
        Property puestoMejoresLenguajes = crearPropiedad(uri, "puestoMejoresLenguajes",model);
        Property puestoMejLengMovil  = crearPropiedad(uri,"puestoMejLengMovil",model);

        //PROPIEDADES
        
        model.add(puestoMejLengMovil, RDFS.subPropertyOf, puestoMejoresLenguajes);
   
        Resource Kotlin = crearRecurso(uri + "Kotlin",model);
        Resource Swift = crearRecurso(uri + "Swift",model);
        Resource Javascript = crearRecurso(uri + "Javascript",model);
        Resource PHP = crearRecurso(uri + "PHP",model);
        Resource Ranking1 = crearRecurso(uri + "Ranking1",model);
        
        Resource Ranking2 = crearRecurso(uri + "Ranking2", model);
        
        model.add(Kotlin, puestoMejoresLenguajes,Ranking2 );
        model.add(Kotlin, puestoMejLengMovil, Ranking1);

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


