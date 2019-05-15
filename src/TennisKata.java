public class TennisKata {

    private String player1;
    private String player2;
    private int p1Score = 0;
    private int p2Score = 0;

    public TennisKata(String player1, String player2) {
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

        if (p1Score == p2Score) {
            return "Both players: " + tennisScore(p1Score);
        }

        return tennisScore(p1Score) + "," + tennisScore(p2Score);
    }

    private boolean isDeuce() {
        return p1Score >= 3 && p2Score == p1Score;
    }

    private String playerWithHighestScore() {
        return (p1Score > p2Score) ? player1 : player2;
    }

    private boolean hasWon() {
        if ((p2Score >= 4 && p2Score >= p1Score + 2) || (p1Score >= 4 && p1Score >= p2Score + 2))
            return true;
        return false;
    }

    private boolean hasAdvantage() {
        if ((p2Score >= 4 && p2Score == p1Score + 1) || (p1Score >= 4 && p1Score == p2Score + 1))
            return true;

        return false;

    }

    public void p1Score() {
        p1Score++;
    }

    public void p2Score() {
        p2Score++;
    }

    private int tennisScore(int score) {
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
