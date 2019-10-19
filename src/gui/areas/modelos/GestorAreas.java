/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.modelos;

import gui.interfaces.IGestorAreas;
import java.util.ArrayList;

/**
 *
 * @author Grupo G9
 */
public class GestorAreas implements IGestorAreas {

    ArrayList<Area> listaAreas = new ArrayList<>();
    private static GestorAreas gestor;//Variable de clase

    //Constructor privado
    private GestorAreas() {
    }

    /**
     * Metodo de clase para crear una unica instancia de GestorAreas
     * @return GestorAreas - instancia unica creada
     */
    public static GestorAreas instanciar() {
        if (gestor == null) {
            gestor = new GestorAreas();
        }
        return gestor;
    }

    /**
     * Crea una nueva Area y la agrega a la lista siempre y cuando: el nombre no
     * sea nullo ni vacio no se encuantra ya en la lista
     *
     * @param nombre nombre del area
     * @return String - cadena que informa si se pudo crear o no el Area o si ya
     * se encontraba en la lista
     */
    @Override
    public String nuevaArea(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            Area area = new Area(nombre);
            if (!this.listaAreas.contains(area)) {
                this.listaAreas.add(area);
                return EXITO;
            } else//Ya existe un area con ese nombre
            {
                return DUPLICADOS;
            }
        } else//Nombre del area vacio o nulo
        {
            return ERROR;
        }
    }

    /**
     * Muestra todas las areas agregadas al ArrayList
     */
    @Override
    public void mostrarAreas() {
        System.out.println("\n\n********Lista Areas********");
        for (Area a : listaAreas) {
            System.out.println(a);
        }
    }

    /**
     * Busca si existe un Area cuyo nombre coincida con el filtro especificado
     *
     * @param nombre filtro especificado
     * @return Area - un area si se encuentra en la lista sino null
     */
    @Override
    public Area dameArea(String nombre) {
        for (Area a : listaAreas) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Busca si existe Areas cuyo nombre contenga el filtro especificado o si el
     * filtro es null regresa toda la lista
     *
     * @param nombre filtro especificado
     * @return ArrayList - un ArrayList de areas segun el filtro 
     */
    @Override
    public ArrayList<Area> buscarAreas(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            ArrayList<Area> areas = new ArrayList<>();
            for (Area a : listaAreas) {
                if (a.getNombre().compareToIgnoreCase(nombre) == 0) {
                    areas.add(a);
                }
            }
            return areas;
        } else {
            return listaAreas;
        }

    }

}
