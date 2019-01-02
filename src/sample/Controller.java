package sample;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import logic.Cell;
import logic.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public HBox hBox;
    private boolean isEnd = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game game = new Game();
        game.setController(this);
        ObservableList<Node> children = hBox.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            VBox vBox = (VBox) node;
            for (int j = 0; j < 6; j++) {
                Cell cell = new Cell(game, j, i);
                game.getCells()[j][i] = cell;
                vBox.getChildren().add(cell.getCircle());
            }
        }
        Label label = new Label("0");
        label.relocate(700, 500);
        label.setFont(Font.font(50));
        hBox.getChildren().addAll(label);
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastTime = 0;
            private double time = 0;
            private double turn = 100;
            private long second = 1000000000;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                }
                if (now > lastTime + second / 10) {
                    lastTime = now;
                    time++;
                    Cell[][] cells = game.getCells();
                    if (this.turn != 0)
                        for (int i = 0; i < 6; i++)
                            for (int j = 0; j < 7; j++) {
                                cells[i][j].play();
                            }

                    if (!game.isSwitchedTurn())
                        turn--;
                    if (game.isSwitchedTurn()) {
                        turn = 100;
                        game.setSwitchedTurn(false);
                    }
                    for (int i = 5; i >= 0; i--) {
                        for (int j = 0; j <= 3; j++) {
                            if (cells[i][j].getSituation() != 0 && cells[i][j].getSituation() == cells[i][j + 1].getSituation() &&
                                    cells[i][j + 1].getSituation() == cells[i][j + 2].getSituation() &&
                                    cells[i][j + 2].getSituation() == cells[i][j + 3].getSituation()) {
                                cells[i][j].getCircle().setFill(Color.GREEN);
                                cells[i][j + 1].getCircle().setFill(Color.GREEN);
                                cells[i][j + 2].getCircle().setFill(Color.GREEN);
                                cells[i][j + 3].getCircle().setFill(Color.GREEN);
                                Label label1 = new Label("player" + (game.getCurrentPlayer().equals(game.player1) ? 2 : 1) + " wins!\n");
                                label1.setFont(Font.font(80));
                                label1.setTextFill((game.getCurrentPlayer().equals(game.player1) ? Color.RED : Color.BLUE));
                                hBox.getChildren().addAll(label1);
                                this.stop();
                                isEnd = true;
                            }
                        }
                    }
                    for (int i = 5; i >= 3; i--) {
                        for (int j = 0; j <= 6; j++) {
                            if (cells[i][j].getSituation() != 0 && cells[i][j].getSituation() == cells[i - 1][j].getSituation() &&
                                    cells[i - 1][j].getSituation() == cells[i - 2][j].getSituation() &&
                                    cells[i - 2][j].getSituation() == cells[i - 3][j].getSituation()) {
                                cells[i][j].getCircle().setFill(Color.GREEN);
                                cells[i - 1][j].getCircle().setFill(Color.GREEN);
                                cells[i - 2][j].getCircle().setFill(Color.GREEN);
                                cells[i - 3][j].getCircle().setFill(Color.GREEN);
                                Label label1 = new Label("player" + (game.getCurrentPlayer().equals(game.player1) ? 2 : 1) + " wins!\n");
                                label1.setFont(Font.font(80));
                                label1.setTextFill((game.getCurrentPlayer().equals(game.player1) ? Color.RED : Color.BLUE));
                                hBox.getChildren().addAll(label1);
                                this.stop();
                                isEnd = true;
                            }
                        }
                    }
                    for (int i = 5; i >= 3; i--) {
                        for (int j = 0; j <= 3; j++) {
                            if (cells[i][j].getSituation() != 0 && cells[i][j].getSituation() == cells[i - 1][j + 1].getSituation() &&
                                    cells[i - 1][j + 1].getSituation() == cells[i - 2][j + 2].getSituation() &&
                                    cells[i - 2][j + 2].getSituation() == cells[i - 3][j + 3].getSituation()) {
                                cells[i][j].getCircle().setFill(Color.GREEN);
                                cells[i - 1][j + 1].getCircle().setFill(Color.GREEN);
                                cells[i - 2][j + 2].getCircle().setFill(Color.GREEN);
                                cells[i - 3][j + 3].getCircle().setFill(Color.GREEN);
                                Label label1 = new Label("player" + (game.getCurrentPlayer().equals(game.player1) ? 2 : 1) + " wins!\n");
                                label1.setFont(Font.font(80));
                                label1.setTextFill((game.getCurrentPlayer().equals(game.player1) ? Color.RED : Color.BLUE));
                                hBox.getChildren().addAll(label1);
                                this.stop();
                                isEnd = true;

                            }
                        }
                    }
                    for (int i = 5; i >= 3; i--) {
                        for (int j = 6; j >= 3; j--) {
                            if (cells[i][j].getSituation() != 0 && cells[i][j].getSituation() == cells[i - 1][j - 1].getSituation() &&
                                    cells[i - 1][j - 1].getSituation() == cells[i - 2][j - 2].getSituation() &&
                                    cells[i - 2][j - 2].getSituation() == cells[i - 3][j - 3].getSituation()) {
                                cells[i][j].getCircle().setFill(Color.GREEN);
                                cells[i - 1][j - 1].getCircle().setFill(Color.GREEN);
                                cells[i - 2][j - 2].getCircle().setFill(Color.GREEN);
                                cells[i - 3][j - 3].getCircle().setFill(Color.GREEN);
                                Label label1 = new Label("player" + (game.getCurrentPlayer().equals(game.player1) ? 2 : 1) + " wins!\n");
                                label1.setFont(Font.font(80));
                                label1.setTextFill((game.getCurrentPlayer().equals(game.player1) ? Color.RED : Color.BLUE));
                                hBox.getChildren().addAll(label1);
                                this.stop();
                                isEnd = true;
                            }
                        }
                    }
                    if (!game.isSwitchedTurn() && turn / 10 == 0) {
                        int x = (int) (Math.random() * 7);
                        for (int k = 5; k > 0; k--) {
                            if (cells[k][x].getSituation() == 0) {
                                cells[k][x].setSituation(game.getCurrentPlayer().getColor());
                                if (cells[k][x].getSituation() == 1)
                                    cells[k][x].getCircle().setFill(Color.BLUE);
                                else
                                    cells[k][x].getCircle().setFill(Color.RED);
                                game.switchPlayer();
                                break;
                            }
                        }
                        turn = 100;
                        game.setSwitchedTurn(true);
                    }
                    if (isEnd) {
                        for (int t = 0; t < 6; t++)
                            for (int u = 0; u < 7; u++) {
                                Circle circle = cells[t][u].getCircle();
                                circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        circle.setFill(circle.getFill());
                                    }
                                });
                            }
                    }
                    outer:
                    for (int i = 0; i < 6; i++)
                        for (int j = 0; j < 7; j++) {
                            if (cells[i][j].getSituation() == 0)
                                break outer;
                            if (i == 5 && j == 6) {
                                Label label1 = new Label("Draw!");
                                label1.setTextFill(Color.VIOLET);
                                label1.setFont(Font.font(80));
                                hBox.getChildren().addAll(label1);
                                this.stop();
                                isEnd = true;
                            }
                        }
                    label.setText("game time: " + time / 10 + "\n" +
                            "\n" + "turn: " + turn / 10 +
                            "\n" + "\n" + "player" + (game.getCurrentPlayer().equals(game.player1) ? 1 : 2) + "'s turn");
                    label.setTextFill((game.getCurrentPlayer().equals(game.player1) ? Color.BLUE : Color.RED));
                }
            }

        };
        animationTimer.start();
    }
}
