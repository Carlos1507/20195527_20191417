package com.example._20195527_20191417.Servlets;

import com.example._20195527_20191417.daos.ActoresDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MostrarActoresServlet", urlPatterns = {"/MostrarActoresServlet", ""})
public class MostrarActoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActoresDao listaAct = new ActoresDao();
        request.setAttribute("listaActores", listaAct.listar_ActoresVersa());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("actores/reporteActores.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
