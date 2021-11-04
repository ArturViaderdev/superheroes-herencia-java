/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superheroesartur;

/**
 *
 * @author arturv
 */
public class Hulk extends Heroe{
    private double peso;
    
    public double getpeso()
    {
        return peso;
    }
    
    public void setpeso(double peso)
    {
        this.peso = peso;
    }
    
    public Hulk(String nombre, String apodo, int edad, double peso)
    {
        super(nombre,apodo,edad);
        setpeso(peso);
    }
    
    @Override
    public void mostrarinformacion()
    {
        super.mostrarinformacion();
        System.out.println("Peso:" + getpeso());
    }
    
    @Override
    public double calcularPotencial()
    {
        System.out.println("Ejecutando calcularPotencial del tipo Hulk");
        return super.calcularPotencial() * peso;
    }
}
