package com.mycompany.carrocompras.app;

import com.mycompany.carrocompras.modelo.dao.ProductoDAO;
import com.mycompany.carrocompras.modelo.Producto;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class AppInitializer implements ServletContextListener {
    private ProductoDAO prodDAO = new ProductoDAO();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ArrayList<Producto> productos = prodDAO.ListarTodos();
        System.out.println("Productos cargados: " + productos.size());
        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre());
        }
        sce.getServletContext().setAttribute("productos", productos);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
