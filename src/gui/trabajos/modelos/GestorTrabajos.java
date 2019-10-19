/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.areas.modelos.Area;
import gui.interfaces.IGestorTrabajos;
import gui.personas.modelos.Profesor;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Grupo G9
 */
public class GestorTrabajos implements IGestorTrabajos {

    private ArrayList<Trabajo> listaTrabajos = new ArrayList<>();
    private static GestorTrabajos gestor;//Variable de clase

    //Constructor privado
    private GestorTrabajos() {
    }

    /**
     * Metodo para crear una unica instacia de GestorTrabajos
     *
     * @return GestorTrabajos - la instancia creada
     */
    public static GestorTrabajos instanciar() {
        if (gestor == null) {
            gestor = new GestorTrabajos();
        }
        return gestor;
    }

    /**
     *
     * @param titulos
     * @param duracion
     * @param fechaPresentacion
     * @param fechaAprobacion
     * @param areas
     * @param ret
     * @param aet
     * @return
     */
    @Override
    public String nuevoTrabajo(String titulos, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, ArrayList<Area> areas, ArrayList<RolEnTrabajo> ret, ArrayList<AlumnoEnTrabajo> aet) {
        if (titulos == null || titulos.trim().isEmpty()) {
            return ERROR;
        }
        if (duracion <= 0) {
            return ERROR;
        }
        if (fechaPresentacion == null) {
            return ERROR;
        }
        if (fechaAprobacion != null) {
            if (!fechaAprobacion.isEqual(fechaPresentacion) && fechaAprobacion.isBefore(fechaPresentacion)) {
                return ERROR;
            }
        }
        if (areas == null || areas.isEmpty()) {
            return ERROR;
        }
        if (aet == null || aet.isEmpty() || aet.size() <= 0) {
            return ERROR;
        }
        if (ret == null || ret.isEmpty() || ret.size() < 4) {
            return ERROR;
        }

        Profesor tutor = obtenerTutor(ret);
        Profesor cotutor = obtenerCotutor(ret);
        ArrayList<Profesor> jurado = obtenerJurado(ret);

        if (tutor == null) {
            return ERROR;
        }
        if (!validarTutorYCotutor(tutor, cotutor)) {
            return ERROR;
        }
        if (!validarJurado(jurado)) {
            return ERROR;
        }
        if (elProfesorEsJurado(cotutor, jurado) || elProfesorEsJurado(tutor, jurado)) {
            return ERROR;
        }

        Trabajo unTrabajo = new Trabajo(titulos, areas, duracion, fechaPresentacion, fechaAprobacion, aet, ret);
        if (!listaTrabajos.contains(unTrabajo)) {
            listaTrabajos.add(unTrabajo);
            return EXITO;
        } else {
            return DUPLICIDAD;
        }
    }

    /**
     * Busca si hay un Trabajo con el filtro especificado, sino devuelvenull
     *
     * @param titulo filtro ingresado
     * @return Trabajo - el trabajo encontrado o null (si no se encuentra uno)
     */
    @Override
    public Trabajo dameTrabajo(String titulo) { //Asumo que el titulo de filtro no es nulo, por lo tanto no controlo si es nulo o no
        for (Trabajo t : listaTrabajos) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Busca si existen trabajos que contengan el filtro especificado. Devuelve
     * el resultado en una lista, si no hay coincidencias devuelve una lista
     * vacia
     *
     * @param titulo filtro ingresado
     * @return ArrayList - un ArrayList con las coincidencias encontradas o un
     * ArrayList vacio
     */
    @Override
    public ArrayList<Trabajo> buscarTrabajos(String titulo) { //Controlo que el titlo no sea nulo. ¿Por que?
        ArrayList<Trabajo> trabajos = new ArrayList<>();
        if (titulo != null && !titulo.trim().isEmpty()) {
            for (Trabajo t : listaTrabajos) {
                if (t.getTitulo().equalsIgnoreCase(titulo)) {
                    trabajos.add(t);
                }
            }
        }
        return trabajos;
    }

    /**
     * Muestra todos los trabajos creados
     */
    @Override
    public void mostrarTrabajos() {
        System.out.println("\n\n\n");
        System.out.print("**********LISTA TRABAJOS**********");
        for (Trabajo t : listaTrabajos) {
            t.mostrar();
        }
    }

    
    ////******************METODOS AUXILIARES**********************////
    /**
     * Devuelve el profesor tutor Si no hay profesores o ninguno es tutor,
     * devuelve null
     *
     * @param listaRolEnTrabajo lista de porfesores que actuan como tutor,
     * cotutor(si hubiara) y jurado
     * @return Profesor - profesor tutor o null
     */
    public Profesor obtenerTutor(ArrayList<RolEnTrabajo> listaRolEnTrabajo) {
        RolEnTrabajo tutor = new RolEnTrabajo();
        int ban = 0;
        if (!listaRolEnTrabajo.isEmpty()) {
            for (RolEnTrabajo p : listaRolEnTrabajo) {
                if (p.getUnRol().equals(Rol.TUTOR)) {
                    tutor = p;
                    ban++;
                }
            }
            if (ban == 1)// Compruebo que hay almenos y solamente un tutor sino sale del if y devuelve null
            {
                return tutor.getUnProfesor();
            }
        }

        return null;
    }

    /**
     * Devuelve el profesor cotutor Si no hay profesores o ninguno es cotutor,d
     * evuelve null
     *
     * @param listaRolEnTrabajo lista de profesores que actuan como tutor,
     * cotutor(si hubiera) y jurado
     * @return Profesor - profesor coutor o null
     */
    public Profesor obtenerCotutor(ArrayList<RolEnTrabajo> listaRolEnTrabajo) {
        RolEnTrabajo cotutor = new RolEnTrabajo();   //Variable donde guardo la informacion si es que hay un cotuor
        int ban = 0;                                 //Bandera para ver si hay un solo tutor o ninguno         
        if (!listaRolEnTrabajo.isEmpty()) {
            for (RolEnTrabajo p : listaRolEnTrabajo) {
                if (p.getUnRol().equals(Rol.COTUTOR)) {
                    cotutor = p;
                    ban++;
                }
            }
            if (ban == 1)// Compruebo que hay almenos y solamente un tutor sino sale del if y devuelve null
            {
                return cotutor.getUnProfesor();
            }
        }

        return null;
    }

    /**
     * Devuelve la lista con el jurado del trabajo
     *
     * @param listaRolEnTrabajo lista de profesores que actuan como tutor,
     * cotutor(si hubiera) y jurado
     * @return ArrayList - lista con el jurado del trabajo
     */
    public ArrayList<Profesor> obtenerJurado(ArrayList<RolEnTrabajo> listaRolEnTrabajo) {
        ArrayList<Profesor> listaJurado = new ArrayList<>();
        for (RolEnTrabajo p : listaRolEnTrabajo) {
            if (p.getUnRol().equals(Rol.JURADO)) {
                listaJurado.add(p.getUnProfesor());
            }
        }
        return listaJurado;
    }

    /**
     * Determina si el profesor especificado forma parte del jurado
     *
     * @param unProfesor profesor del trabajo
     * @param listaJurado jurado del trabajo
     * @return boolena - true si el profesor forma parte del jurado, falso en
     * caso contrario
     */
    public boolean elProfesorEsJurado(Profesor unProfesor, ArrayList<Profesor> listaJurado) {
        if (listaJurado.contains(unProfesor)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida que en casi de tener cotutor, el mismo sea distino al tutor
     *
     * @param tutor tutor del trabajo
     * @param cotutor cotutor del trabajo (puede ser null)
     * @return boolean - si hay un cotutor y es distinto del tutor, devuelve true, o false en caso contrario. Si no hay cotutor devuelve true
     */
    public boolean validarTutorYCotutor(Profesor tutor, Profesor cotutor) {
        if(cotutor == null)
            return true;
//        if (!tutor.equals(cotutor) || cotutor == null) {
//            return true;
//        } else {
//            return false;
//        }
        return !tutor.equals(cotutor);
    }

    /**
     * Determina si sel jurado esta compuesto por 3 profesores distintos
     * @param listaJurado jurado del trabajo
     * @return boolean - true si el jurado esta integrado por 3 profesore distinos, false en caso contrario
     */
    public boolean validarJurado(ArrayList<Profesor> listaJurado) {
        int ban1;
        int ban2 = 0;
        int ban3 = listaJurado.size(); //Cuanto que no tenga mas de 3 Profesores

        for (Profesor p1 : listaJurado) {
            ban1 = 0;         //Reinicio la bandera para ver si p1 se repite en la lista
            for (Profesor p2 : listaJurado) {
                if (p1.equals(p2)) {
                    ban1++;
                }
                if (ban1 > 1) {
                    ban2 = 1;
                }
            }
        }
        if (ban2 == 0 && ban3 == 3) {
            return true;
        } else {
            return false;
        }
    }

}
