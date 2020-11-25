package Dao;

import Bean.Estadios;
import Bean.SeleccionesNacionales;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

public class DaoSeleccionesNacionales extends BaseDao {

    public ArrayList<SeleccionesNacionales> listarSelecciones(){

        ArrayList<SeleccionesNacionales> listaSelecciones = new ArrayList<>();

        String sql = "SELECT * FROM seleccionesnacionales;";

        try (Connection conn = getConnection();Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                SeleccionesNacionales seleccion = new SeleccionesNacionales();
                seleccion.setIdSeleccionesNacionales(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));
                seleccion.setEstadios_idEstadio(rs.getInt(4));
                listaSelecciones.add(seleccion);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaSelecciones;
    }

    public ArrayList<Estadios> listarEstadios(){
        ArrayList<Estadios> listaEstadios = new ArrayList<>();
        /*
                Inserte su código aquí
                 */
        return listaEstadios;
    }


    public void crearSeleccion(SeleccionesNacionales seleccionesNacionales){
        /*
                Inserte su código aquí
                 */
    }

    public void actualizarSeleccion(SeleccionesNacionales seleccionesNacionales){
        /*
                Inserte su código aquí
                 */
    }
    public void borrarSeleccion(int id){
        /*
                Inserte su código aquí
                 */
    }

    public SeleccionesNacionales buscarSeleccion(int id){
        SeleccionesNacionales seleccion = null;
        /*
                Inserte su código aquí
                 */
        return seleccion;
    }



}
