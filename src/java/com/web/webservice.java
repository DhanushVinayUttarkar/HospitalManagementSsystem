/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web;

import com.dbutil.DBsingletone;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author matlab
 */
@WebService(serviceName = "webservice")
public class webservice {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "uname") String uname, @WebParam(name = "upass") String upass) {
        //TODO write your implementation code here:
       System.out.println("user login called here");

        String ret = "false";
        System.out.println(" name :" + uname + " password :" + upass);
        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            PreparedStatement psmt = con.prepareStatement("select * from user where u_name='" + uname + "' and u_pass='" + upass + "'");
            ResultSet rs = psmt.executeQuery();
            if(rs.next()) {
             
                
                ret = rs.getString("u_id");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public String register(@WebParam(name = "uname") String uname, @WebParam(name = "upass") String upass, @WebParam(name = "uphone") String uphone, @WebParam(name = "uemail") String uemail) {
        System.out.println("registration called here");
        String res = "false";
        
        System.out.println("name: "+uname+"pass: "+upass+"email: "+uemail+"phone: "+uphone);
        
        try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            PreparedStatement psmt = con.prepareStatement("insert into user(u_name,u_pass,u_email,u_phone) values(?,?,?,?)");
            psmt.setString(1, uname);
            psmt.setString(2, upass);
            psmt.setString(3, uemail);
            psmt.setString(4, uphone);
            int rs = psmt.executeUpdate();
            
            if(rs == 1)
            {
                res = "true";
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getinfo")
    public String getinfo(@WebParam(name = "uid") String uid, @WebParam(name = "date") String date) {
        System.out.println("getinfo called here");
        String res = "false";
        
        
        System.out.println("uid:"+uid +"date:"+date);
     try {
            DBsingletone dbs = DBsingletone.getDbSingletone();
            Connection con = dbs.getConnection();
            PreparedStatement psmt = con.prepareStatement("select * from addreport where p_name='"+uid+"' and date='"+date+"' ");   
           ResultSet rs = psmt.executeQuery();
           
            JSONArray array = new JSONArray();
           while(rs.next())
           {              
             JSONObject obj = new JSONObject();
             obj.put("d_name", rs.getString("d_name"));
             obj.put("d_report", rs.getString("d_report"));
             array.put(obj);
           }
           
           
           res = array.toString();
//         res = new Gson().toJson(array);
            
           System.out.println("data "+res);
           
     
     }catch(Exception e)
    {
        e.printStackTrace();
    }
   return res;
}
}
