package claserdf;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.StmtIterator;


public class trabajoProp2 {
    public static void main(String[] args){
        String inputFileName = "Proyecto.rdf";
        Model model = ModelFactory.createDefaultModel();
        model.read(inputFileName);
        InfModel inf = ModelFactory.createRDFSModel(model) ;
        
        String resourceURI = model.expandPrefix("pucp:Kotlin");
        Resource kotlin = model.getResource(resourceURI);
        
        resourceURI = model.expandPrefix("pucp:Ranking1");
        Resource Ranking2 = model.getResource(resourceURI);
        String propertyURI = model.expandPrefix("pucp:puestoMejoresLenguajes");
        Property puestoMejoresLenguajes = model.getProperty(propertyURI);
        
        Selector selector = new SimpleSelector(kotlin,puestoMejoresLenguajes, Ranking2);
        StmtIterator iter = inf.listStatements(selector);
        while(iter.hasNext()){
            System.out.println(iter.nextStatement().toString());
        }
                
    }       
}
