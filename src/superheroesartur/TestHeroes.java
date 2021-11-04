/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superheroesartur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arturv
 */
public class TestHeroes {
    private static ArrayList<Heroe> heroes;
   
    private static void mostrarheroes()
    {
        String tipo="";
        for(int cont=0;cont<heroes.size();cont++)
        {
            if(heroes.get(cont) instanceof Hulk)
            {
                tipo = "Hulk";
            }
            else if(heroes.get(cont) instanceof Spiderman)
            {
                tipo="Spiderman";
            }
            System.out.println("Heroe número " + cont + " Nombre:" + heroes.get(cont).getnombre() + " Tipo:" + tipo);
        }
    }
    
    private static void modificardatos()
    {
        Scanner entrada = new Scanner(System.in);
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int posicion = 0, opcion=0, edad, poder;
        double peso;
        
        String nombre, apodo;
        
        mostrarheroes();
        System.out.println("Introduce el número de heroe al que le quieres modificar los datos.");
        try
        {
            posicion = entrada.nextInt();
            if(posicion>=0 && posicion<heroes.size())
            {
                System.out.println("Selecciona que quieres modificar.");
                System.out.println("1-Nombre.");
                System.out.println("2-Apodo.");
                System.out.println("3-Edad");
                
                if(heroes.get(posicion) instanceof Hulk)
                {
                    System.out.println("4-Peso");
                }
                else if(heroes.get(posicion) instanceof Spiderman)
                {
                    System.out.println("4-Poder arácnido");
                }
                opcion = entrada.nextInt();
                switch(opcion)
                {
                    case 1:
                        System.out.println("Introduce el nuevo nombre.");
                        nombre = lector.readLine();
                        heroes.get(posicion).setnombre(nombre);
                        System.out.println("Nombre cambiado.");
                        break;
                    case 2:
                        System.out.println("Introduce el nuevo apodo.");
                        apodo = lector.readLine();
                        heroes.get(posicion).setapodo(apodo);
                        System.out.println("Apodo cambiado.");
                        break;
                    case 3:
                        System.out.println("Introduce la nueva edad.");
                        edad = entrada.nextInt();
                        heroes.get(posicion).setedad(edad);
                        System.out.println("Edad cambiada.");
                        break;
                    case 4: 
                        if(heroes.get(posicion) instanceof Hulk)
                        {
                            System.out.println("Introduce el nuevo peso.");
                            peso = entrada.nextDouble();
                            
                            Hulk r = (Hulk) heroes.get(posicion);
                            
                            r.setpeso(peso);
                            System.out.println("Peso cambiado.");

                        }
                        else if(heroes.get(posicion) instanceof Spiderman)
                        {
                            System.out.println("Introduce poder arácnido 0 o 1");
                            poder = entrada.nextInt();
                            
                            Spiderman r = (Spiderman) heroes.get(posicion);
                            if(poder==0)
                            {
                                r.setpoderAracnido(false);
                                System.out.println("Poder arácnido cambiado.");
                            }
                            else if(poder == 1)
                            {
                                r.setpoderAracnido(true);
                                System.out.println("Poder arácnido cambiado.");
                            }
                            else
                            {
                                System.out.println("Selección incorrecta.");
                            }
                                
                        }
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                }
               
            }
            else
            {
                System.out.println("Posición incorrecta.");
            }
            
        }
        catch(Exception ex)
        {
            System.out.println("Error de entrada de datos.");
        }
    }
        
    private static void limpiarpoderes()
    {
        int posicion;
        Scanner entrada = new Scanner(System.in);
        mostrarheroes();
        char confirma;
        System.out.println("Introduce el número de heroe");
        try
        {
             posicion = entrada.nextInt();
             if(posicion>=0 && posicion<heroes.size())
             {
                 System.out.println("Poderes:");
                 heroes.get(posicion).showPoderes();
                 System.out.println("¿Seguro que deseas eliminar los poderes? s/n");
                 confirma = entrada.next().charAt(0);
                 if(confirma=='s' || confirma =='S')
                 {
                     heroes.get(posicion).quitapoderes();
                     System.out.println("Poderes eliminados.");
                 }
                 else
                 {
                     System.out.println("Cancelado, no se han eliminado poderes.");
                 }
             } 
             else
             {
                 System.out.println("Posición incorrecta.");
             }
        }
        catch(Exception ex)
        {
            System.out.println("Error de entrada de datos.");
        }
    }
    
    //Lo he hecho primero con el código en el main , pero después también he añadido un método en las clases hijo y el padre.
    private static void consultarheroe()
    {
        Scanner entrada = new Scanner(System.in);
        int posicion;
        String tipo;
        mostrarheroes();
        System.out.println("Introduce el número de heroe que quieres consultar");
        try
        {
            posicion = entrada.nextInt();
            if(posicion>=0 && posicion<heroes.size())
            {
                System.out.println("Heroe número " + posicion);
                System.out.println("Nombre:" + heroes.get(posicion).getnombre());
                System.out.println("Apodo:" + heroes.get(posicion).getapodo());
                System.out.println("Edad:" + heroes.get(posicion).getedad());
                System.out.println("Poderes:");
                heroes.get(posicion).showPoderes();
                System.out.println("Potencial:" + heroes.get(posicion).calcularPotencial());
                if(heroes.get(posicion) instanceof Hulk)
                {
                    System.out.println("Tipo:Hulk");
                    Hulk r = (Hulk) heroes.get(posicion);
                    
                    System.out.println("Peso:" + r.getpeso());
                    
                }
                else if(heroes.get(posicion) instanceof Spiderman)
                {
                    System.out.println("Tipo:Spiderman");
                    Spiderman r = (Spiderman) heroes.get(posicion);
                    if(r.getpoderAracnido())
                    {
                        System.out.println("Poder arácnido: True");
                    }
                    else
                    {
                        System.out.println("Poder arácnido: False");
                    }
                    
                }
                System.out.println("Ahora mostraré la misma información pero desde un método en la clase.");
                heroes.get(posicion).mostrarinformacion();
            }
            else
            {
                System.out.println("Posición incorrecta.");
            }
                    
        }
        catch(Exception ex)
        {
            System.out.println("Error de entrada de datos.");
        }
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        //Se crearán dos heroes
        //Inicializo
        heroes = new ArrayList<>();
        //Añado un heroe del tipo spiderman
        heroes.add(new Spiderman("Spiderpadre","Phaterspider",60));
        //le pongo 3 poderes aunque caben 4
        heroes.get(0).setpoder("Trepar", 0);
        heroes.get(0).setpoder("Engancharse", 1);
        heroes.get(0).setpoder("Pegar", 2);
        
        //Añado un heroe del tipo Hulk
        heroes.add(new Hulk("Hulkhijo","Sonhulk",10,200));
        //le pongo 4 poderes
         heroes.get(1).setpoder("Machacar", 0);
        heroes.get(1).setpoder("Transformarse", 1);
        heroes.get(1).setpoder("Ponerse verde", 2);
        heroes.get(1).setpoder("Ponerse blanco", 3);
        
        System.out.println("Añadidos dos heroes");

        try
        {
            do
            {
                System.out.println("Elige una opción.");
                System.out.println("1-Consultar heroe.");
                System.out.println("2-Modificar datos personales.");
                System.out.println("3-Limpiar poderes.");
                System.out.println("4-Salir");
                opcion = entrada.nextInt();
                switch(opcion)
                {
                    case 1:
                        consultarheroe();
                        break;
                    case 2:
                        modificardatos();
                        break;
                    case 3:
                        limpiarpoderes();
                        break;
                    case 4:
                        System.out.println("Adiós");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
                
            }while(opcion!=4);
        }catch(Exception ex)
        {
            System.out.println("Ha ocurrido un error. Seguramente al entrar datos por teclado.");
        }   
        // TODO code application logic here
    }
    
}
