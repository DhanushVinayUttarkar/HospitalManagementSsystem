/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.servlets;

import com.dbutil.DBsingletone;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author N
 */
@WebServlet(name = "PatLog", urlPatterns = {"/PatLog"})
public class PatLog extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String uname = request.getParameter("pusername");
            String upass = request.getParameter("ppassword");
            System.out.println("name: " + uname + " Password: " + upass);

            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            PreparedStatement stmt = con.prepareStatement("Select * from patientreg where p_name='" + uname + "' and p_pass='" + upass + "'");
            ResultSet rs = stmt.executeQuery();
            HttpSession session = request.getSession();
            if (rs.next()) {

                // System.out.println("uname pass " + rs.getString("Aname") + "  " + rs.getString("Apassword"));
                session.setAttribute("p_id", rs.getString("p_id"));
                session.setAttribute("p_name", rs.getString("p_name"));
                
                String name=(String)session.getAttribute("p_name");
                System.out.print("Welcome" + name);
                response.sendRedirect("Patient/PatHome.jsp");
                //RequestDispatcher rd=request.getRequestDispatcher("adminpages/adminhome.jsp");
                //rd.include(request, response);
                // response.sendRedirect("adminpages/adminhome.jsp");
            } else {

                response.sendRedirect("Plogin.jsp");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
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
