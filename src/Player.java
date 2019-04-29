public class Player {
    private String name;
    public int roundScore = 0;
    public int roundShots = 0;
    public int totalScore = 0;
    public boolean isDead = false;
    public static final int SHOT_CAPACITY = 3;
    public final int WIN_SCORE = 13;

    public Player(String name) {
        this.name = name;
    }

    public void addScore() {
        totalScore += roundScore;
    }

    public String getName() {
        return name;
    }
}
