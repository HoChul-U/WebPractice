package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

@WebServlet(name = "cart",urlPatterns = "/cart")
@Slf4j
public class Cart extends HttpServlet {
    private int money;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(getServletContext().getAttribute("onion")==null)
            resp.sendError(588, "init부터 실행하여주세요");
        try (PrintWriter out = resp.getWriter()) {
            for (Food food : Units.getFoodList()) {
                out.println(food.getFoodName() + "  :  " + food.getFoodCount());
            }
            out.println("final price :" + money);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            if (isFoodOverCount(req, "onion", 0)) {
                resp.sendError(588, "수량과맞지않는 숫자가 입력되었습니다.");
            }
            if (isFoodOverCount(req, "eggs", 1)) {
                resp.sendError(588, "수량과맞지않는 숫자가 입력되었습니다.");
            }
            if (isFoodOverCount(req, "welshOnion", 2)) {
                resp.sendError(588, "수량과맞지않는 숫자가 입력되었습니다.");
            }
            if (isFoodOverCount(req, "apple", 3)) {
                resp.sendError(588, "수량과맞지않는 숫자가 입력되었습니다.");
            }
            for (Food food : Units.getFoodList()) {
                log.info(req.getParameter(food.getFoodName()));
                Units.setFoodList(getServletContext(), food.getFoodName(), parseInt(req.getParameter(food.getFoodName())));
                money += food.getFoodMoney() * parseInt(req.getParameter(food.getFoodName()));
            }
            resp.sendRedirect("/cart");
        }
    }

    private boolean isFoodOverCount(HttpServletRequest req, String food, int index) {
        return Integer.parseInt(req.getParameter(food)) < 0
                || Integer.parseInt(req.getParameter(food)) > Units.getFoodList().get(index).getFoodCount();
    }
}
