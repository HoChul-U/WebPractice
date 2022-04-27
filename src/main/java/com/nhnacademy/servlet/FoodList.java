package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "foodList",urlPatterns = "/foods")
public class FoodList extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Units.inputFood(getServletContext());
        req.setAttribute("foodList",Units.getFoodList());
        req.setAttribute("view","foodlist.jsp");
//            RequestDispatcher rd = req.getRequestDispatcher("foodlist.jsp");
//            rd.forward(req,resp);
    }
}
