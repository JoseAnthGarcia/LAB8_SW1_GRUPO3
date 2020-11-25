package Servlet;

import Bean.Estadios;
import Bean.SeleccionesNacionales;
import Dao.DaoSeleccionesNacionales;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SeleccionesServlet", urlPatterns = {"/SeleccionesServlet",""})
public class SeleccionesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        DaoSeleccionesNacionales daoSeleccionesNacionales = new DaoSeleccionesNacionales();
        RequestDispatcher view;

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
        DaoSeleccionesNacionales daoSeleccionesNacionales = new DaoSeleccionesNacionales();
        RequestDispatcher view;

        switch (action){
            case "lista":
                ArrayList<SeleccionesNacionales> listaselecciones1 = daoSeleccionesNacionales.listarSelecciones();
                request.setAttribute("lista", listaselecciones1);
                view = request.getRequestDispatcher("index.jsp");
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
            case "borrar":
                /*
                Inserte su código aquí
                 */

        }

    }
}
