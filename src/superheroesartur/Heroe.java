/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superheroesartur;

import java.util.ArrayList;

/**
 *
 * @author arturv
 */
public class Heroe {
    private String nombre;
    private String apodo;
    private int edad;
    private String poderes[];
    
    public Heroe(String nombre, String apodo, int edad)
    {
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        poderes = new String[4];
    }
    
    public void quitapoderes()
    {
        poderes = new String[4];
    }
    
    public String getnombre()
    {
        return nombre;
    }
    
    public String getapodo()
    {
        return apodo;
    }
    
    public int getedad()
    {
        return edad;
    }
     
    public void setnombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setapodo(String apodo)
    {
        this.apodo=apodo;
    }
    
    public void setedad(int edad)
    {
        this.edad = edad;
    }
    
    public void setpoder(String poder, int posicion)
    {
        poderes[posicion] = poder;
    }
    
    public void showPoderes()
    {
        for(String poder:poderes)
        {
            if(poder!=null)
            {
                System.out.println(poder);
            }
        }
    }
    
    public double calcularPotencial()
    {
        return edad*30;
    }
    
    public void mostrarinformacion()
    {
          System.out.println("Nombre:" + getnombre());
          System.out.println("Apodo:" +getapodo());
          System.out.println("Edad:" + getedad());
          System.out.println("Poderes:");
          showPoderes();
    }
}
