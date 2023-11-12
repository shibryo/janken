package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    public Player(String name, IStandardInput standardInput) {
        this.standardInput = standardInput;
        this.Name = name;
        this.winTimes = 0;
    }
    public String Name;
    public JankenHand Hand;
    public int winTimes;
    public IStandardInput standardInput;

    public JankenHand getHand() {
        return this.Hand;
    }
    public void recordWin(String result){
        if(Objects.equals(result, "WIN"))
            this.winTimes++;
    }

    public void takeYourHand(){
        this.Hand = null;
        System.out.println("Input the "+ this.Name +"'s hand");
        while (this.Hand == null) {
            System.out.print("hand> ");
            var hand = this.standardInput.getInput().toUpperCase();
            try {
                this.Hand = JankenHand.valueOf(hand);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter ROCK, PAPER, or SCISSORS.");
            }
        }
    }
}
