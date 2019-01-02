package logic;

import sample.Controller;

public class Game {
    private Cell[][] cells;

    Controller controller;
    public Player player1;
    public Player player2;
    private Player currentPlayer;
    private boolean switchedTurn = false;


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Game() {
        cells = new Cell[6][7];
        player1 = new Player(this, 1);
        player2 = new Player(this, 2);
        currentPlayer = player1;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void switchPlayer() {
        if (currentPlayer.equals(player1))
            currentPlayer = player2;
        else currentPlayer = player1;
    }

    public boolean isSwitchedTurn() {
        return switchedTurn;
    }

    public void setSwitchedTurn(boolean switchedTurn) {
        this.switchedTurn = switchedTurn;
    }
}
