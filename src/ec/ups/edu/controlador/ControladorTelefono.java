/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.dao.TelefonoDAOImpl;
import ec.ups.edu.dao.UsuarioDAOImpl;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import ec.ups.edu.vista.VistaTelefono;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class ControladorTelefono {
    
    private VistaTelefono vistaT;
    private Telefono telefono;
    private TelefonoDAOImpl telefonoDao;

    public ControladorTelefono(VistaTelefono vistaT, TelefonoDAOImpl telefonoDao) {
        this.vistaT = vistaT;
        this.telefonoDao = telefonoDao;
    }
    
    public int menu(){
        int menu = vistaT.menuEditarTelefonoUsuario();
        
        return menu;
    }
    
    
    public void registrar(Usuario usuario){
        telefono = vistaT.ingresarTelefono();
        telefonoDao.createTelefono(telefono);
        /*
        Usuario usuario2 =usuarioDao.read(usuario.getCedula());
        usuario2.agregarTelefono(telefono);
        usuarioDao.update(usuario2);
*/
    }
    
    public void verTelefono(){
        int id = vistaT.pedirCodigo();
        telefono = telefonoDao.readTelefono(id);
        vistaT.imprimirTelfono(telefono);
        
    }
    
    public void actualizarTelefono(){
        int id = vistaT.pedirCodigo();
        telefonoDao.readTelefono(id);
        vistaT.imprimirTelfono(telefono);
        telefono = vistaT.telefonoEditado();
        telefonoDao.updateTelefono(telefono, id);
        
        
    }
    
    public void eliminarTelefono(){
        int id = vistaT.pedirCodigo();
        telefono = telefonoDao.readTelefono(id);
        vistaT.imprimirTelfono(telefono);
        telefonoDao.deleteTelefono(id);
        
    }
    
    
    public void verTelefonos(){
        List<Telefono> telefonos;
        telefonos = telefonoDao.findAll();
        vistaT.imprimirTodosTelefonos(telefonos);
                
    }
    
    public void salir(){
        String frase = "\nSe ha cerrado sesion.\n";
        vistaT.imprimirFrase(frase);
    }
}
