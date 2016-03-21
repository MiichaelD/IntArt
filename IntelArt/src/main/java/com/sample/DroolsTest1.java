package com.sample;
import javax.swing.JOptionPane;
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

public class DroolsTest1
{

	public static final void main(String[] args)
	{
		int respuesta[];
		respuesta = new int[8];
		String question[];
		question = new String[8];
		question[0]="Desaparecen archivos o aparecen nuevos archivos \n de datos o directorios de origen desconocido.? \n 1.SI / 2.NO";
		question[1]="Los archivos son sustituidos por objetos de origen \n desconocido o por datos falseados? \n 1.SI / 2.NO";
		question[2]="Los programas dirigen los accesos a los discos en \n tiempos inusuales o con una frecuencia mayor.? \n 1.SI / 2.NO";
		question[3]="El número de sectores dañados de disco \n aumenta constantemente.\n 1.SI / 2.NO";
		question[4]="Programas que normalmente se comportan bien, \n funcionan de modo anormal o dejan de funcionar\n 1.SI / 2.NO";
		question[5]="Desaparecen archivos o aparecen nuevos archivos de \n datos o directorios de origen desconocido.\n 1.SI / 2.NO";
		question[6]="Los archivos son sustituidos por objetos de origen \n desconocido o por datos falseados.\n 1.SI / 2.NO";
		question[7]="Aparición de mensajes de \n error no comunes \n 1.SI / 2.NO";
		try 
		{
			// load up the knowledge base
			KnowledgeBase kbase = readKnowledgeBase();
			StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
			// go !
			Message message = new Message();
			for(int i=0;i<=7;i++)			{
				respuesta[i] = Integer.parseInt(JOptionPane.showInputDialog(question[i]));
				//if(respuesta[i]==1)break;
			}
			if(respuesta[0]==1)			{
				message.setMessage("GUSANO!");
				message.setStatus(Message.GUSANO);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[1]==1)			{
				message.setMessage("VIRUS!");
				message.setStatus(Message.VIRUS);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[2]==1)			{
				message.setMessage("CABALLO DE  TROYA");
				message.setStatus(Message.CABALLO);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[3]==1)			{
				message.setMessage("VIRUS BOOT!");
				message.setStatus(Message.BOOT);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[4]==1)			{
				message.setMessage("VIRUS DE SOBREESCRITURA!");
				message.setStatus(Message.VIRUSS);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[5]==1)			{
				message.setMessage("VIRUS!");
				message.setStatus(Message.VIRUS);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[6]==1)			{
				message.setMessage("CABALLO DE TROYA");
				message.setStatus(Message.CABALLO);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
			if(respuesta[7]==1)			{
				message.setMessage("VIRUS DE SOBREESCRITURA!");
				message.setStatus(Message.VIRUSS);
				ksession.insert(message);
				ksession.fireAllRules();
				ksession.wait();
				logger.close();
			}
		}catch (Throwable t) {t.printStackTrace();}
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception{
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("Sample1.drl"), ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0){
			for (KnowledgeBuilderError error: errors){
				System.err.println(error);
			}throw new IllegalArgumentException("Could not parse knowledge.");
		}KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

	public static class Message	{
		public static final int GUSANO = 0;
		public static final int VIRUS = 1;
		public static final int CABALLO = 3;
		public static final int BOOT= 4;
		public static final int VIRUSS=5;
		private String message;
		private int status;
		
		public String getMessage(){
			return this.message;
		}
		public void setMessage(String message){
			this.message = message;
		}
		public int getStatus() {
			return this.status;
		}
		public void setStatus(int status){
			this.status = status;
		}
	}
}
