package claserdf;

import static claserdf.trabajoProp.crearPropiedad;
import static claserdf.trabajoProp.crearRecurso;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.VCARD;

public class trabajo {
    public static void main(String[] args){
        Model model = ModelFactory.createDefaultModel();
        String uri = "http://www.pucp.edu.pe/";
        String ns = "pucp";
        model.setNsPrefix(ns, uri);
        Resource lenguajeProgramacion = Recurso(uri, "LenguajesdeProgramación", model);
        Resource lenguajeAltoNivel = Recurso(uri, "LenguajesdeAltoNivel", model);
        Resource lenguajeBajoNivel = Recurso(uri, "LenguajesdeBajoNivel", model);
        Resource lenguajeProcedimental = Recurso(uri, "LenguajeProcedimental", model);
        Resource lenguajeFuncional = Recurso(uri, "LenguajeFuncional", model);
        Resource lenguajeOrientadoObjetos = Recurso(uri, "LenguajeOrientadoaObjetos", model);
        Resource lenguajeScriptingl = Recurso(uri, "LenguajeScripting", model);
        Resource lenguajeLogico = Recurso(uri, "LenguajeLógico", model);
        Resource lenguajeAsembler = Recurso(uri, "Asembler", model);
        Resource lenguajeFortran = Recurso(uri, "Fortran", model);
        Resource lenguajeCobol = Recurso(uri, "Cobol", model);
        Resource lenguajeScala = Recurso(uri, "Scala", model);
        Resource lenguajeHaskell = Recurso(uri, "Haskell", model);
        Resource lenguajeJava = Recurso(uri, "Java", model);
        Resource lenguajePython = Recurso(uri, "Python", model);
        Resource lenguajeC = Recurso(uri, "C#", model);
        Resource lenguajeKotlin = Recurso(uri,"Kotlin",model);
        Resource lenguajeGo = Recurso(uri,"Go",model);
        Resource lenguajeSwift = Recurso(uri,"Swift",model);
        Resource lenguajeTypeScript = Recurso(uri, "TypeScript", model);
        Resource lenguajeSQL = Recurso(uri, "SQL", model);
        Resource lenguajeMongoDB = Recurso(uri,"MongoDB", model);
        Resource lenguajeProlog = Recurso(uri, "Prolog", model);
        Resource lenguajeLisp = Recurso(uri, "Lisp", model);

        //Subclases
        model.add(lenguajeAltoNivel, RDFS.subClassOf, lenguajeProgramacion);
        model.add(lenguajeBajoNivel, RDFS.subClassOf, lenguajeProgramacion);
        model.add(lenguajeProcedimental, RDFS.subClassOf, lenguajeAltoNivel);
        model.add(lenguajeFuncional, RDFS.subClassOf, lenguajeAltoNivel);
        model.add(lenguajeOrientadoObjetos, RDFS.subClassOf, lenguajeAltoNivel);
        model.add(lenguajeScriptingl, RDFS.subClassOf, lenguajeAltoNivel);
        model.add(lenguajeLogico, RDFS.subClassOf, lenguajeAltoNivel);
        
        //Types
        model.add(lenguajeFortran, RDF.type, lenguajeProcedimental);
        model.add(lenguajeCobol, RDF.type, lenguajeProcedimental);
        model.add(lenguajeScala, RDF.type, lenguajeFuncional);
        model.add(lenguajeHaskell, RDF.type, lenguajeFuncional);
        model.add(lenguajeJava, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajePython, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeC, RDF.type, lenguajeOrientadoObjetos);
        //model.add(lenguajeKotlin, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeGo, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeSwift, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeTypeScript, RDF.type, lenguajeScriptingl);
        model.add(lenguajeSQL, RDF.type, lenguajeScriptingl);
        model.add(lenguajeMongoDB, RDF.type,lenguajeScriptingl);
        model.add(lenguajeProlog, RDF.type, lenguajeLogico);
        model.add(lenguajeLisp, RDF.type, lenguajeLogico);
        
        //NODO EN BLANCO

        Resource blankNode2 = model.createResource();
        Property nacimiento = model.createProperty(uri, "nacimiento");
        Property desarrollador = model.createProperty(uri, "desarrollador");
        Property anhoLanzamiento = model.createProperty(uri, "anhoLanzamiento");
        
        blankNode2.addProperty(desarrollador,"apple");
        blankNode2.addProperty(anhoLanzamiento, "2014");
        lenguajeSwift.addProperty(nacimiento, blankNode2);

        //PROPIEDADES Y SUBPROPIEDADES
        
        Property puestoMejoresLenguajes = crearPropiedad(uri, "puestoMejoresLenguajes",model);
        Property puestoMejLengMovil  = crearPropiedad(uri,"puestoMejLengMovil",model);
        
        model.add(puestoMejLengMovil, RDFS.subPropertyOf, puestoMejoresLenguajes);
        
        Resource Kotlin = crearRecurso(uri + "Kotlin",model);
        Resource Swift = crearRecurso(uri + "Swift",model);
        Resource Javascript = crearRecurso(uri + "Javascript",model);
        Resource PHP = crearRecurso(uri + "PHP",model);
        Resource Ranking1 = crearRecurso(uri + "Ranking1",model);
        
        Resource Ranking2 = crearRecurso(uri + "Ranking2", model);
        
        //model.add(Kotlin, puestoMejoresLenguajes,Ranking2 );
        model.add(Kotlin, puestoMejLengMovil, Ranking1);
        
        //DOMINIO
        
        model.add( puestoMejoresLenguajes , RDFS.domain , lenguajeAltoNivel );
        model.add( puestoMejLengMovil , RDFS.domain , lenguajeOrientadoObjetos );
        
        System.out.println("Escribir RDF/XML...");
        model.write(System.out, "RDF/XML");
        
        //SE DEJA COMENTADO, PARA EVITAR QUE IMPRIMA TODO EN CONSOLA
        /* MODELOS DE SERIALIZACION
        System.out.println("Escribir N-Triple");
        model.write(System.out,"N-TRIPLE");
        System.out.println("Escribir en Turtle");
        model.write(System.out, "TURTLE");
        System.out.println("Escribir en TTL");
        model.write(System.out, "TTL");
        System.out.println("Escribir en N3");
        model.write(System.out, "N3");
        */
        
        //DESCARGANDO PROYECTO
        FileOutputStream output = null;
        try {
            output = new FileOutputStream("Proyecto.rdf");
        } catch (FileNotFoundException e){
            System.out.println("Ocurrió un erro al crear el archivo");
        }
        model.write(output, "RDF/XML-ABBREV");
    }
    
    public static Resource Recurso(String uri, String id, Model model) {
        return model.createResource(uri + id);
    }
}
