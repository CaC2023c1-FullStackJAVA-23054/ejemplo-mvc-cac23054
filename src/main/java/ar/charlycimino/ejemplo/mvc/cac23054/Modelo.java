package ar.charlycimino.ejemplo.mvc.cac23054;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Modelo {


    public Modelo() {
    }
    
    public ArrayList<Producto> getProductos() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        // magia para ir a buscarlos a MySQL...
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM productos;");
        ResultSet rs = ps.executeQuery();
        
        while( rs.next() ) {
            String id = rs.getString(1);
            String nombre = rs.getString(2);
            int rating = rs.getInt(3);
            double precio = rs.getDouble(4);
            String foto = rs.getString(5);
            productos.add(new Producto(id, nombre, rating, precio, foto));
        }
        
        return productos;
    }

}
