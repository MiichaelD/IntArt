package com.sample;
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

public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            Message message = new Message();// instanciamos claseMensaje
            message.setMessage("                                 Entrenador personal" +
            		"\n\nPorfavor contestar cada una de las siguientes preguntas para\nrecibir un" +
            		" diagnostico acertado y una recomendacion eficiente.");
            message.setStatus(Message.INICIO);
            ksession.insert(message);
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
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

    public static class Message {
        public static final int INICIO = 1, nombre= 2,edad = 3,peso = 4,estatura = 5, sexo = 6,
        estructura = 7, cuerpoA = 8, cuerpoB= 9, hombre = 10, mujer = 11, nino = 12, actividad = 13,
        acercamiento = 14, metabolismo= 15, personas = 16, rodeas= 17, PROCESADOR = 18, pesoA = 19,
        hambre = 20, descripcion = 21, ejercicio = 22, principiante = 23, rutbrazo = 24, rutpecho = 25,
        rutpierna = 26, biceps = 27, triceps = 28, bran = 29, tipo = 30, novato = 31, cuadriceps = 32,
        tendon = 33, pantorrilla = 34, rutinas = 35, nbrazo = 36, npecho = 37, npierna = 38, nbiceps = 39,
        ntriceps = 40, nbran = 41, ncuadriceps = 42, ntendon = 43, npantorrilla = 44, experto = 45, ebrazo = 46,
        epecho= 47, epierna= 48, ebiceps= 49, etriceps= 50, ebran= 51, ecuadriceps= 52, etendon= 53, epantorrilla= 54,
        cul= 55, cbrazo= 56, cpierna= 57, cpecho= 58, cbiceps= 59, ctriceps= 60, cbran= 61, ccuadriceps= 62,
        ctendon= 63, cpantorrilla= 64;
        
        String message;
        private int status;

        public String getMessage() {return this.message;}

        public void setMessage(String message) {this.message = message;}

        public int getStatus() {return this.status;}

        public void setStatus(int status) {this.status = status;}

    }

}
