import User.User;
import Game.Game;

public class Main {
    public static void main(String[] args) {

        User player = new User("Player", 0);
        User host = new User("Host", 0);

        // create the game
        Game game = new Game(player, host);

        // play the game until it's over
        while (!game.isGameOver()) {
            game.playRound();
        }

        // print the winner
        game.printWinner();
    }}
