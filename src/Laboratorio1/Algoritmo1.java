/*
 * Universidad Nacional de Colombia (Bogotá )
 * Departamento de Ingeniería de Sistemas y Computación
 * 
 *
 * Laboratorio 1
 * Ejercicio: Algoritmo1
 * Autores coolaboradores: Edwin Gelacio eagelaciom@unal.edu.co - Daniel Chaparro daachaparroga@unal.edu.co
*/
class Algoritmo1 {
    void func1(){
            System.out.println("Segunda funcion");
    }
    
    void func2(){
            System.out.println("Tercera funcion");
    }
}

class Testalgoritmo1{
    public static void main(String[] args) {
        System.out.println("Primera funcion en Main");
        Algoritmo1 p = new Algoritmo1();
        p.func1();
        p.func2();
        System.out.println("Se termina Main");
    }
}

