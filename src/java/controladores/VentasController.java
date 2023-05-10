package controladores;

import com.google.gson.Gson;
import dominio.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.VentasDAO;

/**
 * Controlador de ventas de pruebas
 * @author gibran
 */
public class VentasController extends HttpServlet {

    private final Gson gsonConverter;
    private final VentasDAO ventasDAO;
    
    public VentasController() {
        this.gsonConverter = new Gson();
        this.ventasDAO = new VentasDAO();
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
        response.setContentType("application/json;charset=UTF-8");
        
        List<Venta> listaVentas = this.ventasDAO.consultarTodas();
        
        try(PrintWriter out = response.getWriter()){
            out.print(gsonConverter.toJson(listaVentas));
            out.flush();
        }
        //processRequest(request, response);
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
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Mi servlet";
    }// </editor-fold>

}
