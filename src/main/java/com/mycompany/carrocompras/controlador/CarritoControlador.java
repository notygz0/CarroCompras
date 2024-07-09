package com.mycompany.carrocompras.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarritoControlador extends HttpServlet {
    private String PagListarCarrito = "PagCarrito.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        
        

        switch (accion) {
            case "listar":
                Listar(request, response);
                break;
            default: 
                throw new AssertionError();
        }
    }
    
    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.getRequestDispatcher(PagListarCarrito).forward(request, response);
    }
    
    
}
