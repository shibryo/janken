package org.example;

import java.util.Scanner;
public class JankenController {
    public Player p1;
    public Player p2;
    public int maxRound=3;
    public int currentRound=1;
    public Scanner scan;
    public JankenController(){
        this.scan = new Scanner(System.in);
    }
    public void story(){
        this.start();
        this.entry1();
        this.entry2();
        this.jankens();
        this.callWinner();
    }
    public void start(){
        System.out.println("[Rock-Paper-Scissors Begins]");
        System.out.println();
    }
    public void entry1(){
        System.out.println("Entry: player1");
        System.out.print("name> ");
        String str = this.scan.nextLine();
        this.p1 = new Player(str, this.scan);
        System.out.println("player1: " + str);
        System.out.println();

    }
    public void entry2(){
        System.out.println("Entry: player2");
        System.out.print("name> ");
        String str = this.scan.nextLine();
        this.p2 = new Player(str, this.scan);
        System.out.println("player2: " + str);
        System.out.println();

    }
    public void callWinner(){
        System.out.print(this.p1.winTimes + " to " + this.p2.winTimes);
        if (this.p1.winTimes == this.p2.winTimes) {
            System.out.println(" even...");
        } else if(this.p1.winTimes > this.p2.winTimes){
            System.out.println(" "+ this.p1.Name + " win!");
        } else {
            System.out.println(" "+ this.p2.Name + " win!");
        }
    }
    public String judge(JankenHand hand1, JankenHand hand2){
        System.out.println(hand1 + " vs. " + hand2);
        if (hand1 == hand2) {
            System.out.println("draw");
            return "DRAW";
        } else if (hand1==JankenHand.PAPER && hand2==JankenHand.ROCK
                || hand1==JankenHand.ROCK && hand2==JankenHand.SCISSORS
                || hand1==JankenHand.SCISSORS && hand2==JankenHand.PAPER) {
            return "WIN";
        } else {
            return "LOSE";
        }
    }
    public void jankens(){
        while(this.currentRound<=this.maxRound){
            this.janken();
            this.currentRound++;
        }
    }
    public void janken(){
        System.out.println("[Round "+ currentRound +"]");

        this.p1.takeYourHand();
        this.p2.takeYourHand();
        var hand1 = this.p1.getHand();
        var hand2 = this.p2.getHand();
        var jankenResult = this.judge(hand1, hand2);
        System.out.println("p1" + jankenResult);

    }
}
