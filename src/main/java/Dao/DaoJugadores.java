package Dao;

import Bean.Jugadores;
import Bean.SeleccionesNacionales;

import java.sql.*;
import java.util.ArrayList;

public class DaoJugadores extends BaseDao {

    public ArrayList<Jugadores> listarJugadores(){


        ArrayList<Jugadores> listaJugadores=  new ArrayList<>();
        String sql= "SELECT * FROM sw1lab8.jugadores;";

        try (Connection connection= getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs= statement.executeQuery(sql)){
            while(rs.next()){
                Jugadores jugadores = new Jugadores();
                jugadores.setIdJugadores(rs.getInt(1));
                jugadores.setNombre(rs.getString(2));
                jugadores.setEdad(rs.getInt(3));
                jugadores.setPosicion(rs.getString(4));
                jugadores.setClub(rs.getString(5));
                jugadores.setSn_idSeleccion(rs.getInt(6));

                listaJugadores.add(jugadores);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaJugadores;
    }

    public Jugadores buscarJugadore(int id){
                /*
                Inserte su código aquí
                 */

    }

    public void crearJugador(Jugadores jugadores){
        String sql = "INSERT INTO usuario(nombreUsuario, apellido, dni, correo, contrasenia, idDistrito)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,nombres);
            pstmt.setString(2,apellidos);
            pstmt.setString(3,dni);
            pstmt.setString(4, correo);
            pstmt.setString(5, contrasenia);
            pstmt.setInt(6, idDistrito);

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void actualizarJugador(Jugadores jugadores){
                /*
                Inserte su código aquí
                 */
    }

    public void borrarJugador(int id){
                /*
                Inserte su código aquí
                 */
    }

}
