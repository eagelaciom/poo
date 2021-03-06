/*
 * Universidad Nacional de Colombia (Bogotá )
 * Departamento de Ingeniería de Sistemas y Computación
 * 
 *
 * Laboratorio 1
 * Ejercicio: GuessingGame
 * Autores coolaboradores: Edwin Gelacio eagelaciom@unal.edu.co - Daniel Chaparro daachaparroga@unal.edu.co
*/
import java.util.Scanner;

class TestGuessingGame{   
    
    public static void main(String[] args) {
        
        System.out.println("Adivina el numero");
        System.out.println("Solo tienes 7 intentos");
        
        
        String playAgain = "y";
                
        while(true){
            if(playAgain.charAt(0) != 'y' ){        
                System.out.println("Gracias por jugar");
                break;
            }else{
                GuessingGame();
                System.out.println("Quieres jugar de nuevo (y/n): ");
                Scanner l = new Scanner(System.in);
                playAgain = l.nextLine();
            }
        } 
        
    }
    public static void GuessingGame(){
        int answer = (int)Math.floor((Math.random()*100)+1);
        int guess = 0;
        int numGuesses = 1;
        System.out.println("Adivina un numero entre 0 y 100: ");
        
        while(true){
            if(numGuesses>7 || guess==answer){
                if(numGuesses>7){
                    System.out.println("Tu perdiste");
                    break;
                }else{
                    break;
                }
            }else{
                
                Scanner i = new Scanner(System.in);
                guess = i.nextInt();
                if(guess<answer){
                    System.out.println("Mayor");
                    numGuesses = numGuesses+1;
                }else{
                    if(guess>answer){
                        System.out.println("Menor");
                        numGuesses = numGuesses+1;
                    }else{
                        System.out.println("Tu ganaste");
                        numGuesses = numGuesses+1;
                    }
                }
            }
                
        }
    } 
    
}

    


