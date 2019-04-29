import java.util.Random;

public class Die {
    //private String name;
    private int[] faces;
    private int roll;
    private Random randy = new Random();
    public static final int GREEN = 1;
    public static final int YELLOW = 2;
    public static final int RED = 3;
    public static final int BRAIN = 1;
    public static final int FOOTSTEPS = 2;
    public static final int SHOT = 3;


    public Die(int color) {

        //1=green, 2=yellow, 3=red
        if (color == GREEN) {
            faces = new int[]{BRAIN, BRAIN, BRAIN, FOOTSTEPS, FOOTSTEPS, SHOT};
        } else if (color == YELLOW) {
            faces = new int[]{BRAIN, BRAIN, FOOTSTEPS, FOOTSTEPS, SHOT, SHOT};
        } else if (color == RED){
            faces = new int[]{BRAIN, FOOTSTEPS, FOOTSTEPS, SHOT, SHOT, SHOT};
        }
        roll();
    }

    public int roll() {
        roll = faces[randy.nextInt(6)];
        return roll;
    }
}