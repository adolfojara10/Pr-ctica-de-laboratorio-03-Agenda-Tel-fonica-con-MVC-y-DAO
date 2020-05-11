/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import java.util.*;

/**
 * clase VistaUsuario.
 *
 * Esta clase es la encargada de pedir los datos de las opciones de menu, cuando
 * se quiere crear un nuevo usuario, cuando se quiere iniciar sesion, de
 * imprimir los telefonos de un usuario, de imprimir un usuario, de imprimir
 * todos los usuarios creados, y de imprimir frases. Estos son enviados a otras
 * clases para su debido funcionamiento.
 *
 * @see ControladorUsuario
 * @author Adolfo
 */
public class VistaUsuario {

    //declaracion de un Scanner
    private Scanner entrada;

    /**
     * metodo constructor VistaUsuario.
     *
     * Es el encargado de instanciar un objeto de tipo Scanner.
     */
    public VistaUsuario() {
        entrada = new Scanner(System.in);

    }

    /**
     * metodo menu.
     *
     * es el encargado de imprimir las opciones del menu y de recibir un dato de
     * tipo entero que refleja la opcion que usuario desea ejecutar. Y por
     * ultimo devuelve ese numero.
     *
     * @return int
     */
    public int menu() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite el numero de accion que desea "
                + "ejecutar:\n" + "1.-Crear un nuevo usuario"
                + "\n2.-Iniciar sesion" + "\n3.-Imprimir telefonos de un usuario "
                + "un usuario" + "\n4.-Buscar un usuario" + "\n5.-Imprimir"
                + " todos los usuarios" + "\n6-Salir");
        int opcionMenu = entrada.nextInt();

        return opcionMenu;
    }

    /**
     * metodo crearUsuario.
     *
     * Es el metodo encargado de pedir todos los datos para crear un objeto de
     * tipo Usuario. Ademas se pregunta si se quieren añadir o no numeros de
     * telefono ese momento.
     *
     * @return Usuario
     */
    public Usuario crearUsuario() {
        entrada = new Scanner(System.in);

        System.out.println("\nCreación de un usuario: \n");
        System.out.println("Escriba la cédula del nuevo usuario: ");
        String cedula = entrada.next();
        System.out.println("Escriba el nombre del nuevo usuario: ");
        String nombre = entrada.next();
        System.out.println("Escriba el apellido del nuevo usuario: ");
        String apellido = entrada.next();
        System.out.println("Escriba el correo del nuevo usuario: ");
        String correo = entrada.next();
        System.out.println("Escriba la contraseña del nuevo usuario: ");
        String contraseña = entrada.next();

        System.out.println("¿Desea crear los número de teléfono del nuevo "
                + "usuario en este momento?\n 1.-Si desea crear los teléfonos"
                + " \n 2.-Si desea volver al menú");
        int opcion = entrada.nextInt();

        Map<Integer, Telefono> telefonos = new HashMap<Integer, Telefono>();

        while (opcion == 1) {
            System.out.println("\nInformación de los teléfonos:\n");
            System.out.println("Escriba el codigo: ");
            int codigo = entrada.nextInt();
            System.out.println("Escriba el número: ");
            String numero = entrada.next();
            System.out.println("Escriba el tipo de telédono: ");
            String tipo = entrada.next();
            System.out.println("Escriba la operadora: ");
            String operadora = entrada.next();

            Telefono telefono = new Telefono(codigo, numero, tipo, operadora);
            telefonos.put(codigo, telefono);

            System.out.println("¿Desea crear los número de teléfono del nuevo "
                    + "usuario en este momento?\n 1.-Si desea crear otro teléfono"
                    + " \n 2.-Si desea volver al menú");
            opcion = entrada.nextInt();

        }
        Usuario usuario = new Usuario(cedula, nombre, apellido, correo,
                contraseña, telefonos);

        System.out.println("Usuario creado:\n " + usuario.toString());
        return usuario;
    }

    /**
     * metodo iniciarSesionCorreo.
     *
     * es el metodo encargado de pedir un correo al usuario que desea inicar
     * sesion. Devuelve este valor que es de tipo String
     *
     * @return String
     */
    public String iniciarSesionCorreo() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su correo: ");
        String correo = entrada.next();

        return correo;

    }

    /**
     * metodo iniciarSesionContraseña.
     *
     * metodo encargado de pedir la contraseña al usuario que quiere iniciar
     * sesion. Y por ultimo devuelve la contraseña que es de tipo String.
     *
     * @return String
     */
    public String iniciarSesionContraseña() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su contraseña: ");
        String contraseña = entrada.next();

        return contraseña;
    }

    /**
     * metodo menuEditarTelefonoUsuario.
     *
     * Una vez que el usuario ha iniciado sesion, tendra acceso a editar un
     * telefono suyo ya creado, agregar uno nuevo, elminar un telfono o colver
     * al menu. Lo que hace es recibir un numero que es la opcion y lo devuelve.
     *
     * @return int
     */
    public int menuEditarTelefonoUsuario() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite la opcion que desea realizar:\n"
                + "1.-Ingresar un nuevo numero" + "\n2.-Editar un telefono"
                + "\n3.-Eliminar un telefono" + "\n4.-Cerrar sesion y volver al "
                + "menu");
        int opcionSesion = entrada.nextInt();

        return opcionSesion;
    }

    /**
     * metodo ingresarTelefono.
     *
     * este metodo es el encargado de pedir los datos de un nuevo telefono y
     * crearlo. una vez hecho eso, devuelve el telefono ya creado.
     *
     * @return Telefono
     */
    public Telefono ingresarTelefono() {
        entrada = new Scanner(System.in);

        System.out.println("\nIngreso de telefono: ");
        System.out.println("Ingrese el codigo: ");
        int codigo = entrada.nextInt();
        System.out.println("Ingrese el numero: ");
        String numero = entrada.next();
        System.out.println("Ingrese el tipo: ");
        String tipo = entrada.next();
        System.out.println("Ingrese la operadora: ");
        String operadora = entrada.next();

        Telefono telefono = new Telefono(codigo, numero, tipo, operadora);

        return telefono;

    }

    /**
     * menu editarTelefono.
     *
     * este metodo es el encargado de enviar el codigo del telefono que desea
     * ser editado.
     *
     * @return int
     */
    public int editarTelefono() {
        entrada = new Scanner(System.in);

        System.out.println("Ingrese el codigo del telefono: ");
        int codigo = entrada.nextInt();

        return codigo;
    }

    /**
     * metodo telefonoEditado.
     *
     * pide los datos de un telefono que va a reemplazar a uno antiguo y lo
     * envia.
     *
     * @return Telefono
     */
    public Telefono telefonoEditado() {
        entrada = new Scanner(System.in);

        System.out.println("Ingrese el codigo: ");
        int codigo = entrada.nextInt();
        System.out.println("Ingrese el numero: ");
        String numero = entrada.next();
        System.out.println("Ingrese el tipo: ");
        String tipo = entrada.next();
        System.out.println("Ingrese la operadora: ");
        String operadora = entrada.next();

        Telefono telefono = new Telefono(codigo, numero, tipo, operadora);

        return telefono;
    }

    /**
     * metodo pedirIdentificador.
     *
     * para pedir la cedula o correo de una persona y enviarlo.
     *
     * @return int
     */
    public String pedirIdentificador() {
        entrada = new Scanner(System.in);
        System.out.println("Digite el correo o cedula de la persona a buscar: ");
        String id = entrada.next();

        return id;
    }

    /**
     * metodo imprimirTelefono.
     *
     * metodo encargado de recibir un telefono e imprimirlo mediante su metodo
     * toString
     *
     * @param telefono
     */
    public void imprimirTelfono(Telefono telefono) {
        System.out.println("Telefono: ");
        System.out.println(telefono.toString());
    }

    /**
     * metodo imprimirTelefonos.
     *
     * metodo encargado de recibir un usuario en el cual se van a imprimir todos
     * los telefonos del usuario.
     *
     * @param usuario
     */
    public void imprimirTelefonos(Usuario usuario) {

        System.out.println("Telefonos: ");
        System.out.println(usuario.getTelefonos().toString());

    }

    /**
     * metodo imprimirUsuario.
     *
     * metodo encargado de imprirmir toda la informacion de un usuario ya creado
     *
     * @param usuario
     */
    public void imprimirUsuario(Usuario usuario) {
        System.out.println("Usuario:\n" + usuario.toString());
    }

    /**
     * metodo imprimirUsuarios.
     *
     * este emtodo recibe un Map de usuario ya los imprime
     *
     * @param usuarios
     */
    public void imprimirUsuarios(Map<String, Usuario> usuarios) {

        for (Map.Entry<String, Usuario> usuario2 : usuarios.entrySet()) {
            String key = usuario2.getKey();
            Usuario persona = usuario2.getValue();
            System.out.println("\nClave del usuario: " + key + "\n" + persona);
        }

    }

    /**
     * metodo frase.
     *
     * metodo encargado de recibir una frase y de imprimirla.
     *
     * @param frase
     */
    public void frase(String frase) {
        System.out.println(frase);
    }
}
