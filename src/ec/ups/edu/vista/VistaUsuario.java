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
            System.out.println("Escriba el número: ");
            String numero = entrada.next();
            System.out.println("Escriba el tipo de telédono: ");
            String tipo = entrada.next();
            System.out.println("Escriba la operadora: ");
            String operadora = entrada.next();

            Telefono telefono = new Telefono(opcion, numero, tipo, operadora);
            telefonos.put(opcion, telefono);

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
    
    
}
