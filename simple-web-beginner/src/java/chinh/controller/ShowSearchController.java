/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.controller;

import chinh.account.AccountDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ShowSearchResult", urlPatterns = {"/showsearchresult"})
public class ShowSearchController extends HttpServlet {

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
            out.println("<title>Servlet ShowSearchResult</title>");
            out.println("</head>");
            out.println("<body>");

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String userName = cookies[0].getValue();
                out.println("<font color='red'>Welcome,"
                        + userName
                        + "</font>");
            }

            out.println("<a href='main?action=logout'>Logout</a>");

            out.println("<h1>Search Result</h1>");

            String searchValue = request.getParameter("txtSearchValue");

            out.println("Your search value is " + searchValue);
            List<AccountDTO> result = (List<AccountDTO>) request.getAttribute("SEARCHRESULT");
            if (result != null) {
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>UserID</th>");
                out.println("<th>Lastname</th>");
                out.println("<th>Password</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (AccountDTO dto : result) {
                    out.println("<form action=main>");
                    out.println("<tr>");
                    out.println("<td>"
                            + dto.getUserID()
                            + "<input type='text' name='txtUserID' value='" + dto.getUserID() + "' hidden>"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='text' name='txtLastName' value='" + dto.getLastName() + "'>"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='text' name='txtPassword' value='" + dto.getPassword() + "'>"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='text' name='txtRole' value='" + dto.getRole() + "'>"
                            + "</td>");
                    out.println("<td>"
                            + "<a href='main?action=delete&lastName=" + dto.getLastName() + "&userID=" + dto.getUserID() + "&searchValue=" + searchValue + "'" + ">Delete</a>"
                            + "</td>");
                    out.println("<td>"
                            + "<input type='text' name='searchValue' value='" + searchValue + "' hidden>"
                            + "<input type='submit' name='action' value='update'>"
                            + "</td>");
                    out.println("</tr>");
                    out.println("</form>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("<h4 style='color : green'>Note:<br>"
                        + "Lastname and password name length must be less than 10 and more than 1 character.<br>"
                        + "Role update must be 'us' or 'US' or 'ad' or 'AD'.</h4>");
                out.println("<a href='searchpage'>Continue to search</a>");
            } else {
                out.println("<h2> No record is matched</h2>");
                out.println("<a href='searchpage'>Continue to search</a>");
            }
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
