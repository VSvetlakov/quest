package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "loginServlet", value = "/login")
public class InitServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(InitServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        String username = (String) currentSession.getAttribute("username");

        if (username == null){
            getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/main.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user      = req.getParameter("username");
        String password  = req.getParameter("password");
        String ipAddress = req.getRemoteAddr();

        log.info("Пользователь {} вошел в систему", user);

        HttpSession currentSession = req.getSession();

        currentSession.setAttribute("user",user);
        currentSession.setAttribute("winCount",0);
        currentSession.setAttribute("loseCount",0);

        resp.sendRedirect(req.getContextPath() + "/main.jsp");
    }
}
