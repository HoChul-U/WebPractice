package com.nhnacademy.servlet;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@WebServlet(name = "cart", urlPatterns = "/cart" )
@Slf4j
public class Cart extends HttpServlet {
    int money;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (getServletContext().getAttribute("onion") == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("view","/cart.jsp");
//        try (PrintWriter out = resp.getWriter()) {
//            for (Food food : Units.getFoodList()) {
//                out.println(food.getFoodName() + "  :  " + food.getFoodCount());
//            }
//            out.println("final price :" + req.getAttribute("money"));
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer money;
        if(Objects.isNull(req.getAttribute("money"))){
            money = 0;
        } else {
            money = (Integer) req.getAttribute("money");
        }
        try (PrintWriter out = resp.getWriter()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
            noFoodException(req, resp, requestDispatcher);
            for (Food food : Units.getFoodList()) {
                log.info(req.getParameter(food.getFoodName()));
                Units.setFoodList(getServletContext(), food.getFoodName(), parseInt(req.getParameter(food.getFoodName())));
                money += food.getFoodMoney() * parseInt(req.getParameter(food.getFoodName()));
                log.error(String.valueOf(money));
            }
            req.setAttribute("money",String.valueOf(money));
            RequestDispatcher rd = req.getRequestDispatcher("/cart.jsp");
            rd.forward(req,resp);
        }
    }

    private boolean isFoodOverCount(HttpServletRequest req, String food, int index) {
        return Integer.parseInt(req.getParameter(food)) < 0
                || Integer.parseInt(req.getParameter(food)) > Units.getFoodList().get(index).getFoodCount();
    }

    private void noFoodException(HttpServletRequest req, HttpServletResponse resp, RequestDispatcher requestDispatcher) throws ServletException, IOException {
        if (isFoodOverCount(req, "onion", 0)) {
            requestDispatcher.forward(req, resp);
        }
        if (isFoodOverCount(req, "eggs", 1)) {
            requestDispatcher.forward(req, resp);
        }
        if (isFoodOverCount(req, "welshOnion", 2)) {
            requestDispatcher.forward(req, resp);
        }
        if (isFoodOverCount(req, "apple", 3)) {
            requestDispatcher.forward(req, resp);
        }
    }
}
