/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.modelo;

import java.util.*;

/**
 * clase Usuario.
 *
 * Esta clase es la encargada de asignar los atributos del objeto Usuario.
 * cuenta con dos metodos constructores. el primero donde se inicializa el
 * diccionario de telefonos con el cual tiene una relacionde agregacion. Y el
 * segundo que sirve para setear todos los atributos del objeto. Cuenta con
 * todos los metodos getters y setters y con el toString.
 *
 * @see Telefono
 * @author Adolfo
 */
public class Usuario {

    //declaracion de atributos
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Telefono> listaTelefonos;

    /**
     * metodo constructor Usuario.
     *
     * en este se instancia el diccionario de tipo telefonos<Integer, Telefono>
     */
    public Usuario() {
        listaTelefonos = new ArrayList<>();

    }
/*
    public Usuario(String cedula, String nombre, String apellido, String correo, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    */
    

    /**
     * metodo constructor Usuario.este metodo sirve para settear todos los atributos de la persona que son
 enviados.
     *
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param contraseña
     */
    public Usuario(String cedula, String nombre, String apellido, String correo,
            String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    /**
     * metodo getCedula.
     *
     * sirve para enviar la cedula de un usuario creado.
     *
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * metodo setCedula.
     *
     * sirve para setear el atributo cedula del usuario, recibe este parametro y
     * lo setea
     *
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * metodo getNombre.
     *
     * sirve para enviar el nombre de un usuario creado.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo setNombre.
     *
     * sirve para setear el nombre cedula del usuario, recibe este parametro y
     * lo setea
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo getApellido.
     *
     * sirve para enviar el apellido de un usuario creado.
     *
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * metodo setApellido.
     *
     * sirve para setear el apellido cedula del usuario, recibe este parametro y
     * lo setea
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * metodo getCorreo.
     *
     * sirve para enviar el correo de un usuario creado.
     *
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * metodo setCorreo.
     *
     * sirve para setear el correo cedula del usuario, recibe este parametro y
     * lo setea
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * metodo getContraseña.
     *
     * sirve para enviar la contraseña de un usuario creado.
     *
     * @return contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * metodo setContraseña.
     *
     * sirve para setear el atributo contraseña del usuario, recibe este
     * parametro y lo setea
     *
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * metodo getTelefono.
     *
     * sirve para enviar el diccionario de telefonos de un usuario creado.
     *
     * @return Map<Integer, Telefono>
     */
    public List<Telefono> getTelefonos() {
        return listaTelefonos;
    }

    public void setTelefonos(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }
    
    
    
    /*
    public void actualizaTelefono(Telefono telefono){
        if (listaTelefonos.contains(telefono)){
            int index = listaTelefonos.indexOf(telefono);
            listaTelefonos.set(index, telefono);
        }
    }
    
    public void eliminarTelefono(Telefono telefono){
        if (listaTelefonos.contains(telefono)){
            listaTelefonos.remove(telefono);
        }
    }
    */
    public List<Telefono> listarTelefono(){
        return listaTelefonos;
    }
    
    
    /**
     * metodo hashCode.
     *
     * sirve para crear un codigo unico para la cedula, correo y contraseña
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cedula);
        hash = 41 * hash + Objects.hashCode(this.correo);
        hash = 41 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    /**
     * metodo equals.
     *
     * sirve para la comparacion de los atributos del usuario: cedula, correo, y
     * contraseña. si no los encuatra devuelve null
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return true;
    }

    /**
     * metodo toString.
     *
     * sirve para la correcta impresion de los datos de la persona.
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nUsuario:\n" + "cedula: " + cedula + "\nnombre: " + nombre
                + ", apellido: " + apellido + "\ncorreo: " + correo
                + ", contraseña: " + contraseña + "\ntelefono(s):\n " + listaTelefonos;
    }
}
