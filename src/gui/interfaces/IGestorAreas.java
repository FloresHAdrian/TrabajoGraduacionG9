/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfaces;

import gui.areas.modelos.Area;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public interface IGestorAreas {
    String EXITO = "Area creada correctamente";
    String ERROR = "No se pudo crear, verifique los datos";
    String DUPLICADOS = "Ya existe un area con ese nombre";
    
    
    public String nuevaArea(String nombre);
    
    public void mostrarAreas();
    
    public Area dameArea(String nombre);
    
    public ArrayList<Area> buscarAreas(String nombre);

}

