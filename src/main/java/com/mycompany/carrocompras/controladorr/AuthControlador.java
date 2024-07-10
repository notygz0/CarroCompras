package com.mycompany.carrocompras.controladorr;

import com.mycompany.carrocompras.modelo.Cliente;
import com.mycompany.carrocompras.modelo.dao.AuthDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthControlador extends HttpServlet {

    private AuthDAO authDao = new AuthDAO();
    private final String pagLogin = "PagLogin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        switch (accion) {
            case "login":
                Login(request, response);
                break;
            case "autentificarse":
                Autentificarse(request, response);
                break;
                
            case "logout":
                Logout(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void Autentificarse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        Cliente obj = authDao.Login(correo, password);

        if (obj != null) {
            request.getSession().setAttribute("Usuario", obj);
            response.sendRedirect("index.jsp");
        } else {
            request.getSession().setAttribute("error", "correo y/o contraseña incorrecta");
            request.getRequestDispatcher(pagLogin).forward(request, response);
        }
    }

    protected void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(pagLogin).forward(request, response);
    }
    
    protected void Logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().removeAttribute("usuario");
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
