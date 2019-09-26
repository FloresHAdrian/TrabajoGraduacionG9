
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.areas.modelos.Area;
import gui.seminarios.modelos.Seminario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Adrian
 */
public class Trabajo {
    private String titulo;
    private ArrayList<Area> listAreas;
    private int duracion;
    private LocalDate fechaPresentacion;
    private LocalDate fechaAprobacion;
    private LocalDate fechaFinalizacion;
    private LocalDate fechaExposicion;
    private ArrayList<AlumnoEnTrabajo>  listAlumnoEnTrabajo;
    private ArrayList<RolEnTrabajo> listRolEnTrabajo;
    private ArrayList<Seminario> listSeminario= new ArrayList<>();


    //Constructor para el main entregado
    public Trabajo(String titulo, ArrayList<Area> listAreas, int duracion, LocalDate fechaPresentacion, ArrayList<AlumnoEnTrabajo> listAlumnoEnTrabajo, ArrayList<RolEnTrabajo> listRolEnTrabajo) {
        this.titulo = titulo;
        this.listAreas = listAreas;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.listAlumnoEnTrabajo = listAlumnoEnTrabajo;
        this.listRolEnTrabajo = listRolEnTrabajo;
    }

    //Constructor sin la fecha de presentacion para el TP4
    public Trabajo(String titulo, ArrayList<Area> listAreas, int duracion, LocalDate fechaAprobacion, LocalDate fechaFinalizacion, LocalDate fechaExposicion, ArrayList<AlumnoEnTrabajo> listAlumnoEnTrabajo, ArrayList<RolEnTrabajo> listRolEnTrabajo) {
        this.titulo = titulo;
        this.listAreas = listAreas;
        this.duracion = duracion;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaFinalizacion = fechaFinalizacion;
        this.fechaExposicion = fechaExposicion;
        this.listAlumnoEnTrabajo = listAlumnoEnTrabajo;
        this.listRolEnTrabajo = listRolEnTrabajo;
    }
   
 
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Area> getAreas() {
        return listAreas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.listAreas = areas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public LocalDate getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public ArrayList<AlumnoEnTrabajo> getListAlumnoEnTrabajo() {
        return listAlumnoEnTrabajo;
    }

    public void setListAlumnoEnTrabajo(ArrayList<AlumnoEnTrabajo> listAlumnoEnTrabajo) {
        this.listAlumnoEnTrabajo = listAlumnoEnTrabajo;
    }

    public ArrayList<RolEnTrabajo> getListRolEnTrabajo() {
        return listRolEnTrabajo;
    }

    public void setListRolEnTrabajo(ArrayList<RolEnTrabajo> listRolEnTrabajo) {
        this.listRolEnTrabajo = listRolEnTrabajo;
    }

    public ArrayList<Seminario> getListSeminario() {
        return listSeminario;
    }

    public void setListSeminario(ArrayList<Seminario> listSeminario) {
        this.listSeminario = listSeminario;
    }
    
    public ArrayList<Area> getListAreas() {
        return listAreas;
    }

    public void setListAreas(ArrayList<Area> listAreas) {
        this.listAreas = listAreas;
    }

    public LocalDate getFechaExposicion() {
        return fechaExposicion;
    }

    public void setFechaExposicion(LocalDate fechaExposicion) {
        this.fechaExposicion = fechaExposicion;
    }
        
    //Metodo para agregar un RolEnTrabajo a la lista de roles, y mostrar por pantalla si se agrego o no
    public String agregarProfesor(RolEnTrabajo unRolEnTrabajo){    
        if(!listRolEnTrabajo.contains(unRolEnTrabajo)){
            listRolEnTrabajo.add(unRolEnTrabajo);
            return "Si se pudo agregar el profesor al rol";
        }
        else
            return "No se pudo agregar el profesor al rol";
    }
    
    //Metodo para agregar un seminario si es que no se repite
    public void agregarSeminario(Seminario unSeminario){
        if(!listSeminario.contains(unSeminario))            
            listSeminario.add(unSeminario);
    }
    
    //Metodo para mostrar 
    public void mostrar(){
        int bandera1=1;         //
        int bandera2=1;         //Banderas que ultilizo para mostrar un mensaje una sola vez
        int bandera3=1;         //
        Rol rol1=Rol.TUTOR;     ////
        Rol rol2=Rol.COTUTOR;   //// Valores de instancia que uso para comparar
        Rol rol3=Rol.JURADO;    ////
        
        //Formateo la fecha para mostrarla en la fomra dd/mm/aaaa
        String patron="dd/MM/yyyy";
        String fechaPreFormateada= this.fechaPresentacion!=null ? this.fechaPresentacion.format(DateTimeFormatter.ofPattern(patron)):"";
        String fechaAprobFormateada=this.fechaAprobacion!=null ? this.fechaAprobacion.format(DateTimeFormatter.ofPattern(patron)):"";
//        String fechaFinFormateada= this.fechaFinalizacion!=null ? this.fechaFinalizacion.format(DateTimeFormatter.ofPattern(patron)):"";        
        
        System.out.println("\n\n");
        System.out.println("Titulo: "+titulo);
        System.out.println("Duracion: "+duracion+" meses");
//        System.out.println("Fecha Exposicion: "+fechaFinalizacion);
        System.out.println("Fecha Presentacion: "+fechaPreFormateada);
        if(fechaAprobacion!=null)
            System.out.println("Fecha Aprobacion: "+fechaAprobFormateada);
        else
            System.out.println("Fecha Aprobacion: -");
        if(!listSeminario.isEmpty()){//Si la lista de seminarios esta vacia no la muestro
            System.out.println("\nSeminarios");
            System.out.println("-------------------------------");
        }
        for(Seminario s:listSeminario){
            s.mostrar();
        }
        System.out.println("");
        System.out.println("Alumnos");
        System.out.println("-------------------------------");
        for(AlumnoEnTrabajo a: listAlumnoEnTrabajo){
            a.mostrarAlumno();
        }
        System.out.println("");  
        for(RolEnTrabajo p:listRolEnTrabajo){ //Uso 3 "for" diferentes para mostrar los elementos correspondientes en la lista
              if(p.getUnRol()==rol1){
                  if(bandera1==1){
                      System.out.println("Tutor");
                      System.out.println("-------------------------------");
                      bandera1=0;
                  }
                  p.mostrarProfesorEnRol();
              }
          }
        for(RolEnTrabajo p:listRolEnTrabajo){
              if(p.getUnRol()==rol2){
                  if(bandera2==1){
                      System.out.println("");
                      System.out.println("Cotutor");
                      System.out.println("-------------------------------");
                      bandera2=0;
                  }
                  p.mostrarProfesorEnRol();
              }
          }
        for(RolEnTrabajo p:listRolEnTrabajo){
              if(p.getUnRol()==rol3){
                  if(bandera3==1){
                      System.out.println("");
                      System.out.println("Jurado");
                      System.out.println("-------------------------------");
                      bandera3=0;
                  }
                  p.mostrarProfesorEnRol();
              }
          }
        System.out.println("\n\n");
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.titulo);
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
        final Trabajo other = (Trabajo) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }
   
    @Override
    public String toString() {
        return "Trabajo{" + "titulo=" + titulo + ", listAreas=" + listAreas + ", duracion=" + duracion + ", fechaPresentacion=" + fechaPresentacion + ", fechaAprobacion=" + fechaAprobacion + ", fechaFinalizacion=" + fechaFinalizacion + ", listAlumnoEnTrabajo=" + listAlumnoEnTrabajo + ", listRolEnTrabajo=" + listRolEnTrabajo + ", listSeminario=" + listSeminario + '}';
    }

   
}
