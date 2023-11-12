package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JankenControllerTest {
    @Test
    void  IfYouPlayPaperAndRockYouGetWin(){
        JankenHand paper = JankenHand.PAPER;
        JankenHand rock = JankenHand.ROCK;
        JankenController jankenController = new JankenController(StandardInput.getInstance());

        var result = jankenController.judge(paper, rock);

        assertEquals("WIN", result);
    }
    @Test
    void IfYouPlayRockAndScissorsYouGetWin(){
        JankenHand rock = JankenHand.ROCK;
        JankenHand scissors = JankenHand.SCISSORS;
        JankenController jankenController = new JankenController(StandardInput.getInstance());

        var result = jankenController.judge(rock, scissors);

        assertEquals("WIN", result);
    }
    @Test
    void IfYouPlayScissorsAndPaperYouGetWin() {
        JankenHand scissors = JankenHand.SCISSORS;
        JankenHand paper = JankenHand.PAPER;
        JankenController jankenController = new JankenController(StandardInput.getInstance());

        var result = jankenController.judge(scissors, paper);

        assertEquals("WIN", result);
    }
    @Test
    void IfYouPlayPaperAndPaperYouGetDraw() {
        JankenHand paper = JankenHand.PAPER;
        JankenController jankenController = new JankenController(StandardInput.getInstance());

        var result = jankenController.judge(paper, paper);

        assertEquals("DRAW", result);
    }
    @Test
    void IfEachPlayersHandIsOnlyRockVSRockAtJankensThatWintimesIsEach0() {
        JankenController jankenController = new JankenController(new ConstInput("ROCK"));

        jankenController.story();

        assertEquals(0, jankenController.p1.winTimes);
        assertEquals(0, jankenController.p2.winTimes);
    }
}