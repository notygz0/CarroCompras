package com.mycompany.carrocompras.controladorr;

import com.mycompany.carrocompras.modelo.DetallePedido;
import com.mycompany.carrocompras.modelo.Producto;
import com.mycompany.carrocompras.modelo.dao.ProductoDAO;
import com.mycompany.carrocompras.util.Carrito;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarritoControlador extends HttpServlet {
    private static final String PagListarCarrito = "PagCarrito.jsp";
    private static final String PagInicio= "index.jsp";
    private ProductoDAO prodDao = new ProductoDAO();
    private Carrito objCarrito = new Carrito();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        if (accion == null) {
            // Redirige a la página de inicio si no se especifica ninguna acción
            request.getRequestDispatcher(PagInicio).forward(request, response);
            return;
        }
        switch (accion) {
            case "listar":
                Listar(request, response);
                break;
            case "agregar":
                Agregar(request, response);
                break;
            case "eliminar":
                Eliminar(request, response);
                break;    
            default:
                throw new AssertionError();
        }
    }
    
    public void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType ("text/html;charset=UTF-8");
         int indice = Integer.parseInt(request.getParameter("indice"));
     
        objCarrito. RemoverItemCarrito(request, indice);
        response.sendRedirect("CarritoControladorr?accion=listar");

    }

    protected void Listar (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType ("text/html;charset=UTF-8");
       ArrayList<DetallePedido> lista = objCarrito.ObtenerSesion (request) ;
       request.setAttribute ("carrito",lista);
       request.setAttribute("total",objCarrito.ImporteTotal(lista));
       request.getRequestDispatcher(PagListarCarrito).forward(request, response);
    }

    public void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProd =  Integer.parseInt(request.getParameter("id"));
        Producto obj = prodDao.BuscarPorId(idProd);

        if (obj != null) {
            DetallePedido objDet = new DetallePedido();
            objDet.setProducto(obj);
            objDet.setCantidad(1);

            objCarrito.AgregarCarrito(objDet, request);
        }
        request.getRequestDispatcher(PagInicio).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
      *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
