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
 * @author VSS
 */
@WebServlet(name = "doctorlogin", urlPatterns = {"/doctorlogin"})
public class doctorlogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("dname");
            String pass = request.getParameter("dpass");
            
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            PreparedStatement psmt = con.prepareStatement("select * from doctor where d_name='"+name+"' and d_pass='"+pass+"' and d_isactive = 1");
            ResultSet rs = psmt.executeQuery();
            HttpSession session = request.getSession();
            if(session != null)
            {
                if(rs.next()){
                session.setAttribute("d_id", rs.getString("d_id"));
               session.setAttribute("d_name", rs.getString("d_name"));
//                String id=(String)session.getAttribute("d_id");
//                  String nam=(String)session.getAttribute("d_name");
                   
                   // session.setAttribute("d_name", name);
                 String id=(String)session.getAttribute("d_id");
                  String nam=(String)session.getAttribute("d_name");
                System.out.println("Welcome" + nam);
                response.sendRedirect("adminpages/doctorhome.jsp");
            }
                
            else {
                    System.out.println("session expired");
                response.sendRedirect("doctorlogin.jsp");
            }
            }
            
        } catch (Exception ex) {
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
