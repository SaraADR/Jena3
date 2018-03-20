/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jena2;

import java.util.Iterator;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Derivation;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.PrintUtil;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class Jena2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model esquema = RDFDataMgr.loadModel("esquema.ttl");
        Model datos = RDFDataMgr.loadModel("datos.ttl");
        
        Reasoner razonador = ReasonerRegistry.getRDFSReasoner();
        razonador.setParameter(ReasonerVocabulary.PROPsetRDFSLevel,ReasonerVocabulary.RDFS_SIMPLE);
        razonador.setDerivationLogging(true);
       
        Reasoner razonadorConEsquema = razonador.bindSchema(esquema); //para usar al rezonador mas esquema diferentes datos
        //DEVUELVE UN OBJETO DE INFERENCIA
        InfModel inferencia = ModelFactory.createInfModel(razonadorConEsquema, datos);
        //esas dos son lo mismo que la que esta comentada debajo       
        
       // InfModel inferencia = ModelFactory.createInfModel(razonador, esquema, datos);
        StmtIterator iter = inferencia.listStatements();
        while(iter.hasNext()){
            Statement st=iter.nextStatement();
            System.out.println("--->" + PrintUtil.print(st));
        }
        Resource juan = inferencia.getResource("http://www.sara.com/soy/juan");
        iter = inferencia.listStatements((Resource)null, RDF.type, (RDFNode)null);
        System.out.println("--------------------------------------");
        while(iter.hasNext()){
            Statement st=iter.nextStatement();
            System.out.println("--->" + PrintUtil.print(st));
            for (Iterator iter2 = inferencia.getDerivation(st); iter2.hasNext();) {
                Derivation deriv = (Derivation)iter2.next();
                System.out.println(deriv.toString());
            }
        }
        System.out.println("--------------------------------------");
        ValidityReport validacion = inferencia.validate();
        if(validacion.isValid()){
            System.out.println("OK");
        }else{
            System.out.println("NO OK");
            Iterator iter2 = validacion.getReports();
            while(iter.hasNext()){
                System.out.println(iter2.next().toString());
            }
        }
    }
    
}
