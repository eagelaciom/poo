/*
 * Universidad Nacional de Colombia (Bogotá )
 * Departamento de Ingeniería de Sistemas y Computación
 * 
 *
 * Laboratorio 1
 * Ejercicio: Cine
 * Autores coolaboradores: Edwin Gelacio eagelaciom@unal.edu.co - Daniel Chaparro daachaparroga@unal.edu.co
*/
package Laboratorio1;

import java.util.Scanner;

/**
 *
 * @author Edwin Gelacio
 */
public class Cine {
    public static boolean salir=false;
    public static int ventaTarjeta(int[][] tarjetas ,int totalTarjetas)
    {
        System.out.println("Valor a pagar 70.000");
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner entrada= new Scanner(System.in);
        int cedula=entrada.nextInt();
        tarjetas[totalTarjetas][0]=cedula;
        tarjetas[totalTarjetas][1]=70000;
        totalTarjetas++;
        return totalTarjetas;
    }
    public static int  buscarTarjeta(int[][] tarjetas ,int totalTarjetas ,int cedula)
    {
        int idx=-1;
        for(int i=0;i<totalTarjetas;i++)
        {
            if(tarjetas[i][0]==cedula)
            {
                idx=i;
                break;
            }   
        }
        return idx;
    }
    public static void recargaTarjeta(int[][] tarjetas,int totalTarjetas)
    {
        System.out.println("Valor a recargar 50.000");
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner entrada= new Scanner(System.in);
        int cedula=entrada.nextInt();
        int idx=buscarTarjeta(tarjetas,totalTarjetas,cedula);
        tarjetas[idx][1]+=50000;
    }
    public static void descontarTarjeta(int codigo,int[][] tarjetas,int totalTarjetas,int valor)
    {
        for(int i=0;i<totalTarjetas;i++)
        {
            if(tarjetas[i][0]==codigo)
            {
                tarjetas[i][1]-=valor;
                break;
            }
        }
    }

    public static int crearReserva(int[][] sillas, int[][] reservas,int totalReservas)
    {
        String fila;
        int columna;
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner entrada= new Scanner(System.in);
        int cedula=entrada.nextInt();
        System.out.println("Ingrese el numero de sillas");
        entrada= new Scanner(System.in);
        int nSillas=entrada.nextInt();
        int valorTotal=0;
        for(int i=0;i<nSillas;i++)
        {
            System.out.println("Ingrese la fila a reservar");
            entrada= new Scanner(System.in);
            fila=entrada.next();
            System.out.println("Ingrese la columna");
            entrada= new Scanner(System.in);
            columna=entrada.nextInt();
            columna--;
            int valor=8000;
            int filaEntero=0;
            switch (fila)
            {
                case "A":
                    filaEntero=0;
                    break;
                case "B":
                    filaEntero=1;
                    break;
                case "C":
                    filaEntero=2;
                    break;
                case "D":
                    filaEntero=3;
                    break;
                case "E":
                    filaEntero=4;
                    break;
                case "F":
                    filaEntero=5;
                    break;
                case "G":
                    filaEntero=6;
                    break;
                case "H":
                    filaEntero=7;
                    break;
                case "I":
                    filaEntero=8;
                    valor=11000;
                    break;
                case "J":
                    filaEntero=9;
                    valor=11000;
                    break;
                case "K":
                    filaEntero=10;
                    valor=11000;
                    break;
            }
            if(sillas[filaEntero][columna]==0)
            {
                sillas[filaEntero][columna]=cedula;
                valorTotal+=valor;
            }
            else
            {
                System.out.println("silla ocupada");
                i--;
            }
        }
        reservas[totalReservas][0]=cedula;
        reservas[totalReservas][1]=nSillas;
        reservas[totalReservas][2]=valorTotal;
        System.out.println("Codigo de reserva: "+totalReservas);
        totalReservas++;
        return totalReservas;
    }
    public static int pagarReserva(int[][] reservas,int totalReservas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {
        System.out.println("pagar por:");
        System.out.println("1. Codigo Reserva");
        System.out.println("2. numero de tarjeta");
        Scanner entrada= new Scanner(System.in);
        int opcion=entrada.nextInt();
        if(opcion==1)
        {
            System.out.println("Ingrese codigo de reserva");
            entrada= new Scanner(System.in);
            int codigo=entrada.nextInt();
            return pagarReservaCodigo(reservas,totalReservas,ventas,totalVentas,codigo,tarjetas,totalTarjetas);
        }
        else if(opcion==2)
        {
            System.out.println("Ingrese numero de tarjeta");
            entrada= new Scanner(System.in);
            int numero=entrada.nextInt();
            return pagarReservaNumero(reservas,totalReservas,ventas,totalVentas,numero,tarjetas,totalTarjetas);
        }
        return totalVentas;
    }
    public static int pagarReservaCodigo(int[][] reservas,int totalReservas,int[][] ventas,int totalVentas, int codigo,int[][] tarjetas,int totalTarjetas)
    {
        System.out.println("Detalles del pago:");
        System.out.println("Cliente: "+reservas[codigo][0]);
        System.out.println("Numero Sillas: "+reservas[codigo][1]);
        System.out.println("Valor a pagar: "+(reservas[codigo][2]*0.9));
        System.out.println("Ingrese: ");
        System.out.println("1. Pagar en efectivo");
        System.out.println("2. Pagar con tarjeta");

        Scanner entrada= new Scanner(System.in);
        int opcion=entrada.nextInt();
        if(opcion==1)
        {
            ventas[totalVentas][0]=reservas[codigo][0];
            ventas[totalVentas][1]=(int) (reservas[codigo][2]*0.9);
            totalVentas++;
        }
        else
        {
            ventas[totalVentas][0]=reservas[codigo][0];
            ventas[totalVentas][1]=(int) (reservas[codigo][2]*0.9);
            descontarTarjeta(reservas[codigo][0],tarjetas,totalTarjetas,ventas[totalVentas][1]);
            totalVentas++;
        }
        return totalVentas;
    }
    public static int pagarReservaNumero(int[][] reservas,int totalReservas,int[][] ventas,int totalVentas, int numero,int[][] tarjetas,int totalTarjetas)
    {      
        int codigo=0;
        for(int i=0;i<totalReservas;i++)
        {
            if(reservas[i][0]==numero)
            {
                codigo=i;
                break;
            }
        }
        return pagarReservaCodigo(reservas,totalReservas,ventas,totalVentas,codigo,tarjetas, totalTarjetas);
    }
    public static void cancelarReserva(int[][] reservas,int totalReservas,int[][] sillas)
    {
        System.out.println("cancelar por:");
        System.out.println("1. Codigo Reserva");
        System.out.println("2. numero de tarjeta");
        Scanner entrada= new Scanner(System.in);
        int opcion=entrada.nextInt();
        if(opcion==1)
        {
            System.out.println("Ingrese codigo de reserva");
            entrada= new Scanner(System.in);
            int codigo=entrada.nextInt();
            cancelarReservaCodigo(reservas,sillas,codigo);
        }
        else if(opcion==2)
        {
            System.out.println("Ingrese numero de tarjeta");
            entrada= new Scanner(System.in);
            int numero=entrada.nextInt();
            cancelarReservaNumero(reservas,totalReservas,sillas,numero);
        }    
    }
    public static void cancelarReservaCodigo(int[][] reservas,int[][] sillas, int codigo)
    {   
        int sillasLiberadas=0;
        for(int i=0;i<12;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(sillas[i][j]==reservas[codigo][0])
                {
                    sillas[i][j]=0;
                    sillasLiberadas++;
                }
                if(sillasLiberadas==reservas[codigo][1])
                {
                    break;
                }
            }
            if(sillasLiberadas==reservas[codigo][1])
            {
                break;
            }
        }
        reservas[codigo][0]=0;
        reservas[codigo][1]=0;
        reservas[codigo][2]=0;
    }
    public static void cancelarReservaNumero(int[][] reservas,int totalReservas,int[][] sillas,int numero)
    {      
        int codigo=0;
        for(int i=0;i<totalReservas;i++)
        {
            if(reservas[i][0]==numero)
            {
                codigo=i;
                break;
            }
        }
        cancelarReservaCodigo(reservas,sillas,codigo);
    }
    public static int ventaBoleraSinReserva(int[][] sillas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {
        int [] venta= new int[3];
        int [][] sillasUtilizadas;
        int columna;
        String fila;
        System.out.println("Ingrese numero de cedula del cliente");
        Scanner entrada= new Scanner(System.in);
        venta[0]=entrada.nextInt();
        System.out.println("Ingrese el numero de sillas");
        entrada= new Scanner(System.in);
        venta[1]=entrada.nextInt();
        sillasUtilizadas= new int[venta[1]][2];
        int valorTotal=0;
        for(int i=0;i<venta[1];i++)
        {
            System.out.println("Ingrese la fila a reservar");
            entrada= new Scanner(System.in);
            fila=entrada.next();
            System.out.println("Ingrese la columna");
            entrada= new Scanner(System.in);
            columna=entrada.nextInt();
            columna--;
            int valor=8000;
            int filaEntero=0;
            switch (fila)
            {
                case "A":
                    filaEntero=0;
                    break;
                case "B":
                    filaEntero=1;
                    break;
                case "C":
                    filaEntero=2;
                    break;
                case "D":
                    filaEntero=3;
                    break;
                case "E":
                    filaEntero=4;
                    break;
                case "F":
                    filaEntero=5;
                    break;
                case "G":
                    filaEntero=6;
                    break;
                case "H":
                    filaEntero=7;
                    break;
                case "I":
                    filaEntero=8;
                    valor=11000;
                    break;
                case "J":
                    filaEntero=9;
                    valor=11000;
                    break;
                case "K":
                    filaEntero=10;
                    valor=11000;
                    break;
            }
            if(sillas[filaEntero][columna]==0)
            {
                sillasUtilizadas[i][0]=filaEntero;
                sillasUtilizadas[i][1]=columna; 
                valorTotal+=valor;
            }
            else
            {
                System.out.println("silla ocupada");
                i--;
            }
        }
        venta[2]=valorTotal;
        System.out.println("Valor Total: "+venta[2]);
        System.out.println("tipo de pago:");
        System.out.println("1. Efectivo.");
        System.out.println("2. Tarjeta.");
        entrada= new Scanner(System.in);
        int opcion=entrada.nextInt();
        if(opcion==1)
        {
            return ventaBoleraSinReservaEfectivo(venta,sillasUtilizadas,sillas,ventas,totalVentas,tarjetas,totalTarjetas);
        }
        else if(opcion==2)
        {
            return ventaBoleraSinReservaTarjeta(venta,sillasUtilizadas,sillas,ventas,totalVentas,tarjetas,totalTarjetas);
        }
        
        return totalVentas;
    }

    public static int ventaBoleraSinReservaEfectivo(int[] venta,int[][] sillasUtilizadas,int[][] sillas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {
        for(int i=0;i<venta[1];i++)
        {
            sillas[sillasUtilizadas[i][0]][sillasUtilizadas[i][1]]=venta[0];
        }
        int tarjeta=buscarTarjeta(tarjetas ,totalTarjetas , venta[0]);
        if(tarjeta>-1)
        {
            venta[2]=(int) (venta[2]*0.9);
        }  
        ventas[totalVentas][0]=venta[0];
        ventas[totalVentas][1]=venta[2];
        totalVentas++;
        return totalVentas;
    }
    public static int ventaBoleraSinReservaTarjeta(int[] venta,int[][] sillasUtilizadas,int[][] sillas,int[][] ventas,int totalVentas,int[][] tarjetas,int totalTarjetas)
    {      
        for(int i=0;i<venta[1];i++)
        {
            sillas[sillasUtilizadas[i][0]][sillasUtilizadas[i][1]]=venta[0];
        }
        int tarjeta=buscarTarjeta(tarjetas ,totalTarjetas , venta[0]);
        if(tarjeta>-1)
        {
            venta[2]=(int) (venta[2]*0.9);
            descontarTarjeta(tarjeta,tarjetas,totalTarjetas,venta[1]);
            ventas[totalVentas][0]=venta[0];
            ventas[totalVentas][1]=venta[2];
            totalVentas++;
        }
        return totalVentas;
    }
    public static void totalDineroBoletas(int[][] ventas,int totalVentas)
    {
        int Total=0;
        for (int i = 0; i < totalVentas; i++) {
            Total+=ventas[i][1];
        }
        System.out.println("Total de ventas: "+Total);
    }
    public static void menu()
    {
        System.out.println("Menu.....");
        System.out.println("Digite el numero:");
        System.out.println("1. venta de tarjeta. Valor 70.000");
        System.out.println("2. recarga de tarjeta. Valor 50.000");
        System.out.println("3. crear reserva.");
        System.out.println("4. pagar reserva.");
        System.out.println("5. cancelar reserva");
        System.out.println("6. venta de boleta sin reserva");
        System.out.println("7. total de dinero reacudado de boletas");
        System.out.println("8. salir");
    }
    public static void error()
    {
        System.out.println("Opcion no valida.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // tarjetas: 0 => numero tarjeta, 1=> saldo
        int[][] tarjetas = new int[100][2];
        // totalTarjetas: total de tarjetas vendidas
        int totalTarjetas=0;
        // sillas, sillas ocupadas: 1er posicion => fila, 2da posicion => columna
        int[][] sillas = new int[11][20];
        // reservas, sillas reservadas: 0 => cliente, 1=> numero sillas, 2=> valor
        int[][] reservas = new int[100][3];
        // totalReservas: total de reservas
        int totalReservas=0;
        // ventas, boletas vendidas: 0 => cliente, 1=> valor
        int[][] ventas = new int[100][2];
        // totalVentas: total de ventas
        int totalVentas=0;
        
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<20;j++)
            {
               sillas[i][j]=0;
            }
        }
        
        while(!salir)
        {
            menu();
            Scanner entrada= new Scanner(System.in);
            int opcion=entrada.nextInt();
            
            switch (opcion)
            {
                case 1:
                    totalTarjetas=ventaTarjeta(tarjetas,totalTarjetas);
                    break;
                case 2:
                    recargaTarjeta(tarjetas,totalTarjetas);
                    break;
                case 3:
                    totalReservas=crearReserva(sillas,reservas,totalReservas);
                    break;
                case 4:
                    totalVentas=pagarReserva(reservas,totalReservas,ventas,totalVentas,tarjetas,totalTarjetas);
                    break;
                case 5:
                    cancelarReserva(reservas,totalReservas,sillas);
                    break;
                case 6:
                    totalVentas=ventaBoleraSinReserva(sillas,ventas,totalVentas,tarjetas,totalTarjetas);
                    break;
                case 7:
                    totalDineroBoletas(ventas,totalVentas);
                    break;
                case 8:
                    salir=true;
                    break;
                default:
                    error();
                    break;
            }
        }
    }
    
}
