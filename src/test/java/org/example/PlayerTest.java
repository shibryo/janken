package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    @Test
    void IfInputWinPlayersWinTimesIncrement()
    {
        var player = new Player("test",  StandardInput.getInstance());
        var jankenResult = "WIN";

        player.recordWin(jankenResult);

        assertEquals(1, player.winTimes);
    }
    @Test
    void IfInputWin2TimesPlayersWinTimesIncrement(){
        var player = new Player("test", StandardInput.getInstance());
        var jankenResult = "WIN";

        player.recordWin(jankenResult);
        player.recordWin(jankenResult);

        assertEquals(2, player.winTimes);
    }
    @Test
    void IfInputLosePlayersWinTimesNotIncrement(){
        var player = new Player("test", StandardInput.getInstance());
        var jankenResult = "LOSE";

        player.recordWin(jankenResult);

        assertEquals(0, player.winTimes);
    }
}