/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

/**
 *
 * @author gabinete
 */
public class Profesor extends Persona{
    private Cargo unCargo;

    public Profesor(String apellidos, String nombres,int dni, Cargo unCargo) {
        super(apellidos,nombres,dni);
        this.unCargo = unCargo;
    }

    public Cargo getUnCargo() {
        return unCargo;
    }

    public void setUnCargo(Cargo unCargo) {
        this.unCargo = unCargo;
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println(" - "+ unCargo );
    }

    @Override
    public String toString() {
        return super.toString() +" - Cargo: "+unCargo;
    }
  
}
