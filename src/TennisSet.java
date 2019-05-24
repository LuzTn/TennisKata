public class TennisSet {
    private String player1;
    private String player2;
    private int p1SetScore = 0;
    private int p2SetScore = 0;
    private TennisGame game = new TennisGame(player1, player2);

    public TennisSet(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getSetScore() {
        if (hasWonSet()) {
            return playerWithHighestScore() + " wins";
        }

        if (p1SetScore == p2SetScore) {
            return "Both players: " + p1SetScore;
        }


        //If a player wins a Game and reach the Set score of 6 and the other player has a Set score of 5,
        // a new Game must be played and the first player who reach the score of 7 wins the match
        if ((hasWonSet() && p1SetScore == 6 && p2SetScore == 5) || (hasWonSet() && p1SetScore == 6 && p2SetScore == 5)) {
                return playNewGame();
          }


        return p1SetScore + "," + p2SetScore;
    }

    private String playNewGame() {
        return null;
    }

    private String playerWithHighestScore() {
        return (p1SetScore > p2SetScore) ? player1 : player2;
    }

    private boolean hasWonSet() {
        //If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set
        if ((p2SetScore >= 6 && p1SetScore <= 4) || (p1SetScore >= 6 && p2SetScore <= 4))
            return true;
        return false;
    }

    public void p1SetScore() {
        p1SetScore++;
    }

    public void p2SetScore() {
        p2SetScore++;
    }

    private int tennisGameScore(int score) {
        if (score <= 7) {
            return score;
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }

}
