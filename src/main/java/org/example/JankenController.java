package org.example;

import java.util.Scanner;
public class JankenController {
    public Player p1;
    public Player p2;
    public int maxRound=3;
    public int currentRound=1;
    public IStandardInput standardInput;
    public JankenController(IStandardInput standardInput){
        this.standardInput = standardInput;
    }
    public void story(){
        this.start();
        this.jankens();
        this.callWinner();
    }
    public void start(){
        System.out.println("[Rock-Paper-Scissors Begins]");
        System.out.println();
    }
    public void entry1(String p1name, IStandardInput standardInput){
        System.out.println("Entry: player1");
        System.out.print("name> ");
        this.p1 = new Player(p1name, standardInput);
        System.out.println("player1: " + p1name);
        System.out.println();
    }
    public void entry1(){
        System.out.println("Entry: player1");
        System.out.print("name> ");
        String p1name = this.standardInput.getInput();
        this.p1 = new Player(p1name, this.standardInput);
        System.out.println("player1: " + p1name);
        System.out.println();
    }
    public void entry2(String p2name,IStandardInput standardInput){
        System.out.println("Entry: player2");
        System.out.print("name> ");
        this.p2 = new Player(p2name, standardInput);
        System.out.println("player2: " + p2name);
        System.out.println();
    }
    public void entry2(){
        System.out.println("Entry: player2");
        System.out.print("name> ");
        String p2name = this.standardInput.getInput();
        this.p2 = new Player(p2name, this.standardInput);
        System.out.println("player2: " + p2name);
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
        if (hand1 == hand2) {
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
            this.p1.takeYourHand();
            this.p2.takeYourHand();
            this.play(this.p1, this.p2);
            this.currentRound++;
        }
    }
    public void play(Player p1, Player p2){
        System.out.println(p1.getHand() + " vs. " + p2.getHand());
        var p1JankenResult = this.judge(p1.getHand(), p2.getHand());
        var p2JankenResult = this.judge(p2.getHand(), p1.getHand());
        System.out.println(p1.Name + " " + p1JankenResult);

        p1.recordWin(p1JankenResult);
        p2.recordWin(p2JankenResult);
    }
}
