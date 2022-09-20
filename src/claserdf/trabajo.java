package claserdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
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
        Resource lenguajeProgramacion = Recurso(uri, "Lenguajes de Programación", model);
        Resource lenguajeAltoNivel = Recurso(uri, "Lenguajes de Alto Nivel", model);
        Resource lenguajeBajoNivel = Recurso(uri, "Lenguajes de Bajo Nivel", model);
        Resource lenguajeProcedimental = Recurso(uri, "Lenguaje Procedimental", model);
        Resource lenguajeFuncional = Recurso(uri, "Lenguaje Funcional", model);
        Resource lenguajeOrientadoObjetos = Recurso(uri, "Lenguaje Orientado a Objetos", model);
        Resource lenguajeScriptingl = Recurso(uri, "Lenguaje Scripting", model);
        Resource lenguajeLogico = Recurso(uri, "Lenguaje Lógico", model);
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
        model.add(lenguajeKotlin, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeGo, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeSwift, RDF.type, lenguajeOrientadoObjetos);
        model.add(lenguajeTypeScript, RDF.type, lenguajeScriptingl);
        model.add(lenguajeSQL, RDF.type, lenguajeScriptingl);
        model.add(lenguajeMongoDB, RDF.type,lenguajeScriptingl);
        model.add(lenguajeProlog, RDF.type, lenguajeLogico);
        model.add(lenguajeLisp, RDF.type, lenguajeLogico);
        
        //NODO EN BLANCO
        Resource blankNode = model.createResource();
        blankNode.addProperty(VCARD.Family ,lenguajeAsembler);
        lenguajeBajoNivel.addProperty(VCARD.N, blankNode);
        
        System.out.println("Escribir RDF/XML...");
        model.write(System.out, "RDF/XML");
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
