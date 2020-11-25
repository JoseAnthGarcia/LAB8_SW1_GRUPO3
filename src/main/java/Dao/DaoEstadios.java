package Dao;

import Bean.Estadios;
import Bean.Jugadores;
import Bean.SeleccionesNacionales;

import java.sql.*;
import java.util.ArrayList;

public class DaoEstadios extends BaseDao{

    public ArrayList<Estadios> listarEstadios(){
        ArrayList<Estadios> listaEstadios = new ArrayList<>();
        String sql = "SELECT * FROM estadios;";

        try (Connection conn = getConnection();Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                while (rs.next()) {
                    Estadios estadio = new Estadios();
                    estadio.setIdEstadios(rs.getInt(1));
                    estadio.setNombre(rs.getString(2));
                    estadio.setProvincia(rs.getString(3));
                    estadio.setClub(rs.getString(4));
                    listaEstadios.add(estadio);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaEstadios;
    }


}
