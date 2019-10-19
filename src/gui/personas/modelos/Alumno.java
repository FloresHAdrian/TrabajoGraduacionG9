/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import java.util.Objects;

/**
 *
 * @author Grupo G9
 */
public class Alumno extends Persona{
    private String cx; 
       
    ////<editor-fold defaultstate="collapsed" desc="Constructor">
    public Alumno(String apellidos,String nombre, int dni, String cx){
        super(apellidos,nombre,dni);
        this.cx=cx;
    }
    //</editor-fold>

    ////<editor-fold defaultstate="collapsed" desc="Metodos Get-Set">
    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }
//</editor-fold>

    ////<editor-fold defaultstate="collapsed" desc="HashCode, Equals, ToString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.cx);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Alumno other = (Alumno) obj;
            if (!Objects.equals(this.cx, other.cx)) {
                return false;
            }
        }
        return true;
    }
   
    @Override
    public String toString() {
        return super.toString() + " - CX:"+cx ;
    }
    
    //</editor-fold>
    
    /**
     * Metodo para mostrar el alumno
     */
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.print(" - CX:"+cx+"\n");
    }
}

