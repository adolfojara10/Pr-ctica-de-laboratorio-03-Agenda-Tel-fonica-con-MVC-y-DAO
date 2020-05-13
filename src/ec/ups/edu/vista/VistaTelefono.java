/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.modelo.Telefono;
import ec.ups.edu.modelo.Usuario;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adolfo
 */
public class VistaTelefono {
    private Scanner entrada;

    public VistaTelefono() {
        entrada = new Scanner(System.in);
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
    
    public int confirmarCodigo(){
        System.out.println("Confirme el codigo del tele: ");
        int codigo = entrada.nextInt();
        return codigo;
    }
    
    /**
     * metodo ingresarTelefono.este metodo es el encargado de pedir los datos de un nuevo telefono y
 crearlo.
     *
     * una vez hecho eso, devuelve el telefono ya creado.
     *
     * @return 
     */
    public Telefono ingresarTelefono(){
        System.out.println("\nIngresar el nuevo telefono:\n ");
        System.out.println("Numero:");
        String numero = entrada.next();
        System.out.println("Tipo:");
        String tipo = entrada.next();
        System.out.println("Operadora:");
        String operadora = entrada.next();
        System.out.println("Ingrese el codigo:");
        int codigo = entrada.nextInt();
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
    public int pedirCodigo() {
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
        if (usuario.getTelefonos()!=null){
            System.out.println(usuario.getTelefonos().toString());
        } else {
            System.out.println("No posee telefonos");
        }
    }
    
    public void imprimirTodosTelefonos(List<Telefono> telefonos){
        System.out.println("\nTelefonos registrados: ");
        int conta=0;
        for (Telefono telefono:telefonos){
            conta++;
            System.out.println("Telefono#" + " " + conta + "\n");
            System.out.println(telefono.toString());
        }
        
    }
    
    public void imprimirFrase(String frase){
        System.out.println(frase);
    }
    
}
