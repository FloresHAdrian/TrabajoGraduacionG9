/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.trabajos.modelos;

import gui.interfaces.IGestorRolesEnTrabajos;
import gui.personas.modelos.Profesor;
import java.time.LocalDate;

/**
 *
 * @author Grupo G9
 */
public class GestorRolEnTrabajo implements IGestorRolesEnTrabajos {
//    private ArrayList<RolEnTrabajo> listaRolEnTrabajos;

    private static GestorRolEnTrabajo gestor;//Varible de clase

    //Constructor privado
    private GestorRolEnTrabajo() {
    }

    /**
     * Metodo de clase para crear una unica instancia de GestorRolEnTrabajo
     *
     * @return
     */
    public static GestorRolEnTrabajo instanciar() {
        if (gestor == null) {
            gestor = new GestorRolEnTrabajo();
        }
        return gestor;
    }

    @Override
    public RolEnTrabajo nuevoRolEnTrabajo(Profesor unProfesor, Rol unRol, LocalDate fechaDesde) {
        if (unProfesor != null && unRol != null && fechaDesde != null) {
            System.out.println("Se creo el RolEnTrabajo");
            return new RolEnTrabajo(fechaDesde, unProfesor, unRol);
        }
        System.out.println("No se creo el RolEnTrabajo");
        return null;
    }

}
