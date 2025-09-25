package com.javarush.questgame.service;

import java.io.*;

import com.javarush.questgame.model.GameState;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class GameService  {

    public GameState processChoice(GameState currentState,String choice){
            return switch (currentState.getCurrentStep()){
                case "start" -> startStep();
                case "acceptanceOfACall" -> acceptanceOfACall(choice);
                case "goToBridge" -> raisingOnTheBridge(choice);
                case "aboutYourself" -> trueAboutYourself(choice);
                default -> throw new IllegalStateException("Неизвестное состояние игры: " + currentState.getCurrentStep());
            };
    }
    public GameState startStep(){
        return GameState.startGame().updateStepGame(
                "acceptanceOfACall",
                "Ты потерял память. Принять вызов НЛО?"
                ,false
                ,false
        );
    }
    public GameState acceptanceOfACall(String choice){
        return switch (choice){
            case "1" -> new GameState(
                    false,
                    false,
                    "Ты принял вызов. Поднимаешься на мостик к капитану?",
                    "goToBridge"
            );
            case "2" -> new GameState(
                    true,
                    false,
                    "Ты отклонил вызов. Поражение",
                    "end"
            );
            default -> throw new IllegalArgumentException("Неверный выбор: " + choice);
        };
    }
    public GameState raisingOnTheBridge(String choice){
            return switch (choice){
                case "1" -> new GameState(
                        false,
                        false,
                        "Ты поднялся на мостик. Кто ты такой?",
                        "aboutYourself"
                );
                case "2" -> new GameState(
                        true,
                        false,
                        "Ты не пошел на переговоры. Поражение",
                        "end"
                );
                default -> throw new IllegalArgumentException("Невырный выбор: " + choice);
            };
    }
    public GameState trueAboutYourself(String choice){
            return switch (choice){
                case "1" -> new GameState(
                        true,
                        true,
                        "Тебя вернули домой. Победа",
                        "win"
                );
                case "2" -> new GameState(
                        true,
                        false,
                        "Твою ложь разоблачили. Поражение",
                        "end"
                );
                default -> throw new IllegalArgumentException("Невырный выбор: " + choice);
            };
    }
}