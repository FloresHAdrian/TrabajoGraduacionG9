/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.personas.modelos.Profesor;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Grupo G9
 */
public class RolEnTrabajo {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private String razon;
    private Profesor unProfesor;
    private Rol unRol;
     
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public RolEnTrabajo(LocalDate fechaDesde, Profesor unProfesor, Rol unRol) {
        this.fechaDesde = fechaDesde;
        this.unProfesor = unProfesor;
        this.unRol = unRol;
    }
    
    public RolEnTrabajo() {
    }
//</editor-fold>
 
    //<editor-fold defaultstate="collapsed" desc="Metodos Get-Set">
    public LocalDate getFechaDesde() {
        return fechaDesde;
    }
    
    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    
    public LocalDate getFechaHasta() {
        return fechaHasta;
    }
    
    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    public String getRazon() {
        return razon;
    }
    
    public void setRazon(String razon) {
        this.razon = razon;
    }
    
    public Profesor getUnProfesor() {
        return unProfesor;
    }
    
    public void setUnProfesor(Profesor unProfesor) {
        this.unProfesor = unProfesor;
    }
    
    public Rol getUnRol() {
        return unRol;
    }
    
    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="HashCode, Equals, ToString">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.unProfesor);
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
        final RolEnTrabajo other = (RolEnTrabajo) obj;
        if (!Objects.equals(this.unProfesor, other.unProfesor)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "RolEnTrabajo{" + "fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", razon=" + razon + ", unProfesor=" + unProfesor + ", unRol=" + unRol + '}';
    }
//</editor-fold>//Tengo que acomodar el ToString

    /**
     * Metodo para agregar un profesor con un rol, en el trabajo
     * @param fecha fecha en la que el profesor empezo en el trabajo
     * @param unRol rol que tiene el profesor en el trabajo
     * @param unProfesor profesor que agrega al trabajo
     */
    public void agregarProfesorEnRol(LocalDate fecha,Rol unRol,Profesor unProfesor){
        this.setFechaDesde(fecha);
        this.setUnRol(unRol);
        this.setUnProfesor(unProfesor);
    }
    
    /**
     * Metodo para mostrar los datos del profesor en el trabajo
     */
    public void mostrarProfesorEnRol(){
        this.unProfesor.mostrar();
    }
}
