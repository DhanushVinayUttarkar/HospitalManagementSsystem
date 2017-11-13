/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import com.dbutil.DBsingletone;
import com.dbutil.SendMail;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Vss
 */
@WebServlet(name = "RecieveAudio", urlPatterns = {"/RecieveAudio"})
@MultipartConfig
public class RecieveAudio extends HttpServlet {

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
           
            SimpleDateFormat dateformat = new SimpleDateFormat("ddMyyyyhmma");
            Date date1 = new Date();
            String datecur = dateformat.format(date1);
            
            String param5 = request.getParameter("param1");
            System.out.println("Param5 [" + param5 + "]");
            Part p = request.getPart("file");
            String fileName = extractFileName(p);
            String array[] = fileName.split("_");
             
             String finalFileName = array[0]+datecur;
            File f = new File("D:\\rakshith\\wound_assessment\\web\\p_images\\" + finalFileName+".jpg");
            FileOutputStream fos = new FileOutputStream(f);
            InputStream is = p.getInputStream();
            byte[] buffer = new byte[500000];
            while (is.read(buffer) != -1) {
                fos.write(buffer);
            }
            System.out.println("File name [" + fileName + "] - Size [" + f.length() + "]");
            is.close();
            fos.close();
            
            try{
                
            
         DBsingletone dbs = DBsingletone.getDbSingletone();
         Connection con = dbs.getConnection();
         int check = 0;
         PreparedStatement stmt = con.prepareStatement("insert into upload(pid,pimage) value(?,?)");
         stmt.setString(1, param5);
         stmt.setString(2, fileName+".jpg");
         int i =  stmt.executeUpdate();  
         if(i == 1)
         {
             PreparedStatement psmt = con.prepareStatement("select * from scanner ");
             ResultSet rs = psmt.executeQuery();
             if(rs.next())
             {
                  SendMail sm = new SendMail();
                  sm.MailTo(rs.getString("smail"), param5);
             }
             else
             {
                  System.out.println("failed"); 
             }
            
             System.out.println("success data inserted"); 
             }
             }catch(Exception e)
             {
                 e.printStackTrace();
             }
             
             
        } catch (Throwable t) {
            t.printStackTrace();
        }
        
        
    }
private String extractFileName(Part part) {
String contentDisp = part.getHeader("content-disposition");
String[] items = contentDisp.split(";");
for (String s : items) {
if (s.trim().startsWith("filename")) {
return s.substring(s.indexOf("=") + 2, s.length()-1);
}
}
return "";
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
