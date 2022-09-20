package claserdf;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;


public class ejemplo2 {
    public static void main(String[] args){
        System.out.println("Creando RDF...");
        String personURI = "http://www.pucp.edu.pe/AndresMelgar";
        String fullName = "Andres Melgar";
        String givenName = "Hector Andres";
        String familyName = "Melgar Sasieta";
        
        Model model = ModelFactory.createDefaultModel();
        Resource andresMelgar = model.createResource(personURI);
        andresMelgar.addProperty(VCARD.FN, fullName);
        
        Resource blankNode = model.createResource();
        blankNode.addProperty(VCARD.Given, givenName);
        blankNode.addProperty(VCARD.Family, familyName);
        andresMelgar.addProperty(VCARD.N, blankNode);
        
        System.out.println("Escribir RDF/XML...");
        model.write(System.out, "RDF/XML");
        System.out.println("Escribir N-Triple");
        model.write(System.out,"N-TRIPLE");
        System.out.println("Escribir en Turtle");
        model.write(System.out, "TURTLE");
        System.out.println("Escribir en TTL");
        model.write(System.out, "TTL");
        System.out.println("Escribir en N3");
        model.write(System.out, "N3");
    }
}
