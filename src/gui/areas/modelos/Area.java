/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.modelos;

import java.util.Objects;

/**
 *
 * @author Grupo G9
 */
public class Area {
    private String nombre;

    public Area(String nombre) {
        this.nombre = nombre;
    }
    
    
    ////<editor-fold defaultstate="collapsed" desc="Metodos Get-Set" >   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="HashCode, Equals, ToString">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Area other = (Area) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Area: "+ nombre ;
    }
//</editor-fold>
 
    /**
     * Metodo para mostrar el nombre del area
     */
    public void mostrar(){
        System.out.println("\tArea: "+nombre);
    }
}
