package com.nhnacademy.login;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "logInServlet", urlPatterns = "/login", initParams = {
        @WebInitParam(name = "id", value = "hochul"),
        @WebInitParam(name = "pwd", value = "12345")
})
@Slf4j
public class LogInServlet extends HttpServlet {
    private String configId;
    private String configPassword;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        configId = config.getInitParameter("id");
        configPassword = config.getInitParameter("pwd");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        if (id.equals(configId) && password.equals(configPassword)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);

//            RequestDispatcher rd = req.getRequestDispatcher("/login");
//            rd.forward(req, resp);
            // 요청처리가 별개이면 sendRedirect -> method가 바뀌지 않아서 POST요청만 계속 됨
            resp.sendRedirect("/login");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.error("/login.doGet()");
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            resp.sendRedirect("/login.html");
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("login success: " + session.getAttribute("id"));
            resp.getWriter().println("<a href=\"/logout\">LOGOUT</a>");
            resp.getWriter().println("<br>");
            resp.getWriter().println("<a href=\"/foods\">FOODS</a>");
            resp.getWriter().println("<br>");
            resp.getWriter().println("<a href=\"/cart\">CART</a>");

        }
    }
}
