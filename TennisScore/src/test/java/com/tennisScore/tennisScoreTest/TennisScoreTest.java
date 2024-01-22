package com.tennisScore.tennisScoreTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.tennisscore.tennisscore.TennisScore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author BABEGUNDE
 *
 */

class TennisScoreTest {

    @Test
    void testPlayerAWins() {
        TennisScore.scorePlayers("AAAA");
        assertEquals("Game Over. Player A wins!", TestUtils.getConsoleOutput().trim());
    }

    @Test
    void testPlayerBWins() {
        TennisScore.scorePlayers("BBB");
        assertEquals("Game Over. Player B wins!", TestUtils.getConsoleOutput().trim());
    }

    @Test
    void testDeuce() {
        TennisScore.scorePlayers("AABBAA");
        assertEquals("Deuce", TestUtils.getConsoleOutput().trim());
    }

    @Test
    void testAdvantagePlayerA() {
        TennisScore.scorePlayers("AABBA");
        assertEquals("Advantage: Player A", TestUtils.getConsoleOutput().trim());
    }

    @Test
    void testAdvantagePlayerB() {
        TennisScore.scorePlayers("BBAAA");
        assertEquals("Advantage: Player B", TestUtils.getConsoleOutput().trim());
    }

    @Test
    void testInvalidInput() {
        TennisScore.scorePlayers("CC");
        assertEquals("Invalid input", TestUtils.getConsoleOutput().trim());
    }

    

    @Test
    void testMapScoreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> TennisScore.mapScore(5));
    }

}