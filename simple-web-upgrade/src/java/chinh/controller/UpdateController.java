/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.controller;

import chinh.account.AccountDAO;
import chinh.account.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/update"})
public class UpdateController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // lay cac param
            String userID = request.getParameter("txtUserID");
            String lastName = request.getParameter("txtLastName");
            String password = request.getParameter("txtPassword");
            String role = request.getParameter("txtRole");
            
            // goi dao
            AccountDAO dao = new AccountDAO();
            // trim last name
            String checkName = lastName.trim();
            
            if (checkName.length() > 0 && checkName.length() < 10) { // check length last name
                String checkPass = password.trim();
                if (checkPass.length() > 0 && checkPass.length() < 10) { //check length pass
                    // update account
                    dao.updateByLastName(checkName, checkPass, role, userID);
                    // lay lai gia tri search
                    String txtSearchValue = request.getParameter("lastSearchValue");
                    // search lai
                    dao.searchLastName(txtSearchValue);
                    // goi list acc
                    List<AccountDTO> result = dao.getListAccount();
                    // set result
                    request.setAttribute("SEARCHRESULT", result);
                    // chuyen trang
                    request.getRequestDispatcher("search?txtSearchValue=" + txtSearchValue).forward(request, response);
                } else { // unvalid pass
                    String txtSearchValue = request.getParameter("lastSearchValue");
                    dao.searchLastName(txtSearchValue);
                    List<AccountDTO> result = dao.getListAccount();
                    request.setAttribute("SEARCHRESULT", result);
                    request.getRequestDispatcher("search?txtSearchValue=" + txtSearchValue).forward(request, response);
                }
            } else { // unvalid last name
                String txtSearchValue = request.getParameter("lastSearchValue");
                dao.searchLastName(txtSearchValue);
                List<AccountDTO> result = dao.getListAccount();
                request.setAttribute("SEARCHRESULT", result);
                request.getRequestDispatcher("search?txtSearchValue=" + txtSearchValue).forward(request, response);
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
        try {
            processRequest(request, response);
        

} catch (SQLException ex) {
            Logger.getLogger(UpdateController.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (NamingException ex) {
            Logger.getLogger(UpdateController.class
.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        

} catch (SQLException ex) {
            Logger.getLogger(UpdateController.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (NamingException ex) {
            Logger.getLogger(UpdateController.class
.getName()).log(Level.SEVERE, null, ex);
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
