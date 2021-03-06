<%@ page import="com.example._20195527_20191417.beans.ActoresBean" %><%--
  Created by IntelliJ IDEA.
  User: CARLOS
  Date: 6/06/2022
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="listaActores" scope="request" type="java.util.ArrayList<com.example._20195527_20191417.beans.ActoresBean>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reporte actores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <style>
        .titulo{
            text-align: center;
            text-decoration: underline;
            margin-top: 50px;
        }
        .table{
            margin-top: 20px;
            border-collapse: separate;
        }
        .cabeceraexter{
            text-align: center;
        }
        .cabecerainterna{
            align-content: center;
            background-color: #00008B;
            color: #fff;
            font-weight: bold;
            align-items: center;
        }
        .id{
            text-align: right;
        }
        .nombre{
            text-align: left;
        }
        .categorias, .peliculas{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="titulo h3"><b>Reporte de futuros actores POPCORN S.A.C</b></div>
    <div style="text-align: center;">
        <table class="table table-striped container px-6 py-4" align="center">
            <thead class="cabeceraexter">
                <tr class="cabecerainterna">
                    <td>Id</td>
                    <td>Nombre</td>
                    <td>N° Categorias</td>
                    <td>N° Peliculas</td>
                </tr>
            </thead>

            <tbody>
                <% for (ActoresBean actor: listaActores) {%>
                <tr>
                    <td class="id"><%=actor.getID()%></td>
                    <td class="nombre"><%=actor.getNombre()%></td>
                    <td class="categorias"><%=actor.getCantCategorias()%></td>
                    <td class="peliculas"><%=actor.getCantPeliculas()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
