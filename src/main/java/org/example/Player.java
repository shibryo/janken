package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Player(String name) {
        this.Name = name;
    }
    public List<JankenHand> jankenHandsHistory =  new ArrayList<>();
    public String Name;
}
