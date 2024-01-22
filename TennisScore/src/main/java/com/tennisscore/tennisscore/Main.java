
package com.tennisscore.tennisscore;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Tennis Game!");
            System.out.println("Enter the results strings: ");
            
            String input = scanner.nextLine().toUpperCase(); 
            playTennisGame(input);
        }
    }

    public static void playTennisGame(String input) {
        TennisScore.scorePlayers(input);
    }
}
