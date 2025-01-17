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
import java.io.*;
import java.nio.file.*;


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
    System.out.println("");    
    System.out.print("********************************************");    
    System.out.print("---SISTEMA DE GESTION DE INVENTARIOS---");
    System.out.print("********************************************");
    System.out.println(" ");
    System.out.println("Menu principal");
    System.out.println(" ");
    System.out.println("-- GESTION DE PRODUCTOS --");
    System.out.println("1.1 Seccion de Categorias de Productos");
    System.out.println("1.2 Seccion de Caracteristicas de Productos");
    System.out.println("1.3 Seccion de Especificaciones de Productos");
    System.out.println("1.4 Asignacion de Categorias, Caracteristicas y Especificaciones a Productos  ");
    System.out.println("1.5 Alta de productos ");
    /*System.out.println("1.6 Baja de productos  ");
    System.out.println("1.7 Modificacion de productos  ");*/
    System.out.print("Escriba el numero de la seccion a la cual desea ingresar: ");
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
        case "1.4": 
            asignacionAProductos();
            break;
        case "1.5": 
            altaDeProductos();
            break;  
         case "1.6": 
            bajaDeProductos();
            break;
         case "1.7": 
            bajaDeProductos();
            break;   
         default:
            System.out.println("El numero no representa niguna seccion dentro del programa");
            System.out.print("Intente nuevamente intente escribir el numero de la seccion a la cual desea ingresar: ");
            
            break;
       }
    }
     while (seccion != "0");
    }
     
     //1.1 Definición de Categorías:
      //Opcion 1 dentro del switch principal 
    static void seccionCategorias() {
        
    int respuesta = 0; 
    String confirmacionFinal = "";         
    
    String nombreCate = "";
       File f = new File("C:\\algoritmosProyecto\\DefinicionCategorías.txt"); //Creacion de una nueva representacion de un archivo    
      do { 
       System.out.println("                                                ");
       System.out.println("         ---SECCION DE CATEGORIAS DE PRODUCTO---  ");    
       System.out.println("                                                ");
                System.out.println("            LISTA DE CATEGORIAS EXISTENTES:    ");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivouno = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivouno))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
       
       System.out.println("Acciones a realizar:");
       System.out.println("1. Ingresar el nombre de una nueva categoria:");
       System.out.println("2. Modificar el nombre de alguna categoria ya existente");
       System.out.println("3. Eliminar alguna categoria ya existente ");
       System.out.println("4. Salir de la seccion de Definicion de Categorias ");
       System.out.print("Ingrese un numero segun la accion que desee realizar: ");
       respuesta = scan.nextInt();
       scan.nextLine();
       
        switch (respuesta) {
        case 1: //agregar Categoria
           
            
                try {
                    /*ir hasta el final del archivo, ya que hasta el final del archivo almacenara los nuevos datos
                    (por lo tanto, el true se encarga de almacenar los datos anteriormente guardados y al
                    al ingresar nuevos datos, los almacenara dentro de los otros datos existentes)*/
                    
                    FileWriter fw = new FileWriter(f, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                // Por medio de un mensaje, se le pide al usuario ingresar el nombre de la nueva categoria 
                    System.out.print("Ingrese el nombre de la nueva categoria: ");
                    //guardar resultado en una variable llamada "nombreCate"
                    nombreCate = scan.nextLine();
                    while (nombreCate.isBlank()) {
                    System.out.println("El nombre no puede quedar vacio, intente nuevamente escribir el nombre: ");
                    nombreCate = scan.nextLine();
                    }
                    
                    bw.write(nombreCate + "\n");
                    bw.close();
                } catch (IOException ex) {
                     Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }               
                System.out.println("La categoria, " + nombreCate + " ha sido ingresada al archivo de texto");
                System.out.println("El programa nuevamente lo llevara al apartado principal de Categorias de Productos  ");
                    break;
   


//Termina el caso cuando se logre almacenar de manera correcta el dato en el archivo de tecto de acceso secuencial     

        case 2: //modificar Categorias
               /* System.out.println("");
                System.out.println("           LISTA DE CATEGORIAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivo = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");*/
            
                try {
                    System.out.println(" ");
                    System.out.print("Ingrese el nombre de la categoria que desee modificar: ");
                    String modiCate = scan.nextLine();
                    while (modiCate.isBlank()) {
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nombre de la categoria que desee modificar: ");
                     modiCate = scan.nextLine();
                    }
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scan.nextLine();
                    while (nuevoNombre.isBlank()) {
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nuevo nombre de la categoria: ");
                    nuevoNombre = scan.nextLine();
             }
           
            
                 // objeto File que representa el archivo de copia.
                 
                 File fc = new File("C:\\algoritmosProyecto\\DefinicionCategoríasCopia.txt");
            
                  //abrir el archivo original para lectura
                   //por medio de BufferedReader y FileReader se abre el archivo original para lectura
                 try (BufferedReader br = new BufferedReader(new FileReader(f));
                  //por medio de BufferedWriter y FileWriter se abre el archivo de copia para escritura         
                 BufferedWriter bw = new BufferedWriter(new FileWriter(fc))) {
                
                  String linea; //Se declara una variable llamada linea que almacenará cada línea leída del archivo.
                while ((linea = br.readLine()) != null) { //verifica los datos hasta que los datos sean nulos o inexistentes  
                    String [] datos = linea.split("\\|");
                    //Compara la primera parte de la línea con modiCate. Si son iguales, modificara la línea.
                    if (datos[0].trim().equalsIgnoreCase(modiCate.trim()))  {
                        datos[0] = nuevoNombre;
                        linea = String.join("|", datos);
                    }
                    bw.write(linea);
                    bw.newLine();
                }
            }
            
           // Mover todo lo del archivo de copia al archivo original
            Files.move(fc.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
         } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.println("El nombre de la categoria ha sido modificado por completo");
           System.out.println("El programa nuevamente lo llevara al apartado principal de Categorias de Producto");        
           break; 
            
//Termina el caso cuando se logra modificar de manera correcta  el nombre de la categoria en el archivo de texto de acceso secuencial      
       
        case 3: //eliminar categoria
           /* System.out.println("");
            System.out.println("LISTA DE CATEGORIAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
                    //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) { 
                      String texto;
                    while ((texto = br.readLine()) != null) { //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto); //en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");*/
            
            
                try {
                    System.out.println(" ");
                    System.out.print("Ingrese el nombre de la categoria que desee eliminar: ");
                    String eliminarCate = scan.nextLine();
                    while (eliminarCate.isBlank()) { //bucle que impide los espacios en blanco
                    System.out.print("El nombre no puede quedar vacio, ingrese nuevamente el nombre de la categoria que desee eliminar: ");
                    eliminarCate = scan.nextLine();}
                    /*System.out.print("Realmente desea eliminar esta categoria?");
                    confirmacionFinal = scan.nextLine();
                    
                    if (confirmacionFinal.equalsIgnoreCase("sí")){}*/
                    FileReader fr = new FileReader(f);
                    
                    BufferedReader br = new BufferedReader(fr);
                  
                            
                    File fc = new File("archivo_categoriaElim_copia.txt");
                    FileWriter fw = new FileWriter(fc);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    String linea = "";//leer el archivo original linea por linea
                   while ((linea = br.readLine()) != null) {
                        //split divide una cadenta con base a las cadenas que ya estaban
                        //separa una cadena en un conjunto de cadenas 
                        
                       String[] datos = linea.split("\\|");
                        
                        //verifica subcadena por subcadena 
                        //se cierra el bucle cuando encuentre el mismo caracter 
                        if (!datos[0].trim().equalsIgnoreCase(eliminarCate)) { //scribir todas las líneas que no coincidan con la categoría a eliminar 
                            //agregar los datos que no contengan el dato especifico escrito por el usuario y luego darle un salto de linea
                            bw.write(linea+"\n");
                          /*  bw.newLine();*/
                        }
                    }
                    
                    bw.close();
                    br.close();
                    
                    //cambniarle el nombre 
                    //asignando el nombre del antiguo archivo al archivo nuevo 
                Files.move(fc.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                    
            System.out.println("El nombre de la categoria se ha eliminado por completo del sistema");
            System.out.println("El programa nuevamente lo llevara al apartado principal de Categorias de Productos ");
                }
        break;
 //Termina el caso cuando se logra eliminar de manera correcta el nombre de la categoria en el archivo de texto de acceso secuencial       
        case 4: 
            System.out.println("Esta saliendo de la Seccion de Definicion de Categorias"); //Salir de la Seccion de Definicion de Categorias
            System.out.println("Volvera al menu principal de Gestion de Inventarios");
        break;    
        default :
            //Mensajes indicando que el numero ingresado no representa ninguna accion dentro del sistema
            System.out.println("El numero ingresado no representa niguna accion dentro del sistema");
            System.out.println("El programa nuevamente lo llevara al apartado principal de Categorias de Productos");
        break;
        
        }

       } while (respuesta != 4);//La seccion de categorías se sigue ejecutando hasta que el usuario seleccione el número cuatro
        
    }
     
     //1.2 Definición de Características:
      //Opcion 1.2 dentro del switch principal
    static void seccionCaracteristicas() {
       int respuesta = 0; 
    
    String nombreCaracteristica = "";
       File f = new File("C:\\algoritmosProyecto\\DefinicionCaracteristicas.txt"); //Creacion de una nueva representacion de un archivo
        
       
      do { 
       System.out.println("                                                ");
       System.out.println("    ---SECCION DE CARACTERISTICAS DE PRODUCTO---  ");    
       System.out.println("                                                ");
                System.out.println("         LISTA DE CARACTERISTICAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivoi = "C:\\algoritmosProyecto\\DefinicionCaracteristicas.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoi))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
       System.out.println("Acciones a realizar:");
       System.out.println("1. Ingresar el nombre de una nueva caracteristica:");
       System.out.println("2. Modificar el nombre de alguna caracteristica ya existente");
       System.out.println("3. Eliminar alguna caracteristica ya existente ");
       System.out.println("4. Salir de la seccion de Definicion de Caracteristicas ");
       System.out.print("Ingrese un numero segun la accion que desee realizar: ");
       respuesta = scan.nextInt();
       scan.nextLine(); 
       
       switch (respuesta) {
        case 1: //agregar caracteristica
            
                try {
                    /*ir hasta el final del archivo, ya que hasta el final del archivo almacenara los nuevos datos
                    (por lo tanto, el true se eccarga de almacenar los datos anteriormente guardados y al
                    al ingresar nuevos datos, los almacenara dentro de los otros datos existentes)*/
                    
                    FileWriter fw = new FileWriter(f, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                // Por medio de un mensaje, se le pide al usuario ingresar el nombre de la nueva caracteristica 
                    System.out.print("Ingrese el nombre de la nueva caracteristica: ");
                    //guardar resultado en una variable llamada "nombreCaracteristica"
                    nombreCaracteristica = scan.nextLine();
                    while (nombreCaracteristica.isBlank()) { //si el espacio donde debe ir la caracteristica queda en blanco se activara el bucle
                    System.out.println("El nombre no puede quedar vacio, intente nuevamente escribir el nombre: ");
                    nombreCaracteristica = scan.nextLine();
                    }
                    //escribir el nombre y guardarlo en el archivo
                    bw.write(nombreCaracteristica + "\n");
                    bw.close();
                } catch (IOException ex) {
                     Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }               
                System.out.println("La caracteristica, " + nombreCaracteristica + " ha sido ingresada al archivo de texto");
                System.out.println("El programa nuevamente lo llevara al apartado principal de Caracteristicas de Productos  ");
                    break; 
//Termina el caso cuando se logre almacenar de manera correcta el dato en el archivo de tecto de acceso secuencial         
               
           case 2: //modificar caracteristica
             /*  System.out.println("");
                System.out.println("LISTA DE CARACTERISTICAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivo = "C:\\algoritmosProyecto\\DefinicionCaracteristicas.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");*/
            
                try {
            
                    System.out.print("Ingrese el nombre de la caracteristica que desee modificar: ");
                    String modiCarac = scan.nextLine();
                    while (modiCarac.isBlank()) { // si el nombre queda vacio, se activara el bucle
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nombre de la caracteristica que desee modificar: ");
                     modiCarac = scan.nextLine();
                    }
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scan.nextLine();
                    while (nuevoNombre.isBlank()) {
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nuevo nombre de la caracteristica: ");
                    nuevoNombre = scan.nextLine();
             }
           
            
                 // objeto File que representa el archivo de copia.
                 File fc = new File("C:\\algoritmosProyecto\\DefinicionCaracteristicasCopia.txt");
            
                  //abrir el archivo original para lectura
                   //por medio de BufferedReader y FileReader se abre el archivo original para lectura
                 try (BufferedReader br = new BufferedReader(new FileReader(f));
                  //por medio de BufferedWriter y FileWriter se abre el archivo de copia para escritura         
                 BufferedWriter bw = new BufferedWriter(new FileWriter(fc))) {
                
                  String linea; //Se declara una variable llamada linea que almacenará cada línea leída del archivo.
                while ((linea = br.readLine()) != null) { //verifica los datos hasta que los datos sean nulos o inexistentes  
                    String[] datos = linea.split("\\|");
                    //Compara la primera parte de la línea con modiCate. Si son iguales, modificara la línea.
                    if (datos[0].trim().equalsIgnoreCase(modiCarac.trim()))  {
                        datos[0] = nuevoNombre;
                        linea = String.join("|", datos);
                    }
                    bw.write(linea);
                    bw.newLine();
                }
            }
            
            Files.move(fc.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
             } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
             }
           System.out.println("El nombre de la caracteristica ha sido modificado por completo");
           System.out.println("El programa nuevamente lo llevara al apartado principal de Caracteristicas de Productos");        
              
               
                
              break; 
            
//Termina el caso cuando se logra modificar de manera correcta  el nombre de la caracteristica en el archivo de texto de acceso secuencial      
       
           case 3: //eliminar caracteristica
           /* System.out.println("");
            System.out.println("LISTA DE CARACTERISTICAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionCaracteristicas.txt";
                    //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) { 
                      String texto;
                    while ((texto = br.readLine()) != null) { //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto); //en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");*/
            
            
                try {
                    
                    System.out.print("Ingrese el nombre de la caracteristica que desee eliminar: ");
                    String eliminarCarac = scan.nextLine();
                    while (eliminarCarac.isBlank()) { //si el nombre de la caracteristica queda vacio, se activara el bucle
                    System.out.print("El nombre no puede quedar vacio, ingrese nuevamente el nombre de la caracteristica que desee eliminar: ");
                    eliminarCarac = scan.nextLine();}
                
                    FileReader fr = new FileReader(f);
                     // trae los datos del disco duro hacia "BuffereReader" para leer los archivos de manera mas eficiente
                    BufferedReader br = new BufferedReader(fr); //leer el archivo original
                  
                            
                    File fc = new File("archivo_texto_copia_caracteristica.txt");
                    FileWriter fw = new FileWriter(fc);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    String linea = "";
                    
                    while((linea = br.readLine()) != null) {
                        //split divide una cadena con base a las cadenas que ya estaban
                        //separa una cadena en un conjunto de cadenas 
                        
                        String [] datos = linea.split("\\|");
                        
                        //verifica subcadena por subcadena 
                        //se cierra e if (datos[0].compareTo(eliminarCarac) != 0) {
                            //agregar los datos que no contengan el dato especifil bucle cuando encuentre el mismo caracter 
                        if (!datos[0].trim().equalsIgnoreCase(eliminarCarac)) {
                            //agregar los datos que no contengan el dato especifico escrito por el usuario y luego darle un salto de linea
                            bw.write(linea+"\n"); //
                        }
                    }
                    
                    bw.close();
                    br.close();
                    
                    //cambniarle el nombre 
                    //asignando el nombre del antiguo archivo al archivo nuevo 
                    Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }   
                 System.out.println("El nombre de la caracteristica se ha eliminado por completo del sistema");
                System.out.println("El programa nuevamente lo llevara al apartado principal de Caracteristicas de Productos");
                 break;      
 //Termina el caso cuando se logra eliminar de manera correcta el nombre de la caracteristica en el archivo de texto de acceso secuencial                      
         
                case 4: 
                    System.out.println("Esta saliendo de la Seccion de Definicion de Caracteristicas"); //Salir de la Seccion de Definicion de Caracteristicas
                    System.out.println("Volvera al menu principal de Gestion de Inventarios");
                 break;    
                 default :
                 //Mensajes indicando que el numero ingresado no representa ninguna accion dentro del sistema
                     System.out.println("El numero ingresado no representa niguna accion dentro del sistema");
                     System.out.println("El programa nuevamente lo llevara al apartado principal de Caracteristicas de Productos");
                break;                                
            }      
                 } while (respuesta != 4);
            }
       static void seccionEspecificaciones() {
             int respuesta = 0; 
    
         String nombreEspecificacion = "";
       File f = new File("C:\\algoritmosProyecto\\DefinicionEspecificacion.txt"); //Creacion de una nueva representacion de un archivo      
       
      do { 
       System.out.println("                                                ");
       System.out.println("  ---SECCION DE ESPECIFICACIONES DE PRODUCTO---  ");    
       System.out.println("                                                ");
                System.out.println("      LISTA DE ESPECIFICACIONES EXISTENTES:");
                System.out.println("--------------------------------------------------");
                //Definirá en una variable la ruta del archivo que se desea leer
                String rutaArchivoE = "C:\\algoritmosProyecto\\DefinicionEspecificacion.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoE))) {
                    String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
       System.out.println("Acciones a realizar:");
       System.out.println("1. Ingresar una nueva especificacioin:");
       System.out.println("2. Modificar el nombre de alguna especificacion ya existente");
       System.out.println("3. Eliminar alguna especificacion ya existente ");
       System.out.println("4. Salir de la seccion de Definicion de Caracteristicas ");
       System.out.print("Ingrese un numero segun la accion que desee realizar: ");
       respuesta = scan.nextInt();
       scan.nextLine();    
        
       switch (respuesta) {
        case 1: //agregar Especificaciones
            
                try {
                    /*ir hasta el final del archivo, ya que hasta el final del archivo almacenara los nuevos datos
                    (por lo tanto, el true se eccarga de almacenar los datos anteriormente guardados y al
                    al ingresar nuevos datos, los almacenara dentro de los otros datos existentes)*/
                    
                    FileWriter fw = new FileWriter(f, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                // Por medio de un mensaje, se le pide al usuario ingresar el nombre de la nueva especificacion 
                    System.out.print("Ingrese el nombre de la nueva especificacion: ");
                    //guardar resultado en una variable llamada "nombreEspecificacion"
                    nombreEspecificacion = scan.nextLine();
                    while (nombreEspecificacion.isBlank()) { //si el espacio donde debe ir la caracteristica queda en blanco se activara el bucle
                    System.out.println("El nombre no puede quedar vacio, intente nuevamente ingresar la especificacion: ");
                    nombreEspecificacion = scan.nextLine();
                    }
                    //escribir el nombre y guardarlo en el archivo
                    bw.write(nombreEspecificacion + "\n");
                    bw.close();
                } catch (IOException ex) {
                     Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }               
                System.out.println("La especificacion, " + nombreEspecificacion + " ha sido ingresada al archivo de texto");
                System.out.println("El programa nuevamente lo llevara al apartado principal de Especificacion de Productor  ");
                    break; 
//Termina el caso cuando se logre almacenar de manera correcta el dato en el archivo de tecto de acceso secuencial         
               
           case 2: //modificar especificacion
               /*System.out.println("");
                System.out.println("LISTA DE ESPECIFICACIONES EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivo = "C:\\algoritmosProyecto\\DefinicionEspecificacion.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");*/
            
                try {
            
                    System.out.print("Ingrese la especaciones que desee modificar: ");
                    String modiEspe = scan.nextLine();
                    while (modiEspe.isBlank()) { // si el nombre queda vacio, se activara el bucle
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nombre de la especificacion que desee modificar: ");
                     modiEspe = scan.nextLine();
                    }
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scan.nextLine();
                    while (nuevoNombre.isBlank()) {
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nuevo nombre de la especificacion: ");
                    nuevoNombre = scan.nextLine();
             }
           
            
                 // objeto File que representa el archivo de copia.
                 File fc = new File("C:\\algoritmosProyecto\\DefinicionEspecifiacionesCopia.txt");
            
                  //abrir el archivo original para lectura
                   //por medio de BufferedReader y FileReader se abre el archivo original para lectura
                 try (BufferedReader br = new BufferedReader(new FileReader(f));
                  //por medio de BufferedWriter y FileWriter se abre el archivo de copia para escritura         
                 BufferedWriter bw = new BufferedWriter(new FileWriter(fc))) {
                
                  String linea; //Se declara una variable llamada linea que almacenará cada línea leída del archivo.
                while ((linea = br.readLine()) != null) { //verifica los datos hasta que los datos sean nulos o inexistentes  
                    String[] datos = linea.split("\\|");
                    //Compara la primera parte de la línea con modiCate. Si son iguales, modificara la línea.
                    if (datos[0].trim().equalsIgnoreCase(modiEspe.trim()))  {
                        datos[0] = nuevoNombre;
                        linea = String.join("|", datos);
                    }
                    bw.write(linea);
                    bw.newLine();
                }
            }
            
            Files.move(fc.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
             } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
             }
           System.out.println("El nombre de la especificaciones ha sido modificado por completo");
           System.out.println("El programa nuevamente lo llevara al apartado principal de Definicion de Especificaciones ");        
                    
              break; 
            
//Termina el caso cuando se logra modificar de manera correcta  el nombre de la especificacion en el archivo de texto de acceso secuencial      
       
           case 3: //eliminar especificacion
            System.out.println("");
            System.out.println("LISTA DE ESPECIFIACIONES EXISTENTES:");
                   /* System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionEspecificacion.txt";
                    //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) { 
                      String texto;
                    while ((texto = br.readLine()) != null) { //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto); //en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");*/
            
            
                try {
                    
                    System.out.print("Ingrese el nombre de la especificacion que desee eliminar: ");
                    String eliminarEspe = scan.nextLine();
                    while (eliminarEspe.isBlank()) { //si el nombre de la caracteristica queda vacio, se activara el bucle
                    System.out.print("El nombre no puede quedar vacio, ingrese nuevamente el nombre de la especificacion que desee eliminar: ");
                    eliminarEspe = scan.nextLine();}
                
                    FileReader fr = new FileReader(f);
                     // trae los datos del disco duro hacia "BuffereReader" para leer los archivos de manera mas eficiente
                    BufferedReader br = new BufferedReader(fr); //leer el archivo original
                  
                            
                    File fc = new File("archivo_texto_copia_especificacion.txt");
                    FileWriter fw = new FileWriter(fc);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    String linea = "";
                    
                   while ((linea = br.readLine()) != null) {
                        //split divide una cadena con base a las cadenas que ya estaban
                        //separa una cadena en un conjunto de cadenas 
                        
                        String [] datos = linea.split("\\|");
                        
                        //verifica subcadena por subcadena 
                        //se cierra el bucle cuando encuentre el mismo caracter 
                        if (!datos[0].trim().equalsIgnoreCase(eliminarEspe)) {
                            //agregar los datos que no contengan el dato especifico escrito por el usuario y luego darle un salto de linea
                            bw.write(linea+"\n"); //
                        }
                    }
                    bw.close();
                    br.close();
                    
                    //cambniarle el nombre 
                    //asignando el nombre del antiguo archivo al archivo nuevo 
                    Files.move(fc.toPath(), f.toPath(), REPLACE_EXISTING);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }   
                 System.out.println("El nombre de la Especificacion se ha eliminado por completo del sistema");
                System.out.println("El programa nuevamente lo llevara al apartado principal de Especificaciones de Productos");
                 break;      
 //Termina el caso cuando se logra eliminar de manera correcta el nombre de la caracteristica en el archivo de texto de acceso secuencial                      
         
                case 4: 
                    System.out.println("Esta saliendo de la Seccion de Especificaciones de Productos"); //Salir de la Seccion de Definicion de Caracteristicas
                    System.out.println("Volvera al menu principal de Gestion de Inventarios");
                 break;    
                 default :
                 //Mensajes indicando que el numero ingresado no representa ninguna accion dentro del sistema
                     System.out.println("El numero ingresado no representa niguna accion dentro del sistema");
                     System.out.println("El programa nuevamente lo llevara al apartado principal de Especificaciones de Productos  ");
                break;                                
               }              
               }while (respuesta != 4);  //mientras la respuesta sea distinta a 4 el programa seguirá en marcha  
             }
    
        static void asignacionAProductos() {
            String respuesta = "";
            do{
             System.out.println("                                                ");
             System.out.println("  ---ASIGNACION DE CATEGORIAS, CARACTERISTICAS Y ESPECIFICACIONES A PRODUCTOS---");    
             System.out.println("                                                ");
            
            String producto = "", categoria = "", caracteristica = "", especificacion = "", productoos="";
            
          File file = new File("C:\\algoritmosProyecto\\AsignacionProductos.txt"); //Creacion de una nueva representacion de un archivo      
             
           System.out.println("                                                ");
             System.out.println("  ----Ingreso del nuevo producto----");    
             System.out.println("                                                ");
         

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Ingresar el nombre del nuevo producto
            System.out.print("Ingrese el nombre del nuevo producto: ");
            producto = scan.nextLine();
            while (producto.isBlank()) { //si el espacio donde debe ir el producto queda en blanco se activara el bucle
                System.out.print("El nombre no puede quedar vacío, intente nuevamente escribir el nombre: ");
                producto = scan.nextLine();
            }

            System.out.println("                                                ");
            System.out.println("  -----Asignacion de la categoria-----");
            System.out.println("                                                ");
            System.out.println("LISTA DE CATEGORIAS EXISTENTES:");
            System.out.println("--------------------------------------------------");
            
            // Leer y mostrar categorías existentes
            String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) {
                String texto;
                while ((texto = br.readLine()) != null) {
                    System.out.println(texto);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");

            // Ingresar la categoría del producto
            System.out.print("Ingrese la categoria que defina las propiedades del producto: ");
            categoria = scan.nextLine();
            while (categoria.isBlank()) {
                System.out.print("La categoría no puede quedar vacía, intente nuevamente ingresarla: ");
                categoria = scan.nextLine();
            }

            
            System.out.println("                                                ");
            System.out.println("  -----Asignacion de la caracteristica-----");
            System.out.println("                                                ");
            System.out.println("LISTA DE CARACTERISTICAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivo = "C:\\algoritmosProyecto\\DefinicionCaracteristicas.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
            
            System.out.print("Ingrese la caracteristica que defina las propiedades del producto: ");
            caracteristica = scan.nextLine();
            while (caracteristica.isBlank()) {
                System.out.print("La caracteristica no puede quedar vacía, intente nuevamente ingresarla : ");
                categoria = scan.nextLine();
            }
            
            System.out.println("                                                ");
            System.out.println("  -----Asignacion de la especificacion-----");
            System.out.println("                                                ");
            
              System.out.println("      LISTA DE ESPECIFICACIONES EXISTENTES:");
                System.out.println("--------------------------------------------------");
                //Definirá en una variable la ruta del archivo que se desea leer
                String rutaArchivoE = "C:\\algoritmosProyecto\\DefinicionEspecificacion.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoE))) {
                    String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
            
            System.out.print("Ingrese la especificacion que defina las propiedades del producto: ");
            especificacion = scan.nextLine();
            while (caracteristica.isBlank()) {
                System.out.print("La especificacion no puede quedar vacía, intente nuevamente ingresarla : ");
                especificacion = scan.nextLine();
            }
            
            
            // Escribira el producto y la categoría en una sola línea
            /*bw.write( "|  Producto   |   Categoria   |  Caracteristica  |   Especificacion  |\n");*/
            bw.write( producto +  " | " + categoria + " | " + caracteristica + "|" + especificacion + "\n");
            bw.close();
            
            System.out.println(" ");
            System.out.println("El producto " + producto +  " fue asignado a:");
            System.out.println("Categoria:" + categoria);
            System.out.println("Caracteristica:" + caracteristica);
            System.out.println("Especificacion :" + especificacion);
           

        } catch (IOException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hubo un problema al guardar el nombre del nuevo producto y la categoría:");
        }

        System.out.println("                                                ");
        System.out.println("  LISTA DE PRODUCTOS EXISTENTES:");
        System.out.println("--------------------------------------------------");

        // Lee y muesta los productos existentes
        String rutaArchivo = "C:\\algoritmosProyecto\\AsignacionProductos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String texto;
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------");
            
          
             
        
        
         try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                // Por medio de un mensaje, se le pide al usuario ingresar el nombre del nuevo producto
                    System.out.print("Ingrese el nombre del nuevo producto: ");
                    //guardar resultado en una variable llamada "Productos"
                    producto = scan.nextLine();
                    while (producto.isBlank()) { //si el espacio donde debe ir la caracteristica queda en blanco se activara el bucle
                    System.out.print("El nombre no puede quedar vacio, intente nuevamente escribir el nombre: ");
                    producto = scan.nextLine();
                    }
                    //escribir el nombre y guardarlo en el archivo
                    bw.write(producto + "\\|");
                    bw.close();
                    System.out.println("El nombre del producto se ha guardado dentro del sistema:");
                           
                } catch (IOException ex) {
                     Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                     System.out.print("Hubo un problema al guardar el nombre del nuevo producto:");
                }   
               
        
                   
                   
                   System.out.println("                                                ");
                System.out.println("  -----Asignacion de la categoria-----");    
                System.out.println("   ");     
                   
                    System.out.println("");
                        System.out.println("LISTA DE CATEGORIAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
                    //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) { 
                      String texto;
                    while ((texto = br.readLine()) != null) { //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto); //en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
            
             
         try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    System.out.print("Ingrese la categoria que defina las propiedades del producto: ");        
                    categoria = scan.nextLine();
                    bw.write(producto + categoria + "\n");
                    bw.close();
                    System.out.print("El producto " + producto + "ha sido asignado a la categoria de " + categoria);
                    }
                    catch (IOException ex) {
                     Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
                     System.out.println("Hubo un problema al asignarle la categoria:");
                }    
                     System.out.println(" ");
                    System.out.println("  LISTA DE PRODUCTOS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    rutaArchivo = "C:\\algoritmosProyecto\\AsignacionProductos.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
                   System.out.println("Desea ingresar otro producto? (Responder Si/No)");
                   respuesta = scan.nextLine();
            
        } while (respuesta.equalsIgnoreCase("si"));
        
        System.out.println("Esta saliendo de la Seccion de Asignacion"); //Salir de la Seccion 
        System.out.println("Volvera al menu principal de Gestion de Inventarios");                   
}
                    

                                  

            
    
    
        static void altaDeProductos (){
     String producto = "", categoria = "", caracteristica = "", especificacion = "", respuesta="";
             do{ 
         System.out.println("                                                ");
             System.out.println("  ----ALTA DE PRODUCTOS ----");    
             System.out.println("                                                ");
         
        
        File f = new File("C:\\algoritmosProyecto\\AltaDeProductos.txt");

        try {
            FileWriter fwr = new FileWriter(f, true);
            BufferedWriter bwr = new BufferedWriter(fwr);

            // Ingresar el nombre del nuevo producto
            System.out.print("Ingrese el nombre del nuevo producto: ");
            producto = scan.nextLine();
            while (producto.isBlank()) {
                System.out.print("El nombre no puede quedar vacío, intente nuevamente escribir el nombre: ");
                producto = scan.nextLine();
            }

            
            System.out.println("                                                ");
            System.out.println("  -----Seleccion de la categoria-----");
            System.out.println("                                                ");
            System.out.println("LISTA DE CATEGORIAS EXISTENTES:");
            System.out.println("--------------------------------------------------");
            
            // Lee y mmuestra categorías existentes
            String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) {
                String texto;
                while ((texto = br.readLine()) != null) {
                    System.out.println(texto);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");

            // Ingresar la categoría del producto
            System.out.print("Ingrese la categoria que defina las propiedades del producto: ");
            categoria = scan.nextLine();
            while (categoria.isBlank()) {
                System.out.print("La categoría no puede quedar vacía, intente nuevamente ingresarla: ");
                categoria = scan.nextLine();
            }
            
            
            System.out.println("                                                ");
            System.out.println("  -----Seleccion de las caracteristicas-----");
            System.out.println("                                                ");
            String[][] datosCaracteristicas = new String[1][3];
            // Ingresar las características
            for (int i = 0; i < datosCaracteristicas.length; i++) {
                System.out.println("Ingrese las caracteristicas para el producto " + producto );

                for (int j = 0; j < 3; j++) {
                    System.out.print("Ingrese la caracteristica " + (j + 1) + ": ");
                    caracteristica = scan.nextLine();
                    while (caracteristica.isBlank()) {
                        System.out.print("La caracteristica no puede quedar vacia, intente nuevamente: ");
                        caracteristica = scan.nextLine();
                    }
                    datosCaracteristicas[i][j] = caracteristica;
                }

                // Escribir las características en el archivo
                bwr.write(producto + " | " + categoria + " | " + datosCaracteristicas[i][0] + " | " + datosCaracteristicas[i][1] + " | " + datosCaracteristicas[i][2]);
                bwr.newLine();
               
                      
            }

            bwr.close();
            System.out.println("El producto, su categoria y sus caracteristicas se han guardado correctamente.");
            System.out.println("El programa nuevamente lo llevara al apartado principal de Especificaciones de Productos  ");
        } catch (IOException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        System.out.println("--------------------------------------------------");
                   System.out.println("Desea ingresar otro producto? (Responder Si/No)");
                   respuesta = scan.nextLine();
            
        } while (respuesta.equalsIgnoreCase("si"));
        
        System.out.println("Esta saliendo de la Seccion de Alta de productos"); //Salir de la Seccion 
        System.out.println("Volvera al menu principal de Gestion de Inventarios"); 
        
        }
     
          /*File file = new File("C:\\algoritmosProyecto\\AsignacionProductos.txt"); //Creacion de una nueva representacion de un archivo      
             
           System.out.println("                                                ");
             System.out.println("  ----Ingreso del nuevo producto----");    
             System.out.println("                                                ");
         

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Ingresar el nombre del nuevo producto
            System.out.print("Ingrese el nombre del nuevo producto: ");
            producto = scan.nextLine();
            while (producto.isBlank()) { //si el espacio donde debe ir el producto queda en blanco se activara el bucle
                System.out.print("El nombre no puede quedar vacío, intente nuevamente escribir el nombre: ");
                producto = scan.nextLine();
            }

            System.out.println("                                                ");
            System.out.println("  -----Asignacion de la categoria-----");
            System.out.println("                                                ");
            System.out.println("LISTA DE CATEGORIAS EXISTENTES:");
            System.out.println("--------------------------------------------------");
            
            // Leer y mostrar categorías existentes
            String rutaArchivoo = "C:\\algoritmosProyecto\\DefinicionCategorías.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoo))) {
                String texto;
                while ((texto = br.readLine()) != null) {
                    System.out.println(texto);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------");

            // Ingresar la categoría del producto
            System.out.print("Ingrese la categoria que defina las propiedades del producto: ");
            categoria = scan.nextLine();
            while (categoria.isBlank()) {
                System.out.print("La categoría no puede quedar vacía, intente nuevamente ingresarla: ");
                categoria = scan.nextLine();
            }

            
            System.out.println("                                                ");
            System.out.println("  -----Asignacion de la caracteristica-----");
            System.out.println("                                                ");
            System.out.println("LISTA DE CARACTERISTICAS EXISTENTES:");
                    System.out.println("--------------------------------------------------");
                    //Definirá en una variable la ruta del archivo que se desea leer
                    String rutaArchivo = "C:\\algoritmosProyecto\\DefinicionCaracteristicas.txt";
                 //BufferedReader para leer el archivo
                try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                      String texto;
                    while ((texto = br.readLine()) != null) {  //lee los datos hasta que los datos sean nulos o inexistentes
                    System.out.println(texto);//en cada vuelta del ciclo se imprimira los datos leidos
                    }
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                    System.out.println("--------------------------------------------------");
            
            System.out.print("Ingrese la caracteristica prinicipal del producto: ");
            caracteristica = scan.nextLine();
            while (caracteristica.isBlank()) {
                System.out.print("La caracteristica no puede quedar vacía, intente nuevamente ingresarla : ");
                categoria = scan.nextLine();
            }    
            
            String [][] datosCaracteristicas = new String [100][3];
            File f = new File("C:\\algoritmosProyecto\\datosCaracteristicas.txt");
            try {
            FileWriter fwr = new FileWriter(f, true);
            BufferedWriter bwr = new BufferedWriter(fwr);

            // Ingresar el nombre de los datos especificos del producto
            System.out.print("Ingrese el nombre del nuevo producto: ");
            producto = scan.nextLine();
            while (producto.isBlank()) { //si el espacio donde debe ir el producto queda en blanco se activara el bucle
                System.out.print("El nombre no puede quedar vacío, intente nuevamente escribir el nombre: ");
                producto = scan.nextLine();
            }

            
            
            
            
             // Escribira el producto y la categoría en una sola línea
            /*bw.write( "|  Producto   |   Categoria   |  Caracteristica  |   Especificacion  |\n");*/
           /* bw.write( producto +  " | " + categoria + " | " + caracteristica + "|" + especificacion + "\n");
            bw.close();
            
            System.out.println(" ");
            System.out.println("El producto " + producto +  " fue asignado a:");
            System.out.println("Categoria:" + categoria);
            System.out.println("Caracteristica:" + caracteristica);
            System.out.println("Especificacion :" + especificacion); 
            
            
            } catch (IOException ex) {
            Logger.getLogger(AlgoritmosProyecto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hubo un problema al guardar el nombre del nuevo producto y la categoría:");
        }*/

         
            
             
        
    
        
        static void bajaDeProductos() {
            
        }
    
    
        }
 
        
    

