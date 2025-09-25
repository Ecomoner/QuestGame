package com.javarush.questgame.controller;

import com.javarush.questgame.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "HomeServlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Player.getFromSession(req.getSession());
        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Player player = Player.getFromSession(session);

        String playerName = req.getParameter("playerName");

        if (playerName != null && !playerName.isBlank()){
            player.setName(playerName.trim());
        }else {
            req.setAttribute("error","Пожалуйста введите имя");
            doGet(req, resp);
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}
