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
@WebServlet(name = "Patqueryy", urlPatterns = {"/Patqueryy"})
public class Patqueryy extends HttpServlet {

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
            HttpSession session=request.getSession();
           String p_id=(String)session.getAttribute("p_id");
            String p_query = request.getParameter("description");
            String d_id = request.getParameter("doctor");
            String catid = request.getParameter("catid");
            System.out.println(p_query+" "+d_id+" "+catid);
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();     
//            String p_query = request.getParameter("p_query");
            System.out.println("Query:"+p_query);
            PreparedStatement ps = con.prepareStatement("insert into query (p_query,p_id,d_id) values(?,?,?)");
            ps.setString(1, p_query);
            ps.setString(2, p_id);
            ps.setString(3, d_id);
           
            int rs = ps.executeUpdate();
            if (rs != 0) {
               
                response.sendRedirect("Patient/PatHome.jsp?Query sent success");
             
                     } 

            else {
                response.sendRedirect("adminpages/Category.jsp?Query not sent");
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
