package com.company.hangman;

public enum DifficultyLevels {
    EASY("Easy: 3-5 letter words"),
    MEDIUM("Medium: 6-8 letter words"),
    HARD("Hard: 9-30 letter words");

    private String displayText;

    DifficultyLevels(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
