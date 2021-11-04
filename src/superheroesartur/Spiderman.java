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
public class Spiderman extends Heroe {

    private boolean poderAracnido;

    public boolean getpoderAracnido() {
        return poderAracnido;
    }

    public void setpoderAracnido(boolean poderAracnido) {
        this.poderAracnido = poderAracnido;
    }

    public Spiderman(String nombre, String apodo, int edad) {
        super(nombre, apodo, edad);
        setpoderAracnido(false);
    }

    public double calcularPoderAracnido() {
        if (poderAracnido) {
            return 10;
        } else {
            return 2;
        }
    }

    @Override
    public void mostrarinformacion() {
        super.mostrarinformacion();
        if (getpoderAracnido()) {
            System.out.println("Poder arácnido: True");
        } else {
            System.out.println("Poder arácnido: False");
        }
    }

    @Override
    public double calcularPotencial() {
        System.out.println("Ejecutando calcularpotencial de tipo Spiderman");
        return super.calcularPotencial() * calcularPoderAracnido();
    }
}
