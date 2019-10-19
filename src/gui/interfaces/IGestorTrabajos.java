/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.areas.modelos.Area;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public interface IGestorTrabajos {

    String EXITO = "Se creo el trabajo correctamente";
    String DUPLICIDAD = "No se agrego el trabajo, porque ya esta en la lista";
    String ERROR = "No se pudo crear el trabajo, verifique los datos";

    public String nuevoTrabajo(String titulos, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, ArrayList<Area> areas, ArrayList<RolEnTrabajo> ret, ArrayList<AlumnoEnTrabajo> aet);

    public Trabajo dameTrabajo(String titulo);

    public ArrayList<Trabajo> buscarTrabajos(String titulo);

    public void mostrarTrabajos();
}
