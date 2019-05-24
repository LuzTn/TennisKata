public class TennisGame {

    private String player1;
    private String player2;
    private int p1GameScore = 0;
    private int p2GameScore = 0;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (hasWon()) {
            return playerWithHighestScore() + " wins";
        }

        if (hasAdvantage()) {
            return "Advantage " + playerWithHighestScore();
        }

        if (isDeuce())
            return "Deuce";

        if (p1GameScore == p2GameScore) {
            return "Both players: " + tennisGameScore(p1GameScore);
        }

        return tennisGameScore(p1GameScore) + "," + tennisGameScore(p2GameScore);
    }

    private String playerWithHighestScore() {
        return (p1GameScore > p2GameScore) ? player1 : player2;
    }

    private boolean hasWon() {
        if ((p2GameScore >= 4 && p2GameScore >= p1GameScore + 2) || (p1GameScore >= 4 && p1GameScore >= p2GameScore + 2))
            return true;
        return false;
    }


    // If the 2 players reach the score 40, the DEUCE rule is activated
    private boolean isDeuce() {
        return p1GameScore >= 3 && p2GameScore == p1GameScore;
    }

    private boolean hasAdvantage() {
        if ((p2GameScore >= 4 && p2GameScore == p1GameScore + 1) || (p1GameScore >= 4 && p1GameScore == p2GameScore + 1))
            return true;

        return false;

    }

    public void p1GameScore() {
        p1GameScore++;
    }

    public void p2GameScore() {
        p2GameScore++;
    }

    //Each time a player win a point, the Game score changes as follow:
    //0 -> 15 -> 30 -> 40-> Win game
    private int tennisGameScore(int score) {
        switch (score) {
            case 0:
                return 0;
            case 1:
                return 15;
            case 2:
                return 30;
            case 3:
                return 40;
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }
}
