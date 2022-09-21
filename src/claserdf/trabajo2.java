package claserdf;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.RDFS;

public class trabajo2 {
    public static void main(String[] args){
        String inputFileName ="Proyecto.rdf";
        Model model = ModelFactory.createDefaultModel();
        model.read(inputFileName);
        
        String resourcedURI = model.expandPrefix("pucp:LenguajeFuncional");
        Resource resource = model.getResource(resourcedURI);
        Selector selector = new SimpleSelector(resource, RDFS.subClassOf, (RDFNode) null);
        StmtIterator iter = model.listStatements(selector);
        while (iter.hasNext()){
            System.out.println(iter.nextStatement().toString());
        }  
    }
}
