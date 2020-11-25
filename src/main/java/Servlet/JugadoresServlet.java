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
    public boolean validarString(String input){
        boolean resultado = true;
        boolean resultado2= true;
        if(input.equalsIgnoreCase("")){
            resultado = false;
        }
        try{
            int numero= Integer.parseInt(input);
            resultado2=false;
        }catch (NumberFormatException e){
            resultado2=true;
        }
        boolean resultadoFinal= resultado&&resultado2;


        return resultadoFinal;
    }
    public boolean validarNumero(String input){
        boolean resultado = true;
        try{
            int valor = Integer.parseInt(input);
        }catch (NumberFormatException e){
            resultado = false;
        }
        return resultado;
    }

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


        DaoJugadores daoJugadores1 = new DaoJugadores();
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String posicion = request.getParameter("posicion");
        String club = request.getParameter("club");
        String sn_idSeleccion = request.getParameter("sn_idSeleccion");




        boolean nombreB = validarString(nombre);
        boolean edadB = validarNumero(edad);
        boolean clubB = validarNumero(club);

        switch (action){

            case "guardar":
                if(nombreB && edadB && clubB){

                    boolean correoExis = false;
                    if(daoJugadores.buscarNombre(nombre)){
                        correoExis = true;
                    }

                    if( !correoExis ){
                        Jugadores jugadores = new Jugadores();
                        jugadores.setNombre(nombre);
                        jugadores.setEdad(Integer.parseInt(edad));
                        jugadores.setPosicion(posicion);
                        jugadores.setClub(club);
                        jugadores.setSn_idSeleccion(Integer.parseInt(sn_idSeleccion));
                        daoJugadores.crearJugador(jugadores);
                        response.sendRedirect(request.getContextPath()+"/JugadoresServlet");
                    }else{

                        request.setAttribute("correoExiste", correoExis);

                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("FormCreate.jsp");
                        requestDispatcher.forward(request, response);

                    }


                }else{
                    request.setAttribute("nombreB", nombreB);
                    request.setAttribute("edadB", edadB);
                    request.setAttribute("clubB", clubB);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("FormCreate.jsp");
                    requestDispatcher.forward(request, response);
                }
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

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("FormCreate.jsp");
                requestDispatcher.forward(request, response);
                break;

            case "editar":
                int jugadorId = Integer.parseInt(request.getParameter("jugadorId"));
                Jugadores jugador = daoJugadores.buscarJugadores(jugadorId);


                request.setAttribute("jugador", jugador);
                requestDispatcher = request.getRequestDispatcher("FormEdit.jsp");
                requestDispatcher.forward(request, response);

                break;


            case "borrar":
                /*
                Inserte su código aquí
                 */
                break;
        }
    }
}
