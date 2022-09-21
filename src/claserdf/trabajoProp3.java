package claserdf;

import java.io.PrintWriter;
import java.util.Iterator;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Derivation;
import org.apache.jena.vocabulary.RDF;

public class trabajoProp3 {

    public static void main(String[] args) {
        String inputFileName = "Proyecto.rdf";
        Model model = ModelFactory.createDefaultModel();
        model.read(inputFileName);
        InfModel inf = ModelFactory.createRDFSModel(model);
        inf.setDerivationLogging(true);

        String resourceURI = model.expandPrefix("pucp:Kotlin");
        Resource Kotlin = model.getResource(resourceURI);
        resourceURI = model.expandPrefix("pucp:LenguajeOrientadoaObjetos");
        Resource lenguajeOrientadoObjetos = model.getResource(resourceURI);

        if (existenAfirmaciones(inf, Kotlin, RDF.type, lenguajeOrientadoObjetos)) {
            System.out.println("La afirmacion es cierta");
            mostrarDerivaciones(inf, Kotlin, RDF.type, lenguajeOrientadoObjetos);
        } else {
            System.out.println("La afirmacion no es cierta");
        }
    }

    public static void mostrarDerivaciones(InfModel inf, Resource Sujeto, Property predicado, Resource objeto) {
        PrintWriter out = new PrintWriter(System.out);
        for (StmtIterator i = inf.listStatements(Sujeto, predicado, objeto); i.hasNext();) {
            Statement s = i.nextStatement();
            System.out.println("Statement is" + s);
            for (Iterator id = inf.getDerivation(s); id.hasNext();) {
                Derivation deriv = (Derivation) id.next();
                deriv.printTrace(out, true);
            }
        }
        out.flush();
    }

    public static Boolean existenAfirmaciones(InfModel inf, Resource Sujeto,
            Property predicado, Resource objeto) {
        Boolean hayAfirmaciones;
        Selector selector = new SimpleSelector(Sujeto, predicado, objeto);
        StmtIterator iter = inf.listStatements(selector);
        hayAfirmaciones = iter.hasNext();
        return hayAfirmaciones;
    }
}
