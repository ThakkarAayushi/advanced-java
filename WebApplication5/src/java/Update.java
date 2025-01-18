/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aayushi
 */
public class Update extends HttpServlet {

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
            String uname=request.getParameter("uname");
            String pwd=request.getParameter("pwd");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           // out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
           // out.println("<h2> Record Updated successfully</h2>");
            out.println("</body>");
            out.println("</html>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException ej)
            {
                 out.println(ej);
            }
            String dbname="jdbc:mysql://localhost:3306/dbtest?zeroDateTimeBehavior=convertToNull";
            String name="root";
            String pass="AAYUshi@78";
            try
            {
                   Connection cn=DriverManager.getConnection(dbname,name,pass);
                  //  String q="insert into std1(name,en,bn,sem) values(?,?,?,?)";
              
                    String q="UPDATE user SET pwd = ? WHERE uname = ?";
                    PreparedStatement pst=cn.prepareStatement(q);
                    pst.setString(1, pwd);
                    pst.setString(2,uname);
                    int n=pst.executeUpdate();
                    if(n>0){
                        out.println("Updated successfully");
                    }
                    else{
                        out.println("User not found. Password update failed.");
                    }
            }
            catch(SQLException ej)
            {
                     out.println(ej);
            }
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
