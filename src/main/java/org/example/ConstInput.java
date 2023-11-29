package org.example;

public class ConstInput implements IStandardInput{
    private String constString;
    public ConstInput(String constString){
        this.constString = constString;
    }

    @Override
    public String getInput() {
        return this.constString;
    }
}
