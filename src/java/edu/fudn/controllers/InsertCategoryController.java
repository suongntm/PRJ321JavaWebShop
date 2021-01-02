/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fudn.controllers;


import edu.fudn.dao.CategoryDao;
import edu.fudn.entities.Category;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SuongNTM
 */
@WebServlet(name = "InsertCategoryController", urlPatterns = {"/InsertCategoryController"})
public class InsertCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //nạp dữ liệu
        
        request.setAttribute("mode", "insert");
        
        RequestDispatcher rd = request.getRequestDispatcher("backend/categories/addOrEdit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String id = request.getParameter("categoryId");
        String name = request.getParameter("name");
        try {
            CategoryDao dao = new CategoryDao();
            Category entity = new Category();
            
            
            
            //entity.setCategoryId(Integer.parseInt(id));
            entity.setName(name);
            
            dao.insertCategory(entity);
            
            RequestDispatcher rd = request.getRequestDispatcher("ListCategoriesController");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
