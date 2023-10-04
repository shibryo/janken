package org.example;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Controller {
    public Controller() {
        jankenController = new JankenController();
    }
    JankenController jankenController;

    public void start(){
        jankenController.start();
        jankenController.entry1();
        jankenController.entry2();
    }
    public void loop(){
        for (int i=1; i<4; i++){
            jankenController.janken(i);
        }
    }
    public void end(){
        jankenController.callWinner();
    }
}
