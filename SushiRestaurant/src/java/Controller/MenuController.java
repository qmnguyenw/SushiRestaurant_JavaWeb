/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MenuDAO;
import Entity.Menu;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quang Nguyen
 */
public class MenuController extends HttpServlet {

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
        String message = null;
        try {
            String currentPageStr = request.getParameter("currentPage");
            int currentPage = -1;
            if (currentPageStr == null) {
                currentPage = 1;
            } else {
                currentPage = Integer.parseInt(currentPageStr);
            }
            request.setAttribute("currentPage", currentPage);
            
            MenuDAO menuDAO = new MenuDAO();
            ArrayList<Menu> listMenu = menuDAO.getTotalMenu(currentPage);
            int totalPage = menuDAO.getNumberPage();
            request.setAttribute("listMenu", listMenu);
            request.setAttribute("totalPage", totalPage);
            if (listMenu == null || totalPage == 0 || currentPage < 1 || currentPage > totalPage) {
                message = "Not found any menu";
            }
        } catch (NumberFormatException ex) {
            message = "Current page must be number";
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher("exception.jsp").forward(request, response);
            return;
        }
        request.setAttribute("menu", true);
        request.setAttribute("message", message);
        request.getRequestDispatcher("menu.jsp").forward(request, response);
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
