package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.SpeciesDao;
import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.ZooDao;
import com.codecool.shop.dao.implementation.Mem.SpeciesDaoMem;
import com.codecool.shop.dao.implementation.Mem.AnimalDaoMem;
import com.codecool.shop.dao.implementation.Mem.ZooDaoMem;
import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Order;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnimalDao animalDataStore = AnimalDaoMem.getInstance();
        SpeciesDao speciesDataStore = SpeciesDaoMem.getInstance();
        ZooDao zooDataStore = ZooDaoMem.getInstance();

        if (req.getParameter("id") != null){
            int animalId = Integer.valueOf(req.getParameter("id"));
            Order.getInstance().add(animalDataStore.find(animalId));
        }

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        String filter_species = req.getParameter("species");
        String filter_zoo = req.getParameter("zoo");

        context.setVariable("species", speciesDataStore.getAll());
        context.setVariable("zoos", zooDataStore.getAll());
        context.setVariable("cart", Order.getInstance());
        context.setVariable("animals", filterAnimals(filter_species, filter_zoo));
        engine.process("product/index.html", context, resp.getWriter());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private List<Animal> filterAnimals(String species, String zoo) {
        return AnimalDaoMem.getInstance().getAll().stream()
                .filter(animal -> species == null || species.equals("") || animal.getSpecies().getId() == Integer.valueOf(species))
                .filter(animal -> zoo == null || zoo.equals("") || animal.getZoo().getId() == Integer.valueOf(zoo))
                .collect(Collectors.toList());
    }
}
