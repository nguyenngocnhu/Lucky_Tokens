package User;
import java.util.Random;

public class User {
    private String type;
    private int tokens;

    // constructor
    public User(String type, int tokens) {
        this.type = type;
        this.tokens = tokens;
    }

    public String getType() {
        return type;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public int rollDice() {
        Random rand = new Random();
        int roll = rand.nextInt(6) - 2; // generate a random number between -2 to 3
        return roll;
    }
}