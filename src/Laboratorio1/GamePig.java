/*
 * Universidad Nacional de Colombia (Bogotá )
 * Departamento de Ingeniería de Sistemas y Computación
 * 
 *
 * Laboratorio 1
 * Ejercicio: GamePig
 * Autores coolaboradores: Edwin Gelacio eagelaciom@unal.edu.co - Daniel Chaparro daachaparroga@unal.edu.co
*/
import java.util.Scanner;
import java.util.Random;


public class GamePig {
    
    public static void main(String[] args) {
            System.out.println("Este es el juego de los dados del cerdo");
            pig();
    }
        
    public static void pig(){
        int puntajejug=0,puntajetotalj=0;
        int puntajecomp=0,puntajetotalcomp=0;
        int dadojugador,dadocomp,dadojugador1,dadocomp1,totaldadosj,totaldadosc,numa=0;
        Random rand = new Random();
        String d;
        char opcion = 'p';
        char opcion1 = 'P';
        
        System.out.print("Ingresa tu nombre: ");
        Scanner n = new Scanner(System.in);
        String nombre = n.nextLine();
        
        while(puntajetotalj <= 100 && puntajetotalcomp <= 100){
            do{
                dadojugador = rand.nextInt(6)+1; 
                dadojugador1 = rand.nextInt(6)+1;
                System.out.println("### Turno " + nombre + " ###");
                System.out.println("Obtuviste: " + dadojugador + " y " + dadojugador1);
                totaldadosj=dadojugador+dadojugador1;
                System.out.println("Total tiro: " + totaldadosj);
                if(dadojugador == 1 || dadojugador1 == 1 ){
                    System.out.println("Perdiste el turno");
                    totaldadosj=0;
                    puntajetotalj += totaldadosj;
                    System.out.println("El total es: " + puntajetotalj);
                    break;
                }else if(dadojugador == 1 && dadojugador1 == 1){
                    puntajetotalj=0;
                    System.out.println("Perdiste el turno y el acumulado");
                    break;
                }else{
                    puntajejug = puntajejug + totaldadosj;
                    puntajetotalj = puntajetotalj + totaldadosj;
                    System.out.println("Tu puntaje es: " + puntajetotalj);
                    if(puntajetotalj >= 100){
                        break;
                    }else{
                        System.out.print("Si quieres tirar los dados de nuevo presiona 't' si no presiona 'p' para pasar: ");
                        Scanner t = new Scanner(System.in);
                        d = t.nextLine();
                        opcion = d.charAt(0);
                        opcion1 = d.charAt(0);
                        if(opcion == 'p' || opcion1 == 'P'){
                            break;
                        }
                    }
                }
                
            }
            
            while(dadojugador != 1 || dadojugador1 != 1 && opcion !='p' || opcion1 !='P');
            
                if(puntajejug >= 100){
                    break;
                }else{
                    do{
                        dadocomp = rand.nextInt(6)+1; 
                        dadocomp1 = rand.nextInt(6)+1;
                        System.out.println("### Turno computadora ###");
                        System.out.println("La computadora obtuvo: " + dadocomp + " y " + dadocomp1);
                        totaldadosc=dadocomp+dadocomp1;
                        System.out.println("Total tiro computadora: " + totaldadosc);
                        if(dadocomp == 1 || dadocomp1 == 1){
                            System.out.println("La computadora perdio el turno");
                            totaldadosc = 0;
                            puntajetotalcomp += totaldadosc; 
                            System.out.println("El total de la computadora es: " + puntajetotalcomp);
                            break;
                        }else if(dadocomp == 1 && dadocomp1 == 1){
                            puntajetotalcomp=0;
                            System.out.println("Perdio el turno y el acumulado");
                            break;
                        }else{
                            puntajecomp = puntajecomp + totaldadosc;
                            puntajetotalcomp = puntajetotalcomp + totaldadosc;
                            System.out.println("Total puntaje computadora: " + puntajetotalcomp);
                            if(puntajetotalcomp >= 100){
                                break;
                            }else{
                                System.out.println("La computadora continua o pasa: ");
                                numa = rand.nextInt(2)+1;
                                if(numa == 1){
                                    System.out.println("Continua");
                                }else{
                                    System.out.println("Pasa");
                                    break;
                                }
                            }
                        }
                    }while(dadocomp !=1 || dadocomp1 !=1);
                }
            
        }while (puntajetotalj >= 100){
            System.out.println(nombre + " ganaste!");
            break;
            
        }while (puntajetotalcomp >= 100){
            System.out.println("La computadora gano!");
            break;
        }
        
        
    }    
    
    
    
}
