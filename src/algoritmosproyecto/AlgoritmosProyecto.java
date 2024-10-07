/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosproyecto;


import java.util.Scanner;


/**
 *
 * @author mpelv
 */
public class AlgoritmosProyecto {
    
    
 static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    int seccion = 0;
    //Menú principal 
    do {
    System.out.print("---SISTEMA DE GESTION DE INVENTARIOS---");
    System.out.println(" ");
    System.out.println("1. Seccion de Categorias");
    System.out.println("2. Seccion de Caracteristicas");
    System.out.println("3. Seccion de Especificaciones");
    System.out.println("4. ");
    System.out.println("5. ");
    System.out.println("Escriba el numero correspondiente segun la sección a la cual desea ingresar:");
    seccion = scan.nextInt();
    
     //Switch encargado de direccionar al programa según el número ingresado anteriormente 
     switch (seccion) {
        case 1:
            //ingresar a la seccion de categorías mediante un método
            seccionCategorias();
            break;
        case 2:
            seccionCaracteristicas();
            break;
        case 3:
            seccionEspecificaciones();
            break;
         default:
            System.out.print("El numero no representa niguna seccion dentro del programa");
            break;
       }
    }
     while (seccion != 0);
    }
     
     //1.1 Definición de Categorías:
      //Opcion 1 dentro del switch principal 
    static void seccionCategorias() {
        System.out.println("  ---Seccion de Categorias de Productos---  "); 
        
     
       }

    
     //1.2 Definición de Características:
      //Opcion 2 dentro del switch principal
    static void seccionCaracteristicas() {
        System.out.println(" ---Seccion de Caracteristicas de Productos--- ");
    }

     //1.3 Definición de Especificaciones:
      //Opcion 3 dentro del switch principal
    static void seccionEspecificaciones() {
        System.out.println(" ---Seccion de Caracteristicas de Productos--- ");
    }
}
