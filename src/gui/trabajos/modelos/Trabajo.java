
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.areas.modelos.Area;
import gui.personas.modelos.Profesor;
import gui.seminarios.modelos.Seminario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Grupo G9
 */
public class Trabajo {
    private String titulo;
    private ArrayList<Area> listAreas;
    private int duracion;
    private LocalDate fechaPresentacion;
    private LocalDate fechaAprobacion;
    private LocalDate fechaExposicion;
    private ArrayList<AlumnoEnTrabajo>  listAlumnoEnTrabajo;
    private ArrayList<RolEnTrabajo> listRolEnTrabajo;
    private ArrayList<Seminario> listSeminario= new ArrayList<>();

    //// <editor-fold defaultstate="collapsed" desc="Constructores">    
    //Constructor de trabajo para el TP5
    public Trabajo(String titulo, ArrayList<Area> listAreas, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, LocalDate fechaExposicion, ArrayList<RolEnTrabajo> listRolEnTrabajo, ArrayList<AlumnoEnTrabajo> listAlumnoEnTrabajo) {
        this.titulo = titulo;
        this.listAreas = listAreas;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaExposicion = fechaExposicion;
        this.listAlumnoEnTrabajo = listAlumnoEnTrabajo;
        this.listRolEnTrabajo = listRolEnTrabajo;
    }
    
    public Trabajo(String titulo, ArrayList<Area> listAreas, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, ArrayList<AlumnoEnTrabajo> listAlumnoEnTrabajo, ArrayList<RolEnTrabajo> listRolEnTrabajo) {
        this.titulo = titulo;
        this.listAreas = listAreas;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaAprobacion = fechaAprobacion;
        this.listAlumnoEnTrabajo = listAlumnoEnTrabajo;
        this.listRolEnTrabajo = listRolEnTrabajo;
    }

    //Constructor para el main entregado
    public Trabajo(String titulo, ArrayList<Area> listAreas, int duracion, LocalDate fechaPresentacion, ArrayList<AlumnoEnTrabajo> listAlumnoEnTrabajo, ArrayList<RolEnTrabajo> listRolEnTrabajo) {
        this.titulo = titulo;
        this.listAreas = listAreas;
        this.duracion = duracion;
        this.fechaPresentacion = fechaPresentacion;
        this.listAlumnoEnTrabajo = listAlumnoEnTrabajo;
        this.listRolEnTrabajo = listRolEnTrabajo;
    }


//</editor-fold>      
   
    //// <editor-fold defaultstate="collapsed" desc="Metodos GET y SET">    
 
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
//</editor-fold>      
    
    //// <editor-fold defaultstate="collapsed" desc="HashCode, Equals  y ToString">    
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
        return "Titulo: " + titulo + "\nAreas: " + listAreas + "\nDuracion: " + duracion + "\nFecha de Presentacion: " + fechaPresentacion + "\nFecha de Aprobacion: " + fechaAprobacion + "\nAlumnos:\n-------------------------\n" + listAlumnoEnTrabajo + ", listRolEnTrabajo=" + listRolEnTrabajo + ", listSeminario=" + listSeminario + '}';
    }
    
    //</editor-fold>   

    //**********METODOS**********//   
    public String agregarProfeosr(Profesor unProfesor, LocalDate fechaDesde, Rol unRol){
        return "hola";
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
    
    /**
     * Metodo para mostrar la informacion de un Trabajo
     */
    public void mostrar(){
        int bandera1=1;         //
        int bandera2=1;         //Banderas que utilizo para mostrar un mensaje una sola vez
        int bandera3=1;         //
        
        //Formateo la fecha para mostrarla en la fomra dd/mm/aaaa
        DateTimeFormatter patron=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaPreFormateada= this.fechaPresentacion.format(patron);
        String fechaAprobFormateada=this.fechaAprobacion!=null ? this.fechaAprobacion.format(patron):"";
        
        System.out.println("\n\n");
        System.out.println("Titulo: "+titulo);
        System.out.println("Duracion: "+duracion+" meses");
        System.out.println("Fecha Presentacion: "+fechaPreFormateada);
        if(fechaAprobacion!=null)//Cuando se crea un trabajo la fechaAprobacion puede ser nula
            System.out.println("Fecha Aprobacion: "+fechaAprobFormateada);
        else
            System.out.println("Fecha Aprobacion: -");
        if(listSeminario!=null && !listSeminario.isEmpty()){//Si la lista de seminarios esta vacia no la muestro
            System.out.println("\nSeminarios");
            System.out.println("-------------------------------");
        }
        for(Seminario s:listSeminario){
            s.mostrar();
        }
        System.out.println("\nAlumnos");
        System.out.println("-------------------------------");
        for(AlumnoEnTrabajo a: listAlumnoEnTrabajo){
                a.mostrarAlumno();
        }
        System.out.println("");
          
        for(RolEnTrabajo p:listRolEnTrabajo){ //Uso 3 "for" diferentes para mostrar los elementos correspondientes en la lista
                if(p.getUnRol().equals(Rol.TUTOR)){
                    if(bandera1==1){
                        System.out.println("Tutor");
                        System.out.println("-------------------------------");
                        bandera1=0;
                    }
                    p.mostrarProfesorEnRol();
                }
          }
        for(RolEnTrabajo p:listRolEnTrabajo){
              if(p.getUnRol().equals(Rol.COTUTOR)){
                  if(bandera2==1){
                      System.out.println("\nCotutor");
                      System.out.println("-------------------------------");
                      bandera2=0;
                  }
                  p.mostrarProfesorEnRol();
              }
          }
        for(RolEnTrabajo p:listRolEnTrabajo){
              if(p.getUnRol().equals(Rol.JURADO)){
                  if(bandera3==1){
                      System.out.println("\nJurado");
                      System.out.println("-------------------------------");
                      bandera3=0;
                  }
                  p.mostrarProfesorEnRol();
              }
          }
        System.out.println("\n\n");        
    }
 
}
