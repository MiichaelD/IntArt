package com.prueba;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Rutinas {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Tamaulipas\nSus playas La Carbonera, Miramar, Bagdad, Soto la Marina y Barra del\n"+
			    "Tordo son las m�s visitadas por los turistas, gracias a la tranquilidad\n"+
			    "y belleza de sus aguas, tra�das a estas tierras por el Golfo de M�xico.\n"+
			    "Sobre ellas se puede bucear, esnorquelear, surfear, pasear en kayak y\n"+
			    "pescar. Continuando con las traves�as por agua, no se puede dejar de\n"+
			    "citar el apasionante y r�pido descenso por el cauce de alguno de los\n"+
			    "r�os que recorren el estado.\n\n"+
			    "El senderismo, la caminata, el campismo, la escalada en roca y el\n"+
			    "ciclismo de monta�a son algunos de los deportes que se pueden practicar\n"+
			    "al recorrer los caminos tamaulipecos, que ofrecen a la vista paisajes\n"+
			    "maravillosos. La caza es otro deporte que puede desempe�arse\n"+
			    "perfectamente en Tamaulipas, dado que aqu�  se encuentra uno de los\n"+
			    "ranchos cineg�ticos m�s importantes del pa�s.\n\n"+
			    "Tamaulipas es un estado que se puede saborear a trav�s de su nutrido\n"+
			    "cat�logo culinario. La especialidad de la casa es la popular carne a\n"+
			    "la tampique�a, misma que se puede disfrutar  al comp�s de un\n"+
			    "tradicional huapango, g�nero musical que remarca la esencia cultural\n"+
			    "tamaulipeca. Por �ltimo, artesan�as elaboradas a partir de materiales\n"+
			    "como barro, madera, gamuza, fibras vegetales y objetos marinos, reflejan\n" +
			    "la imaginacion de los artesanos locales","Tamaulipas"
				,JOptionPane.PLAIN_MESSAGE,new ImageIcon("C:/USERS/SKELETON/DESKTOP/tamaulipas.jpg"));
		Rutinas r=new Rutinas();
		//r.m1();
		//r.m2();
		r.m3();
	}
	
	 public void m1(){
/*		 entry:
			 lista.add(new Edo("Baja California",Edo.climas.Seco,true,false));
	    	lista.add(new Edo("Sonora",Edo.climas.Seco,true,true));
	    	lista.add(new Edo("Baja California Sur",Edo.climas.Seco,true,true));
	    	lista.add(new Edo("Sinaloa",Edo.climas.Seco,true,false));
	    	lista.add(new Edo("Chihuahua",Edo.climas.Templado,false,false));
	    	lista.add(new Edo("Coahuila",Edo.climas.Templado,false ,false));
	    	lista.add(new Edo("Nuevo Leon",Edo.climas.Templado,false ,false));
	    	lista.add(new Edo("Tamaulipas",Edo.climas.Templado,true ,false));
	    	lista.add(new Edo("Durango",Edo.climas.Templado,false ,false));
	    	lista.add(new Edo("Zacatecas",Edo.climas.Templado,false ,true));
	    	lista.add(new Edo("San Luis Potos�",Edo.climas.Templado,false ,false));
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
	    	lista.add(new Edo("Campeche",Edo.climas.CalidoHumedo,true ,false));
	*/		 
		Scanner sc=new Scanner(System.in),sc2=null;
		String var="";
		try{sc.useDelimiter("\"|;");}catch(Exception e){}
		while(sc.hasNext()){
			sc.next();
			var=sc.next();
			if(var.contains(" ")){ sc2=new Scanner(var); var=""; while(sc2.hasNext()){var+=sc2.next();}	}
			System.out.print(var+",");
			sc.next();
			if(var.equals("Campeche"))break;
		}
	} 
	 
	 public void m2(){
		 //entrada:BajaCalifornia,Sonora,BajaCaliforniaSur,Sinaloa,Chihuahua,Coahuila,NuevoLeon,Tamaulipas,Durango,Zacatecas,SanLuisPotosi,Guanajuato,Queretaro,Hidalgo,Puebla,Oaxaca,Guerrero,Jalisco,Nayarit,Colima,Michoacan,Veracruz,Chiapas,Campeche,
		 Scanner sc=new Scanner(System.in);
		 sc.useDelimiter(",");
		 while(sc.hasNext()){
			 String var=sc.next();
			 System.out.println(
			 		"rule \""+var+"\"\n\twhen m: Mensaje(status==Mensaje.valores."+var+",myMessage:message);\n\tthen"+
			 		"\n\tString descripcion=null;\n\tJOptionPane.showMessageDialog(null,descripcion);\n\tm.setStatus(Mensaje.valores.Fin);\n\tupdate(m);\nend\n\n"); 
		 }
	 }

	 public void m3(){
		 Scanner in=new Scanner(System.in);
		 while(in.hasNext()){
			 String cadena=in.nextLine();
			 while(cadena.startsWith("\t")||cadena.startsWith(" "))
				 cadena=cadena.substring(1,cadena.length());
			 
			 if(cadena.equals(""))System.out.println("");
			 else  System.out.println("\t\""+cadena+"\"+");
		 }
	 }
	 
}
