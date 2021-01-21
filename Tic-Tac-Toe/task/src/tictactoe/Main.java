package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        while (ticTacToe.state == GameState.NOT_FINISHED) {
            ticTacToe.printGrid();
            System.out.println("Enter the coordinates:");
            ticTacToe.userMove(InputData.readMove());
            ticTacToe.analyze();
        }
        ticTacToe.printGrid();
        System.out.println(ticTacToe.state.msg);
    }
}

class InputData {
    static Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int[] readMove() {
        int[] arr = new int[2];
        String s;
        String[] ss;
        while (true) {
            s = readLine();
            ss = s.split(" ");
            if (ss.length != 2 || !ss[0].matches("\\d+") || !ss[1].matches("\\d+")) {
                System.out.println("You should enter numbers!");
            } else {
                arr[0] = Integer.parseInt(ss[0]);
                arr[1] = Integer.parseInt(ss[1]);
                if (arr[0] < 1 || arr[0] > 3 || arr[1] < 1 || arr[1] > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                break;
            }
        }
        return arr;
    }
}
