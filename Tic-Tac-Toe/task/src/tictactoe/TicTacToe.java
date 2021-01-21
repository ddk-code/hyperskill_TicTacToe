package tictactoe;

import java.util.Arrays;

enum Player {
    X('X'),
    O('O');

    char c;

    Player(char c) {
        this.c = c;
    }
}

public class TicTacToe {
    String line;
    char[][] grid = new char[3][3];
    GameState state;
    Player player;

    int x;
    int o;
    boolean isEmptyCells;

    public TicTacToe() {
        Arrays.fill(this.grid[0], ' ');
        Arrays.fill(this.grid[1], ' ');
        Arrays.fill(this.grid[2], ' ');
        this.state = GameState.NOT_FINISHED;
        this.player = Player.X;
        this.x = 0;
        this.o = 0;
        this.isEmptyCells = true;
    }

    public void analyze() {
        if (Math.abs(this.x - this.o) > 1 || isWin('X') && isWin('O')) {
            this.state = GameState.IMPOSSIBLE;
        } else if (!isWin('X') && !isWin('O')) {
            this.state = isEmptyCells ? GameState.NOT_FINISHED : GameState.DRAW;
        } else if (isWin('X')) {
            this.state = GameState.X_WINS;
        } else if (isWin('O')) {
            this.state = GameState.O_WINS;
        }
    }

    public boolean isWin(char c) {
        boolean d1 = true;
        boolean d2 = true;
        boolean v = false;
        boolean g = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && this.grid[i][j] != c) {
                    d1 = false;
                }
                if (i + j == 2 && this.grid[i][j] != c) {
                    d2 = false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (this.grid[i][0] == c && this.grid[i][1] == c && this.grid[i][2] == c) {
                g = true;
            }
            if (this.grid[0][i] == c && this.grid[1][i] == c && this.grid[2][i] == c) {
                v = true;
            }

        }
        return d1 || d2 || v || g;
    }


    public void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            printCharArray(this.grid[i]);
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void printCharArray(char[] array) {
        for (char c : array) {
            System.out.print(c + " ");
        }
    }

    public void userMove(int[] arr) {
        if (this.grid[arr[0] - 1][arr[1] - 1] == ' ') {
            this.grid[arr[0] - 1][arr[1] - 1] = this.player.c;
            switch (this.player) {
                case X:
                    ++this.x;
                    this.player = Player.O;
                    break;
                case O:
                    ++this.o;
                    this.player = Player.X;
                    break;
            }
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            userMove(InputData.readMove());
        }
        this.isEmptyCells = this.x + this.o < 9;
    }
}
