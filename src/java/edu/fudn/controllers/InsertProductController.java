/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fudn.controllers;

import edu.fudn.dao.CategoryDao;
import edu.fudn.dao.ProductDao;
import edu.fudn.entities.Category;
import edu.fudn.entities.Product;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author SuongNTM
 */
@WebServlet(name = "InsertProductController", urlPatterns = {"/InsertProductController"})
public class InsertProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            CategoryDao dao = new CategoryDao();
            List<Category> list = dao.findAllCategories();

            request.setAttribute("categories", list);

            RequestDispatcher rd = request.getRequestDispatcher("backend/products/addOrEdit.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(InsertProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            HashMap<String, String> fields = new HashMap<>();
            String imageName = null;
            while (iter.hasNext()) {
                FileItem item = iter.next();

                if (item.isFormField()) {
                    fields.put(item.getFieldName(), item.getString());
                } else {
                    String filename = item.getName();
                    Path path = Paths.get(filename);
                    
                    String storedPath = servletContext.getRealPath("/uploads");
                    
                    File uploadedFile = new File(storedPath + "/" + path.getFileName());
                    item.write(uploadedFile);
                    imageName = path.getFileName().toString();
                    System.out.println(storedPath + "/" + path.getFileName());
                }
            }
            
            Product prod = new Product();
            prod.setName(fields.get("name"));
            prod.setPrice(Double.parseDouble(fields.get("price")));
            prod.setQuantity(Integer.parseInt(fields.get("quantity")));
            prod.setStatus(fields.get("status"));
            prod.setDescription(fields.get("description"));
            prod.setManufacturedDate(new Date());
            Category cate = new Category();
            cate.setCategoryId(Integer.parseInt(fields.get("categoryId")));
            prod.setCategories(cate);
            prod.setImage(imageName);
            
            ProductDao dao = new ProductDao();
            dao.insertProduct(prod);
            
            RequestDispatcher rd = request.getRequestDispatcher("ListProductsController");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
