package com.javarush.questgame.model;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
    private String name;
    private int countGame = 0;

    public Player incrementOfGame(){
        this.countGame++;
        return this;
    }

    public static Player getFromSession(HttpSession session){
        Player player = (Player) session.getAttribute("player");
        if (player == null){
            player = new Player();
            session.setAttribute("player",player);
        }
        return player;
    }
}
