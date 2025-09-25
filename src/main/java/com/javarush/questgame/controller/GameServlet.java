package com.javarush.questgame.controller;

import com.javarush.questgame.model.GameState;
import com.javarush.questgame.model.Player;
import com.javarush.questgame.service.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "GameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = new GameService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if(gameState == null){
            gameState = GameState.startGame();
            session.setAttribute("gameState",gameState);
        }
        GameState newState = gameService.processChoice(gameState,"start");
        session.setAttribute("gameState",newState);

        req.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        GameState currentState = (GameState) session.getAttribute("gameState");
        Player player = Player.getFromSession(session);

        String choice = req.getParameter("choice");

        if ("restart".equals(choice)){
            session.removeAttribute("gameState");
            session.setAttribute("player",player.incrementOfGame());
            resp.sendRedirect(req.getContextPath() + "/game");
            return;
        }
        try {
            GameState newState = gameService.processChoice(currentState,choice);
            session.setAttribute("gameState",newState);
            if(newState.isGameOver()){
                req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(req,resp);
            }
        }catch (IllegalArgumentException e){
            req.setAttribute("error", "Неверный выбор, попробуйте еще раз");
            req.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(req, resp);
        }

    }
}
