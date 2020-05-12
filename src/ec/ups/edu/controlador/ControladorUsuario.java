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
import ec.ups.edu.vista.VistaUsuario;
import java.util.*;

/**
 * clase ControladorUsuario.
 *
 * esta clase es la encargada de comunicarse tanto con la clase VistaUsuario y
 * la clase UsuarioDAOImpl. Llama a los distintos metodos de estas clases, por
 * se crean un objeto de cada clase dicha. Ademas se crea un objeto de la clase
 * Usuario.
 *
 * @see UsuarioDAOImpl
 * @see VistUsuario
 * @see Usuario
 * @author Adolfo
 */
public class ControladorUsuario {

    //declaracion de los objetos
    private Usuario usuario2;
    private Telefono telefono2;
    
    private VistaUsuario vistaU;
    private VistaTelefono vistaT;
    
    private UsuarioDAOImpl usuarioDaoImpl;
    private TelefonoDAOImpl telefonoDaoImpl;
    

    /**
     * metodo constructor ControladorUsuario.este metodo recibe un parametro de
     * tipo VistaUsuario, y lo setea.Ademas 
     * se instancia un objeto de tipo UsuarioDAOImpl.
     *
     *
     * @param vistaU
     * @param vistaT
     * @param usuarioDaoImpl
     * @param telefonoDAOImpl
     */
    public ControladorUsuario(VistaUsuario vistaU, VistaTelefono vistaT, UsuarioDAOImpl usuarioDaoImpl, TelefonoDAOImpl telefonoDaoImpl) {    
        this.vistaU = vistaU;
        this.vistaT = vistaT;
        this.usuarioDaoImpl = usuarioDaoImpl;
        this.telefonoDaoImpl = telefonoDaoImpl;
    }

    /**
     * metodo menu.
     *
     * este metodo llama al metodo de la clase VistaUsuario el cual envia un
     * parametro de tipo int que es recibido. una vez recibido este parametro,
     * devuelve el entero.
     *
     * @return opcionMenu
     */
    public int menu() {
        int opcionMenu = vistaU.menu();
        return opcionMenu;
    }

    /**
     * metodo registrar.
     *
     * este metodo es el encargado de llamar a la clase VistaUsuario y su metodo
     * crearUsuario y recibe un objeto de tipo Usuario. Este objeto recibido es
     * enviado al metodo create de UsuarioDAOImpl.
     */
    public void registrar() {
        usuario2 = vistaU.crearUsuario();
        usuarioDaoImpl.create(usuario2);
    }

    /**
     * metodo iniciarSesion.
     *
     * este metodo es el encargado de iniciar sesion de un usuario ya creado. Si
     * no envia un mensaje de usuario no encontrado. primero llama a los metodos
     * de la VistaUsuario par obtener la contraseña y correo de la persona que
     * quiere iniciar sesion. una vez hecho eso se mandan estos datos al
     * UsuarioDAOImpl y al metodo read, para que me devuevla un usuario. Luego
     * hay un condicional en caso de que haya encontrado el usuario. Se crea un
     * menu interno para la diferente aplicaionde metodos para agregar, editar,
     * eliminar un telefono del usuario.
     */
    public void iniciarSesion() {

        //se obtienen los datos de contraseña y correo
        String correo = vistaU.iniciarSesionCorreo();
        String contraseña = vistaU.iniciarSesionContraseña();

        //se envian los datos y se recibe una persona
        usuario2 = usuarioDaoImpl.iniciarSesion(correo, contraseña);

        //condicional
        if (usuario2 != null) {

            //se imprime el usuario
            vistaU.imprimirUsuario(usuario2);
            int opcionSesion = 0;
            //inicio del menu
            while (opcionSesion != 4) {
                //se obtiene el entero encargado de trabajar con el menu
                opcionSesion = vista.menuEditarTelefonoUsuario();
                switch (opcionSesion) {
                    case 1:
                        //se recibe un telefono que es creado en VistaUsuario
                        Telefono telefono = vista.ingresarTelefono();

                        //se envia el telefono y usuario para actualizarlos
                        usuarioDaoImpl.agregarTelefono(usuario2, telefono);

                        //se imprime los telefonos del usuario
                        vista.imprimirTelefonos(usuario2);
                        break;

                    case 2:

                        //se recibe un entero el cual es pedido por VistaUsuario
                        int codigo = vista.editarTelefono();

                        //se recibe un telefono del metodo read telefono, y se envian
                        //el usuario que inicio sesion y el codigo del telefono a editar
                        Telefono telefono2 = usuarioDaoImpl.readTelefono(usuario2,
                                codigo);

                        if (telefono2 != null) {

                            //se imprime el telefono a editar
                            vista.imprimirTelfono(telefono2);

                            //revibe el nuevo telefono que va a reemplazar al anterior
                            telefono2 = vista.telefonoEditado();

                            //se envia el usuario que inicio sesion, el telefono nuevo
                            //y el codigo del telefono antiguo
                            usuarioDaoImpl.agregarTelefonoEditado(usuario2, telefono2,
                                    codigo);

                            //imprime los nuevos telefonos del usuario
                            vista.imprimirTelefonos(usuario2);
                        } else {
                            //en caso que no encontro el telfono
                            String frase = "Codigo erroneo";

                            //para imprimir la frase
                            vista.frase(frase);
                        }
                        break;

                    case 3:

                        //para obtener el codigo del telefono a eliminar
                        int codigo2 = vista.editarTelefono();

                        //para recibir el telefono a eliminar
                        Telefono telefono3 = usuarioDaoImpl.readTelefono(usuario2,
                                codigo2);
                        if (telefono3 != null) {

                            //imprimir el telefono que va a ser eliminado
                            vista.imprimirTelfono(telefono3);

                            //para eliminar el telefono
                            usuarioDaoImpl.eliminarTelefono(usuario2, codigo2);

                            //imprime los nuevos telefonos
                            vista.imprimirTelefonos(usuario2);
                        } else {

                            //en caso de que no haya encontrado el telefono
                            String frase = "Codigo erroneo";

                            //se imprime la frase
                            vista.frase(frase);
                        }
                        break;

                    case 4:

                        //para cerrar sesion
                        String frase = "\nSesion cerrada\n";

                        //para imprimir la frase
                        vista.frase(frase);

                        break;

                    default:
                        String frase2 = "Error al digitar. Vuelva a digitar la "
                                + "accion que desea ejecutar";
                        vista.frase(frase2);

                        break;
                }

            }

        } else {
            String frase = "Datos incorrectos";
            vista.frase(frase);
        }

    }

    /**
     * metodo imprimirTelefonos.
     *
     * sirve para imprimir los telefonos de un usuario mediante la digitacion de
     * su correo o cedula.
     */
    public void imprimirTelefonos() {
        //se pide el correo o cedula
        String id = vista.pedirIdentificador();

        //se envia el id para recibir un objetode tipo Usuario
        usuario2 = usuarioDaoImpl.read(id);
        if (usuario2 != null) {

            //para imprimir los telefonos del objeto
            vista.imprimirTelefonos(usuario2);
        } else {

            //en caso de que no haya encontrado el usuario
            String frase = "Usuario no encontrado";
            vista.frase(frase);
        }

    }

    /**
     * metodo buscarUsuario.
     *
     * sirve para buscar un usuario e imprimir todos sus datos.
     */
    public void buscarUsuario() {

        //se pide el identificador del correo o cedula
        String id = vista.pedirIdentificador();

        //recibir un usuario mandando el id
        usuario2 = usuarioDaoImpl.read(id);
        if (usuario2 != null) {

            //imprime el usuario
            vista.imprimirUsuario(usuario2);
        } else {
            String frase = "Usuario no encontrado";
            vista.frase(frase);
        }
    }

    /**
     * metodo imprimirUsuarios.
     *
     * metodo encargado de imprimir todos los uduarios creados.
     */
    public void imprimirUsuarios() {

        //creacion de un diccionario de usuarios
        Map<String, Usuario> usuarios = new HashMap<>();

        //se recibe el diccionario de usuarios
        usuarios = usuarioDaoImpl.llamarUsuarios();

        //se imprimen los usuarios
        vista.imprimirUsuarios(usuarios);

    }

    /**
     * metodo salir.
     *
     * encargado de enviar un mensaje al usuario en caso de salir del programa.
     */
    public void salir() {

        //creacion de la frase a ser impresa
        String frase = "Usted ha salido del programa";

        //impresion de la frase
        vista.frase(frase);
    }

    /**
     * metodo numeroErroneo.
     *
     * metodo encargado de imprimir un mensaje en caso de uqe el usuario en el
     * menu haya digitado una opcion incorrecta.
     */
    public void numeroErroneo() {

        //creacion de la frase a ser impresa
        String frase = "Opcion incorrecta. Digite otra vez la opcion";

        //impresion de la frase
        vista.frase(frase);
    }

    private UsuarioDAOImpl usuarioDAOImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
