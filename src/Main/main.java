
package Main;

import Controlador.Controlador;
import Modelos.*;
import Vistas.*;

/*@author carlos */
public class main {

    public static void main(String[] args) {
        
        //Vistas de Programa
        frmLogin VistaPrincipal = new frmLogin();
        frmCuentas VistaCuentas = new frmCuentas();
        frmRegistro VistaRegistrar = new frmRegistro();
        frmAdministrador VistaAdministrador = new frmAdministrador();
        frmCrearJornadas VistaCrearJornadas = new frmCrearJornadas();
        frmResultados VistaResultados = new frmResultados();
        frmJornadas VistaJornadas = new frmJornadas();
        frmUsuario VistaUsuario = new frmUsuario();
        frmQuiniela VistaQuiniela = new frmQuiniela();
        frmResultadosQuiniela VistaResultadosQuiniela = new frmResultadosQuiniela();
        frmBoletin VistaBoletin = new frmBoletin();
        ModeloResultadosA modeloResultados = new ModeloResultadosA();
        
        

        //Modelos de Programa
        ModeloParticipantes modeloParticipantes = new ModeloParticipantes();
        ModeloEquipos modeloEquipos = new ModeloEquipos(); 
        ModeloQuiniela modeloQuiniela = new ModeloQuiniela();
        ModeloJornada modeloJornada = new ModeloJornada();
        ModeloBoletin modeloBoletin = new ModeloBoletin();
        GestorPass GestorCuentas = new GestorPass();
        Controlador controlador = new Controlador(VistaPrincipal,VistaCuentas,
        VistaRegistrar, VistaAdministrador, VistaCrearJornadas, VistaResultados,
        VistaJornadas,  VistaQuiniela, VistaUsuario, VistaResultadosQuiniela,VistaBoletin, modeloParticipantes, modeloEquipos, 
        modeloQuiniela, modeloJornada,modeloResultados,modeloBoletin,GestorCuentas);
    }
    
}
