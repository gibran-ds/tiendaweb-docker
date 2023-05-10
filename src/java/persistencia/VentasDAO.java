package persistencia;

// TODO: ESTO SOLO ES UN EJEMPLO, PODRÍA HACERSE CON INYECCIÓN DE DEPENDENCIAS

import dominio.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VentasDAO {
    
    private final String CADENA_CONEXION = "jdbc:mysql://mysql-server:3306/ventas_web";
    private final String USUARIO = "root";
    private final String CONTRASENIA = "1234";
    private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    
    public List<Venta> consultarTodas() {        
        List<Venta> listaVentas = new LinkedList<>();
        try{
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
            String codigoSQL = "SELECT id, monto, sucursal FROM ventas;";
            PreparedStatement comando = connection.prepareStatement(codigoSQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Integer id = resultado.getInt("id");
                Float monto = resultado.getFloat("monto");
                String sucursal = resultado.getString("sucursal");
                Venta venta = new Venta(id, monto, sucursal);
                listaVentas.add(venta);
            }
            return listaVentas;
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
}
