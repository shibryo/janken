package org.example;

import java.util.Scanner;
import java.util.List;
public class JankenController {
    public Player player1;
    public Player player2;
    public int P1WinnerRecord=0;
    public int P2WinnerRecord=0;
    public Scanner scan;
    public JankenController(){
        this.scan = new Scanner(System.in);
    }
    public void start(){
        System.out.println("Title: Start");
    }
    public void entry1(){
        System.out.println("Title: Entry1");
        System.out.println("input>");
        String str = this.scan.nextLine();
        this.player1 = new Player(str);
        System.out.println("player1: " + str);
    }
    public void entry2(){
        System.out.println("Title: Entry2");
        System.out.println("input>");
        String str = this.scan.nextLine();
        this.player2 = new Player(str);
        System.out.println("player2: " + str);
    }
    public void callWinner(){
        if(this.P1WinnerRecord>1){
            System.out.println("Winner: "+ this.player1.Name);
        } else {
            System.out.println("Winner: "+ this.player2.Name);
        }
    }
    public void janken(int i){
// No. n janken
        while(true) {
            System.out.println("No. " + i + "Janken");

// take your hand
            System.out.println("Input the player1's hand");
            System.out.println("input>");
            String hand1 = this.scan.nextLine();
            this.player1.jankenHandsHistory.add(JankenHand.valueOf(hand1));
            System.out.println("player1: " + hand1);

            System.out.println("input>");
            String hand2 = this.scan.nextLine();
            this.player2.jankenHandsHistory.add(JankenHand.valueOf(hand2));
            System.out.println("player2: " + hand2);
// do janken
            var doJankenHand1 = this.player1.jankenHandsHistory.get(i - 1).ordinal();
            var doJankenHand2 = this.player2.jankenHandsHistory.get(i - 1).ordinal();

            if (doJankenHand1 == doJankenHand2) {
                System.out.println("even");
                continue;
            } else if (doJankenHand1 == 0 && doJankenHand2 == 2) {
                P1WinnerRecord++;
                System.out.println("win player1");
            } else if (doJankenHand1 - 1 == doJankenHand2) {
                P1WinnerRecord++;
                System.out.println("win player1");
            } else {
                P2WinnerRecord++;
                System.out.println("win player2");
            }
// recode janken
            break;
        }
    }
}
