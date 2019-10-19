/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.interfaces.IGestorAlumnosEnTrabajos;
import gui.personas.modelos.Alumno;
import java.time.LocalDate;

/**
 *
 * @author Grupo G9
 */
public class GestorAlumnoEnTrabajos implements IGestorAlumnosEnTrabajos {

//    private ArrayList<AlumnoEnTrabajo> aet= new ArrayList<>();
    private static GestorAlumnoEnTrabajos gestor;//Variable de clase

    //Constructor Privado
    private GestorAlumnoEnTrabajos() {

    }

    /**
     * Metodo de clase para crear una unica instancia de GestorAlumnoEnTrabajo
     *
     * @return intanca creada o ya existente
     */
    public static GestorAlumnoEnTrabajos instanciar() {
        if (gestor == null) {
            gestor = new GestorAlumnoEnTrabajos();
        }
        return gestor;
    }

    /**
     * Crea un nuevo AlumnoEnTrabajo siempre que fechaDesde no sea nula unAlumno
     * no sea nulo
     *
     * @param fechaDesde fecha en la que el alumno empezo a trabajar en el
     * Trabajo
     * @param unAlumno Alumno del Trabajo
     * @return AlumnoEnTrabajo - un nuevo AlumnoEnTrabajo (si se crea), sino
     * null
     */
    @Override
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno) {
        if (fechaDesde != null && unAlumno != null) {
            System.out.println("Se creo el AlumnoEnTrabajo");
            return new AlumnoEnTrabajo(fechaDesde, unAlumno);
        }
        System.out.println("No se pudo crear el AlumnoEnTrabajo");
        return null;
    }

}
