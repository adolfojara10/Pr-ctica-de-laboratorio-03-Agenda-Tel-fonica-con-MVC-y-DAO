/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.idao;

import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import java.util.*;

/**
 * Interface IUsuarioDAO.
 * 
 * Es la interface de los metodos que van a ser implementados en la clase 
 * IUsuarioDAOImpl.
 * 
 * @author Adolfo
 */
public interface IUsuarioDAO {
    /**
     * metodo create.
     * 
     * este recibe un usuario ya creado y lo añade al diccionario de usuarios.
     * @param usuario 
     */
    public void create(Usuario usuario);

    /**
     *  metodo read.
     * 
     * este metodo recibe un parametro de tipo String que es llamado cedula,
     * pero que puede ser una cedula o un correo electronico. Este parametro
     * nos sirve para encontrar el usuario y devolver un objeto de tipo Uusuario.
     * 
     * @param cedula
     * @return Usuario
     */
    public Usuario read(String cedula);

    /**
     *  metodo update.
     * 
     * este metodo recibe un objeto de tipo usuario y lo reemplza por uno ya
     * existente.
     * @param usuario 
     */
    public void update(Usuario usuario);

    /**
     *  metodo delete.
     * 
     * este metodo elimina un usuario ya creado. Recibe el usuario y lo busca y
     * luego lo elimina.
     * @param usuario 
     */
    public void delete(Usuario usuario);

    /**
     * metodo iniciarSesion.
     * 
     * este metodo recibe el correo y la contraseña digitadas por un usuario que 
     * desea inicar sesion de su cuenta. estos dos parametros compara con los
     * parametros de todos los clientes y una vez que los encuentra devuelve
     * el usuario encontrado.
     * @param correo
     * @param contraseña
     * @return Usuario
     */
    public Usuario iniciarSesion(String correo, String contraseña);

    /**
     * metodo agregarTelefono.
     * 
     * este metodo es usado cuando el usuario inicia Sesion. Una vez hecho eso,
     * el usuario podra agregar numero de telefono a su cuenta. Recibe como
     * parametro el usuario que inicio sesion y un telefono ya creado y lo 
     * añade al diccionario de telefonos del usuario. Devuelve un el diccionario
     * de telefonos para imprimir al usuario sus nuevos numeros telefonicos.
     * @param usuario
     * @param telefono
     * @return Map<Integer, Telefono>
     */
    public Map<Integer, Telefono> agregarTelefono(Usuario usuario, Telefono telefono);

    /**
     * metodo readTelefono.
     * 
     * este metodo es el encargado de recibir al usuario que inicio sesion y el 
     * codigo de uno de sus telefonos. Busca el telefono del usuario y lo devuelve
     * para su futura impresion.
     * @param usuario
     * @param codigo
     * @return Telefono
     */
    public Telefono readTelefono(Usuario usuario, int codigo);

    /**
     * metodo agregarTelefonoEditado.
     * 
     * este metodo es el encargado de recibir el usuario que ya ha iniciado sesion,
     * el telefono ya creado, y el codigo del telefono antiguo. En el telefono
     * antiguo se borra y luego se añade el nuevo telefono que tiene diferentes
     * datos. Devuelve el nuevo diccionario de telefonos del usuario. 
     * @param usuario
     * @param telefono
     * @param codigo
     * @return Map<Integer, Telefono>
     */
    public Map<Integer, Telefono> agregarTelefonoEditado(Usuario usuario,
            Telefono telefono, int codigo);

    /**
     * metodo eliminarTelefono.
     * 
     * este metodo recibe al usuario que ha iniciado sesion, y al codigo del 
     * telefono que va a hacer eliminado. Borra el telefono y devuelve el nuevo
     * diccionario del usuario.
     * @param usuario
     * @param codigo
     * @return Map<Integer, Telefono>
     */
    public Map<Integer, Telefono> eliminarTelefono(Usuario usuario, int codigo);

    /**
     * metodo llamarUsuarios.
     * 
     * este metodo solamente envia el diccionario de todos los usuarios
     * 
     * @return Map<String, Usuario>
     */
    public Map<String, Usuario> llamarUsuarios();

}
