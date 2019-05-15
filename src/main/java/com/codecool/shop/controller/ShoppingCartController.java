package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.codecool.shop.model.Order;


@WebServlet(urlPatterns = {"/shopping-cart"})
public class ShoppingCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        Order order = new Order();

        //testing the order methods
        Product product_eins = new Product("Something", 20f, "USD", "nope", productCategoryDataStore.find(1), supplierDataStore.find(1));
        Product product_zwei = new Product("Something else", 25f, "USD", "nope and nope", productCategoryDataStore.find(1), supplierDataStore.find(1));

        order.add(product_eins);
        order.add(product_eins);
        order.add(product_zwei);


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("", productCategoryDataStore.find(1));
        context.setVariable("cart", order);
        engine.process("cart/cart.html", context, resp.getWriter());
    }

}
