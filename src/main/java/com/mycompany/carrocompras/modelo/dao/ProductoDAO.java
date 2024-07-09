package com.mycompany.carrocompras.modelo.dao;

import com.mycompany.carrocompras.config.Conexion;
import com.mycompany.carrocompras.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public ArrayList<Producto> ListarTodos () {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        
        try{
            cn= Conexion.getConnection();
            String sql = "select * from Producto";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Producto obj = new Producto();
                obj.setIdProd(rs.getInt("id_prod"));
                obj.setNombre(rs.getString("nombre"));
                obj.setPrecio(rs.getDouble("precio"));
                obj.setImagen(rs.getString("imagen"));
                lista.add(obj);  // Corrección aquí
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(cn != null) {
                    cn.close();
                }
                if(ps != null){
                    ps.close();
                }
                 if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return lista;
    }
}
