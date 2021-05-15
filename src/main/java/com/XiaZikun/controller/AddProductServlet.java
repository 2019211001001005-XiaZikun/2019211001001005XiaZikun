package com.XiaZikun.controller;

import com.XiaZikun.dao.ProductDao;
import com.XiaZikun.model.Category;
import com.XiaZikun.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)// 16 mB
public class AddProductServlet extends HttpServlet {
    Connection con= null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList= null;
        try {
            categoryList = Category.findAllCategory(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("categoryList",categoryList);
        //we will use later
        String path="/WEB-INF/views/admin/addProduct.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all parameter
        String productName=request.getParameter("productName");
        double price = request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription = request.getParameter("productDescription");

        //get picture
        InputStream inputStream=null;
        Part fileParts= request.getPart("picture");//baidu
        if (fileParts!=null){
            inputStream=fileParts.getInputStream();
        }

        //set into model
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        //call same in dao
        ProductDao productDao=new ProductDao();
        try {
            int n=productDao.save(product,con);
            if(n>0){
                response.sendRedirect("productList");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //forward
    }
}
