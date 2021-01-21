package tictactoe;

public enum GameState {
    NOT_FINISHED("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    IMPOSSIBLE("Impossible");

    String msg;

    GameState(String msg) {
        this.msg = msg;
    }
}
