package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Order;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("order", Order.getInstance());
        engine.process("checkout/checkout.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order.getInstance().setCustomerName(request.getParameter("ShippingName"));
        Order.getInstance().setCustomerEmail(request.getParameter("ShippingEmail"));
        Order.getInstance().setCustomerPhone(request.getParameter("ShippingPhone"));
        Order.getInstance().setCountry(request.getParameter("ShippingCountry"));
        Order.getInstance().setCity(request.getParameter("ShippingCity"));
        Order.getInstance().setZip(request.getParameter("ShippingZip"));
        Order.getInstance().setAddress(request.getParameter("ShippingAddress"));
        response.sendRedirect("/payment");
    }
}
