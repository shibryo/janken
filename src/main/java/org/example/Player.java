package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    public Player(String name, Scanner scan) {
        this.scan = scan;
        this.Name = name;
        this.winTimes = 0;
    }
    public String Name;
    public JankenHand Hand;
    public int winTimes;
    public Scanner scan;

    public JankenHand getHand() {
        var hand = this.Hand;
        this.Hand = null;
        return hand;
    }
    public void recordWin(String result){
        if(Objects.equals(result, "WIN"))
            this.winTimes++;
    }

    public void takeYourHand(){
        System.out.println("Input the "+ this.Name +"'s hand");
        while (this.Hand == null) {
            System.out.print("hand> ");
            var hand = scan.nextLine().toUpperCase();
            try {
                this.Hand = JankenHand.valueOf(hand);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter ROCK, PAPER, or SCISSORS.");
            }
        }
    }
}
