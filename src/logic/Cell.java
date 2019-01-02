package logic;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cell {
    private int situation = 0;
    private Circle circle;
    private Game game;
    private int i, j;


    public Cell(Game game, int i, int j) {
        this.i = i;
        this.j = j;
        this.game = game;
        this.circle = new Circle();
        this.circle.setRadius(50);
        this.circle.setFill(Color.WHITE);
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public Circle getCircle() {
        return circle;
    }

    public void play() {
        this.circle.setOnMouseClicked(event -> {
            for (int k = 5; k >= 0; k--) {
                if (game.getCells()[k][j].getSituation() == 0) {
                    game.getCells()[k][j].setSituation(game.getCurrentPlayer().getColor());
                    if (game.getCells()[k][j].getSituation() == 1)
                        game.getCells()[k][j].circle.setFill(Color.BLUE);
                    else
                        game.getCells()[k][j].circle.setFill(Color.RED);
                    game.switchPlayer();
                    game.setSwitchedTurn(true);
                    break;
                }
            }
        });
    }
}
