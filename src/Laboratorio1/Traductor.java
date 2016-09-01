/*
 * Universidad Nacional de Colombia (Bogotá )
 * Departamento de Ingeniería de Sistemas y Computación
 * 
 *
 * Laboratorio 1
 * Ejercicio: Traductor
 * Autores coolaboradores: Edwin Gelacio eagelaciom@unal.edu.co - Daniel Chaparro daachaparroga@unal.edu.co
*/
import java.util.ArrayList;
import java.util.Scanner;


public class Traductor {
    
   
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> palabra_espanol = new ArrayList<>();
    static ArrayList<String> palabra_ingles = new ArrayList<>();
    static ArrayList<String> palabra_frances = new ArrayList<>();
    static ArrayList<String> palabra_italiano = new ArrayList<>();
        
    public static void main(String[] args) {
        
       palabra_espanol.add("amor");
       palabra_ingles.add("love");
       palabra_frances.add("amour");
       palabra_italiano.add("amore");


       palabra_espanol.add("jugar");
       palabra_ingles.add("play");
       palabra_frances.add("jouer");
       palabra_italiano.add("giocare");

       palabra_espanol.add("comer");
       palabra_ingles.add("eat");
       palabra_frances.add("manger");
       palabra_italiano.add("mangiare");

       palabra_espanol.add("saltar");
       palabra_ingles.add("jump");
       palabra_frances.add("sauter");
       palabra_italiano.add("salatre");
    
       traduc();
   
        
}
      static private void traduc(){
        String opcion1 ;
        System.out.println("Seleccion la opcion que desea realizar \n 1)Traducir palabra 2)Traducir frase" );
        opcion1 = in.next();
  
        if(opcion1.equals("1")){
            
            Traducirpalabra();
        }
        if(opcion1.equals("2")){
            Traducirfrase();
        }
     }
     static private void Traducirpalabra(){
 
       System.out.println("Seleccione el idioma de la palabra que desea traducir \n 1.Espa�ol 2.Ingles 3.Frances 4.Italiano");
        
         String idioma_origen=in.next();
         
         int index=0;
        
        System.out.println("Ingrese la palabra que desea traducir");
        
         String palabra_origen=in.next();
        
        if(idioma_origen.equals("1")){
            
            if (palabra_espanol.contains(palabra_origen)){}
            else {System.out.println("La palabra no existe en diccionario");
            traduc();}
            
        System.out.println("Seleccione el idioma al que quiere traducir la palabra \n 1.Ingles 2.Frances 3.Italiano");
        
         String idioma_destino=in.next();
         
         index=palabra_espanol.indexOf(palabra_origen);
         
         if(idioma_destino.equals("1")){
             System.out.println("La traduccion al ingles es: "+ palabra_ingles.get(index));
             traduc();
        }
       
        if (idioma_destino.equals("2")){
           System.out.println("La traduccion al frances es: "+ palabra_frances.get(index));
           traduc();
            
        }
       
        if (idioma_destino.equals("3")){
            System.out.println("La traduccion al italiano es: "+ palabra_italiano.get(index));
            traduc();
        }
        }
         
        
        else{ 
    
        if(idioma_origen.equals("2")){
           if (palabra_ingles.contains(palabra_origen)){
               index=palabra_ingles.indexOf(palabra_origen);
           }
           else {System.out.println("La palabra no existe en diccionario");
           traduc();}
        }
       
        if (idioma_origen.equals("3")){
           if (palabra_frances.contains(palabra_origen)){
               index=palabra_frances.indexOf(palabra_origen);
           }
           else {System.out.println("La palabra no existe en diccionario");
           traduc();}
        }
       
        if (idioma_origen.equals("4")){
           if (palabra_italiano.contains(palabra_origen)){
               index=palabra_italiano.indexOf(palabra_origen);
           }  
           else {System.out.println("La palabra no existe en diccionario");
           traduc();}
        }
            System.out.println("La traduccion al espanol es: "+ palabra_espanol.get(index));
            traduc();
            
}    
     }   
     
     static private void Traducirfrase(){
     
       int frase;

        System.out.println("Ingrese la frase que desea traducir" );
        frase = Integer.parseInt(in.next());
     
        
        
        
     }
     
     
            
            
     
    
}