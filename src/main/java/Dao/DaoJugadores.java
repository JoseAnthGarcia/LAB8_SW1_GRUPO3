package Dao;

import Bean.Jugadores;
import Bean.SeleccionesNacionales;

import java.sql.*;
import java.util.ArrayList;

public class DaoJugadores extends BaseDao {
    public boolean buscarNombre(String correo){
        boolean encontrado = false;

        String sql = "SELECT nombre FROM jugadores where nombre=?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1,correo);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    encontrado = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return encontrado;
    }
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

    public Jugadores buscarJugadores(int id){
        String sql = "select j.nombre, j.edad, j.posicion, j.club , s.nombre,sn_idSeleccion\n" +
                "from jugadores j\n" +
                "inner join seleccionesnacionales s on j.sn_idSeleccion=s.idSeleccionesNacionales where idJugadores = ?;";
        Jugadores jugadores = new Jugadores();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {

                    jugadores.setNombre(rs.getString(1));
                    jugadores.setEdad(rs.getInt(2));
                    jugadores.setPosicion(rs.getString(3));
                    jugadores.setClub(rs.getString(4));
                    jugadores.setSn_idSeleccion(rs.getInt(6));


                }
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return jugadores;

    }

    public void crearJugador(Jugadores jugadores){

        String nombre= jugadores.getNombre();
        int edad= jugadores.getEdad();
        String posicion= jugadores.getPosicion();
        String club = jugadores.getClub();
        int seleccion = jugadores.getSn_idSeleccion();
        String sql = "INSERT INTO usuario(nombre, edad, posicion, club, sn_idSeleccion)\n" +
                "VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1,nombre);
            pstmt.setInt(2,edad);
            pstmt.setString(3,posicion);
            pstmt.setString(4, club);
            pstmt.setInt(5,seleccion);


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
