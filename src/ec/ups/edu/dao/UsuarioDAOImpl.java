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
 * Clase UsuarioDAOImpl.
 *
 * Esta clase implementa todos los metodos declarados en la Interface
 * IUsuaioDAO. Esta clase es la encargada de darle usos a esos metodos de
 * distintas formas. Ademas aqui se crea un diccionario de personas.
 *
 * @see IUsuarioDao
 * @author Adolfo
 */
public class UsuarioDAOImpl implements IUsuarioDAO {

    //instancia de un diccionario privado de usuarios
    private Map<String, Usuario> listaUsuarios;

    /**
     * metodo constructor UsuarioDAOImpl.
     *
     * sirve para la instancia de undiccionari ode tipo HashMap. La key va a ser
     * un String y el value sera un Usuario.
     */
    public UsuarioDAOImpl() {
        listaUsuarios = new HashMap<String, Usuario>();
    }

    /**
     * metodo create.
     *
     * Es la sobreescritura del metodo de la Interface. este recibe un usuario
     * ya creado y lo añade al diccionario de usuarios.
     *
     * @param usuario
     */
    //@Override
    @Override
    public void create(Usuario usuario) {
        //se añade el usuario al diccionario
        listaUsuarios.put(usuario.getCedula(), usuario);
    }

    /**
     * metodo read.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo recibe un
     * parametro de tipo String que es llamado cedula, pero que puede ser una
     * cedula o un correo electronico. Este parametro nos sirve para encontrar
     * el usuario y devolver un objeto de tipo Uusuario.
     *
     * @param cedula
     * @return Usuario
     */
    // @Override
    @Override
    public Usuario read(String cedula) {
        //bucle for each para buscar el usuario
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            //se compara la cedula o el correo
            if (valor.getCedula().equals(cedula)
                    || (valor.getCorreo().equals(cedula))) {
                //se obtiene el usuario con el key
                Usuario usuario2 = listaUsuarios.get(key);
                return usuario2;
            }

        }
        return null;
    }

    /**
     * metodo update.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo recibe un
     * objeto de tipo usuario y lo reemplza por uno ya existente.
     *
     * @param usuario
     */
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

    /**
     * metodo delete.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo elimina un
     * usuario ya creado. Recibe el usuario y lo busca y luego lo elimina.
     *
     * @param usuario
     */
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

    /**
     * metodo iniciarSesion.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo recibe el
     * correo y la contraseña digitadas por un usuario que desea inicar sesion
     * de su cuenta. estos dos parametros compara con los parametros de todos
     * los clientes y una vez que los encuentra devuelve el usuario encontrado.
     *
     * @param correo
     * @param contraseña
     * @return Usuario
     */
    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
        //bucle for each para recorrer los usuarios
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            //compara primero el correo
            if (valor.getCorreo().equals(correo)) {
                //si el correo es igual, compara la contraseña
                if (valor.getContraseña().equals(contraseña)) {
                    Usuario usu = new Usuario();
                    usu = listaUsuarios.get(key);
                    return usu;
                }
            }

        }

        return null;
    }

    /**
     * metodo agregarTelefono.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo es usado
     * cuando el usuario inicia Sesion. Una vez hecho eso, el usuario podra
     * agregar numero de telefono a su cuenta. Recibe como parametro el usuario
     * que inicio sesion y un telefono ya creado y lo añade al diccionario de
     * telefonos del usuario. Devuelve un el diccionario de telefonos para
     * imprimir al usuario sus nuevos numeros telefonicos.
     *
     * @param usuario
     * @param telefono
     * @return Map<Integer, Telefono>
     */
    @Override
    public Map<Integer, Telefono> agregarTelefono(Usuario usuario, Telefono telefono) {
        //se crea un diccionario de telefonos para enviarle al usuario
        Map<Integer, Telefono> telefonos = new HashMap<Integer, Telefono>();
        //se obtienen los telefonos del usuario
        telefonos = usuario.getTelefonos();
        //se agrega el telefono
        telefonos.put(telefono.getCodigo(), telefono);
        //se agrega el diccionario al usuario
        usuario.setTelefonos(telefonos);

        return telefonos;
    }

    /**
     * metodo readTelefono.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo es el
     * encargado de recibir al usuario que inicio sesion y el codigo de uno de
     * sus telefonos. Busca el telefono del usuario y lo devuelve para su futura
     * impresion.
     *
     * @param usuario
     * @param codigo
     * @return Telefono
     */
    @Override
    public Telefono readTelefono(Usuario usuario, int codigo) {

        Map<Integer, Telefono> telefonos = new HashMap<Integer, Telefono>();
        telefonos = usuario.getTelefonos();

        for (Map.Entry<Integer, Telefono> telefono2 : telefonos.entrySet()) {

            if (telefono2.getKey().equals(codigo)) {

                Telefono telefono3 = new Telefono();
                int key = telefono2.getKey();
                //obtencion del telefono
                telefono3 = telefonos.get(key);
                return telefono3;

            }
        }

        return null;
    }

    /**
     * metodo agregarTelefonoEditado.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo es el
     * encargado de recibir el usuario que ya ha iniciado sesion, el telefono ya
     * creado, y el codigo del telefono antiguo. En el telefono antiguo se borra
     * y luego se añade el nuevo telefono que tiene diferentes datos. Devuelve
     * el nuevo diccionario de telefonos del usuario.
     *
     * @param usuario
     * @param telefono
     * @param codigo
     * @return Map<Integer, Telefono>
     */
    @Override
    public Map<Integer, Telefono> agregarTelefonoEditado(Usuario usuario,
            Telefono telefono, int codigo) {

        Map<Integer, Telefono> telefonos = new HashMap<Integer, Telefono>();

        telefonos = usuario.getTelefonos();
        //se elimina el telefono que tiene es codigo
        telefonos.remove(codigo);
        //se agrega el telefono nuevo
        telefonos.put(telefono.getCodigo(), telefono);

        usuario.setTelefonos(telefonos);

        return telefonos;
    }

    /**
     * metodo eliminarTelefono.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo recibe al
     * usuario que ha iniciado sesion, y al codigo del telefono que va a hacer
     * eliminado. Borra el telefono y devuelve el nuevo diccionario del usuario.
     *
     * @param usuario
     * @param codigo
     * @return Map<Integer, Telefono>
     */
    @Override
    public Map<Integer, Telefono> eliminarTelefono(Usuario usuario, int codigo) {

        Map<Integer, Telefono> telefonos = new HashMap<Integer, Telefono>();

        telefonos = usuario.getTelefonos();

        telefonos.remove(codigo);

        usuario.setTelefonos(telefonos);

        return telefonos;
    }

    /**
     * metodo llamarUsuarios.
     *
     * este metodo solamente envia el diccionario de todos los usuarios
     *
     * @return Map<String, Usuario>
     */
    @Override
    public Map<String, Usuario> llamarUsuarios() {
        return listaUsuarios;
    }
}
