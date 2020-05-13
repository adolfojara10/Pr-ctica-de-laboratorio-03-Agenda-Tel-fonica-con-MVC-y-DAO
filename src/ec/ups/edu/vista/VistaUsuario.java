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
                + " todos los usuarios" + "\n6-Imprimir todos los telefonos "
                + "registrados" + "\n7.-Salir");
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

        /*
        System.out.println("¿Desea crear los número de teléfono del nuevo "
                + "usuario en este momento?\n 1.-Si desea crear los teléfonos"
                + " \n 2.-Si desea volver al menú");
        int opcion = entrada.nextInt();

        <Integer, Telefono> telefonos = new HashMap<Integer, Telefono>();

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
            

            System.out.println("¿Desea crear los número de teléfono del nuevo "
                    + "usuario en este momento?\n 1.-Si desea crear otro teléfono"
                    + " \n 2.-Si desea volver al menú");
            opcion = entrada.nextInt();

        }
        */
        Usuario usuario = new Usuario(cedula, nombre, apellido, correo,
                contraseña);

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
