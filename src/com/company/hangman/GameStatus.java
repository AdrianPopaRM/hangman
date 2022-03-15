package com.company.hangman;

public class GameStatus {
    private int numberOfTry = 0;
    private char[] wordInCharFormat;
    private final String searchedWord;

    public GameStatus(String searchedWord) {
        this.searchedWord = searchedWord;
        this.wordInCharFormat = Graphics.firstDisplayOfTheWord(searchedWord);
    }

    public char[] getWordInCharFormat() {
        return wordInCharFormat;
    }

    public boolean gameIsOver() {
        return numberOfTry == 7 || playerHasGuessedWord();
    }

    public boolean playerHasGuessedWord() {
        for (char c : wordInCharFormat) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public void wordContainsPlayerGuessedLetter(char letter) {
        if (searchedWord.contains(Character.toString(letter))) {
            System.out.println("You guessed right");
            updateTheWord(letter);
            return;
        }
        System.out.println("You guessed wrong this time, better luck next time..");
        numberOfTry++;
    }

    private char[] updateTheWord(char guessedLetter) {
        for (int i = 1; i < this.searchedWord.length() - 1; i++) {
            if (this.searchedWord.charAt(i) == guessedLetter) {
                wordInCharFormat[i] = guessedLetter;
            }
        }
        return wordInCharFormat;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}
