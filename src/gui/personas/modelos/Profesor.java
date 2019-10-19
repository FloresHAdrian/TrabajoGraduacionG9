/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

/**
 *
 * @author Grupo G9
 */
public class Profesor extends Persona{
    private Cargo unCargo;

    ////<editor-fold defaultstate="collapsed" desc="Constructores">
    public Profesor(String apellidos, String nombres,int dni, Cargo unCargo) {
        super(apellidos,nombres,dni);
        this.unCargo = unCargo;
    }
    //</editor-fold>

    ////<editor-fold defaultstate="collapsed" desc="Metodos Get-Set">
    public Cargo getUnCargo() {
        return unCargo;
    }

    public void setUnCargo(Cargo unCargo) {
        this.unCargo = unCargo;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        return super.toString() +" - Cargo: "+unCargo;
    }
    
    /**
     * Metodo para mostrar el profesor
     */
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println(" - "+ unCargo );
    }
  
}
