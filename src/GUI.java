import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class GUI extends GridPane {
    private NewGame game = new NewGame();

    private Player p1 = new Player("Player 1");
    private Player p2 = new Player("Player 2");
    private Player currentPlayer = p1;

    private Label title = new Label("Zombie Dice");
    private Label lblRound = new Label("Round 1");
    private Label lblPlayer1 = new Label("Player 1:");
    private Label lblPlayer2 = new Label("Player 2:");
    private Label score1 = new Label("Score: 0");
    private Label score2 = new Label("Score: 0");
    private Label shots1 = new Label("Shots: 0");
    private Label shots2 = new Label("Shots: 0");
    private Label scoreTotal1 = new Label("Total: 0");
    private Label scoreTotal2 = new Label("Total: 0");
    private Label message = new Label("");
    private Button rollButton = new Button("Roll");
    private Button passButton = new Button("Pass");

    public GUI() {
        title.setAlignment(Pos.CENTER);

        rollButton.setOnAction(this::roll);
        rollButton.setAlignment(Pos.CENTER);

        passButton.setOnAction(this::pass);
        passButton.setAlignment(Pos.CENTER);

        lblPlayer1.setAlignment(Pos.CENTER);
        lblPlayer2.setAlignment(Pos.CENTER);

        message.setAlignment(Pos.CENTER);

        add(title, 1, 0);
        add(lblRound, 2, 0);
        add(rollButton, 1, 3);
        add(passButton, 2, 3);
        add(lblPlayer1, 0, 1);
        add(lblPlayer2, 3, 1);
        add(score1, 0, 2);
        add(shots1, 0, 3);
        add(scoreTotal1, 0, 5);
        add(score2, 3, 2);
        add(shots2, 3, 3);
        add(scoreTotal2, 3, 5);
        add(message, 1, 5);

        setAlignment(Pos.CENTER);
        setHgap(10);

    }

    private void roll(ActionEvent event) {
        if (!currentPlayer.isDead) { //checks if the player is dead
            if (game.enoughDice) { //checks if there are enough dice in the cup
                game.takeTurn(currentPlayer);
                updateRoundData();
                //Checks if the player is dead
                if (currentPlayer.roundShots >= Player.SHOT_CAPACITY) {
                    currentPlayer.isDead = true;
                }
            } else {
                message.setText("You ran out of dice! Click 'Pass'");
            }
        }
        else {
            message.setText("You are Dead! Click 'Pass'");
        }
        System.out.println("");
    }

    private void pass(ActionEvent event) {
        game.resetDice();

        if (!currentPlayer.isDead) {
            currentPlayer.addScore();
        }
        else {
            currentPlayer.isDead = false;
        }
        updateGameData();
        currentPlayer.roundScore = 0;
        currentPlayer.roundShots = 0;
        updateRoundData();

        if (currentPlayer.totalScore >= currentPlayer.WIN_SCORE)
            message.setText(currentPlayer.getName() + " Won!");

        if (currentPlayer == p1) {
            currentPlayer = p2;
        }
        else if (currentPlayer == p2) {
            currentPlayer = p1;
            game.round++;
        }
        lblRound.setText("Round " + game.round);
        System.out.println("---------");
    }

    public void updateRoundData() {
        score1.setText("Score: " + p1.roundScore);
        shots1.setText("Shots: " + p1.roundShots);
        score2.setText("Score: " + p2.roundScore);
        shots2.setText("Shots: " + p2.roundShots);
    }

    public void updateGameData() {
        message.setText("");
        scoreTotal1.setText("Total: " + p1.totalScore);
        scoreTotal2.setText("Total: " + p2.totalScore);
    }
}