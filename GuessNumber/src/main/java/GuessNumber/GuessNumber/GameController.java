package GuessNumber.GuessNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/new")
    public String startNewGame() {
        gameService.startNewGame();
        return "A new game has started! Guess a number between 1 and 100.";
    }

    @PostMapping("/guess")
    public String guessNumber(@RequestParam int number) {
        return gameService.guessNumber(number);
    }

    @GetMapping("/score")
    public String getScore() {
        return "Current score: " + gameService.getScore();
    }

    @GetMapping("/attempts")
    public String getAttempts() {
        return "Attempts made: " + gameService.getAttempts();
    }

    @GetMapping("/status")
    public String getGameStatus() {
        return gameService.isGameOver() ? "Game over! Start a new game." : "Game is ongoing!";
    }
}
