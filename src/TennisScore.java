
import java.util.HashMap;
import java.util.Map;


public class TennisScore {
    private static int playerAScore = 0;
    private static int playerBScore = 0;
    private static boolean playerAHasAdvantage = false;
    private static boolean playerBHasAdvantage = false;
    private static final Map<Integer, String> SCORE_MAP = new HashMap<>();

    //holds the scores in the requirement
    static {
        SCORE_MAP.put(0, "0");
        SCORE_MAP.put(1, "15");
        SCORE_MAP.put(2, "30");
        SCORE_MAP.put(3, "40");
    }

    public static void handlePlayerGame(char player) {
        if (player == 'A') {
            playerAScore++;
        } else if (player == 'B') {
            playerBScore++;
        }

        if (playerAScore == 4 && playerBScore == 3) {
            playerAHasAdvantage = true;
        } else if (playerAScore == 3 && playerBScore == 4) {
            playerBHasAdvantage = true;
        } else if (playerAScore == 4 && playerBScore <= 2) {
            printWinner("Player A");
        } else if (playerBScore == 4 && playerAScore <= 2) {
            printWinner("Player B");
        } else if (playerAScore == 4 && playerBScore == 4) {
            handleDeuce();
        } else {
            printScore();
            //System.out.println("Player A: " + mapScore(playerAScore) + " / Player B: " + mapScore(playerBScore));
        }
    }

    //return the players to zero after a win
    public static void refreshPlayers() {
        playerAScore = 0;
        playerBScore = 0;
        playerAHasAdvantage = false;
        playerBHasAdvantage = false;
    }

    public static void printWinner(String winner) {
        System.out.println("Game Over. " + winner + " wins!");
        refreshPlayers();
    }

    public static void handleDeuce() {

        if (playerAHasAdvantage) {
            printWinner("Player A");
        } else if (playerBHasAdvantage) {
            printWinner("Player B");
        } else {
            System.out.println("Deuce");
        }
    }

    public static void printScore() {

        if (playerAHasAdvantage) {
            System.out.println("Advantage: Player A");
        } else if (playerBHasAdvantage) {
            System.out.println("Advantage: Player B");
        } else {
            System.out.println("Player A: " + mapScore(playerAScore)  +
                    " / Player B: " + mapScore(playerBScore));
        }
    }

    public static String mapScore(int score) {

        String result = SCORE_MAP.get(score);
        if (result == null) {
            throw new IllegalArgumentException("Invalid score: " + score);
        }
        return result;

    }

    public static void playTennis(char result) {
        switch (result) {
            case 'A':
                handlePlayerGame('A');
                break;
            case 'B':
                handlePlayerGame('B');
                break;
            default:
                System.out.println("Invalid input");
        }
    }
    
    //stream the game with playTennis method on input players
    public static void scorePlayers(String players) {
        players.chars().forEach(player -> playTennis((char) player));
    }

    public static void main(String[] args) {
        // Test the inputs
        scorePlayers("ABABABAA");
    }

}
