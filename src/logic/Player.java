package logic;

public class Player {
    private int color;
    private Game game;

    public Player(Game game,int color) {
        this.color = color;
        this.game= game;

    }
    public int getColor() {
        return color;
    }
}
