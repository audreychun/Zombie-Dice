import java.util.ArrayList;
import java.util.Random;

public class NewGame {

    private Random randy = new Random();
    private ArrayList<Die> diceList = new ArrayList<>(); //list of all dice
    private ArrayList<Die> diceInCup = new ArrayList<>(); //list of dice in the cup
    private ArrayList<Die> diceInPlay = new ArrayList<>(); //list of dice being used
    public int round = 1;
    public boolean enoughDice = true;
    public final int DICE_PER_TURN = 3; //how many dice to use each turn

    public NewGame() {

        diceList.add(new Die(Die.GREEN));
        diceList.add(new Die(Die.GREEN));
        diceList.add(new Die(Die.GREEN));
        diceList.add(new Die(Die.GREEN));
        diceList.add(new Die(Die.GREEN));
        diceList.add(new Die(Die.GREEN));
        diceList.add(new Die(Die.YELLOW));
        diceList.add(new Die(Die.YELLOW));
        diceList.add(new Die(Die.YELLOW));
        diceList.add(new Die(Die.YELLOW));
        diceList.add(new Die(Die.RED));
        diceList.add(new Die(Die.RED));
        diceList.add(new Die(Die.RED));

        diceInCup = new ArrayList<>(diceList); //The list  of the dice that are still in the cup
    }

    //public boolean switchTurn() {

    //}

    public void takeTurn(Player player) {
        int diceNeeded = DICE_PER_TURN - diceInPlay.size(); //number of dice to take from cup

        //Takes a random die from the cup, and puts it in plays
        for (int i = 1; i <= diceNeeded; i++) {
            diceInPlay.add(diceInCup.remove(randy.nextInt(diceInCup.size()))); //Takes a random die from the cup
        }

        for (int j = DICE_PER_TURN - 1; j >= 0; j--) {
            int currentRoll = diceInPlay.get(j).roll();
            //prints the roll result
            if (currentRoll == 1) {
                System.out.println("Brain");
            }
            else if (currentRoll == 2) {
                System.out.println("Footsteps");
            }
            else if (currentRoll == 3) {
                System.out.println("Shot");
            }


            //rolls each of the dice, adjusts score based on what it rolls
            if (currentRoll == Die.BRAIN) {
                //brains
                player.roundScore++;
                diceInPlay.remove(j);
            } else if (currentRoll == Die.SHOT) {
                //shots
                player.roundShots++;
                diceInPlay.remove(j);
            }
        }
        if (DICE_PER_TURN - diceInPlay.size() > diceInCup.size()){
            enoughDice = false;
        }
    }

    public void resetDice() {
        diceInPlay.clear();
        diceInCup = new ArrayList<>(diceList);
        enoughDice = true;
    }
}
