/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seminarios.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Seminario {
    private LocalDate fechaExposicion;
    private String observaciones;
    private NotaAprobacion nota;

    public Seminario(LocalDate fechaExposicion, NotaAprobacion nota, String observaciones) {
        this.fechaExposicion = fechaExposicion;
        this.observaciones = observaciones;
        this.nota = nota;
    }

    public LocalDate getFechaExposicion() {
        return fechaExposicion;
    }

    public void setFechaExposicion(LocalDate fechaExposicion) {
        this.fechaExposicion = fechaExposicion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public NotaAprobacion getNota() {
        return nota;
    }

    public void setNota(NotaAprobacion nota) {
        this.nota = nota;
    }
    
    
    public void mostrar(){
        //Formateo la fecha para presentarla en pantalla de la forma dd/mm/aaaa
        String patron="dd/MM/yyyy";
        String fechaExpoFormateada= this.fechaExposicion!=null ? this.fechaExposicion.format(DateTimeFormatter.ofPattern(patron)):"";
        
        //Como se que se agrega un seminario con una fecha  y nota, asumno que no son null, por lo tanto no hago ese control     
        System.out.println("Fecha de Exposicion:"+fechaExpoFormateada);   
        if(nota==NotaAprobacion.APROBADO_CO || nota==NotaAprobacion.APROBADO_SINOBS)//Como lo dos son aprobado muestro solo mensaje
            System.out.println("Nota: Aprobado  ");
        if(nota==NotaAprobacion.DESAPROBADO)
            System.out.println("Nota: Desaprobado");         
        if(observaciones!=null)
            System.out.println("Observaciones: "+observaciones);
        else
            System.out.println("Observaciones: -");         
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.fechaExposicion);
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
        final Seminario other = (Seminario) obj;
        if (!Objects.equals(this.fechaExposicion, other.fechaExposicion)) {
            return false;
        }
        return true;
    }

       
    @Override
    public String toString() {
        return "Seminario{" + "fechaExposicion=" + fechaExposicion + ", observaciones=" + observaciones + ", nota=" + nota + '}';
    }
    
    
}