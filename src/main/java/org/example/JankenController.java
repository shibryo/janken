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
            System.out.println("[Round "+ currentRound +"]");
            this.janken(this.p1, this.p2);
            this.currentRound++;
        }
    }
    public void janken(Player p1, Player p2){

        p1.takeYourHand();
        p2.takeYourHand();
        var hand1 = p1.getHand();
        var hand2 = p2.getHand();
        var p1JankenResult = this.judge(hand1, hand2);
        var p2JankenResult = this.judge(hand2, hand1);
        p1.recordWin(p1JankenResult);
        p2.recordWin(p2JankenResult);

    }
}
