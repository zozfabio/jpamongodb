package com.mycompany.firsteclipselinkmongodb.controller;

import com.mycompany.firsteclipselinkmongodb.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Principal", urlPatterns = {"/principal"})
public class Principal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("firsteclipselinkmongodbPU");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        Pessoa p  = new Pessoa();
        p.setNome("Fabio");
        manager.persist(p);
        
        manager.getTransaction().commit();
        
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Servlet Principal</title>");            
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Servlet Principal</h1>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}