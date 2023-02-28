/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.controller;

import chinh.shopping.Cart;
import chinh.shopping.Tea;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCartController", urlPatterns = {"/updatecart"})
public class UpdateCartController extends HttpServlet {

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
            // lay cac param
            String id = request.getParameter("id");
            int newQuantity = Integer.parseInt(request.getParameter("quantity"));
            
            // goi session
            HttpSession session = request.getSession();
            // lay session cart hien tai
            Cart cart = (Cart) session.getAttribute("CART");
            //khoi tao obj tea
            Tea tea = null;
            for (Tea dto : cart.getCart().values()) { // loop tung obj trong cart
                if (dto.getId().equals(id)) { // check id => trung thi update
                    // lay name
                    String name = dto.getName();
                    // lay gia
                    int price = dto.getPrice();
                    // new tea
                    tea = new Tea(id, name, newQuantity, price);
                    // tim thi break
                    break;
                }
            }
            // update cart
            cart.update(id, tea);
            // set lai cart
            session.setAttribute("CART", cart);
            // chuyen trang
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);
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
