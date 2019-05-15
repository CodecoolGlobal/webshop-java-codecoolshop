package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDao = SupplierDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        ProductCategory category;

        String categoryId = (req.getParameter("category") != null) ? req.getParameter("category") : "";
        try {
            category = productCategoryDataStore.find(Integer.parseInt(categoryId));
        } catch (NumberFormatException e) {
            category = new ProductCategory("Products", "Default", "Default description");
        }

        Supplier supplier;

        String supplierId = (req.getParameter("supplier") != null) ? req.getParameter("supplier") : "";
        try {
            supplier = supplierDao.find(Integer.parseInt(supplierId));
        } catch (NumberFormatException e) {
            supplier = new Supplier("Default supplier", "Default state", "Default city", "Default description");
        }

        context.setVariable("category", category);
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("suppliers", supplierDao.getAll());

        if (category.getName().equals("Products") && !supplier.getName().equals("Default supplier")) {
            context.setVariable("products", productDataStore.getBy(supplier));
        } else if (!category.getName().equals("Products") && supplier.getName().equals("Default supplier")) {
            context.setVariable("products", productDataStore.getBy(category));
        } else if (category.getName().equals("Products") && supplier.getName().equals("Default supplier")) {
            context.setVariable("products", productDataStore.getAll());
        } else {
            context.setVariable("products", productDataStore.getBy(supplier, category));
        }

        engine.process("product/index.html", context, resp.getWriter());
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
