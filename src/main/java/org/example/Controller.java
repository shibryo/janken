package org.example;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Controller {
    public Controller() {
        jankenController = new JankenController(StandardInput.getInstance());
    }
    JankenController jankenController;

    public void start(){
        this.jankenController.story();
    }
}
