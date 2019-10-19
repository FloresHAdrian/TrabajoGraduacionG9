/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal.controladores;

import gui.areas.modelos.Area;
import gui.areas.modelos.GestorAreas;
import gui.personas.modelos.Alumno;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorPersonas;
import gui.personas.modelos.Profesor;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.GestorAlumnoEnTrabajos;
import gui.trabajos.modelos.GestorRolEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.Rol;
import gui.trabajos.modelos.RolEnTrabajo;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class Test {

    public static void main(String[] args) {
        //**************AREAS*****************//
        GestorAreas gsAreas = GestorAreas.instanciar();

        System.out.println(gsAreas.nuevaArea("Software"));
        System.out.println(gsAreas.nuevaArea("Hardware"));
        System.out.println(gsAreas.nuevaArea("Software"));//No la agrega, ya existe area con este nombre
        System.out.println(gsAreas.nuevaArea(""));//No lo crea, nombre vacio
        System.out.println(gsAreas.nuevaArea(null));//No lo crea,nombre nulo
        System.out.println(gsAreas.nuevaArea("SofTware"));
        
        gsAreas.mostrarAreas();

        System.out.println("\n\n");
        System.out.println(gsAreas.dameArea(null));
        System.out.println(gsAreas.dameArea("Software"));
        System.out.println(gsAreas.dameArea("Soft"));
        System.out.println(gsAreas.dameArea(""));
        

        ArrayList<Area> buscarArea;
        buscarArea = gsAreas.buscarAreas("software");
        if (buscarArea == null || buscarArea.isEmpty()) {
            System.out.println("\n\nNo se entoncontro nada");
        } else {
            for (Area a : buscarArea) {
//                System.out.println("\n\n");
                System.out.println(a);
            }
        }

        System.out.println("\n\n\n");
        //**************PERSONAS***************//
        GestorPersonas gsPersonas = GestorPersonas.instanciar();

        System.out.println(gsPersonas.nuevoProfesor("A1", "B1", 1, Cargo.ADG));
        System.out.println(gsPersonas.nuevoProfesor("R", "B2", 2, (Cargo) null)); //No deberia crearlo, cargo nulo
        System.out.println(gsPersonas.nuevoProfesor("A2", "B2", 2, Cargo.TITULAR));
        System.out.println(gsPersonas.nuevoProfesor("A3", "B3", 3, Cargo.EXTERNO));
        System.out.println(gsPersonas.nuevoProfesor("A4", "B4", 4, Cargo.ADJUNTO));
        System.out.println(gsPersonas.nuevoProfesor("A5", "B5", 5, Cargo.ADJUNTO));
        System.out.println(gsPersonas.nuevoProfesor("A6", "B6", 6, Cargo.ADG));

        System.out.println("\n\n");
        System.out.println(gsPersonas.nuevoAlumno("C1", "D1", 11, "1"));
        System.out.println(gsPersonas.nuevoAlumno("C2", "D2", 22, "2"));
        System.out.println(gsPersonas.nuevoAlumno("C2", "D2", 33, ""));//No deberia crearlo, cx vacio
        System.out.println(gsPersonas.nuevoAlumno("C3", "D3", 33, "3"));
        System.out.println(gsPersonas.nuevoAlumno("C3", "D3", 33, "4"));//No deberia agregarlo, ya hay alumno con mismo dni
        
        gsPersonas.mostrarPersonas();
        gsPersonas.mostrarProfesores();
        gsPersonas.mostrarAlumnos();
        
        System.out.println("\n\n");
        System.out.println(gsPersonas.dameAlumno("1"));
        System.out.println(gsPersonas.dameAlumno(""));
        System.out.println(gsPersonas.dameAlumno(null));
        System.out.println("");
        System.out.println(gsPersonas.dameProfesor(11));
        System.out.println(gsPersonas.dameProfesor(2));
        System.out.println(gsPersonas.dameProfesor(33));
        System.out.println(gsPersonas.dameProfesor(0));

        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();
        
        alumnos = gsPersonas.buscarAlumnos("C");
        profesores = gsPersonas.buscarProfesores("A1");
        
        System.out.println("\n\n");
        if(alumnos.isEmpty())
            System.out.println("No se encontro a ningun alumno con ese apellido");
        else{
        for(Alumno a: alumnos)
            System.out.println(a);
        }
        if(profesores.isEmpty())
            System.out.println("No se encontro a ningun profesor con ese apellido");
        else{
        for(Profesor a: profesores)
            System.out.println(a);
        } 
        
        
        
        
        //****************TRABAJOS*******************//
        GestorRolEnTrabajo gsRet= GestorRolEnTrabajo.instanciar();
        GestorAlumnoEnTrabajos gsAet= GestorAlumnoEnTrabajos.instanciar();
        
        LocalDate fecha1 = LocalDate.of(2019,10,10);
        LocalDate fecha2 = LocalDate.of(2019, 11, 15);
        LocalDate fecha3 = LocalDate.of(2019,11,20);
        LocalDate fecha4 = LocalDate.of(2019, 12, 5);
        
        ArrayList<RolEnTrabajo> ret = new ArrayList<>();
        ArrayList<AlumnoEnTrabajo> aet = new ArrayList<>();
        ArrayList<Area> areas = new ArrayList<>();
        
        areas.add(gsAreas.dameArea("Software"));
        
        System.out.println("\n\n");
        aet.add(gsAet.nuevoAlumnoEnTrabajo(fecha1, gsPersonas.dameAlumno("1")));
        gsAet.nuevoAlumnoEnTrabajo(fecha1, null);//No deber crearlo, alumno nulo
        gsAet.nuevoAlumnoEnTrabajo(null, null);//No deberia crearlo, argumentos nulos
        
        ret.add(gsRet.nuevoRolEnTrabajo(gsPersonas.dameProfesor(1), Rol.TUTOR, fecha1));
        ret.add(gsRet.nuevoRolEnTrabajo(gsPersonas.dameProfesor(2), Rol.COTUTOR, fecha1));
        ret.add(gsRet.nuevoRolEnTrabajo(gsPersonas.dameProfesor(6), Rol.JURADO, fecha2));
        ret.add(gsRet.nuevoRolEnTrabajo(gsPersonas.dameProfesor(3), Rol.JURADO, fecha2));
        ret.add(gsRet.nuevoRolEnTrabajo(gsPersonas.dameProfesor(4), Rol.JURADO, fecha2));
        
        GestorTrabajos gsTrabajo = GestorTrabajos.instanciar();
        
        System.out.println(gsTrabajo.nuevoTrabajo("Titulo", 2, fecha1,fecha1, areas, ret, aet));
        System.out.println(gsTrabajo.nuevoTrabajo("Redes", 2, fecha1,fecha3, areas, ret, aet));
        
        gsTrabajo.mostrarTrabajos();
        
//        System.out.println(gsTrabajo.dameTrabajo("Titulo"));
    }
}
