package claserdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;


public class LengProg {
    public static void main(String[] args){
        System.out.println("Creando RDF...");
        String personURI = "htpp://www.pucp.edu.pe/AndresMelgar";
        String fullName = "Andres Melgar";
        
        Model model = ModelFactory.createDefaultModel();
        Resource andresMelgar = model.createResource(personURI);
        andresMelgar.addProperty(VCARD.FN, fullName);
        
        System.out.println("Escribir RDF RDF/XML...");
        model.write(System.out, "RDF/XML");
        
        FileOutputStream output =null;
        try {
            output = new FileOutputStream("Carta.rdf");
        } catch (FileNotFoundException e){
            System.out.println("Ocurrió un error en el sistema de archivo");
        }
        
        model.write(output,"RDF/XML");
    }
}
