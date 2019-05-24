import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisKataTest {

    TennisGame game = new TennisGame("Player 1", "Player 2");
    TennisSet tennisSet = new TennisSet("Player 1", "Player 2");

    // Tests for the tennis game
    @Test
    public void testNewGameStartsWithScoreZero() {
        String score = game.getScore();
        assertEquals("Both players: " + 0, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsFirstBall() {
        game.p1GameScore();
        String score = game.getScore();
        assertEquals(15 + "," + 0, score);
        System.out.println(score);
    }

    @Test
    public void testFifteenBoth() {
        game.p1GameScore();
        game.p2GameScore();
        String score = game.getScore();
        assertEquals("Both players: " + 15, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);
        String score = game.getScore();
        assertEquals(0 + "," + 30, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsFirstThreeBalls() {
        createScore(3, 0);
        String score = game.getScore();
        assertEquals(40 + "," + 0, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsGame() {
        createScore(4, 0);
        String score = game.getScore();
        assertEquals("Player 1 wins", score);
        System.out.println(score);
    }

    @Test
    public void testPlayerTwoWinsGame() {
        createScore(1, 4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    @Test
    public void testPlayersAreDeuce() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
        System.out.println(score);
    }

    @Test
    public void testPlayerTwoAdvantage() {
        createScore(4, 5);
        String score = game.getScore();
        assertEquals("Advantage Player 2", score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneAdvantage() {
        createScore(5, 4);
        String score = game.getScore();
        assertEquals("Advantage Player 1", score);
        System.out.println(score);
    }

    @Test
    public void testPlayerTwoWins() {
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    @Test
    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("Player 1 wins", score);
        System.out.println(score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.p1GameScore();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.p2GameScore();
        }
    }

    // Tests for the tennis set

    @Test
    public void testNewSetStartsWithScoreZero() {
        String score = tennisSet.getSetScore();
        assertEquals("Both players: " + 0, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsFirstSet() {
        tennisSet.p1SetScore();
        String score = tennisSet.getSetScore();
        assertEquals(1 + "," + 0, score);
        System.out.println(score);
    }

    @Test
    public void testBothWinASet() {
        tennisSet.p1SetScore();
        tennisSet.p2SetScore();
        String score = tennisSet.getSetScore();
        assertEquals("Both players: " + 1, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsSecondSet() {
        createSetScore(6, 5);
        String score = tennisSet.getSetScore();
        assertEquals(0 + "," + 0, score);
        System.out.println(score);
    }


    private void createSetScore(int playerOneSets, int playerTwoSets) {
        for (int i = 0; i < playerOneSets; i++) {
            tennisSet.p1SetScore();
        }
        for (int i = 0; i < playerTwoSets; i++) {
            tennisSet.p2SetScore();
        }
    }
}
