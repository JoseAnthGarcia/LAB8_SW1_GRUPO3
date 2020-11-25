package Dao;

import Bean.Jugadores;
import Bean.SeleccionesNacionales;

import java.sql.*;
import java.util.ArrayList;

public class DaoJugadores {

    public ArrayList<Jugadores> listarJugadores(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String usuario="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/hr?serverTimezone=America/Lima";

        ArrayList<Jugadores> listaJugadores=  new ArrayList<>();
        String sql= "SELECT * FROM sw1lab8.jugadores;";

        try (Connection connection= DriverManager.getConnection(url,usuario,password);
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
                /*
                Inserte su código aquí
                 */
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
