package com.admin.servlets;
import com.dbutil.DBsingletone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            System.out.println("we r into servlet");
            String name = request.getParameter("username");
            String pass = request.getParameter("password");
            String dept = request.getParameter("dept");
            String phone = request.getParameter("phone");
            String email = request.getParameter("uemail");
            System.out.println(dept+phone);
            System.out.println("name="+name);
            Connection con = null;
            PreparedStatement psmt = null;
            DBsingletone dbs = DBsingletone.getDbSingletone();
            con = dbs.getConnection();
            System.out.println("Connection  suceess.........");
            try {
                String query = "insert into doctor(d_name,d_pass,d_dept,d_phone,d_email) values(?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, pass);
            stmt.setString(3, dept);
            stmt.setString(4, phone);
            stmt.setString(5, email);
            
            stmt.executeUpdate();
            System.out.println("executed");
           response.sendRedirect("registration.jsp");
              
            }catch(SQLException e){
                e.printStackTrace();
            }
            
        } catch (Exception e) {

        }
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
    }// </editor-fold>

}
