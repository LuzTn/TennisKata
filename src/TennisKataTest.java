import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisKataTest {

    TennisKata game = new TennisKata("Player 1", "Player 2");

    @Test
    public void testNewGameStartsWithScoreZero() {
        String score = game.getScore();
        assertEquals("Both players: " + 0, score);
        System.out.println(score);
    }

    @Test
    public void testPlayerOneWinsFirstBall() {
        game.p1Score();
        String score = game.getScore();
        assertEquals(15 + "," + 0, score);
        System.out.println(score);
    }

    @Test
    public void testFifteenBoth() {
        game.p1Score();
        game.p2Score();
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
    public void testPlayerTwoWins() {
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.p1Score();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.p2Score();
        }
    }
}
