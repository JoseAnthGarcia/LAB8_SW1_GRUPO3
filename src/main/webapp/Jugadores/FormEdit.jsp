<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="jugador" scope="request" type="Bean.Jugadores" />
<%

    boolean nombreB = request.getAttribute("nombreB") == null ? true : (Boolean) request.getAttribute("nombreB");
    boolean edadB = request.getAttribute("edadB") == null ? true : (Boolean) request.getAttribute("edadB");
    boolean correoExiste = request.getAttribute("correoExiste") == null ? true : (Boolean) request.getAttribute("correoExiste");
    boolean clubB = request.getAttribute("clubB") == null ? true : (Boolean) request.getAttribute("clubB");

%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' />
    <title>JSP Page</title>
</head>
<body>
<div class='container'>
    <div class="row mb-4">
        <div class="col"></div>
        <div class="col-md-6">
            <h1 class='mb-3'>Editar un Jugador de fútbol</h1>
            <form method="POST" action="<%=request.getContextPath()%>/JugadoresServlet?action=actualizar">
                <input type="hidden" class="form-control" name="id" value="<%=jugador.getIdJugadores()%>">
                <div class="form-group">
                    <label >Nombre</label>
                    <input type="text" class="form-control <%=nombreB?"":"is-invalid"%>"
                           aria-describedby="inputLastNameFeedback"
                           name="nombre" value="<%=jugador.getNombre()%>"
                           id="inputNombre" <%=request.getParameter("nombre")==null?"":"value='"+request.getParameter("nombre")+"'"%>>
                    <div id="inputNombreFeedback" class="invalid-feedback">
                        Ingrese datos, por favor.
                    </div>
                </div>
                <div class="form-group">
                    <label >Edad</label>
                    <input type="text" class="form-control <%=edadB?"":"is-invalid"%>"
                           aria-describedby="inputLastNameFeedback"
                           name="edad" value="<%=jugador.getEdad()%>"
                           id="inputEdad" <%=request.getParameter("edad")==null?"":"value='"+request.getParameter("edad")+"'"%>>
                    <div id="inputEdadFeedback" class="invalid-feedback">
                        Ingrese datos, por favor.
                    </div>
                </div>
                <div class="form-group">
                    <label >Posición</label>
                    <select name="posicion" class="form-control">
                        <% if(jugador.getPosicion().equals("Delantero")){%>
                        <option value="Delantero" selected>Delantero</option>
                        <%}else{%>
                        <option value="Delantero" >Delantero</option>
                        <%}%>
                        <% if(jugador.getPosicion().equals("Defensa")){%>
                        <option value="Defensa" selected>Defensa</option>
                        <%}else{%>
                        <option value="Defensa">Defensa</option>
                        <%}%>
                        <% if(jugador.getPosicion().equals("Portero")){%>
                        <option value="Portero" selected>Portero</option>
                        <%}else{%>
                        <option value="Portero">Portero</option>
                        <%}%>



                    </select>
                </div>
                <div class="form-group">
                    <label >Club</label>
                    <input type="text" class="form-control <%=clubB?"":"is-invalid"%>"
                           aria-describedby="inputLastNameFeedback"
                           name="club" value="<%=jugador.getClub()%>"
                           id="inputClub" <%=request.getParameter("club")==null?"":"value='"+request.getParameter("club")+"'"%>>
                    <div id="inputClubFeedback" class="invalid-feedback">
                        Ingrese datos, por favor.
                    </div>
                </div>
                <div class="form-group">
                    <label >Seleccion Nacional</label>

                    <select name="sn_idSeleccion" class="form-control">
                        <% if(jugador.getSn_idSeleccion()==1){%>
                        <option value="1" selected>Peru</option>
                        <%}else{%>
                        <option value="1" >Peru</option>
                        <%}%>
                        <% if(jugador.getSn_idSeleccion()==2){%>
                        <option value="2" selected>Chile</option>
                        <%}else{%>
                        <option value="2" selected>Chile</option>
                        <%}%>
                        <% if(jugador.getSn_idSeleccion()==3){%>
                        <option value="3" selected>Argentina</option>
                        <%}else{%>
                        <option value="3" >Argentina</option>
                        <%}%>



                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="<%= request.getContextPath()%>/JugadoresServlet" class="btn btn-danger">Cancelar</a>
            </form>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
