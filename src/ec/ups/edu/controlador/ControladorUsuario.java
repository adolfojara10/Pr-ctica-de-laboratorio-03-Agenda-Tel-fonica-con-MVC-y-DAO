/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.dao.UsuarioDAOImpl;
import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.vista.VistaUsuario;

/**
 *
 * @author Adolfo
 */
public class ControladorUsuario {
    
    private Usuario usuario2;
    private VistaUsuario vista;
    private UsuarioDAOImpl usuarioDaoImpl;

    public ControladorUsuario(VistaUsuario vista) {
        this.vista = vista;
        this.usuarioDaoImpl=new UsuarioDAOImpl();
    }
    
    public void registrar(){
        usuario2 = vista.crearUsuario();
        usuarioDaoImpl.create(usuario2);
    }
    
    
    
}
