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
                String nombre = request.getParameter("nombre");
                String tecnico = request.getParameter("tecnico");
                int estadioId = Integer.parseInt(request.getParameter("estadio")); //exige validacion?

                boolean valNombre = true;
                if(nombre.equals("") || daoSeleccionesNacionales.bucarSeleccionNombre(nombre)){
                    valNombre = false;
                }

                boolean valTecnico = true;
                if(tecnico.equals("")){
                    valTecnico = false;
                }

                if(valNombre && valTecnico){
                    SeleccionesNacionales seleccion = new SeleccionesNacionales();
                    seleccion.setNombre(nombre);
                    seleccion.setTecnico(tecnico);
                    seleccion.setEstadios_idEstadio(estadioId);
                    daoSeleccionesNacionales.crearSeleccion(seleccion);
                    response.sendRedirect(request.getContextPath()+"/SeleccionesServlet");
                }else{
                    ArrayList<Estadios> listaEstadios = daoSeleccionesNacionales.listarEstadios();
                    request.setAttribute("listaEstadios", listaEstadios);
                    view = request.getRequestDispatcher("/Selecciones/FormCreate.jsp"); //ayuda tecnica
                    view.forward(request, response);
                }

                break;
            case "actualizar":
                int id2 = Integer.parseInt(request.getParameter("id"));
                String nombre2 = request.getParameter("nombre");
                String tecnico2 = request.getParameter("tecnico");
                int estadioId2 = Integer.parseInt(request.getParameter("estadio")); //exige validacion?

                boolean valNombre2 = true;
                if(nombre2.equals("")){
                    valNombre2 = false;
                }

                boolean valTecnico2 = true;
                if(tecnico2.equals("")){
                    valTecnico2 = false;
                }

                if(valNombre2 && valTecnico2){
                    SeleccionesNacionales seleccion2 = new SeleccionesNacionales();
                    seleccion2.setIdSeleccionesNacionales(id2);
                    seleccion2.setNombre(nombre2);
                    seleccion2.setTecnico(tecnico2);
                    seleccion2.setEstadios_idEstadio(estadioId2);
                    daoSeleccionesNacionales.actualizarSeleccion(seleccion2);
                    response.sendRedirect(request.getContextPath()+"/SeleccionesServlet");
                }else{
                    request.setAttribute("nombre2",nombre2);//no es necesario
                    request.setAttribute("tecnico2",tecnico2);//no es necesario
                    //falta el combobox :c
                    ArrayList<Estadios> listaEstadios = daoSeleccionesNacionales.listarEstadios();
                    request.setAttribute("listaEstadios", listaEstadios);
                    view = request.getRequestDispatcher("/Selecciones/FormCreate.jsp"); //ayuda tecnica
                    view.forward(request, response);
                }

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
                ArrayList<Estadios> listaEstadios = daoSeleccionesNacionales.listarEstadios();
                request.setAttribute("listaEstadios", listaEstadios);
                view = request.getRequestDispatcher("/Selecciones/FormCreate.jsp"); //ayuda tecnica
                view.forward(request, response);
                break;
            case "editar":
                int idSeleccion = Integer.parseInt(request.getParameter("idSeleccion"));
                SeleccionesNacionales seleccion = daoSeleccionesNacionales.buscarSeleccion(idSeleccion);
                if(seleccion!=null){
                    ArrayList<Estadios> listaEstadios2 = daoSeleccionesNacionales.listarEstadios();
                    request.setAttribute("listaEstadios", listaEstadios2);
                    request.setAttribute("seleccion", seleccion);
                    view = request.getRequestDispatcher("/Selecciones/FormEdit.jsp"); //ayuda tecnica
                    view.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/SeleccionesServlet");
                }
            case "borrar":
                int idSelec = Integer.parseInt(request.getParameter("idSeleccion"));
                SeleccionesNacionales seleccion3 = daoSeleccionesNacionales.buscarSeleccion(idSelec);
                if(seleccion3!=null){
                    daoSeleccionesNacionales.borrarSeleccion(idSelec);
                    response.sendRedirect(request.getContextPath()+"/SeleccionesServlet");
                }else{
                    response.sendRedirect(request.getContextPath()+"/SeleccionesServlet");
                }

        }

    }
}
