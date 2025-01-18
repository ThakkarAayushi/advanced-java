/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aayushi
 */
public class Calculator extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Calculator at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       // processRequest(request, response);
          int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            String operation = request.getParameter("operation");
               PrintWriter out = response.getWriter();
            // Perform calculation based on the operation
            int result= 0;
            String message = "";
         try{
            if ("add".equalsIgnoreCase(operation)) {
                result = num1 + num2;
                message = "Addition";
            } else if ("subtract".equalsIgnoreCase(operation)) {
                result = num1 - num2;
                message = "Subtraction";
            } else if ("multiply".equalsIgnoreCase(operation)) {
                result = num1 * num2;
                message = "Multiplication";
            } else if ("divide".equalsIgnoreCase(operation)) {
                if (num2 != 0) {
                    result = num1 / num2;
                    message = "Division";
                } else {
                    out.println("<h3>Division by zero is not allowed.</h3>");
                    return;
                }
            } else {
                out.println("<h3>Invalid operation selected!</h3>");
                return;
            }

            // Display the result
            out.println("<html><body>");
            out.println("<h2>Result</h2>");
            out.println("<h3>Operation: " + message + "</h3>");
            out.println("<h3>Result: " + result + "</h3>");
            out.println("<a href='index.html'>Go back</a>");
            out.println("</body></html>");
         }
        catch(NumberFormatException e) {
            out.println("<h3>Error: Please enter valid numeric values.</h3>");
        }
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
