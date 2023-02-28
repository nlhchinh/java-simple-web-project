/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.controller;

import chinh.account.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateNewAccountController", urlPatterns = {"/createnewaccount"})
public class CreateNewAccountController extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // lay cac param
            String userID = request.getParameter("txtUserID");
            String lastName = request.getParameter("txtLastName");
            String password = request.getParameter("txtPassword");
            String confirmPass = request.getParameter("txtConfirmPass");
            String role = request.getParameter("cmbRole");
            
            //goi dao
            AccountDAO dao = new AccountDAO();
            
            if (dao.existUserID(userID) == null) { // check userID da ton tai chua
                if (userID.length() >= 6 && userID.length() < 10) { // check length userID
                    if (lastName.length() >= 2 && lastName.length() < 10) { // check length lastname
                        if (password.length() >= 1 && password.length() < 10) { // check length pass
                            if (password.equals(confirmPass)) { // check confirm pass 
                                // tao moi account
                                dao.createNewACcount(userID, lastName, confirmPass, role); 
                                // message
                                String success = "Create new account successfull! You can use that account to login now.";
                                // set message
                                request.setAttribute("success", success);
                                // chuyen trang
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            } else { // password confirm ko dung
                                String confirm = "Password confirm do not match!!!";
                                request.setAttribute("confirm", confirm);
                                request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
                            }
                        } else { // unvalid pass
                            String lengthPass = "Password length must be more than or equal 1 and less than 10 characters!!!";
                            request.setAttribute("lengthPass", lengthPass);
                            request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
                        } 
                    } else { //unvalid last name
                        String lengthName = "LastName must be more than or equal 2 and less than 10 characters!!!";
                        request.setAttribute("lengthName", lengthName);
                        request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
                    }
                } else { // unvalid userID
                    String lengthID = "UserID length must be more than or equal 6 and less than 10 characters!!!";
                    request.setAttribute("lengthID", lengthID);
                    request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
                }
            } else { // trung userID
                String duplicated = "UserID is duplicated, pls choose other userID characters!!!";
                request.setAttribute("duplicated", duplicated);
                request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
            }
        }
        request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateNewAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateNewAccountController.class.getName()).log(Level.SEVERE, null, ex);
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
