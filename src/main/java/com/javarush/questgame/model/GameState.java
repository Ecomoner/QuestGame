package com.javarush.questgame.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameState {
    private boolean gameOver;
    private boolean winGame;
    private String message;
    private String currentStep;

    public static GameState startGame(){
        return GameState.builder()
                .currentStep("start")
                .message("Ты потерял помять. Принять вызов НЛО?")
                .gameOver(false)
                .winGame(false)
                .build();
    }
    public GameState updateStepGame(String currentStep,String message,boolean gameOver,boolean winGame){
        return GameState.builder()
                .currentStep(currentStep)
                .message(message)
                .gameOver(gameOver)
                .winGame(winGame)
                .build();
    }

}
