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
        String visitedPlacesInBoard[] = new String[9];
        printBoard(board, visitedPlacesInBoard);
        while ((isBoardFull(board))){
            if (isWinner(board)) {
                System.out.println("You Won");
                printBoard(board, visitedPlacesInBoard);
                System.out.println("Congratulations!!!!!");
                return;
            } else {
                System.out.println("ELSE");
                printBoard(board, visitedPlacesInBoard);
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                while (input<0 || input>8){
                    System.out.println("Enter a valid number(0-8)");
                    input = scanner.nextInt();
                }
                    if (isValidMove(visitedPlacesInBoard, input)) {
                        playerPosition(board, input, visitedPlacesInBoard);
                        computerPosition(board, visitedPlacesInBoard);

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
    public static void printBoard(String[] board, String[] visitedPlacesInBoard){
        List<String> playedPosition = new ArrayList<>();
        System.out.println("");
        for (int i=0; i<board.length; i++){
            if (board[i] == null && !playedPosition.contains(board[i])) {
                board[i] = "" + i;
                visitedPlacesInBoard[i] = "NV";
                playedPosition.add(board[i]);
            }
        }
        System.out.println("\t\t" + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("\t\t---------");
        System.out.println("\t\t" + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("\t\t---------");
        System.out.println("\t\t" + board[6] + " | " + board[7] + " | " + board[8]);
    }

    /**
     * Checks for the winner
     * @param board : board
     * @return
     */
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

    /**
     * Player
     * @param board : board
     * @param position : index for the played position
     * @param visitedPlacedInBoard : visited places in the board
     * @return
     */
    public static String[] playerPosition(String[] board, int position, String[] visitedPlacedInBoard){
        board[position] = "X";
        visitedPlacedInBoard[position] = "V";
        return board;
    }

    /**
     * Computer Player
     * @param board : board
     * @param visitedPlacesInBoard : visited places in the board
     */
    public static void computerPosition(String[] board, String[] visitedPlacesInBoard){
        Random random = new Random();
        int randomNumber = random.nextInt(9);
        System.out.println(randomNumber);
        if (board[randomNumber] == "O" || board[randomNumber] == "X"){
           computerPosition(board, visitedPlacesInBoard);
        } else {
            board[randomNumber] = "O";
            visitedPlacesInBoard[randomNumber] = "V";
        }
    }

    /**
     * Checks for validMove in the board
     * @param visitedPlacesInBoard : visited places in the board
     * @param number : index for the visited array(board)
     * @return
     */
    public static boolean isValidMove(String[] visitedPlacesInBoard, int number){
            if (visitedPlacesInBoard[number] == "V" ){
                System.out.println("Invalid move");
                System.out.println("Please select a place not X or O ");
                return false;
            }
        return true;
    }
}