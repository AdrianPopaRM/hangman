package com.company.hangman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInput {
     private final Set<Character> alreadyUsedLetters = new HashSet<>();

    public char getNextAvailableLetter() {
        char lastGuessedLetter = getNextLetter();
        while (alreadyUsedLetters.contains(lastGuessedLetter)) {
            System.out.println("You already tried this letter,try again");
            lastGuessedLetter = getNextLetter();
        }
        alreadyUsedLetters.add(lastGuessedLetter);
        return lastGuessedLetter;
    }

    private char getNextLetter() {
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine().charAt(0);
    }
}
