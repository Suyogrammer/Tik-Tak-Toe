import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("TIC-TAC-TOE");
        System.out.println("!!Welcome to tic tak toe!!");
        System.out.println("Input number from 1-9 as defined: \n\t (0-2) first row," +
                "\n\t (3-5) second row,\n\t (6-8) third row");
        String board[] = new String[9];
        printBoard(board);
        while ((isBoardFull(board))){
            if (isWinner(board)) {
                System.out.println("You Won");
                printBoard(board);
                System.out.println("Congratulations!!!!!");
                return;
            } else {
                System.out.println("ELSE");
                printBoard(board);
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if (isValidMove(board)){
                    playerPosition(board, input);
                    computerPosition(board);
                }
            }
        }
    }

    /**
     * Checks if the board is full or not
     * @param board : an array of strings
     * @return true or false
     */
    private static boolean isBoardFull(String[] board) {
        for (int i=0; i<board.length; i++){
            if (board[i] == " "){
                return false;
            }
        }
        return true;
    }

    /**
     * Game Board
     * @param board : an array of strings
     */
    public static void printBoard(String[] board){
        List<String> playedPosition = new ArrayList<>();
        System.out.println("");
        for (int i=0; i<board.length; i++){
            if (board[i] == null && !playedPosition.contains(board[i])) {
                board[i] = "" + i;
                playedPosition.add(board[i]);
            }
        }
        System.out.println("\t\t" + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("\t\t---------");
        System.out.println("\t\t" + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("\t\t---------");
        System.out.println("\t\t" + board[6] + " | " + board[7] + " | " + board[8]);
    }

    public static boolean isWinner(String[] board){
        return (board[0] == board[1] && board[1] == board[2]) ||
                (board[0] == board[3] && board[3] == board[6]) ||
                (board[0] == board[4] && board[4] == board[8]) ||
                (board[1] == board[4] && board[4] == board[7]) ||
                (board[2] == board[5] && board[5] == board[8]) ||
                (board[3] == board[4] && board[4] == board[5]) ||
                (board[6] == board[7] && board[7] == board[8]) ||
                (board[2] == board[4] && board[4] == board[6]);

    }

    public static String[] playerPosition(String[] board, int position){
        board[position] = "X";
        return board;
    }

    public static void computerPosition(String[] board){
        Random random = new Random();
        int randomNumber = random.nextInt(9);
        System.out.println(randomNumber);
        if (board[randomNumber] == "O" || board[randomNumber] == "X"){
           computerPosition(board);
        } else {
            board[randomNumber] = "O";
        }
    }

    public static boolean isValidMove(String[] board){
        for (int i=0; i<board.length; i++){
            if ((board[i] == "X") || (board[i] == "O")){
                System.out.println("Invalid move");
                System.out.println("Please select a place not X or O ");
                return false;
            }
        }
        return true;
    }

}