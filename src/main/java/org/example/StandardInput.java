package org.example;

import java.util.Scanner;

public class StandardInput implements IStandardInput {
    private static StandardInput instance;
    public Scanner scanner;
    private StandardInput(Scanner scanner){
        this.scanner = scanner;
    }
    public static StandardInput getInstance() {
        if (instance == null){
            instance = new StandardInput(new Scanner(System.in));
        }
        return instance;
    }
    @Override
    public String getInput() {
        return this.scanner.nextLine();
    }
}
