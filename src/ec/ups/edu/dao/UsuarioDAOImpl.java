/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.IUsuarioDAO;
import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class UsuarioDAOImpl implements IUsuarioDAO {

    private Map<String, Usuario> listaUsuarios;

    public UsuarioDAOImpl() {
        listaUsuarios = new HashMap<String, Usuario>();

    }

    //@Override
    @Override
    public void create(Usuario usuario) {
        listaUsuarios.put(usuario.getCedula(), usuario);
    }

    // @Override
    @Override
    public Usuario read(String cedula) {
        Iterator it = listaUsuarios.keySet().iterator();
        while (it.hasNext()) {
            Usuario usuario = (Usuario) it.next();
            if (usuario.getCedula().equals(cedula)) {
                return usuario;

            }
        }
        return null;
    }

    //@Override
    @Override
    public void update(Usuario usuario) {
        Iterator it = listaUsuarios.keySet().iterator();
        while (it.hasNext()) {
            Usuario usuario2 = (Usuario) it.next();
            if (usuario2.getCedula().equals(usuario)) {
                listaUsuarios.replace(usuario.getCedula(), usuario, usuario2);
                break;
            }
        }

    }

    //@Override
    @Override
    public void delete(Usuario usuario) {
        Iterator it = listaUsuarios.keySet().iterator();
        while (it.hasNext()) {
            Usuario usuario2 = (Usuario) it.next();
            if (usuario2.getCedula().equals(usuario)) {
                listaUsuarios.remove(usuario.getCedula());
                break;
            }
        }
    }

    

    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
        
        for (Map.Entry<String, Usuario> usuario:listaUsuarios.entrySet()){
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            if(valor.getCorreo().equals(correo)){
                if(valor.getContraseña().equals(contraseña)){
                    String frase = "sesion iniciada";
                    Usuario usu = new Usuario();
                    usu = listaUsuarios.get(key);
                    return usu;
                }
            }
            
        }
        
        return null;
    }

    public Map<Integer,Telefono> agregarTelefono(Usuario usuario, Telefono telefono){
        Map<Integer, Telefono> telefonos=new HashMap<Integer, Telefono>();
        
        telefonos = usuario.getTelefonos();
        
        telefonos.put(telefono.getCodigo(), telefono);
        
        usuario.setTelefonos(telefonos);
        
        
        return telefonos;
    }
    
    
    
    
    
    @Override
    public Map<String, Usuario> llamarUsuarios() {
        return listaUsuarios;
    }
}
