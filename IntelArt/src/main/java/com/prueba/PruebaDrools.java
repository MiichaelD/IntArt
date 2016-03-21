package com.prueba;
//import javax.swing.*;
import java.util.*;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class PruebaDrools {
	
	//Clima-20;		Playa-25;		Seguridad-10;		Comida-15//
    public static final void main(String[] args) { try {
      	Mensaje mess = new Mensaje();
        Edo	edo=new Edo();
        final PruebaDrools pd=new PruebaDrools();
    	
    	new Thread(new Runnable(){ public void run(){pd.LlenarEdos();}}).start();
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "Prueba");
            mess.setMessage("Contesta unas breves preguntas para poder ofrecerte\nun catalogo de lugares que podrian ser de tu agrado.");
            mess.setStatus(Mensaje.valores.Inicio);
            ksession.insert(mess);
            ksession.insert(edo);
            ksession.insert(pd);
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) { t.printStackTrace();}
    }  
    
    static public String[] agrado=null;
    
    static public LinkedList<Edo> lista=new LinkedList<Edo>();
        
    public void LlenarEdos(){
    	lista.add(new Edo("BajaCalifornia",Edo.climas.Seco,true,false));
    	lista.add(new Edo("Sonora",Edo.climas.Seco,true,true));
    	lista.add(new Edo("BajaCaliforniaSur",Edo.climas.Seco,true,true));
    	lista.add(new Edo("Sinaloa",Edo.climas.Seco,true,false));
    	lista.add(new Edo("Chihuahua",Edo.climas.Templado,false,false));
    	lista.add(new Edo("Coahuila",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("NuevoLeon",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("Tamaulipas",Edo.climas.Templado,true ,false));
    	lista.add(new Edo("Durango",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("Zacatecas",Edo.climas.Templado,false ,true));
    	lista.add(new Edo("SanLuisPotosi",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("Guanajuato",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("Queretaro",Edo.climas.Templado,false ,true));
    	lista.add(new Edo("Hidalgo",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("Puebla",Edo.climas.Templado,false ,false));
    	lista.add(new Edo("Oaxaca",Edo.climas.Templado,true ,false));
    	lista.add(new Edo("Guerrero",Edo.climas.Templado,true,true));
    	lista.add(new Edo("Jalisco",Edo.climas.CalidoSemiHumedo,true ,false));
    	lista.add(new Edo("Nayarit",Edo.climas.CalidoSemiHumedo,true ,true));
    	lista.add(new Edo("Colima",Edo.climas.CalidoSemiHumedo,true ,true));
    	lista.add(new Edo("Michoacan",Edo.climas.CalidoSemiHumedo,true ,false));
    	lista.add(new Edo("Veracruz",Edo.climas.CalidoHumedo,true ,false));
    	lista.add(new Edo("Chiapas",Edo.climas.CalidoHumedo,true ,true));
    	lista.add(new Edo("Campeche",Edo.climas.CalidoHumedo,true ,true));
    	lista.add(new Edo("QuintanaRoo",Edo.climas.CalidoHumedo,true ,true));
    }
    
    static public String mostrar(int cuantos){
    	String cadena="",puntos="";
    	agrado=new String[lista.size()];
    	Scanner sc=null;
    	for(int i=0;i<lista.size();i++)
    		agrado[i]=lista.get(i).agrado+"\t"+lista.get(i).nombre;
    	
    	Arrays.sort(agrado,Collections.reverseOrder());
    	for(int i=0;i<agrado.length;i++)
    	System.out.println(agrado[i]);
    	
    	System.out.println("\nEMPEZAMOS OTRA COSA");
    	
    	cadena="\nPos.  Agrado     Lugar:\n";
    	for(int i=0;i<cuantos;i++){
        	sc=new Scanner(agrado[i]);
        	sc.useDelimiter("[\t]");
        	puntos=sc.next();
        	agrado[i]=sc.next();
        	cadena+=(1+i)+")           "+puntos+"          "+agrado[i]+"\n";
    	}
    	return (cadena);
    }
    
    public static class Mensaje {
        public static enum valores {Inicio,CuandoViajar,tienePlaya,esSeguro,viajaVerano,viajaInvierno,Fin,
        	Comida,Mariscos,Pescado,Camarones,Pulpo,Almeja,OtraComida,Tamales,Pollo,China,Carne,Quesos,BajaCalifornia,
        	Sonora,BajaCaliforniaSur,Sinaloa,Chihuahua,Coahuila,NuevoLeon,Tamaulipas,Durango,Zacatecas,SanLuisPotosi,
        	Guanajuato,Queretaro,Hidalgo,Puebla,Oaxaca,Guerrero,Jalisco,Nayarit,Colima,Michoacan,Veracruz,Chiapas,Campeche,QuintanaRoo}
        
        static String message;
        static valores status;
      
        public  String getMessage() {return message;}
        public  void setMessage(String mensaje) {message = mensaje;}
        public valores getStatus() {return status;}
        public void setStatus(valores estado) {status = estado;}
        public void setStatuss(String estado){status=valores.valueOf(estado); }
    }

    public static class Edo{
    	public Edo(String nombre,climas clima,boolean playa, boolean seguro){
    		this.nombre=nombre;
    		this.clima=clima;
    		this.playa=playa;
    		muySeguro=seguro;	}
    	public Edo(){}
    	static public enum climas{Seco,Templado,CalidoSemiHumedo,CalidoHumedo}
    	public int agrado=0;
    	public String nombre;
    	public boolean playa,muySeguro;
    	public climas clima;
    }
    
    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Rules.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
}
