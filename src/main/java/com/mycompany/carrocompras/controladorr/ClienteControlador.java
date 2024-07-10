package com.mycompany.carrocompras.controladorr;

import com.mycompany.carrocompras.modelo.Cliente;
import com.mycompany.carrocompras.modelo.dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {
    private final String pagNuevo = "PagRegistrarCliente.jsp";
    private ClienteDAO cliDao = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "nuevo":
                Nuevo(request, response);
                break;
            case "guardar":
                Guardar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cliente obj = new Cliente();
        obj.setNombres(request.getParameter("nombres"));
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setTelefono(request.getParameter("telefono"));
        obj.setCorreo(request.getParameter("correo"));
        obj.setPassword(request.getParameter("password"));
        
        if(cliDao.ExisteCorreo(obj.getCorreo().trim()) == false){
             int result = cliDao.Guardar(obj);

        if (result > 0) {
            request.getSession().setAttribute("success", "Cuenta registrada!");
            response.sendRedirect("ClienteControlador?accion=nuevo");
            return;
        } else {
            request.getSession().setAttribute("error", "No se pudo registrar cuenta!");
        }
      }else{
            request.getSession().setAttribute("error","El correo"+obj.getCorreo()+""
            +"ya se encuentra registrado!");
        }

        int result = cliDao.Guardar(obj);

        if (result > 0) {
            request.getSession().setAttribute("success", "Cuenta registrada!");
            response.sendRedirect("ClienteControlador?accion=nuevo");
            return;
        } else {
            request.getSession().setAttribute("error", "No se pudo registrar cuenta!");
        }

        request.setAttribute("cliente", obj);
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void Nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("cliente", new Cliente());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
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
