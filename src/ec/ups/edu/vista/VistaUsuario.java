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
 *
 * @author Adolfo
 */
public class VistaUsuario {

    private Scanner entrada;

    public VistaUsuario() {
        entrada = new Scanner(System.in);

    }
    
    public int menu(){
        entrada = new Scanner(System.in);
        System.out.println("\nDigite el numero de accion que desea "
                    + "ejecutar:\n" + "1.-Crear un nuevo usuario" 
                    + "\n2.-Iniciar sesion" + "\n3.-Imprimir telefonos de un usuario "
                    + "un usuario" + "\n4.-Buscar un usuario" + "\n5.-Imprimir"
                    + " todos los usuarios" + "\n6-Salir");
        int opcionMenu = entrada.nextInt();
        
        return opcionMenu;
    }

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

    public String iniciarSesionCorreo() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su correo: ");
        String correo = entrada.next();

        return correo;

    }

    public String iniciarSesionContraseña() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su contraseña: ");
        String contraseña = entrada.next();

        return contraseña;
    }

    public int menuEditarTelefonoUsuario() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite la opcion que desea realizar:\n"
                + "1.-Ingresar un nuevo numero" + "\n2.-Editar un telefono"
                + "\n3.-Eliminar un telefono" + "\n4.-Cerrar sesion y volver al "
                + "menu");
        int opcionSesion = entrada.nextInt();
           
               
        return opcionSesion;
    }

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
    
    public int editarTelefono(){
        entrada= new Scanner(System.in);
        
        System.out.println("Ingrese el codigo del telefono: ");
        int codigo = entrada.nextInt();
        
        return codigo;
    }
    
    public Telefono telefonoEditado(){
        entrada= new Scanner(System.in);
        
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
    
    
    public String pedirIdentificador(){
        entrada= new Scanner(System.in);
        System.out.println("Digite el correo o cedula de la persona a buscar: ");
        String id = entrada.next();

        return id;
    }
    
    public void imprimirTelfono(Telefono telefono){
        System.out.println("Telefono: ");
        System.out.println(telefono.toString());
    }
    
    public void imprimirTelefonos(Usuario usuario){
        
        System.out.println("Telefonos: ");
        System.out.println(usuario.getTelefonos().toString());
        
    }

    public void imprimirUsuario(Usuario usuario) {
        System.out.println("Usuario:\n" + usuario.toString());
    }

    public void imprimirUsuarios(Map<String,Usuario> usuarios){
        
        for (Map.Entry<String, Usuario> usuario2:usuarios.entrySet()){
            String key = usuario2.getKey();
            Usuario persona = usuario2.getValue();
            System.out.println("\nClave del usuario: " + key + "\n" + persona);
        } 
        
    }
    public void frase(String frase) {
        System.out.println(frase);
    }

    /*
    public Telefono crearTelefono(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("");
        
    }
     */
}
