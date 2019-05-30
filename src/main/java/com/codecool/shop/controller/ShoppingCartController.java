package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.implementation.DB.AnimalDaoDB;
import com.codecool.shop.dao.implementation.Mem.AnimalDaoMem;
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

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("cart", Order.getInstance());
        engine.process("cart/cart.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        AnimalDao animalDataStore = AnimalDaoMem.getInstance();
        AnimalDao animalDataStore = AnimalDaoDB.getInstance();

        if (req.getParameter("id") != null) {
            int animalId = Integer.valueOf(req.getParameter("id"));
            Order.getInstance().add(animalId);

            resp.sendRedirect("/");
        } else if (req.getParameter("add-item-by-id") != null){
            int animalId = Integer.valueOf(req.getParameter("add-item-by-id"));
            Order.getInstance().add(animalId);
            doGet(req, resp);
        } else if (req.getParameter("reduce-item-by-id") != null){
            int animalId = Integer.valueOf(req.getParameter("reduce-item-by-id"));
            Order.getInstance().reduce(animalId);
            doGet(req, resp);
        }

    }
}
