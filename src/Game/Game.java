package Game;
import java.util.Random;
import User.User;
public class Game {
    private User player;
    private User host;
    private int round;

    // constructor
    public Game(User player, User host) {
        this.player = player;
        this.host = host;

        //random round and set first start tokens for Both
        this.round = roundRoll();
        player.setTokens(this.round);
        host.setTokens(this.round);
    }

    // method to play one round of the game
    public void playRound() {
        for (int i = 1; i <= this.round; i++) {
            System.out.println("Round " + i + ":");

            // get the rolls for both players
            int playerRoll = player.rollDice();
            int hostRoll = host.rollDice();

            // calculate the total for this round
            int total = playerRoll + hostRoll;
            System.out.println("Player's roll: " + playerRoll);
            System.out.println("Host's roll: " + hostRoll);
            System.out.println("Total: " + total);

            // update the tokens for each player based on the total

            if (total != 3) {
                if (total > 0) {
                    if (total <= host.getTokens()) {
                        player.setTokens(player.getTokens() + total);
                    } else {
                        player.setTokens(player.getTokens() + host.getTokens());
                        host.setTokens(0);
                    }
                } else {
                    if (total == -3) {
                        player.setTokens(player.getTokens() / 2);
                    } else {
                        if (total <= player.getTokens()) {
                            host.setTokens(host.getTokens() + total);
                        } else {
                            host.setTokens(host.getTokens() + player.getTokens());
                            player.setTokens(0);
                        }
                    }
                }
            } else {
                player.setTokens(player.getTokens() * 2);
            }

            System.out.println("Player's token count: " + player.getTokens());
            System.out.println("Host's token count: " + host.getTokens());
            System.out.println();
        }

    }

    // method to check if the game is over
    public boolean isGameOver() {
        return host.getTokens() <= 0;
    }

    // method to print the winner of the game
    public void printWinner() {
        if (player.getTokens() >= host.getTokens()) {
            System.out.println("Player wins!");

        } else {
            System.out.println("Host wins!");
        }
    }

    public int roundRoll() {
        Random rand = new Random();
        int roll = rand.nextInt(5) + 1; // generate a random number between 1 to 5
        return roll;
    }
}
