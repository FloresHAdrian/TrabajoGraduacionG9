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
public abstract class Persona {
    private String apellido;
    private String nombre;
    private int dni;

    ////<editor-fold defaultstate="collapsed" desc="Constructor">
    public Persona(String apellido, String nombre, int dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }
    //</editor-fold>
    
    ////<editor-fold defaultstate="collapsed" desc="Metodos Get-Set">
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    //</editor-fold>
    
    ////<editor-fold defaultstate="Collapsed" desc="HashCode, Equals, ToString">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.dni;
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+dni+"] - "+apellido+", "+nombre;
    }
    //</editor-fold>
    
    /**
     * Metodo para mostrar los datos de la persona
     */
    public void mostrar(){
        System.out.print("["+dni+"] - "+apellido+", "+nombre);
    }
}
