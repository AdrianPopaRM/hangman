package com.company.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private GameStatus gameStatus;
    private UserInput userInput;
    Player player;

    public Game(Player player) {
        this.player = player;
        Graphics.displayMenu(gameStatus,this);
    }

    public void play() {
        this.gameStatus = new GameStatus(choosingTheWord());
        this.userInput = new UserInput();
        while (!gameStatus.gameIsOver()) {
            gameStep();
        }
        finalStep();
        Graphics.displayMenu(gameStatus,this);
    }

    private void playerWon() {
        Graphics.survived();
        System.out.println("You win boay");
        this.player.setWins(this.player.getWins() + 1);
    }

    private void playerLost() {
        Graphics.deadPhase();
        System.out.println("You lost this time, maybe get lucky next time huh?");
        this.player.setLosses(this.player.getLosses() + 1);
    }

    public String choosingTheWord() {
        List<String> list = new ArrayList<>();
        int minNumberOfLetters = this.player.getMinNumberOfLetters();
        int maxNumberOfLetters = this.player.getMaxNumberOfLetters();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/com/company/week10/ex3_hangMan/dictionary.txt"))) {
            String input;
            while ((input = br.readLine()) != null) {
                if (input.length() >= minNumberOfLetters && input.length() <= maxNumberOfLetters) {
                    list.add(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.get((int) Math.floor(Math.random() * (list.size())));
    }

    public void gameStep() {
        Graphics.displayHangMan(this.gameStatus.getNumberOfTry());
        System.out.println(Arrays.toString(this.gameStatus.getWordInCharFormat()) + "    " + "Current attempt is " + (this.gameStatus.getNumberOfTry() + 1) + ". Enter your guess: ");
        gameStatus.wordContainsPlayerGuessedLetter(userInput.getNextAvailableLetter());
    }

    public void finalStep() {
        if (!gameStatus.playerHasGuessedWord()) {
            playerLost();
        } else {
            playerWon();
        }
    }

}
