/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosproyecto;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    String seccion = "";
    //Menú principal 
    do {
    System.out.print("********************************************");    
    System.out.print("---SISTEMA DE GESTION DE INVENTARIOS---");
    System.out.print("********************************************");
    System.out.println(" ");
    System.out.println("Menu principal");
    System.out.println(" ");
    System.out.println("1. GESTION DE PRODUCTOS");
    System.out.println("1.1 Definicion de Categorias");
    System.out.println("1.2 Definicion de Caracteristicas");
    System.out.println("1.3 Definicion de Especificaciones");
    /*System.out.println("1.4.Asignacion de Categorias, Caracteristicas y Especificaciones a Productos  ");
    System.out.println("1.5.Alta de productos  ");
    System.out.println("1.6. Baja de productos  ");
    System.out.println("1.7. Modificacion de productos  ");*/
    System.out.print("Escriba el numero correspondiente segun la seccion a la cual desea ingresar:");
    seccion = scan.nextLine();
    
     //Switch encargado de direccionar al programa según el número ingresado anteriormente 
     switch (seccion) {
        case "1.1":
            //ingresar a la seccion de categorías mediante un método
            seccionCategorias();
            break;
        case "1.2":
            seccionCaracteristicas();
            break;
        case "1.3":
            seccionEspecificaciones();
            break;
         default:
            System.out.println("El numero no representa niguna seccion dentro del programa");
            break;
       }
    }
     while (seccion != "0");
    }
     
     //1.1 Definición de Categorías:
      //Opcion 1 dentro del switch principal 
    static void seccionCategorias() {
        System.out.println(" ");
        System.out.println("  ---Seccion de Definicion de Categorias---  "); 
    int respuesta = 0; 
    String nombreCate = "";
       File f = new File("C:\\algoritmosProyecto\\DefinicionCategorías.txt"); //"C:\\ArchivoTextoSecuencial\\archivo_texto.txt"
       
       do {
       System.out.println(" ");
       System.out.println("Acciones a realizar:");
       System.out.println("1. Ingresar nuevo nombre de categoria:");
       System.out.println("2. Modificar nombre de categoria");
       System.out.println("3. Eliminar nombre de categoria");
       System.out.println("4. Salir de la seccion de categorias ");
       System.out.print("Ingrese un numero segun la accion que desee realizar:");
       respuesta = scan.nextInt();
       scan.nextLine();
       
        switch (respuesta) {
        case 1:
        //Escribir archivo
                try {
                    //"FileWriter" Creacion de una variable (fw) que servira para escribir en el archivo
                    FileWriter fw = new FileWriter(f); //se abre el archivo
                    //"BuffereWriter" almacena los datos temporalmente en la memoria RAM, luego dicho grupo de datos los llevará al disco duro
                    BufferedWriter bw = new BufferedWriter(fw); //optimiza la lectura/escritura del archivo
                    //write escribe una cadena de texto
                    //utilizar la variable "bw" de BuffereWrite                
                    System.out.print("Ingrese el nombre de la categoria: ");
                    //guardar resultado en una variable llamada "nombreCate"
                    nombreCate = scan.nextLine();
                    while (nombreCate.isBlank()) {
                    System.out.println("El nombre no puede estar vacio, ingrese nuevamente el nombre: ");
                    nombreCate = scan.nextLine();
                    }
                    
                    bw.write(nombreCate + "\n"); //escribiendo dentro del archivo
                    //cerrar el archivo
                    bw.close();
                    // prevee errores al escribir el texto y al abrir el archivo nuevamente         
                    //captura el error al intentar ingresar un texto en "try"
                } catch (IOException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
         //agregar registro
                try {
                    /*ir hasta el final del archivo, ya que hasta el final del archivo almacenara los nuevos datos
                    (por lo tanto, el true se eccarga de almacenar los dartos anteriormente guardados y al
                    al ingresar nuevos datos, los almacenara dentro de los otros datos existentes)*/
                    FileWriter fw = new FileWriter(f, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(nombreCate);
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                } 
                System.out.println("La categoría" + nombreCate + "ha sido ingresada al archivo de texto Secuencial");
        //Termina el caso cuando se logre almacenar de manera correcta el dato en el archivo de tecto de acceso secuencial     
        break;
        case 2:
         
             
        System.out.print("Ingrese el nombre de la categorIa a modificar: ");
        String modiCate = scan.nextLine();
        System.out.println("La categoría, " + modiCate + " ha sido modificada sin novedades");
        break;
        
        
        
        }  
       
       } while (respuesta != 0);
       
    }
    
     //1.2 Definición de Características:
      //Opcion 2 dentro del switch principal
    static void seccionCaracteristicas() {
        System.out.println(" ---Seccion de Definicion de Caracteristicas--- ");
    }

     //1.3 Definición de Especificaciones:
      //Opcion 3 dentro del switch principal
    static void seccionEspecificaciones() {
        System.out.println(" ---Seccion de Definicion de Especificaciones--- ");
    }
}
