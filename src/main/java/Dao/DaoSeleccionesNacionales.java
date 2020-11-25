package Dao;

import Bean.Estadios;
import Bean.SeleccionesNacionales;

import javax.servlet.RequestDispatcher;
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

        String sql = "SELECT * FROM estadios;";

        try (Connection conn = getConnection();Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Estadios estadio = new Estadios();
                estadio.setIdEstadios(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                estadio.setProvincia(rs.getString(3));
                estadio.setClub(rs.getString(4));
                listaEstadios.add(estadio);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaEstadios;
    }


    public void crearSeleccion(SeleccionesNacionales seleccionesNacionales){

        String sql = "INSERT INTO seleccionesnacionales(nombre, tecnico, estadios_idEstadios)\n" +
                "VALUES (?,?,?);";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,seleccionesNacionales.getNombre());
            pstmt.setString(2,seleccionesNacionales.getTecnico());
            pstmt.setInt(3,seleccionesNacionales.getEstadios_idEstadio());

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void actualizarSeleccion(SeleccionesNacionales seleccionesNacionales){
        String sql = "UPDATE seleccionesnacionales\n" +
                "SET nombre=?, tecnico=?,estadios_idEstadios= ?\n" +
                "WHERE idSeleccionesNacionales=?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,seleccionesNacionales.getNombre());
            pstmt.setString(2,seleccionesNacionales.getTecnico());
            pstmt.setInt(3,seleccionesNacionales.getEstadios_idEstadio());
            pstmt.setInt(4,seleccionesNacionales.getIdSeleccionesNacionales());

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void borrarSeleccion(int id){
        String sql = "DELETE FROM seleccionesnacionales WHERE idSeleccionesNacionales=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1,id);

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public SeleccionesNacionales buscarSeleccion(int id){
        SeleccionesNacionales seleccion = null;

        String sql = "SELECT * FROM seleccionesnacionales WHERE idSeleccionesNacionales=?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1,id);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    seleccion = new SeleccionesNacionales();
                    seleccion.setIdSeleccionesNacionales(rs.getInt(1));
                    seleccion.setNombre(rs.getString(2));
                    seleccion.setTecnico(rs.getString(3));
                    seleccion.setEstadios_idEstadio(rs.getInt(4));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return seleccion;
    }

    public boolean bucarSeleccionNombre(String nombre){

        boolean selecionExiste = false;

        String sql = "SELECT * FROM seleccionesnacionales WHERE nombre=?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,nombre);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    selecionExiste = true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return selecionExiste;
    }



}
