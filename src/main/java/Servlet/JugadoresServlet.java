package Servlet;

import Bean.Estadios;
import Bean.Jugadores;
import Bean.SeleccionesNacionales;
import Dao.DaoEstadios;
import Dao.DaoJugadores;
import Dao.DaoSeleccionesNacionales;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JugadoresServlet", urlPatterns = {"/JugadoresServlet"})
public class JugadoresServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        DaoSeleccionesNacionales daoSeleccionesNacionales = new DaoSeleccionesNacionales();
        DaoJugadores daoJugadores = new DaoJugadores();
        RequestDispatcher view;
        ArrayList<String> posiciones = new ArrayList<>();
        posiciones.add("Portero");
        posiciones.add("Defensa");
        posiciones.add("Mediocampista");
        posiciones.add("Delantero");

        switch (action){

            case "guardar":
                /*
                Inserte su código aquí
                 */
                break;
            case "actualizar":
                /*
                Inserte su código aquí
                 */
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        DaoJugadores daoJugadores = new DaoJugadores();
        DaoSeleccionesNacionales daoSeleccionesNacionales = new DaoSeleccionesNacionales();
        RequestDispatcher view;
        ArrayList<String> posiciones = new ArrayList<>();
        posiciones.add("Portero");
        posiciones.add("Defensa");
        posiciones.add("Mediocampista");
        posiciones.add("Delantero");
        switch (action){
            case "lista":
                ArrayList<Jugadores> jugadoresArrayList = daoJugadores.listarJugadores();
                request.setAttribute("lista", jugadoresArrayList);
                view = request.getRequestDispatcher("/Jugadores/lista.jsp");
                view.forward(request, response);
                break;
            case "crear":
                /*
                Inserte su código aquí
                 */
                break;
            case "editar":
                /*
                Inserte su código aquí
                 */
                break;
            case "borrar":
                /*
                Inserte su código aquí
                 */
                break;
        }
    }
}
