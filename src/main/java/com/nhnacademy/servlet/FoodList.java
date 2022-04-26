package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
        try (PrintWriter out = resp.getWriter()) {
            Units.getFoodList();
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <form action=\"/cart\" method=\"post\">\n" +
                    "        <input type =\"number\" name=\"onion\"/>\"Onion\"<br>\n" +
                    "        <input type=\"number\" name=\"eggs\"/>\"Egg\"<br>\n" +
                    "        <input type=\"number\" name=\"welshOnion\"/>\"WelshOnion\"<br>\n" +
                    "        <input type=\"number\" name=\"apple\"/>\"Apple\"<br>\n" +
                    "        <button type=\"submit\">gimoli</button>\n" +
                    "    </form>\n" +
                    "    \n" +
                    "</body>\n" +
                    "</html>");
            for (Food food : Units.getFoodList()) {
                out.println("<li>");
                out.println(food.toString());
                out.println("</li>");
            }
        }
    }
}
