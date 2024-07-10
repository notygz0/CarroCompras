package com.mycompany.carrocompras.controlador;

import com.mycompany.carrocompras.util.Carrito;
import com.mycompany.carrocompras.modelo.DetallePedido;
import com.mycompany.carrocompras.modelo.Producto;
import com.mycompany.carrocompras.modelo.dao.ProductoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarritoControlador extends HttpServlet {

    private String PagListarCarrito = "PagCarrito.jsp";
    private String PagInicio = "index.jsp";
    private ProductoDAO prodDao = new ProductoDAO();
    private Carrito objCarrito = new Carrito();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                Listar(request, response);
                break;
            case "agregar":
                Agregar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idProd = Integer.parseInt(request.getParameter("id"));
        Producto obj = prodDao.BuscarPorId(idProd);
        if (obj != null) {
            DetallePedido objDet = new DetallePedido();
            objDet.setProducto(obj);
            objDet.setCantidad(1);

            objCarrito.AgregarCarrito(objDet, request);
        }

        request.getRequestDispatcher(PagInicio).forward(request, response);
    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<DetallePedido> lista = objCarrito.ObtenerSesion(request);
        request.setAttribute("carrito", lista);
        request.setAttribute("total", objCarrito.ImporteTotal(lista));
        request.getRequestDispatcher(PagListarCarrito).forward(request, response);
    }

}
