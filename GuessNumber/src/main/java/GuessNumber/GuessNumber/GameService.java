package GuessNumber.GuessNumber;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {

    private int randomNumber;
    private int maxAttempts = 10;
    private int attempts = 0;
    private int score = 0;
    private boolean gameOver = false;

    public GameService() {
        startNewGame();
    }

    public void startNewGame() {
        Random random = new Random();
        this.randomNumber = random.nextInt(100) + 1;
        this.attempts = 0;
        this.gameOver = false;
    }

    public String guessNumber(int guess) {
        if (gameOver) {
            return "Game over! Start a new game.";
        }

        attempts++;

        if (guess == randomNumber) {
            score += (maxAttempts - attempts + 1) * 10;
            gameOver = true;
            return "Congratulations! You guessed the number in " + attempts + " attempts. Your score: " + score;
        } else if (attempts >= maxAttempts) {
            gameOver = true;
            return "Game over! You've reached the maximum number of attempts. The correct number was " + randomNumber;
        } else if (guess < randomNumber) {
            return "Your guess is too low!";
        } else {
            return "Your guess is too high!";
        }
    }

    public int getScore() {
        return score;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
