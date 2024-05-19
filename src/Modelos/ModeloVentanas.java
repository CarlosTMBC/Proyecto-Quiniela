/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author carlt
 */

public class ModeloVentanas {
    public List<JFrame> ventanasAbiertas = new ArrayList<>();

    public void ObtenerVentanas(JFrame frame) {
        ventanasAbiertas.add(frame);
    }
    public void CerrarVentanas(JFrame frame) {
        frame.dispose();
        ventanasAbiertas.remove(frame);
    }

    // Método adicional para cerrar todas las ventanas
    public void CerrarTodasLasVentanas() {
        for (JFrame frame : new ArrayList<>(ventanasAbiertas)) {
            frame.dispose();
            ventanasAbiertas.remove(frame);
        }
}
}