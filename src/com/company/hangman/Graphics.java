package com.company.hangman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Graphics {
    public static void displayHangMan(int step){
//        if(step==0) {
//            System.out.println("    ___________");
//            System.out.println("   ║");
//            System.out.println("   ║");
//            System.out.println("   ║");
//            System.out.println("   ║");
//            System.out.println("   ║");
//            System.out.println("   ║");
//            System.out.println("———————");
//        }
        if(step==0){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("———————");
        }
        if(step==1){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║           ☺");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("———————");
        }
        if(step==2){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║           ☺");
            System.out.println("   ║           |  ");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("———————");
        }
        if(step==3){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║           ☺");
            System.out.println("   ║         / |  ");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("———————");
        }
        if(step==4){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║           ☺");
            System.out.println("   ║         / | \\ ");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("———————");
        }
        if(step==5){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║           ☺");
            System.out.println("   ║         / | \\ ");
            System.out.println("   ║           |");
            System.out.println("   ║");
            System.out.println("   ║");
            System.out.println("———————");
        }
        if(step==6){
            System.out.println("    ___________");
            System.out.println("   ║           |");
            System.out.println("   ║           ☺");
            System.out.println("   ║         / | \\ ");
            System.out.println("   ║           |");
            System.out.println("   ║         /   \\ ");
            System.out.println("   ║");
            System.out.println("———————");
        }
//        System.out.println("    ___________");
//        System.out.println("   ║           |");
//        System.out.println("   ║           ☺");
//        System.out.println("   ║         / | \\ ");
//        System.out.println("   ║           |");
//        System.out.println("   ║         /   \\ ");
//        System.out.println("   ║");
//        System.out.println("———————");

    }
    public static void deadPhase(){
        System.out.println("    ___________");
        System.out.println("   ║           |");
        System.out.println("   ║           ☠");
        System.out.println("   ║         / | \\ ");
        System.out.println("   ║           |");
        System.out.println("   ║         /   \\ ");
        System.out.println("   ║");
        System.out.println("———————");
    }
    public static void survived(){
        System.out.println("    ___________");
        System.out.println("   ║           |");
        System.out.println("   ║");
        System.out.println("   ║           ☺");
        System.out.println("   ║         / | \\ ");
        System.out.println("   ║           |");
        System.out.println("———————      /   \\ ");
    }
    public static void displayMenu(GameStatus gameStatus, Game game) {
        System.out.println("    *    Hi " + game.player.getName() + ", glad to see you again");
        System.out.println("    *    Your win / lose ratio is: " + game.player.getWins() + " / " + game.player.getLosses());
        System.out.println("    *       1) Play");
        System.out.println("    *       2) If you want to change difficulty ");
        System.out.println("    *       3) If you want to add words to the dictionary");
        System.out.println("    *       4) Exit game");
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();

        if (choice == 1) {
            game.play();
        }
        if (choice == 2) {
            game.player.changeDifficulty();
            Graphics.displayMenu(gameStatus,game);

        }
        if (choice == 3) {
            try {
                FileWriter file = new FileWriter("src/com/company/week10/ex3_hangMan/dictionary.txt", true);
                System.out.println("Enter a word for the dictionary: ");
                Scanner s = new Scanner(System.in);
                BufferedWriter output = new BufferedWriter(file);
                output.write(s.next());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Graphics.displayMenu(gameStatus,game);
        }
        if (choice == 4) {
            System.out.println("Hope i'll see you again " + game.player.getName() + ". Have a good day.");
        }
    }

    public static char[] firstDisplayOfTheWord(String word) {
        char[] wordInCharFormat = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) == word.charAt(0)) || (word.charAt(i) == word.charAt(word.length() - 1))) {
                wordInCharFormat[i] = word.charAt(i);
                continue;
            }
            wordInCharFormat[i] = '_';
        }
        return wordInCharFormat;
    }
}
