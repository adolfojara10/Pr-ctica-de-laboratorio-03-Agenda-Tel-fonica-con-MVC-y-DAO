/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.dao;

import ec.ups.edu.idao.ITelefonoDAO;
import ec.ups.edu.modelo.Telefono;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class TelefonoDAOImpl implements ITelefonoDAO {
    
    private List<Telefono> listaTelefonos;

    public TelefonoDAOImpl() {
        listaTelefonos = new ArrayList<Telefono>();
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
     * @param telefono
     */
    @Override
    public void createTelefono(Telefono telefono) {
        //se añade un telefono a la lisatTelefonos
        listaTelefonos.add(telefono);
        
    }

    /**
     * metodo readTelefono.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo es el
     * encargado de recibir al usuario que inicio sesion y el codigo de uno de
     * sus telefonos. Busca el telefono del usuario y lo devuelve para su futura
     * impresion.
     *
     * @param codigo
     * @return Telefono
     */
    @Override
    public Telefono readTelefono(int codigo) {
        for (Telefono telefono : listaTelefonos){
            if (telefono.getCodigo() == codigo){
                return telefono;
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
     * @param telefono
     * @param codigo
     */
    @Override
    public void updateTelefono(Telefono telefono, int codigo) {
        for (int i=0;i<listaTelefonos.size();i++){
            Telefono telefono2 = listaTelefonos.get(i);
            if(telefono2.getCodigo()==codigo){
                listaTelefonos.set(i, telefono);
                break;
            }
        }
        
    }

    /**
     * metodo eliminarTelefono.
     *
     * Es la sobreescritura del metodo de la Interface. este metodo recibe al
     * usuario que ha iniciado sesion, y al codigo del telefono que va a hacer
     * eliminado. Borra el telefono y devuelve el nuevo diccionario del usuario.
     *
     * @param codigo
     */
    @Override
    public void deleteTelefono(int codigo) {
        Iterator <Telefono> it = listaTelefonos.iterator();
        while(it.hasNext()){
            Telefono telefono = it.next();
            if (telefono.getCodigo()==codigo){
                it.remove();
                break;
            }
        }
        
    }  
    

    @Override
    public List<Telefono> findAll() {
       return listaTelefonos;
    }

   
}
