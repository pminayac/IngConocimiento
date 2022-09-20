package claserdf;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;


public class LengProg2 {
    public static void main(String[] args){
        String inputFileName ="Carta.rdf";
        Model model = ModelFactory.createDefaultModel();
        model.read(inputFileName);
        
        
    }
}
