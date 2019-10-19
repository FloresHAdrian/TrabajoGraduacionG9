/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import gui.interfaces.IGestorPersonas;
import java.util.ArrayList;

/**
 *
 * @author Grupo G9
 */
public class GestorPersonas implements IGestorPersonas {

    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private static GestorPersonas gestor;//Variable de clase

    //Constructor privado
    private GestorPersonas() {
    }

    /**
     * Metodo de clase para crear una unica instancia de GestorPersonas
     * @return GestorPersona - instancia creada
     */
    public static GestorPersonas instanciar() {
        if (gestor == null) {
            gestor = new GestorPersonas();
        }
        return gestor;
    }

    /**
     * Crea una nuevo Profesor y lo agrega a la lista siempre y cuando: los
     * apellidos no sean nulos ni vacios los nombre no sean nulos ni vacios el
     * dni sea mayor a cero el cargo no sea nulo no exista otro igual en la
     * lista
     *
     * @param apellidos apellidos de profesor
     * @param nombres nombres del profesor
     * @param dni dni del profesor
     * @param cargo cargo del profesor
     * @return String - cadena que informa si se pudo crear o no el Profesor o
     * si ya estaba en la lista
     */
    @Override
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo) {
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return ERROR;
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            return ERROR;
        }
        if (cargo == null || dni <= 0) {
            return ERROR;
        }

        Persona profesor = new Profesor(apellidos, nombres, dni, cargo);
        if (!this.listaPersonas.contains(profesor)) {
            this.listaPersonas.add(profesor);
            return EXITO;
        } else {
            return DUPLICIDAD;
        }
    }

    /**
     * Crea un nuevo Alumno y lo agrega a la lista siempre que: los apellidos no
     * sean nulos ni vacios los nombres no sean nulos ni vacios el dni sea mayor
     * a cero el cx no sea nulo no exista otro igual en la lista
     *
     * @param apellidos
     * @param nombres
     * @param dni
     * @param cx
     * @return String - cadena informando si se pudo crear o no el Alumno o si
     * ya existia en la lista
     */
    @Override
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx) {
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return ERROR;
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            return ERROR;
        }
        if (dni <= 0 || cx == null || cx.trim().isEmpty()) {
            return ERROR;
        }

        Persona alumno = new Alumno(apellidos, nombres, dni, cx);
        if (!this.listaPersonas.contains(alumno)) {
            this.listaPersonas.add(alumno);
            return EXITO;
        } else {
            return DUPLICIDAD;
        }
    }

    /**
     * Busca si existen profesores cuyo apellido contenga el filtro especificado
     *
     * @param apellidos cadena de filtro
     * @return ArrayList - devuelve un ArrayList de profesores que coincidan con
     * el filtro y si no los hay devuelve una lista vacia
     */
    @Override
    public ArrayList<Profesor> buscarProfesores(String apellidos) {
        ArrayList<Profesor> profesores = new ArrayList<>();
        if (apellidos != null && !apellidos.trim().isEmpty()) {
            for (Persona p : listaPersonas) {
                if (p instanceof Profesor) {
                    if (p.getApellido().compareToIgnoreCase(apellidos) == 0) 
                        profesores.add((Profesor) p);
                }
            }         
        }
        return profesores;
    }

    /**
     * Busca si existen alumnos cuyo apellidos contenga el filtro especificado
     *
     * @param apellidos cadena del filtro
     * @return ArrayList - devuelve un ArrayList de profesores que coinciden con
     * el filtro y si no los hay devuelve una lista vacia
     */
    @Override
    public ArrayList<Alumno> buscarAlumnos(String apellidos) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        if (apellidos != null && !apellidos.trim().isEmpty()) {
            for (Persona p : listaPersonas) {
                if (p instanceof Alumno) {
                    if (p.getApellido().equalsIgnoreCase(apellidos)) {
                        alumnos.add((Alumno) p);
                    }
                }
            }
        }
        return alumnos;
    }

    /**
     * Busca si existe un profesor cuyo documento coincida con el filtro
     * especificado
     *
     * @param documento filtro ingresado
     * @return Profesor - un Profesor( si hay coincidencia) o null (si no hay
     * coincidencia)
     */
    @Override
    public Profesor dameProfesor(int documento) {
        if (documento > 0) {
            for (Persona a : listaPersonas) {
                if (a instanceof Profesor) {
                    if (a.getDni() == documento) {
                        return (Profesor) a;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Busca si existe un alumno cuyo documento coincida con el filtro
     * espeficado
     *
     * @param cx filtro ingresado
     * @return Alumno - un Alumno (si hay coincidencia) o null (si no hay
     * coincidencia)
     */
    @Override
    public Alumno dameAlumno(String cx) {
        if (cx != null && !cx.trim().isEmpty()) {
            for (Persona a : listaPersonas) {
                if (a instanceof Alumno) {
                    if (((Alumno) a).getCx().equals(cx)) {
                        return (Alumno) a;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Mustra todas las personas de la lista
     */
    @Override
    public void mostrarPersonas() {
        System.out.println("\n\n********Lista Personas********");
        for (Persona a : listaPersonas) {
            System.out.println(a);
        }
    }

    /**
     * Muestra todas las personas que son Alumnos de la lista
     */
    @Override
    public void mostrarAlumnos() {
        System.out.println("\n\n********Lista Alumnos********");
        for (Persona a : listaPersonas) {
            if (a instanceof Alumno) {
                System.out.println(a);
            }
        }
    }

    /**
     * Muestra todas las personas que son Profesores de la lista
     */
    @Override
    public void mostrarProfesores() {
        System.out.println("\n\n********Lista Profesores********");
        for (Persona a : listaPersonas) {
            if (a instanceof Profesor) {
                System.out.println(a);
            }
        }
    }

}
