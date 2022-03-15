package com.company.hangman;

public class Main {
    public static void main(String args[]){
        UserInput userInput=new UserInput();
//        .alreadyUsedLetters.add('a');
//        System.out.println(userInput.getNextAvailableLetter());
        Player aurica=new Player("Aurica");
        Game test=new Game(aurica);
    }
}
