package jena3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

public class Jena3 {

    Model modelo;
    String url;
    
    public void setModel(Model modelo) {
        this.modelo = modelo;
    }
    
    public Model getModel(){
        return modelo;
    }
    
    public boolean setURL(String url){
        if(isUrl(url)){
            this.url=url;
            return true;
        }else{
            return false;
        }
    }
    public String getURL(){
        return url;
    }

    public String hacerConsulta(String mensaje) {
       String sol = "";
        try (QueryExecution ejecucion = QueryExecutionFactory.create(QueryFactory.create(mensaje) , modelo)) {
            ResultSet resultados =ejecucion.execSelect();
            for(; resultados.hasNext();){
            QuerySolution solucion =resultados.nextSolution();
            sol = sol + solucion.toString() + "\n";
        }
            ejecucion.close();
            return sol;
        }catch(org.apache.jena.query.QueryParseException  e){
            sol = "La consulta podría estar mal formulada, por favor revisela.\n" + e.getMessage();
            return sol;
        }
    }
    
    public String hacerConsultaRemota(String mensaje){    
    String sol = "";    
        try (QueryExecution ejecucion = QueryExecutionFactory.sparqlService(url, QueryFactory.create(mensaje))) {
            ResultSet resultados = ejecucion.execSelect();
            for(; resultados.hasNext();){
                QuerySolution solucion =resultados.nextSolution();
                sol = sol + solucion.toString() + "\n";
            }
            return sol;
        }catch(org.apache.jena.query.QueryParseException e ){
            sol = "La consulta podría estar mal formulada, por favor revisela.\n" + e.getMessage();
            return sol;
        }      
    }
    
    private static boolean isUrl(String s) {
    String regex = "^(https?://)?(([\\w!~*'().&=+$%-]+: )?[\\w!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([\\w!~*'()-]+\\.)*([\\w^-][\\w-]{0,61})?[\\w]\\.[a-z]{2,6})(:[0-9]{1,4})?((/*)|(/+[\\w!~*'().;?:@&=+$,%#-]+)+/*)$";
 
    try {
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(s);
        return matcher.matches();
    } catch (RuntimeException e) {
        return false;
    }
}
   
}
