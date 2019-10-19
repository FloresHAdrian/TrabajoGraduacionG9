/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.personas.modelos.Alumno;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.Profesor;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public interface IGestorPersonas {

    String EXITO = "Persona creada correctamente";
    String DUPLICIDAD = "Ya existe esta Persona con esos datos";
    String ERROR = "No se pudo crear, verifique los datos";

    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo);

    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx);

    public ArrayList<Profesor> buscarProfesores(String apellidos);

    public ArrayList<Alumno> buscarAlumnos(String apellidos);

    public Profesor dameProfesor(int documento);

    public Alumno dameAlumno(String cx);

    public void mostrarPersonas();

    public void mostrarAlumnos();

    public void mostrarProfesores();
}
