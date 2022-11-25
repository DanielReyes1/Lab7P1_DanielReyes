
package lab7p1_danielreyes;

import java.util.Scanner;
import java.util.Random;
        
public class Lab7P1_DanielReyes {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    
    public static void main(String[] args) {
           int opcion = menu();
           while (opcion != 4){
               switch(opcion){
                   case 1:{
                       System.out.println("Ha elegido la primera opcion");
                       System.out.print("Ingrese M: ");
                       int filas = leer.nextInt();
                       System.out.print("Ingrese N: ");
                       int columnas = leer.nextInt();
                       int [][] primero = lectura(filas, columnas);
                       System.out.println("La matriz generada es: ");
                       System.out.println(imprimir(primero));
                       int [][] segundo = mrotada(primero);
                       System.out.println("La matriz rotada es: ");
                       System.out.println(imprimir(segundo));
                   }
                       break;
                   case 2:{
                       System.out.println("Ha elegido la segunda opcion");
                       System.out.print("Ingrese M: ");
                       int filas = leer.nextInt();
                       System.out.print("Ingrese N: ");
                       int columnas = leer.nextInt();
                       int [][] primero = lectura(filas, columnas);
                       System.out.println("La matriz generada es: ");
                       System.out.println(imprimir(primero));
                       System.out.println("Op.1: "+ sumaex(primero));
                       System.out.println("Op.2: "+ multiint(primero));
                       System.out.println("El numero generado es: "+ sumafinal(sumaex(primero),multiint(primero)));
                       
                   }
                        break;
                   case 3:
                        System.out.println("Ha elegido la tercera opcion");
                        System.out.print("Cadena 1: ");
                        String cadena1 = leer.next().toLowerCase();
                        System.out.print("Cadena 2: ");
                        String cadena2 = leer.next().toLowerCase();
                        System.out.println(agregar(cadena1));
                        System.out.println(agregar(cadena2));
                        System.out.println(imprimir(resultado(agregar(cadena1),agregar(cadena2))));
                        System.out.println("El size de la subsecuencia más grande es igual a : "+ num(resultado(agregar(cadena1),agregar(cadena2))));
                        
                       break;
               }
               opcion = menu();
           }
           System.out.println("Ha elegido la opcion 4, nos vemos");
        
    }// main
    public static int menu(){
        System.out.println("------Menu------");
        System.out.println("1- Portrait");
        System.out.println("2- Nuúmero mágico");
        System.out.println("3- Subsecuencia");
        System.out.println("4- Salir del sistema");
        System.out.print("Ingrese una opcion: ");
        int temporal = leer.nextInt();
        return temporal;
    }
    
    public static int [][] lectura (int numf, int numc){
        int [][] temporal = new int [numf] [numc];
        for (int i = 0; i < numf; i++){
            for (int j = 0; j < numc; j++){
                temporal[i][j] = 1 + aleatorio.nextInt(9);
            }
        }
        return temporal;
    }
    public static String imprimir(int [][] numeros){
        String temporal = "";
        for(int i = 0; i < numeros.length; i++){
            for (int j = 0; j < numeros[i].length; j++){
                temporal += numeros[i][j] + " ";
            }
            temporal += "\n";
        }
        
        return temporal;
    }
    public static int [][] mrotada(int [][] matriz){
        int [][] temporal = new int [matriz[0].length][matriz.length];
        int contc = 0;
            for(int i = 0; i < matriz[0].length; i++){
                int contf = matriz.length - 1;
                for (int j = 0; j < matriz.length; j++){
                   temporal[i][j] = matriz[contf][contc]; 
                   contf--;
                }
                contc++;
            }
        return temporal;
    }
    public static int sumaex(int [][] matriz){
        int temporal = 0;
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (i == 0 || i == matriz.length - 1 || j == 0 || j == matriz[i].length - 1){
                    temporal += matriz[i][j];
                }
            }
        }
        return temporal;
    }
    public static int multiint(int [][] matriz){
        int temporal = 1;
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (i != 0 && i != matriz.length - 1 && j != 0 && j != matriz[i].length - 1){
                    temporal = temporal * matriz[i][j];
                }
            }
        }
        return temporal;
    }
    public static int sumafinal(int op1, int op2){
        int temporal = op1 + op2;
        return temporal;
    }
    public static String agregar(String cadena){
        String temporal = "-";
        for (int i = 0; i < cadena.length(); i++){
            char a = cadena.charAt(i);
            temporal += a;
        }
        return temporal;
    }
    public static int [][]resultado(String cad1, String cad2){
        int [][] temporal = new int [cad1.length()][cad2.length()];
        int cont = 0;
        for (int i = 0; i < cad1.length(); i++){
            char a = cad1.charAt(i);
            for(int j = 0; j < cad2.length(); j++){
                char b = cad2.charAt(j);
                if(a == '-' || b == '-'){
                    temporal[i][j] = 0;
                }
                else if (a == b){
                    cont++;
                    temporal [i][j] = temporal[i-1][j-1] + 1;
                }
                else{
                    temporal [i][j] = Math.max(temporal[i][j-1],temporal[i-1][j]);
                    
                }
                
            }
        }
        return temporal;
    }
    public static int num(int [][] matriz){
        int temporal = 0;
        temporal = matriz[matriz.length-1][matriz[0].length-1];
        return temporal;
    }
}// public class
