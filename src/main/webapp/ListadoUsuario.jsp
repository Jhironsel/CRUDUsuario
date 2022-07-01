
<%@page import="sur.softsurena.crudusuario.UsuariosEntity"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="sur.softsurena.crudusuario.UsoRestApi"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body>
        <h1>Listado de Usuarios</h1>

        <%
            //Capturando los parametros de la petición
            String pNombre = request.getParameter("txtPNombre");
            String apellidos = request.getParameter("txtApellidos");
            String estado = request.getParameter("Estado");

            //Creando un json para ser enviado
            JSONObject user = new JSONObject();
            user.put("nombres", pNombre);
            user.put("apellidos", apellidos);
            user.put("estado", estado);

            if (pNombre != null) {
                //Enviamos un Post para agregar el json construido en user
                UsoRestApi.postUsuario("http://localhost:8080/postUsuario/", user, "POST");
                
                String json = UsoRestApi.restUsuario("http://localhost:8080/getUsuarios", "GET");
                Gson gson = new Gson();
                UsuariosEntity[] userJson = gson.fromJson(json, UsuariosEntity[].class);
                String thead = "<table class='w3-table-all'>"
                        + "<thead> "
                        + "   <tr class='w3-light-grey w3-hover-red'> "
                        + "     <th>Identificador</th> "
                        + "     <th>Nombre</th> "
                        + "     <th>Apellidos</th>"
                        + "     <th>Estado</th>"
                        + "   </tr>"
                        + "</thead>";
                out.print(thead);

                for (Object u : userJson) {
                    out.println(u);
                }
                out.print("</table>");
            }


        %>

        <a class="w3-button w3-white w3-border w3-border-red w3-round-large"
           href="/CRUDUsuario">Registro</a>

    </body>
</html>
