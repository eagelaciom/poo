/*
 * Universidad Nacional de Colombia (Bogotá )
 * Departamento de Ingeniería de Sistemas y Computación
 * 
 *
 * Laboratorio 1
 * Ejercicio: Magazine
 * Autores coolaboradores: Edwin Gelacio eagelaciom@unal.edu.co - Daniel Chaparro daachaparroga@unal.edu.co
*/

import java.util.Scanner;


public class Magazine {
    
    public static void main(String[] args) {
        
        System.out.println("Daily Life Magazine");
        data();
        
    }
    
    public static void data(){
        int edad;
        String genero,opcion = "y";
        double ingresos;
        int[] grupoedad = new int[5];
        int[] grupogenerom = new int [5];
        int[] grupogenerof = new int [5];
        int[] grupoingresos = new int[4];
        int opc;
        String opci = "y";
        Scanner op = new Scanner(System.in);
        boolean ing = true;
        
        
        while(true){
            if(opci.charAt(0) != 'y'){
                System.out.println("Hasta luego");
                break;
            }else{
                System.out.println("Selecciona la opcion a ejecutar: ");
                System.out.println("1. Ingresar datos ");
                System.out.println("2. Mostrar estadistica de lectores por grupos de edad");
                System.out.println("3. Mostrar estadistica de lectores por genero y edad");
                System.out.println("4. Mostrar estadistica de lectores por ingresos anuales");
                System.out.println("5. Salir");
                System.out.print("Digita a continuacion la opcion: ");
                Scanner o = new Scanner(System.in);
                opc = o.nextInt();
                switch(opc){
                    case 1:
                        
                        while(ing){
                            if(opcion.charAt(0) != 'y'){
                                break;
                            }else{

                                System.out.println("Ingrese la edad: ");
                                Scanner e = new Scanner(System.in);
                                edad = e.nextInt();
                                if(edad<20){
                                    grupoedad[0]=grupoedad[0]+1;
                                }else if(edad>=20 && edad <=29){
                                    grupoedad[1]=grupoedad[1]+1;
                                }else if(edad>=30 && edad <=39){
                                    grupoedad[2]=grupoedad[2]+1;
                                }else if(edad>=40 && edad <=49){
                                    grupoedad[3]=grupoedad[3]+1;   
                                }else if(edad>=50){
                                    grupoedad[4]=grupoedad[4]+1;
                                }
                                System.out.println("Ingrese el genero (m) para masculino o (f) para femenino ");
                                Scanner g = new Scanner(System.in);
                                genero = g.nextLine();
                                if(edad<20 && genero.charAt(0) == 'm'){
                                    grupogenerom[0]=grupogenerom[0]+1;
                                }else if(edad<20 && genero.charAt(0) == 'f'){
                                    grupogenerof[0]=grupogenerof[0]+1;
                                }else if(edad>=20 && edad <=29 && genero.charAt(0) == 'm'){
                                    grupogenerom[1]=grupogenerom[1]+1;
                                }else if(edad>=20 && edad <=29 && genero.charAt(0) == 'f'){
                                    grupogenerof[1]=grupogenerof[1]+1;
                                }else if(edad>=30 && edad <=39 && genero.charAt(0) == 'm'){
                                    grupogenerom[2]=grupogenerom[2]+1;
                                }else if(edad>=30 && edad <=39 && genero.charAt(0) == 'f'){
                                    grupogenerof[2]=grupogenerof[2]+1;
                                }else if(edad>=40 && edad <=49 && genero.charAt(0) == 'm'){
                                    grupogenerom[3]=grupogenerom[3]+1;
                                }else if(edad>=40 && edad <=49 && genero.charAt(0) == 'f'){
                                    grupogenerof[3]=grupogenerof[3]+1;
                                }else if(edad>=50 && genero.charAt(0) == 'm'){
                                    grupogenerom[4]=grupogenerom[4]+1;
                                }else if(edad>=50 && genero.charAt(0) == 'f'){
                                    grupogenerof[4]=grupogenerof[4]+1;
                                }

                                System.out.println("Ingrese el ingreso anual: ");
                                Scanner i = new Scanner(System.in);
                                ingresos = i.nextInt();
                                if(ingresos<30000){
                                    grupoingresos[0]=grupoingresos[0]+1;
                                }else if(ingresos>=30000 && ingresos <=49999){
                                    grupoingresos[1]=grupoingresos[1]+1;
                                }else if(ingresos>=50000 && ingresos <=69999){
                                    grupoingresos[2]=grupoingresos[2]+1;
                                }else if(ingresos>=70000){
                                    grupoingresos[3]=grupoingresos[3]+1;
                                }  

                                System.out.println("Deseas ingresas otra entrada (y/n): ");
                                Scanner y = new Scanner(System.in);
                                opcion = y.nextLine();

                            }
                        }
                        System.out.println("Volver al menu (y/n): ");
                        opci = op.nextLine();
                        break;
                    
                    case(2):
                        System.out.println("Analisis de informacion por grupos de edad");
                        System.out.println("Numero de lectores menores de 20 años: " + grupoedad[0]);
                        System.out.println("Numero de lectores entre 20 y 29 años: " + grupoedad[1]);
                        System.out.println("Numero de lectores entre 30 y 39 años: " + grupoedad[2]);
                        System.out.println("Numero de lectores entre 40 y 49 años: " + grupoedad[3]);
                        System.out.println("Numero de lectores mayores de 50 años: " + grupoedad[4]);
                        System.out.println("Volver al menu (y/n): ");
                        opci = op.nextLine();
                        break;
                    
                    case(3):
                        System.out.println("Analisis de informacion por genero y edad");
                        System.out.println("Numero de lectores menores de 20 años masculinos: " + grupogenerom[0]);
                        System.out.println("Numero de lectores menores de 20 años femeninos: " + grupogenerof[0]);
                        System.out.println("Numero de lectores entre 20 y 29 años masculinos: " + grupogenerom[1]);
                        System.out.println("Numero de lectores entre 20 y 29 años femeninos: " + grupogenerof[1]);
                        System.out.println("Numero de lectores entre 30 y 39 años masculinos: " + grupogenerom[2]);
                        System.out.println("Numero de lectores entre 30 y 39 años femeninos: " + grupogenerof[2]);
                        System.out.println("Numero de lectores entre 40 y 49 años masculinos: " + grupogenerom[3]);
                        System.out.println("Numero de lectores entre 40 y 49 años femeninos: " + grupogenerof[3]);
                        System.out.println("Numero de lectores mayores de 50 años masculinos: " + grupogenerom[4]);
                        System.out.println("Numero de lectores mayores de 50 años femeninos: " + grupogenerof[4]);
                        System.out.println("Volver al menu (y/n): ");
                        opci = op.nextLine();
                        break;
                        
                    case(4):
                        System.out.println("Analisis de informacion por ingresos anuales: ");
                        System.out.println("Numero de lectores con ingresos menores a $30000: " + grupoingresos[0]);
                        System.out.println("Numero de lectores con ingresos entre $30000 y $49999: " + grupoingresos[1]);
                        System.out.println("Numero de lectores con ingresos entre $50000 y $69999: " + grupoingresos[2]);
                        System.out.println("Numero de lectores con ingresos mayores a $70000: " + grupoingresos[3]);
                        System.out.println("Volver al menu principal (y/n): ");
                        opci = op.nextLine();
                        break;
                        
                    case(5):
                        opci = "n";
                        break;
                
                }
            }        
        }
    }
        
}
    
    
    

