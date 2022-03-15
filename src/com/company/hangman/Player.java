package com.company.hangman;

import java.util.Locale;
import java.util.Scanner;

public class Player {
    private String name;
    private int wins=0;
    private int losses=0;
    private DifficultyLevels difficultyLevel;

    Player(String name){
        this.changeDifficulty();
        this.name=name;
    }
    public  void changeDifficulty(){
        System.out.println("Please select a difficulty level. You can change this later");
        for (DifficultyLevels difficultyLevels : DifficultyLevels.values()) {
            System.out.println("    *   " + difficultyLevels.getDisplayText());
        }
        Scanner keyboard=new Scanner(System.in);
        this.setDifficultyLevel(DifficultyLevels.valueOf(keyboard.next().toUpperCase(Locale.ROOT)));
    }
    public void setDifficultyLevel(DifficultyLevels difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getName(){
        return this.name;
    }
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public DifficultyLevels getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getMinNumberOfLetters() {
        if (this.getDifficultyLevel().equals(DifficultyLevels.EASY)) {
            return 3;
        }
        if (this.getDifficultyLevel().equals(DifficultyLevels.MEDIUM)) {
            return 6;
        }
        return 9;
    }

    public int getMaxNumberOfLetters() {
        if (this.getDifficultyLevel().equals(DifficultyLevels.EASY)) {
            return 5;
        }
        if (this.getDifficultyLevel().equals(DifficultyLevels.MEDIUM)) {
            return 8;
        }
        return 30;
    }
}

